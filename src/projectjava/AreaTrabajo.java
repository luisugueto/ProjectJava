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
    Diagrama d;
    boolean diagramaActivo = false;
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
        
        //botones("Nuevo", 200, 300, 50, 50, "bar-chart");
        //botones("Ver Diagrama", 400, 300, 50, 50, "bar-chart");
        //botones("Nuevo Usuario", 600, 300, 50, 50, "inicio");
        
        dibujarDiagrama();
    }
    
    public void dibujarDiagrama () {
        d = new Diagrama();
        add(d);
        diagramaActivo=true;
    }
    
    public void cerrarDiagrama() {
        diagramaActivo = false;
        d = null;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (!diagramaActivo) {
            Image fondo;
            fondo = controlador.crearImagen("/images/inicio.png", "Fondo Inicial").getImage();
            int x, y, w, h;
            w = fondo.getWidth(null);
            h = fondo.getHeight(null);
            x = (this.getWidth()/2)-(w/2);
            y = (this.getHeight()/5)-(h/2);
            g.drawImage(fondo, x, y, w, h, this);
        }
    }
    
    public void botones(String nombre, int x, int y, int ancho, int alto, String imagen){
        JButton boton = new JButton();
        boton.setName(nombre.toUpperCase());
        boton.setBounds(x, y, ancho, alto);
        boton.setToolTipText(nombre);
        boton.setIcon(new ImageIcon("src/images/"+imagen+".png"));
        boton.addActionListener(controlador);
        boton.addMouseListener(controlador);
        add(boton);
    }
    
    public static synchronized AreaTrabajo getInstance() {
        if (instance == null) instance = new AreaTrabajo(Controlador.getInstance());
        return instance;
    }
}