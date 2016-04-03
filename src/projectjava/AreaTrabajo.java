package projectjava;

import controller.Controlador;
import javax.swing.*;
import java.awt.*;
import java.util.Properties;
import model.DB;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swingViewer.View;
import org.graphstream.ui.swingViewer.Viewer;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;


public final class AreaTrabajo extends JPanel
{
    private static volatile AreaTrabajo instance = null;
    Controlador controlador;
    Cursor pt;
    
    String eol = "<br>"; //System.getProperty("line.separator");
    
    String[] titulos0 = 
        { "Mantenimiento predictivo", "Mantenimiento preventivo",
        "Planificación", "Programación", "Ejecución", "Gestión de las paradas de planta",
        "Punto de Pedido", "Cantidad de Pedido", "Materiales obsoletos"};
    String[] titulos1 =
        {"ACR", "Mantenimiento Planificado", "Inventarios",
         "Factor de Utilización de la Capacidad Instalada"};
    String[] titulos2 = {"Confiabilidad", "MTTR"};
    String[] titulos3 = {"Disponibilidad", "Costos"};
    String[] titulos4 = {"Ingresos", "AO"};
    String[] titulos5 = {"EBIT"};
    String[] titulos6 = {"EVA"};
    String[][] titulos = {titulos0, titulos1, titulos2, titulos3, titulos4, titulos5, titulos6};
            
    Graph graph = new SingleGraph("TITULO");
    Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
    View view = viewer.addDefaultView(false);
    
    ButtonTabComponent boton;
    UtilDateModel model = new UtilDateModel();
    JDatePanelImpl datePanel;
    JDatePickerImpl botonFecha;
    Properties p = new Properties();
    
    JPanel barraSuperior = new JPanel();
    JPanel panelBoton = new JPanel();
    
    JButton botonn;
    
    boolean diagramaActivo = false;
    boolean diagramaCreado = false;
    DB datos;
    
    AreaTrabajo (Controlador controlador) {
        super();
        setName("AT");
        setLayout(new BorderLayout());       
            
        this.controlador = controlador;
        instance = this;
        datos = DB.getInstance();
        boton = new ButtonTabComponent(this);
        boton.setBounds(5, 0, boton.getWidth(), boton.getHeight());
        
        graph.addAttribute("ui.stylesheet", "url('file:src/css/estiloPrincipal.css')");
        
        add(panelBoton);
        crearBotonesInicio("Registrar", "formulario");
        crearBotonesInicio("Ver Diagrama", "diagrama");
        crearBotonesInicio("Nuevo Usuario", "nuevo");

        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(model, p);
        botonFecha = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        
        
        barraSuperior.setSize(this.getWidth(), 25);
        barraSuperior.add(boton, "East");
        barraSuperior.add(botonFecha);   
        
        /*botonFormulario = botones("Nuevo", 200, 300, 50, 50, "bar-chart");
        botonDiagrama = botones("Ver Diagrama", 400, 300, 50, 50, "bar-chart");
        boton3 = botones("Nuevo Usuario", 600, 300, 50, 50, "bar-chart");*/
        
    }
    
    public void valoresDiagrama() {
        
    }
    
    public void dibujarDiagrama () {
                
        view.setBounds(0, 60, getWidth()-10, getHeight()-40);
        viewer.enableAutoLayout();
        remove(panelBoton);
        int c, i=0, j=0;
        
        if(!diagramaCreado) {
            
            c = titulos0.length;

            for (String[] tts : titulos) {
                for (String t : tts) {
                    Node n = graph.addNode(t);
                    n.addAttribute("titulo", t);
                    n.addAttribute("linea", j);
                    n.addAttribute("ui.style", "fill-image: url('src/images/nodes/"+t+".png');");
                    System.out.println(i+" "+j+" "+t);
                }
                j++;
            }

            graph.addEdge(titulos0[0]+titulos1[1], titulos0[0], titulos1[1]);

            graph.addAttribute("ui.quality");
            graph.addAttribute("ui.antialias");
            diagramaCreado = true;
        }
        int x,y, lineaActual, lineaAnterior;
        lineaAnterior = 0;
        x = 20; y = 100; i=0;
        
        diagramaActivo = true;
        
        add(view, BorderLayout.CENTER);
        
        for (Node n : graph.getEachNode()) {
            lineaActual = (int)n.getAttribute("linea");
            if (lineaActual != lineaAnterior) i=1;
            n.addAttribute("xy", x+(150*lineaActual), y*(++i));
            //n.addAttribute("ui.label", (Object)n.getAttribute("titulo")); //+" "+n.getAttribute("valor"));
        }
        
        add(barraSuperior, BorderLayout.NORTH);
        barraSuperior.repaint();
        repaint();
    }
    
    public void cerrarDiagrama() {
        diagramaActivo = false;
        remove(view);
        remove(barraSuperior);
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
            y = (this.getHeight()/5)-(h/2)+50;
            
            g.drawImage(fondo, x, y, w, h, this);
            
            panelBoton.setVisible(!diagramaActivo);
        }
    }
    
    public JButton botonIcon(String nombre, int x, int y, String imagen){
        JButton boto = new JButton();
        ImageIcon img = new ImageIcon("src/images/"+imagen+".png");
        boto.setIcon(img);
        boto.setName(nombre.toUpperCase());
        boto.setBounds(x, y, img.getIconWidth(), img.getIconHeight());
        boto.setToolTipText(nombre);
        boto.addActionListener(controlador);
        boto.addMouseListener(controlador);
        boto.setLayout(new GridLayout(1,1));
        add(boto);
        return boto;
    }
    
    public void crearBotonesInicio (String toolTipText, String nombreImagen){
        panelBoton.setSize(400,1000);
        panelBoton.setLocation(300, 300);
        panelBoton.add(botonn = botonIcon(toolTipText, 250, 300, nombreImagen));
    }
    
    public static synchronized AreaTrabajo getInstance() {
        if (instance == null) instance = new AreaTrabajo(Controlador.getInstance());
        return instance;
    }
}