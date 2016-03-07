package controller;

import com.itextpdf.text.DocumentException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import spev.AreaTrabajo;
import spev.BarraDeEstado;
import model.DB;
import spev.BarraHerramientas;
import spev.Configuracion;
import spev.Informacion;
import spev.ReportarError;
import spev.Reportes;
import spev.TablasTermodinamica;
import spev.Ventana;
import spev.VentanaDeOpciones;
import spev.VentanaAcercaDe;
import spev.VerLogs;


public class Controlador extends AbsControlador
{
    private static volatile Controlador instance = null;
    
    private BarraDeEstado be;
    private AreaTrabajo area;
    private Ventana ventana;
    private BarraHerramientas bh;
    private StringBuffer log = new StringBuffer();
    
    private final DB datos = DB.getInstance();
    
    JFileChooser fc;
    int returnVal;
    File file;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String fuente = ((JComponent)e.getSource()).getName();
        Reportes reportes = new Reportes();

        switch (fuente)
        {
            case "NUEVO":
                if (datos.getPerfilActual() == null) {
                    System.out.println("Error en la base de datos.");
                } else {
                    new VentanaDeOpciones(ventana);
                    insertLog("Abriendo Nuevo Ciclo.");
                }
                break;
            case "CERRAR TODO": area.cerrarTodo(); break;
            case "FONDO":
                datos.setValorConf("fondoActivo", "false");
                break;
            case "CONFIGURACIÓN": 
                Configuracion conf = new Configuracion(ventana);
                insertLog("Abriendo Configuración.");
                break;
            case "ACERCA DE...": 
                new VentanaAcercaDe();  
                insertLog("Abriendo Acerca de...");
                break;
            case "REPORTAR ERROR": 
                new ReportarError(ventana); 
                insertLog("Abriendo Reportar Error.");
                break;
            case "IMPRIMIR" :
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setPrintable(d);
                boolean doPrint = job.printDialog();
                if (doPrint) {
                    try {
                        job.print();
                    } catch (PrinterException pe) {
                        System.out.println("Impresion cancelada");
                    }
                }
                break;
            case "SALIR":
                ventana.dispatchEvent(new WindowEvent(ventana, WindowEvent.WINDOW_CLOSING));
                break;
            case "INICIAR": case "DETENER": case "DESHACER": case "REHACER":
            case "GUARDAR": case "GUARDAR COMO...": case "GUARDAR TODO...": case "ABRIR":
                if (d != null) d.getControlador().actionPerformed(e);
                break;
            case "HISTORIAL ACTUAL":
                d = area.getCicloActual();
                fc = new JFileChooser();
                returnVal = fc.showSaveDialog(ventana);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    file = fc.getSelectedFile();
                    //log.append("Opening: "+file.getName()+"."+newline);
                } else {
                    // log.append("Open command cancelled by user."+newline);
                    break;
                }

                try {
                    reportes.reporteHistorialActual(d.getLog().toString(),d.getNombre(), file);
                    JOptionPane.showMessageDialog(null, "Reporte Guardado.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    insertLog("Guardando Historial Actual del Ciclo: "+d.getNombre().toString());
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor cierre el archivo pdf.");
                    //Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                case "ESTADO ACTUAL":
                d = area.getCicloActual();
                fc = new JFileChooser();
                returnVal = fc.showSaveDialog(ventana);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    file = fc.getSelectedFile();
                    //log.append("Opening: "+file.getName()+"."+newline);
                } else {
                    // log.append("Open command cancelled by user."+newline);
                    break;
                }

                try {
                    reportes.reporteEstadoActual(d.getNombre(), d.getEstadoCiclo(0), d.getEstadoCiclo(1), d.getEstadoCiclo(2), d.getEstadoCiclo(3), file);
                    JOptionPane.showMessageDialog(null, "Reporte Guardado.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    insertLog("Guardando Estado Actual del Ciclo: "+d.getNombre().toString());
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor cierre el archivo pdf.");
                    //Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }                
                break;
             case "REPORTE COMPLETO":
                fc = new JFileChooser();
                returnVal = fc.showSaveDialog(ventana);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    file = fc.getSelectedFile();
                    //log.append("Opening: "+file.getName()+"."+newline);
                } else {
                    // log.append("Open command cancelled by user."+newline);
                    break;
                }

                try {
                       reportes.reporteCompleto(d.getLog().toString(), d.getNombre(), d.getEstadoCiclo(0), d.getEstadoCiclo(1), d.getEstadoCiclo(2), d.getEstadoCiclo(3), file);
                       JOptionPane.showMessageDialog(null, "Reporte Guardado.", "Información", JOptionPane.INFORMATION_MESSAGE);
                       insertLog("Guardando Reporte Completo del Ciclo: "+d.getNombre().toString());
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor cierre el archivo pdf.");
                    //Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DocumentException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }             
                break;
             case "PANEL INFORMATIVO":
                 String activo;
                 if (datos.getValorConf("panelActivo").equals("true")) activo = "false";
                 else activo = "true";
                 datos.setValorConf("panelActivo", activo);
                 ventana.toggleComponents();
                 break;
             case "INFORMACIÓN":
                 new Informacion();
                 insertLog("Abriendo Información");
                 break;
             case "TABLAS TERMODINÁMICA":
                 TablasTermodinamica termo = new TablasTermodinamica();
                 termo.setVisible(true);
                 insertLog("Abriendo Tablas Termodinámica");
                 break;
             case "VER LOGS":
                 setMensaje(getLog().toString());
             default:
                System.out.println(fuente+" no tiene una accion asignada.");
                break;
        }
    }
    
    public void actualizarGUI () {
        //ventana.repaint();
        //area.actualizar();
    }
    
    // Añade un texto al registro de Eventos (Variable log)
    public void insertLog (String line) {
        log.append(line);
        log.append(System.getProperty("line.separator"));
    }
    
    public void insertLog (String line, String color) {
        log.append(color+" "+line);
        log.append(System.getProperty("line.separator"));
    }
    
    
    // Devuelve todo el registro de Eventos (Variable log).
    public StringBuffer getLog() {
        return log;
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        String fuente = ((JComponent)e.getSource()).getName();
        //int x=e.getX(), y=e.getY();
                
        /*switch(fuente)
        {
            case "CALDERA":
                setEstado("X: "+x+" Y: "+y+"");
                break;
        }*/
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        String fuente = ((JComponent)e.getSource()).getName();
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }
       
    public void setHistorial (String msj) { be.setMensajeHistorial(msj); }
    public void setEstadoValores (String msj) { be.setMensajeValores(msj); }

    public void setEstado (String msj) { be.setMensaje(msj); }
    public void setEstado () { be.setMensaje(be.default_message); }
    public void setEstado (String msj, boolean append) {
        if (append) setEstado(msj);
        else setEstado(be.getMensaje()+msj);
    }
    public void setVentana(Ventana ventana) { this.ventana = ventana; }
    public Ventana getVentana() { return this.ventana; }
    public void setObjects() {
        be = ventana.getBarraEstado();
        area = ventana.getAreaTrabajo();
    }
    public void setBackground() { ventana.setBackground(); }
    public void toggleComponents () {
        ventana.toggleComponents();
        ventana.getBarraMenu().toggleMenus();
    }
    public void setMensaje(String msj) { VerLogs ver = new VerLogs(); ver.setMensaje(msj); }
    public void nuevoCiclo(String tipo, String nombre) { area.nuevoCiclo(tipo, nombre); }
        
    public static synchronized Controlador getInstance() {
        if (instance == null) instance = new Controlador();
        return instance;
    }
}
