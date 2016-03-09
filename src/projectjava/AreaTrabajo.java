package projectjava;

import controller.Controlador;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import model.DB;


public class AreaTrabajo extends JPanel
{
    private static volatile AreaTrabajo instance = null;
    Controlador controlador;
    Cursor pt;
    
    DB datos;
    
    AreaTrabajo (Controlador controlador)
    {
        super();
        setName("AT");
        
        this.controlador = controlador;
        addMouseListener(controlador);
        addMouseMotionListener(controlador);
                
        datos = DB.getInstance();
        instance = this;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image fondo;
            fondo = controlador.crearImagen("/images/inicio.png", "Fondo Inicial").getImage();
            int x, y, w, h;
            w = fondo.getWidth(null);
            h = fondo.getHeight(null);
            x = (this.getWidth()/2)-(w/2);
            y = (this.getHeight()/2)-(h/2);
            g.drawImage(fondo, x, y, w, h, this);
    }

    public static synchronized AreaTrabajo getInstance() {
        if (instance == null) instance = new AreaTrabajo(Controlador.getInstance());
        return instance;
    }
}

    