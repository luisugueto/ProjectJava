package projectjava;

import controller.Controlador;
import javax.swing.*;
import java.awt.*;
import model.DB;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swingViewer.View;
import org.graphstream.ui.swingViewer.Viewer;


public class AreaTrabajo extends JPanel
{
    private static volatile AreaTrabajo instance = null;
    Controlador controlador;
    Cursor pt;
    
    String eol = System.getProperty("line.separator");
    String[] titulosIniciales = 
        { "Mantenimiento"+eol+"predictivo", "Mantenimiento"+eol+"preventivo",
        "Planificación", "Programación", "Ejecución", "Gestión de las"+eol+"paradas de planta",
        "Punto de Pedido", "Cantidad de Pedido", "Materiales obsoletos"};
            
    Graph graph = new SingleGraph("TITULO");
    Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
    View view = viewer.addDefaultView(false);
    
    ButtonTabComponent boton = new ButtonTabComponent(this);
    
    JButton botonFormulario, botonDiagrama, boton3;
    
    boolean diagramaActivo = false;
    DB datos;
    
    AreaTrabajo (Controlador controlador)
    {
        super();
        setName("AT");
        setLayout(new BorderLayout());
        
        this.controlador = controlador;
                
        datos = DB.getInstance();
        instance = this;
        
        dibujarDiagrama();
        
        /*botonFormulario = botones("Nuevo", 200, 300, 50, 50, "bar-chart");
        botonDiagrama = botones("Ver Diagrama", 400, 300, 50, 50, "bar-chart");
        boton3 = botones("Nuevo Usuario", 600, 300, 50, 50, "bar-chart");*/
    }
    
    public void dibujarDiagrama () {
        
        add(view, BorderLayout.CENTER);
        view.setBounds(0, 60, getWidth()-10, getHeight()-40);
        viewer.enableAutoLayout();
        
        for (int i = 0; i < 9; i++) {
            Node x = graph.addNode(Integer.toString(i));
            x.addAttribute("xy", 20, 50*(i+1));
        }
        
        graph.addAttribute("ui.quality");
        graph.addAttribute("ui.antialias");
                
        boton.setBounds(this.getWidth()-20, 0, boton.getWidth(), boton.getHeight());
        add(boton);
    }
    
    public void cerrarDiagrama() {
        diagramaActivo = false;
        paintComponent(getGraphics());
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
            //if (view != null) remove(view);
        } else {
            /*remove(botonFormulario);
            remove(botonDiagrama);
            remove(boton3);
            add(view, BorderLayout.CENTER);*/
        }
    }
    
    public JButton botones(String nombre, int x, int y, int ancho, int alto, String imagen){
        JButton boton = new JButton();
        boton.setName(nombre.toUpperCase());
        boton.setBounds(x, y, ancho, alto);
        boton.setToolTipText(nombre);
        boton.setIcon(new ImageIcon("src/images/"+imagen+".png"));
        boton.addActionListener(controlador);
        boton.addMouseListener(controlador);
        boton.setSize(ancho, alto);
        add(boton);
        return boton;
    }
    
    public static synchronized AreaTrabajo getInstance() {
        if (instance == null) instance = new AreaTrabajo(Controlador.getInstance());
        return instance;
    }
}