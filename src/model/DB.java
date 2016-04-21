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
    String fecha;
    public DB () {
               
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
    
    public void getId(int pos){
    try { res = getDatos(); 
        while (res.next()) {
               String temp = res.getString(3);
                if(getFecha().equals(temp)){// Asignar temp a alguna variable
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
    
    private void imprimirExcepcion(Exception e) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.out.println();
    }
    
    private void imprimirExcepcion(Exception e, String q) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.out.println(q);
        System.out.println();
        
    }
    
    public void setFecha(String val){ this.fecha = val;}
    public String getFecha(){ return fecha; }
    
    public static synchronized DB getInstance() {
        if (instance == null) instance = new DB();
        return instance;
    }
}