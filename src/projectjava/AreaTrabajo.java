package projectjava;

import controller.Controlador;
import javax.swing.*;
import java.awt.*;
import model.DB;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swingViewer.View;
import org.graphstream.ui.swingViewer.Viewer;


public class AreaTrabajo extends JPanel
{
    private static volatile AreaTrabajo instance = null;
    Controlador controlador;
    Cursor pt;

    String[] titulosIniciales = 
        { "Mantenimiento<br>predictivo", "Mantenimiento<br>preventivo",
        "Planificación", "Programación", "Ejecución", "Gestión de las<br>paradas de planta",
        "Punto de Pedido", "Cantidad de Pedido", "Materiales obsoletos"};
            
    Graph graph = new SingleGraph("TITULO");
    Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
    View view = viewer.addDefaultView(false);
    ButtonTabComponent boton = new ButtonTabComponent(this);
    
    boolean diagramaActivo = false;
    DB datos;
    
    AreaTrabajo (Controlador controlador)
    {
        super();
        setName("AT");
        setLayout(new BorderLayout());
        
        this.controlador = controlador;
        addMouseListener(controlador);
        addMouseMotionListener(controlador);
                
        datos = DB.getInstance();
        instance = this;
        
        dibujarDiagrama();
    }
    
    public void dibujarDiagrama () {
        
        add(view, BorderLayout.CENTER);
        view.setBounds(0, 60, getWidth()-10, getHeight()-40);
        setVisible(true);
        viewer.enableAutoLayout();
        
        graph.addNode("A" );
        graph.addNode("B" );
        graph.addNode("C" );
        graph.addEdge("AB", "A", "B");
        graph.addEdge("BC", "B", "C");
        graph.addEdge("CA", "C", "A");
        
        graph.addAttribute("ui.quality");
        graph.addAttribute("ui.antialias");
        
        diagramaActivo = true;
        
        boton.setBounds(this.getWidth()-20, 0, boton.getHeight(), boton.getHeight());
    }
    
    public void cerrarDiagrama() {
        diagramaActivo = false;
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
            y = (this.getHeight()/2)-(h/2);
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