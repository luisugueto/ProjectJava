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
 
    @Override 
    public void start(Stage stage) {
        stage.setTitle("Gráfico");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
         xAxis.setLabel("Comportamiento Térmico");
        final LineChart<String,Number> lineChart = new LineChart<String,Number>(xAxis,yAxis);
       
        lineChart.setTitle("Comportamiento Térmico");
                          
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Estados Térmicos");
        
        series1.getData().add(new XYChart.Data("Primero", 0));
        series1.getData().add(new XYChart.Data("Segundo", 30));
        series1.getData().add(new XYChart.Data("Tercero", 31));
        series1.getData().add(new XYChart.Data("Cuarto", 0));
                   
        Scene scene  = new Scene(lineChart,800,600);       
        lineChart.getData().add(series1);
       
        stage.setScene(scene);
        stage.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}