package controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import projectjava.AreaTrabajo;
import projectjava.BarraDeEstado;
import model.DB;
import projectjava.Ventana;
import projectjava.BarraHerramientas;
import projectjava.CrearUsuario;
import projectjava.FormDatos;

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

        switch (fuente)
        {
            case "REGISTRAR":
                FormDatos form = new FormDatos();
                form.setId(ventana.getId());
                form.setVisible(true);
                break;
            case "NUEVO USUARIO":
                CrearUsuario crear = new CrearUsuario();
                crear.setVisible(true);
                break;
            case "SALIR":
                ventana.dispatchEvent(new WindowEvent(ventana, WindowEvent.WINDOW_CLOSING));
                break;
            case "VER DIAGRAMA":
                area.dibujarDiagrama();
                break;
            default:
                System.out.println(fuente+" no tiene una accion asignada. AP.");
                break;
        }
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
        String fuente = ((JComponent)e.getSource()).getName();
        
        switch (fuente)
        {         
            case "REGISTRAR":
                setEstado("Nuevo");
                break;
            case "SALIR":
                setEstado("Salir");
                break;
            case "VER GRÁFICO":
                setEstado("Ver Gráfico");
                break;
             case "NUEVO USUARIO":
                setEstado("Nuevo Usuario");
                break;
            case "LISTA DE USUARIOS":
                setEstado("Lista de Usuarios");
                break;
            case "MODIFICAR USUARIO":
                setEstado("Modificar Usuario");
                break;
            case "INFORMACIÓN":
                setEstado("Información");
                break;
            case "REPORTAR ERROR":
                setEstado("Reportar Error");
                break;

            default:
                System.out.println(fuente+" no tiene una accion asignada. ME.");
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }
       
    
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
        
    public static synchronized Controlador getInstance() {
        if (instance == null) instance = new Controlador();
        return instance;
    }
}
