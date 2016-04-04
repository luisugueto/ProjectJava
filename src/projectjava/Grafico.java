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
    String desde = ""+getDiaDesde()+"-"+getMesDesde()+"-"+getAnioDesde(), hasta = ""+getDiaHasta()+"-"+getMesHasta()+"-"+getAnioHasta();

    @Override 
    public void start(Stage stage) {
        stage.setTitle("Gráfico de Disponibilidad");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
         xAxis.setLabel("Fechas");
        final LineChart<String,Number> lineChart = new LineChart<String,Number>(xAxis,yAxis);
       
        lineChart.setTitle("Gráfico de Disponibilidad entre fechas");
                          
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Disponibilidad");
        
        //series1.getData().add(new XYChart.Data("", 0));
        //series1.getData().add(new XYChart.Data(getDesde(), 30));
        //series1.getData().add(new XYChart.Data(getHasta(), 31));
        //series1.getData().add(new XYChart.Data("", 0));
        
        for (int i =0; i < 20 ; i++) {
            series1.getData().add(new XYChart.Data((i+1)+"-03-16", (int)Math.floor(Math.random()*(200-30)+30)));
        }
                   
        Scene scene  = new Scene(lineChart,800,600);       
        lineChart.getData().add(series1);
       
        stage.setScene(scene);
        stage.show();
    }
    
    public void iniciar(){
        launch();
    }
    
    public void setDesde(String des){ this.desde = des; }
    public void setHasta(String has){ this.hasta = has; }
    
    public String getDesde(){ return desde; }
    public String getHasta(){ return hasta; }
    
    public void setDiaDesde(int n){ this.diaDesde = n; }
    public void setMesDesde(int n){ this.mesDesde = n; }
    public void setAnioDesde(int n){ this.anioDesde = n; }

    public void setDiaHasta(int n){ this.diaHasta = n; }
    public void setMesHasta(int n){ this.mesHasta = n; }
    public void setAnioHasta(int n){ this.anioHasta = n; }
    
    
    public int getDiaDesde(){ return diaDesde; }
    public int getMesDesde(){ return mesDesde; }
    public int getAnioDesde(){ return anioDesde; }

    public int getDiaHasta(){ return diaHasta; }
    public int getMesHasta(){ return mesHasta; }
    public int getAnioHasta(){ return anioHasta; }

}