package projectjava;

import controller.Controlador;
import model.DB;

public class ProjectJava
{    
    public static void main(String[] args)
    {
        Login login = new Login();
                
        login.setVisible(true);
    }
    
    public static void iniciar(int tipo) {
        Ventana ventana = new Ventana();
        FormDatos form = new FormDatos();
    
        Controlador controlador = new Controlador();
        controlador.setVentana(ventana);
        ventana.setControlador(controlador);
        ventana.setTipo(tipo);
        ventana.construirGUI();
        controlador.setObjects();
        
        DB datos = DB.getInstance();
        
        ventana.setVisible(true);
    }
}
