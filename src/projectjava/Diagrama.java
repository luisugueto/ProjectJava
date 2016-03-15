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
        
    AreaTrabajo at = AreaTrabajo.getInstance();
    
    Graph graph = new SingleGraph("TITULO");
    Viewer viewer = new Viewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
    View view = viewer.addDefaultView(false);
    
    public Diagrama () {
  
        setLayout(new BorderLayout());
        add(view, BorderLayout.CENTER);
        setSize(at.getWidth()-10, at.getHeight()-40);
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

    }
    
    public void cerrarDiagrama () {
        at.cerrarDiagrama();
    }

}
