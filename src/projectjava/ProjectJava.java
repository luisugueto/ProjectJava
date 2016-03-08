package projectjava;

import controller.Controlador;
import model.DB;

public class ProjectJava
{
    public static void main(String[] args)
    {
        Ventana ventana = new Ventana();
        Controlador controlador = new Controlador();
        controlador.setVentana(ventana);
        ventana.setControlador(controlador);
        ventana.construirGUI();
        controlador.setObjects();
        
        DB datos = DB.getInstance();
        
        Login login = new Login();
        login.setVisible(true);
    }
}
