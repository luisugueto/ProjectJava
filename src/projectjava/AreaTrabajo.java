package projectjava;

import controller.Controlador;
import javax.swing.*;
import java.awt.*;
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
        setLayout(null);
        this.controlador = controlador;
        addMouseListener(controlador);
        addMouseMotionListener(controlador);
                
        datos = DB.getInstance();
        instance = this;
        
        botones("Nuevo", 200, 300, 50, 50, "bar-chart");
        botones("Ver Diagrama", 400, 300, 50, 50, "bar-chart");
        botones("Ver Diagrama", 600, 300, 50, 50, "inicio");

    }
    
    public void dibujarDiagrama () {
        Caja uno = new Caja("Prueba", 200, 200, "239.11");
        uno.setBounds(200, 200, 100, 100);
        add(uno);
    }
    
    public void botones(String nombre, int x, int y, int ancho, int alto, String imagen){
        JButton boton = new JButton();
        boton.setName(nombre.toUpperCase());
        boton.setBounds(x, y, ancho, alto);
        boton.setToolTipText(nombre);
        boton.setIcon(new ImageIcon("src/images/"+imagen+".png"));
        boton.addActionListener(controlador);
        add(boton);
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
            y = (this.getHeight()/5)-(h/2);
            g.drawImage(fondo, x, y, w, h, this);
    }

    public static synchronized AreaTrabajo getInstance() {
        if (instance == null) instance = new AreaTrabajo(Controlador.getInstance());
        return instance;
    }
}

    