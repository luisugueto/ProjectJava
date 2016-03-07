package projectjava;

import controller.Controlador;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.DB;

public class Ventana extends JFrame
{
    private static volatile Ventana instance = null;
    BarraMenu barraMenu;
    BarraDeEstado barraEstado;
    BarraHerramientas barraHerramientas;
    BarraElementos barraElementos;
    AreaTrabajo areaTrabajo;
    
    Controlador controlador;
    
    boolean toggledBarraEstado = false;
    boolean toggled = false;
    
    DB datos;
    
    Ventana ()
    {
        super("Simulador de Plantas de Energía de Vapor");
        setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/logo.png")));
        this.setLocation(100,100);
        this.setSize(800,600);        
        this.setExtendedState(6);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Colores.main);
        
        datos = DB.getInstance();
        
    }
    
    public void setControlador (Controlador controlador) {
        this.controlador = controlador;
    }
    
    public void construirGUI() {
        barraMenu = new BarraMenu(controlador);
        barraEstado = new BarraDeEstado();
        barraHerramientas = new BarraHerramientas(controlador, false);
        areaTrabajo = new AreaTrabajo(controlador);
        
        getContentPane().add(barraHerramientas, "North");
        
        setJMenuBar(barraMenu);
        
        JPanel margen = new JPanel();
        margen.setBorder(BorderFactory.createMatteBorder(7,4,0,4,Colores.main));
        ((FlowLayout)margen.getLayout()).setVgap(0);
        ((FlowLayout)margen.getLayout()).setHgap(0);
        getContentPane().add("Center", margen);
        margen.setLayout(new GridLayout(1,1));
        margen.add(areaTrabajo);    
        controlador.insertLog("Cargando app...");
    }
    
    public void setBackground(){
        setBackground(Color.yellow);
    }
    
    public void toggleComponents () {
        String panelActivo = datos.getValorConf("panelActivo");
        
        if (!toggled) {
            barraHerramientas.toggleBotones();
            if (panelActivo.equals("true")) getContentPane().add("South", barraEstado);
        }
        else {
            barraHerramientas.toggleBotones();
            if (barraEstado.getParent() == getContentPane()) getContentPane().remove(barraEstado);
        }
        toggled = !toggled;
    }
    
    public void toggleBarraEstado () {
        if (toggledBarraEstado) getContentPane().remove(barraEstado);
        else getContentPane().add("South", barraEstado);
        toggledBarraEstado = !toggledBarraEstado;
    }

    public BarraMenu getBarraMenu() {return barraMenu;}
    public BarraHerramientas getBarraHerramientas() {return barraHerramientas;}
    public BarraElementos getBarraElementos() {return barraElementos;}
    public BarraDeEstado getBarraEstado() {return barraEstado;}
    public AreaTrabajo getAreaTrabajo () {return areaTrabajo;}
    public Controlador getControlador() { return controlador; }
    
    public static synchronized Ventana getInstance() {
        if (instance == null) instance = new Ventana();
        return instance;
    }
}