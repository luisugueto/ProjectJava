package projectjava;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
 
public class Grafico extends Application {
    int diaDesde, mesDesde, anioDesde, diaHasta, mesHasta, anioHasta;
    String desde = ""+diaDesde+"-"+mesDesde+"-"+anioDesde, hasta = ""+diaHasta+"-"+mesHasta+"-"+anioHasta;

    @Override 
    public void start(Stage stage) {
        stage.setTitle("Gráfico");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
         xAxis.setLabel("Prueba");
        final LineChart<String,Number> lineChart = new LineChart<String,Number>(xAxis,yAxis);
       
        lineChart.setTitle("Prueba");
                          
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Prueba");
        
        series1.getData().add(new XYChart.Data("", 0));
        series1.getData().add(new XYChart.Data(desde, 30));
        series1.getData().add(new XYChart.Data(hasta, 60));
        
        Scene scene  = new Scene(lineChart,500,400);       
        lineChart.getData().add(series1);
       
        stage.setScene(scene);
        stage.show();
    }
    
    public void iniciar(){
        System.out.println(desde);  
        System.out.println(hasta);
        launch();
    }
    
    public void setDesde(String des){ this.desde = des; }
    public void setHasta(String has){ this.hasta = hasta; }
    
    public void setDiaDesde(int n){ this.diaDesde = n; }
    public void setMesDesde(int n){ this.mesDesde = n; }
    public void setAnioDesde(int n){ this.anioDesde = n; }

    public void setDiaHasta(int n){ this.diaHasta = n; }
    public void setMesHasta(int n){ this.mesHasta = n; }
    public void setAnioHasta(int n){ this.anioHasta = n; }

}