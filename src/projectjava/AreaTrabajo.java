package projectjava;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxEdgeStyle;
import com.mxgraph.view.mxGraph;
import controller.Controlador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Map;
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
    
    String fecha, valor;
    String fech = "";
    
    String eol = "<br>"; //System.getProperty("line.separator");
    
    String[] titulos0 = 
        { "Mantenimiento \npredictivo", "Mantenimiento \npreventivo",
        "Planificación", "Programación", "Ejecución", "Gestión de las \nparadas de planta",
        "Punto de pedido", "Cantidad de pedido", "Materiales \nobsoletos"};
    String[] titulos1 =
        {"ACR", "Mantenimiento \nplanificado", "Inventarios",
         "Factor de utilización de \nla capacidad instalada"};
    String[] titulos2 = {"Confiabilidad", "MTTR"};
    String[] titulos3 = {"Disponibilidad", "Costos"};
    String[] titulos4 = {"Ingresos", "AO"};
    String[] titulos5 = {"EBIT"};
    String[] titulos6 = {"EVA"};
    String[][] titulos = {titulos0, titulos1, titulos2, titulos3, titulos4, titulos5, titulos6};
            
    //Graph graph = new SingleGraph("TITULO");
    //Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
    //View view = viewer.addDefaultView(false);
    
    //Variables de Clases para el Diagrama
    mxGraph graph = new mxGraph(); 
    mxGraphComponent graphComponent = new mxGraphComponent(graph);
    
    ButtonTabComponent boton;
    UtilDateModel model = new UtilDateModel();
    JDatePanelImpl datePanel;
    JDatePickerImpl botonFecha;
    Properties p = new Properties();
    
    JPanel barraSuperior = new JPanel();
    JPanel panelBoton = new JPanel();
    
    JButton botonn, botonnn;
    
    boolean diagramaActivo = false;
    boolean diagramaCreado = false;
    DB datos = DB.getInstance();
    Formulas form;
    
    AreaTrabajo (Controlador controlador) {
        super();
        setName("AT");
        setLayout(new BorderLayout());       
        this.controlador = controlador;
        instance = this;
        datos = DB.getInstance();
        boton = new ButtonTabComponent(this);
        boton.setBounds(5, 0, boton.getWidth(), boton.getHeight());
        
        botonnn = new JButton("Buscar");
        botonnn.setBounds(5,0, 5, 10);
        botonnn.setName("BUSCAR");
        botonnn.addActionListener(controlador);
        
        add(panelBoton, BorderLayout.SOUTH);

        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(model, p);
        botonFecha = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        
        crearBotonesInicio("Registrar", "formulario");
        crearBotonesInicio("Ver Diagrama", "diagrama");
        crearBotonesInicio("Gráfico", "nuevo");
        panelBoton.setSize(this.getWidth(), 80);
        panelBoton.setLocation(30, 300);
        
        barraSuperior.setSize(this.getWidth(), 25);
        barraSuperior.add(boton);
        barraSuperior.add(botonFecha);   
        barraSuperior.add(botonnn);     
    }
    
    public void dibujarDiagrama () {
                
        remove(panelBoton);
        diagramaActivo = true;
        
        int x = 20, y = 60, i=0, a = 0, b = 0, c = 0;
        int lineaActual = 0;
                
        ArrayList<Object> v = new ArrayList<Object>();
        Object v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13;
        
		Object parent = graph.getDefaultParent();
        
        Map<String, Object> style = graph.getStylesheet().getDefaultEdgeStyle();
        style.put(mxConstants.STYLE_EDGE, mxEdgeStyle.EntityRelation);
        style.put(mxConstants.STYLE_FONTCOLOR, "#774400");
        style.put(mxConstants.STYLE_OPACITY, 50);
        style.put(mxConstants.STYLE_FONTCOLOR, "#774400");

		graph.getModel().beginUpdate();
		try
		{           
            for (String t : titulos0) {
                    v1 = graph.insertVertex(parent, null, t, x+((lineaActual*2)+a), y*(++i)+b+c, 100, 40);                     
                    v.add(v1);
                }
                
                v2 = graph.insertVertex(parent, null, "ACR", 170, 50, 100, 40); 
                v3 = graph.insertVertex(parent, null, "Mantenimiento \nplanificado", 170, 120, 100, 40);                     
                v4 = graph.insertVertex(parent, null, "Inventarios", 170, 500, 100, 40);                     
                v5 = graph.insertVertex(parent, null, "Factor de utilización de \nla capacidad instalada", 170, 600, 100, 40);                     
                v6 = graph.insertVertex(parent, null, "Confiabilidad", 350, 70, 100, 40);   
                v7 = graph.insertVertex(parent, null, "MTTR", 350, 250, 100, 40);                     
                v8 = graph.insertVertex(parent, null, "Disponibilidad", 460, 150, 100, 40);                     
                v9 = graph.insertVertex(parent, null, "Costos", 490, 350, 100, 40);                     
                v10 = graph.insertVertex(parent, null, "Ingresos", 630, 150, 100, 40);                     
                v11 = graph.insertVertex(parent, null, "AO", 690, 500, 100, 40);                     
                v12 = graph.insertVertex(parent, null, "EBIT", 700, 260, 100, 40);                     
                v13 = graph.insertVertex(parent, null, "EVA", 790, 350, 100, 40);                                    
                          
			graph.insertEdge(parent, null, " ", v.get(0), v3);
            graph.insertEdge(parent, null, " ", v.get(1), v3);
            graph.insertEdge(parent, null, " ", v.get(2), v7);
            graph.insertEdge(parent, null, " ", v.get(3), v7);
            graph.insertEdge(parent, null, " ", v.get(4), v7);
            graph.insertEdge(parent, null, " ", v.get(6), v4);
            graph.insertEdge(parent, null, " ", v.get(7), v4);
            graph.insertEdge(parent, null, " ", v.get(8), v4);
            graph.insertEdge(parent, null, " ", v2, v6);
            graph.insertEdge(parent, null, " ", v3, v6);
            graph.insertEdge(parent, null, " ", v4, v11);
            graph.insertEdge(parent, null, " ", v4, v9);
            graph.insertEdge(parent, null, " ", v5, v11);
            graph.insertEdge(parent, null, " ", v.get(2), v9);
            graph.insertEdge(parent, null, " ", v.get(3), v9);
            graph.insertEdge(parent, null, " ", v.get(4), v9);
            graph.insertEdge(parent, null, " ", v.get(5), v8);
            graph.insertEdge(parent, null, " ", v.get(5), v9);
            graph.insertEdge(parent, null, " ", v6, v8);
            graph.insertEdge(parent, null, " ", v7, v8);
            graph.insertEdge(parent, null, " ", v8, v10);
            graph.insertEdge(parent, null, " ", v9, v12);
            graph.insertEdge(parent, null, " ", v10, v12);
            graph.insertEdge(parent, null, " ", v11, v13);
            graph.insertEdge(parent, null, " ", v12, v13);
		}
		finally
		{
			graph.getModel().endUpdate();
		}
                
        graphComponent.getGraphControl().addMouseListener(new MouseAdapter() {
            @Override 
            public void mousePressed(MouseEvent e)
            {
                form = new Formulas(getFecha());
                String name;
                float num;
                Object cell = graphComponent.getCellAt(e.getX(), e.getY());
                if (cell instanceof mxCell)
                {
                    name = (String)(((mxCell) cell).getValue());
                    
                        switch (name){
                            case "Mantenimiento \npredictivo":
                                setValor(form.getMantenimientoPredictivo());
                                new PopClickListener(e, name, valor);      
                                break;
                            case "Mantenimiento \npreventivo": 
                                setValor(form.getMantenimientoPreventivo()); 
                                new PopClickListener(e, name, valor);      
                                break;
                            case "Planificación":
                                setValor(form.getPlanificacion());
                                new PopClickListener(e, name, valor);      
                                break;
                            case "Programación":
                                setValor(form.getProgramacion());
                                new PopClickListener(e, name, valor);      
                                break;
                            case "Ejecución":
                                setValor(form.getEjecucion());
                                new PopClickListener(e, name, valor);      
                                break;
                            case "Gestión de las \nparadas de planta":
                                setValor("");
                                new PopClickListener(e, name, valor);      
                                break;
                            case "Punto de pedido":
                                setValor(form.getPuntoPedido());
                                new PopClickListener(e, name, valor);      
                                break;
                            case "Cantidad de pedido":
                                setValor(form.getCantidadPedido());
                                new PopClickListener(e, name, valor);      
                                break;
                            case "Materiales \nobsoletos":
                                setValor(form.getMaterialesObsoletos());
                                new PopClickListener(e, name, valor);      
                                break;
                            case "ACR":
                                setValor("");
                                new PopClickListener(e, name, valor);      
                                break;
                            case "Mantenimiento \nplanificado":
                                setValor(form.getMantenimientoPlanificado());
                                new PopClickListener(e, name, valor);      
                                break;
                            case "Inventarios":
                                setValor(form.getInventarios());
                                new PopClickListener(e, name, valor);      
                                break;
                            case "Factor de utilización de \nla capacidad instalada":
                                setValor("");
                                new PopClickListener(e, name, valor);      
                                break;
                            case "Confiabilidad":
                                setValor(form.getConfiabilidad());
                                new PopClickListener(e, name, valor);      
                                break;
                            case "MTTR":
                                setValor(form.getMTTR());
                                new PopClickListener(e, name, valor);      
                                break;
                            case "Disponibilidad":
                                setValor(form.getDisponibilidad());
                                new PopClickListener(e, name, valor);      
                                break;
                            case "Costos":
                                setValor(form.getCostos());
                                new PopClickListener(e, name, valor);      
                                break;
                            case "Ingresos":
                                setValor("");
                                new PopClickListener(e, name, valor);      
                                break;
                            case "AO":
                                new PopClickListener(e, name, valor);      
                                break;
                            case "EBIT":
                                new PopClickListener(e, name, valor);      
                                break;
                            case "EVA":
                                new PopClickListener(e, name, valor);      
                                break;

                            default:
                                System.out.println("No existente.");
                                break;
                        
                    }
                    
                }
            }
        }); 

		add(graphComponent);
        add(barraSuperior, BorderLayout.NORTH);
        barraSuperior.repaint();
        controlador.setEstado("");
        repaint();
    }
    
    public void cerrarDiagrama() {
        diagramaActivo = false;
        datePanel.getModel().setValue(null);
        remove(graphComponent);
        remove(boton);
        remove(botonFecha);
        remove(barraSuperior);
        removeAll();
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
            y = (this.getHeight()/5)-(h/2)+50;
            
            g.drawImage(fondo, x, y, w, h, this);
            
            add(panelBoton, BorderLayout.SOUTH);            
        }
    }
    
    public JButton botonIcon(String nombre, int x, int y, String imagen){
        JButton boto = new JButton();
        ImageIcon img = new ImageIcon("src/images/"+imagen+".png");
        Image image = img.getImage();
        image = image.getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH );
        boto.setHorizontalAlignment(SwingConstants.RIGHT);
        boto.setIcon(new ImageIcon(image));
        boto.setName(nombre.toUpperCase());
        boto.setBounds(x, y, 200, 64);
        boto.setToolTipText(nombre);
        boto.addActionListener(controlador);
        boto.addMouseListener(controlador);
        boto.setLayout(new GridLayout(1,1));
        boto.setBorder(BorderFactory.createEmptyBorder());
        boto.setBorderPainted(false); 
        boto.setContentAreaFilled(false); 
        boto.setFocusPainted(false); 
        boto.setOpaque(false);
        boto.setText(nombre);
        boto.setFont(new Font("Arial", Font.PLAIN, 24));
        
        add(boto);
        return boto;
    }
    
    public void crearBotonesInicio (String toolTipText, String nombreImagen){
        panelBoton.add(botonn = botonIcon(toolTipText, 250, 300, nombreImagen));
    }
    
    public void setFecha(String val){ this.fecha = val;
    }
    public String getFecha(){ return fecha; }
    
    public void setFechaBoton(String val) { this.fecha = val;}
    public String getFechaBoton() {
        String diaa = "", mess = "";
        int mes = botonFecha.getModel().getMonth()+1;
        int dia = botonFecha.getModel().getDay();
        if(dia<10) diaa = "0"+dia;
        if (mes<10) mess = "0"+mes;
        
        return botonFecha.getModel().getDay()+"-"+mess+"-"+botonFecha.getModel().getYear(); }
    
    public void setValor(String val) { this.valor = val;}
    
    public static synchronized AreaTrabajo getInstance() {
        if (instance == null) instance = new AreaTrabajo(Controlador.getInstance());
        return instance;
    }
}