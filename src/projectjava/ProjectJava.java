package projectjava;

import controller.Controlador;
import model.DB;

public class ProjectJava
{    
    public static void main(String[] args)
    {
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        
        Login login = new Login();
                
        login.setVisible(true);
    }
    
    public static void iniciar(int tipo, int id) {
        Ventana ventana = new Ventana(tipo);
    
        Controlador controlador = new Controlador();
        controlador.setVentana(ventana);
        ventana.setControlador(controlador);
        ventana.setTipo(tipo);
        ventana.setId(id);
        ventana.construirGUI();
        controlador.setObjects();
        
        DB datos = DB.getInstance();
        
        ventana.setVisible(true);
    }
}
