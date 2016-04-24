package projectjava;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;
 
public class VentanaGrafico extends JFrame {
  
    JFreeChart Grafica;
    DefaultCategoryDataset Datos = new DefaultCategoryDataset();
    
//GRAFICO MULTILINEAL
    public VentanaGrafico (String titulo, ArrayList valores){
       
        XYSeries series = new XYSeries("Comportamiento");
        float v;
        // Introduccion de datos

        for(int i = 0; i < valores.size(); i++){
            v = Float.parseFloat(valores.get(i).toString());
            series.add(i, v);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);        

        JFreeChart chart = ChartFactory.createXYLineChart(
                " ",
                "Valores del Grafico", 
                ""+titulo, 
                dataset, 
                PlotOrientation.VERTICAL,
                true,
                false,
                false
        );
        
        
        chart.setBackgroundPaint(Color.white);
        // consigue una referencia para el plot en futuras personalizaciones…
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        // Permite visualizar las coordenadas trazando ejes
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);

        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        XYItemLabelGenerator xy = new StandardXYItemLabelGenerator();
        renderer.setBaseItemLabelGenerator(xy);
        renderer.setShapesVisible(true);
        renderer.setShapesFilled(true);
        //renderer.setBaseItemLabelVisible(true);
        renderer.setBaseLinesVisible(true);
        renderer.setBaseItemLabelsVisible(true);

        // Cambiando la unidad de seleccion auto tickchange a enteros solamente…
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // PERSONALIZACION OPCIONAL COMPLETA.        
        
        ChartFrame ventana = new ChartFrame(titulo, chart);
        //setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/logo.png")));
        ventana.pack();
        ventana.setSize(400, 400);
        ventana.setExtendedState(6);
        ventana.setResizable(true);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);   
    }   
}