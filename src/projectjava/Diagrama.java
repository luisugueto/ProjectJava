package projectjava;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.swingViewer.View;
import org.graphstream.ui.swingViewer.Viewer;


public class Diagrama extends JPanel {
    
    String[] titulosIniciales = 
        { "Mantenimiento<br>predictivo", "Mantenimiento<br>preventivo",
        "Planificación", "Programación", "Ejecución", "Gestión de las<br>paradas de planta",
        "Punto de Pedido", "Cantidad de Pedido", "Materiales obsoletos"};
        
    AreaTrabajoo at = AreaTrabajoo.getInstance();
    
    public Diagrama () {
        Graph graph = new SingleGraph("Tutorial 1");
        Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        View view = viewer.addDefaultView(false);
        
        setLayout(new BorderLayout());
        add(view, BorderLayout.CENTER);
        setSize(320, 240);
        setVisible(true);
        
        graph.addNode("A" );
        graph.addNode("B" );
        graph.addNode("C" );
        graph.addEdge("AB", "A", "B");
        graph.addEdge("BC", "B", "C");
        graph.addEdge("CA", "C", "A");
        
        graph.addAttribute("ui.quality");
        graph.addAttribute("ui.antialias");

        add(view);
    }

}
