/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author raven
 */
public final class DB
{
    private static volatile DB instance = null;
    
    // Conexion con la BD
    Connection c = null;
    
    // Variable general para consultas
    Statement query = null, query1 = null;
    
    // Variable general para resultados
    ResultSet res = null;
    String resultado;
    
    private DB () {
               
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/java.bd");
            query = c.createStatement();
        } catch (Exception e) { imprimirExcepcion(e); System.exit(0); }
        finally {}
        //inicializar();
        System.out.println("Conexión establecida con la base de datos.");
    }
    
    public int insertGeneral (String table, String... values) {
        String strQuery, con;
        con = "'";
        
        if (values[0].equals("null")) con = "";
        
        strQuery = "INSERT INTO "+table+" VALUES ("+con;
        strQuery += values[0];
        
        for(int i=1; i < values.length ; i++) {
            strQuery += con+", '"+values[i];
        }
        strQuery += "');";
        try {
            query.executeUpdate(strQuery);
            return query.getGeneratedKeys().getInt(1);
        } catch (Exception e) { imprimirExcepcion(e, strQuery); return -1; }
    }
    
    public String getResultado(){ return resultado; }
    
    public void getId(String fecha, int pos){
    try { res = getDatos(); 
        while (res.next()) {
               String temp = res.getString(3);
                if(fecha.equals(temp)){// Asignar temp a alguna variable
                   this.resultado = res.getString(pos);
                   break;
                }
        }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
    }
       
    public ResultSet getUser () {
        try {
            res = query.executeQuery("SELECT * FROM `user`");
        } catch (Exception e) { imprimirExcepcion(e); }
        return res;
    }
    
    public ResultSet getDatos () {
        try {
            res = query.executeQuery("SELECT * FROM `datos`");
        } catch (Exception e) { imprimirExcepcion(e); }
        return res;
    }
    
    public ResultSet getUsuario (String usuario, String contrasena) {
        try {
            res = query.executeQuery("SELECT * FROM `user` WHERE user = "+usuario+" AND contrasena = "+contrasena);
        } catch (Exception e) { imprimirExcepcion(e); }
        return res;
    }
    
    public String[][] getPerfiles () {
        String[][] perfiles = null;
        int i =0, n=0;
        try {
            res = query.executeQuery("SELECT COUNT(ID) FROM Perfil;");
            if (res.next()) n = res.getInt(1);
            perfiles = new String[n][];
            res = query.executeQuery("SELECT * FROM Perfil;");
            while (res.next()) {
                perfiles[i] = new String[2];
                perfiles[i][0] = res.getString(1);
                perfiles[i][1] = res.getString(2);
                i++;
            }
        } catch (Exception e) { imprimirExcepcion(e); }
        return perfiles;
    }
    
    public String getPerfil(String idPerfil){
        String valor = null;
        
        try {
            res = query.executeQuery("SELECT Nombre FROM `Perfil` WHERE ID = '"+idPerfil+"'");
            if (res.next()) valor = res.getString(1);
        } catch (Exception e) { imprimirExcepcion(e); }
        
        return valor;
    }
    
    public String getPerfilActual() {
        String idPerfil = null;
        
        try {
            res = query.executeQuery("SELECT perfilActual FROM `General`");
            if(res.next()) idPerfil = res.getString(1);
        } catch (Exception e) { imprimirExcepcion(e); }
        
        return idPerfil;
    }
    
    public void setPerfilActual (String idPerfil) {
        try {
            if (query.executeUpdate("UPDATE `General`"
                      + "SET perfilActual = '"+idPerfil+"'") == 0)
                insertGeneral("General", idPerfil);
        } catch (Exception e) { imprimirExcepcion(e); }
    }
    
    public int addPerfil (String nombre) {
        int id = insertGeneral("Perfil", "null", nombre);
        inicializarPerfil(Integer.toString(id));
        return id;
    }
    
    public ResultSet getConfiguracion () {
        String idPerfil = getPerfilActual();
        try {
            res = query.executeQuery("SELECT * FROM `Configuracion` WHERE ID_Perfil = '"+idPerfil+"'");
        } catch (Exception e) {imprimirExcepcion(e); }
        return res;
    }
    
    public boolean setValorConf (String clave, String valor) {
        String idPerfil = getPerfilActual();
        try {
            res = query.executeQuery("UPDATE `Configuracion`"
                                   + "SET Valor = '"+valor+"'"
                                   + "WHERE Clave = '"+clave+"'"
                                   + "AND ID_Perfil = '"+idPerfil+"'");
            return true;
        } catch (Exception e) { imprimirExcepcion(e); return false; }
    }
    
    public boolean addValorConf (String clave, String valor) {
        String idPerfil = getPerfilActual();
        try {
            insertGeneral("Configuracion", clave, valor, idPerfil);
            return true;
        } catch (Exception e) { imprimirExcepcion(e); return false; }
    }
    
    public String getValorConf (String clave) {
        String valor = "null";
        String idPerfil = getPerfilActual();
        try {
            res = query.executeQuery("SELECT valor FROM `Configuracion`"
                                    + "WHERE clave = '"+clave+"' AND ID_Perfil = '"+idPerfil+"'");
            if(res.next()) {valor = res.getString(1);}
        } catch (Exception e) { imprimirExcepcion(e); }
        
        return valor;
    }
    
    public ResultSet getValor (String tabla, String columna, String valor){ //throws SQLException{
        try {
           // query1 = c.createStatement();
            res = query.executeQuery("SELECT * FROM "+ tabla +" WHERE "+ columna +"='"+valor+"'");
           // res.next();
           // System.out.println(res.getFloat(0));

        } catch (Exception e) { imprimirExcepcion(e); }
        return res;
    }
    
    public ResultSet getTablas() {
        try {
            res = query.executeQuery("SELECT name FROM sqlite_master WHERE type='table'");
        } catch (Exception e) { imprimirExcepcion(e); }
        return res;
    }
    
    /*
        Primer método de la base de datos en ejecutarse, revisa si existen
        perfiles creados, si no, crea uno e inicializa las variables de
        configuración con los valores por defecto
    */
    public void inicializar() {
        String id = getPerfilActual();
        if (id == null || id.equals("null")) {
            inicializarPerfil(Integer.toString(addPerfil("Default")));
        }
    }
    
    public void inicializarPerfil(String idPerfil) {
        String[] claves, valoresDefault;
        
        setPerfilActual(idPerfil);
        claves = new String[]{"abrirCiclos", "guardarCiclos", "colorApp", "panelActivo", "fondoActivo"};
        valoresDefault = new String[]{"Si", "5 min", "Default", "true", "true"};
        
        for (int i=0; i < claves.length ; i++) {
            addValorConf(claves[i], valoresDefault[i]);
        }
    }
    
    private void imprimirExcepcion(Exception e) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.out.println();
    }
    
    private void imprimirExcepcion(Exception e, String q) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.out.println(q);
        System.out.println();
        
    }
    
    public static synchronized DB getInstance() {
        if (instance == null) instance = new DB();
        return instance;
    }
}