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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import projectjava.Formulas;

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
    int resultad = 0;
    String fecha = "", fecha1 = ""; 
    public ArrayList resultados = new ArrayList();
    
    public DB () {
          
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/java.bd");
            query = c.createStatement();
        } catch (Exception e) { imprimirExcepcion(e); System.exit(0); }
        finally {}
        //inicializar();
//        System.out.println("Conexión establecida con la base de datos.");
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
    public ArrayList getResultados(){ return resultados; }
    public int getResultad(){ return resultad; }
    
    public void getDatoPorPosicion(int pos){
        resultados.clear();
        try { res = getDatos(); 
            while (res.next()) {
                   String temp = res.getString(3);
                    if(fecha.equals(temp)){// Asignar temp a alguna variable
                            this.resultado = res.getString(pos);
                            this.resultad = res.getInt(pos);
                       break;
                    }
            }
        } catch (SQLException ex) { System.out.println(ex.getMessage()); }
    }
    
    public void getDatoPorPosicionMes(int pos){
        resultados.clear();
        try { res = getDatos(); 
                while (res.next()) {
                    String fechaData = res.getString(3);
                    String partFechaData[] = fechaData.split("-");
                    if(fecha.equalsIgnoreCase(partFechaData[1]+"-"+partFechaData[2]))
                    {
                        resultados.add(res.getString(pos));
                    }
                }
            } catch (SQLException ex) { System.out.println(ex.getMessage()); } 
    }
    
    public void getDatoPorPosicionAnio(int pos){     
        resultados.clear();
        try { res = getDatos(); 
                while (res.next()) {
                       String temp = res.getString(3);
                       String partsTemp[] = temp.split("-");
                       System.out.println(fecha);
                        if(fecha.equals(partsTemp[2])){// Asignar temp a alguna variable
                            this.resultados.add(res.getString(pos));                      
                        }
                }
            } catch (SQLException ex) { System.out.println(ex.getMessage()); }
    }
    
    public void getResultadosRangoDeFecha() throws ParseException{
        resultados.clear();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = sdf.parse(fecha);
        Date date2 = sdf.parse(fecha1);
        
        try { res = getDatos(); 
                while (res.next()) {
                    Date date3 = sdf.parse(res.getString(3));
                    if(date3.after(date1) && date3.before(date2)) 
                        resultados.add(res.getString(3));
                }
            } catch (SQLException ex) { System.out.println(ex.getMessage()); }
    }
    
    public void getResultadosPorFecha(int pos) throws ParseException{
        resultados.clear();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = sdf.parse(fecha);
        String fechaC = ""+date1;

        try { res = getDatos(); 
                while (res.next()) {
                    Date date3 = sdf.parse(res.getString(3));
                   
                    String fechaC1 = ""+date3;
                    
                    if(fechaC.equals(fechaC1))
                    {
                        this.resultad = res.getInt(pos);
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
    public void setFecha2(String val){ this.fecha1 = val;}
    
    public String getFecha(){ return fecha; }
    public String getFecha2(){ return fecha1; }
    
    public static synchronized DB getInstance() {
        if (instance == null) instance = new DB();
        return instance;
    }
}