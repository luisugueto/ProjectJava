package projectjava;

import java.awt.Color;
import javax.swing.JColorChooser;

public class Colores extends javax.swing.JFrame
{
    private static volatile Colores instance = null;
    
    Ventana v;
    int red, green, blue;
    
    // Colores por defecto
    public static Color
        main = new Color(238,238,238),
        inside_panel = new Color(210,210,210),
        area_trabajo = new Color(255,254,251),
        font_tborder = new Color(80,80,80);
    
    public void CambiarColor(Ventana v){
        Color c = JColorChooser.showDialog(this, "Seleccione el color" , Color.white); 
        if(c != null){
           v.barraHerramientas.setBackground(c);
           v.barraMenu.setBackground(c);
           v.areaTrabajo.setBackground(c);
           v.barraEstado.setBackground(c);     
           this.red = c.getRed();
           this.green = c.getGreen();
           this.blue = c.getBlue();
           main = new Color(red, green, blue);
           inside_panel = new Color(red, green, blue);
           area_trabajo = new Color(red, green, blue);
           font_tborder = new Color(red, green, blue);
           
        }
    }    
    
    public static synchronized Colores getInstance() {
        if (instance == null) instance = new Colores();
          
        return instance;
    }
}
