package projectjava;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BarraDeEstado extends JPanel
{
    JLabel estadoActual;
    public String default_message, m;
    private final Font font = new Font("Arial", Font.PLAIN, 11);
    
    BarraDeEstado ()
    {
        super();
        this.default_message = " ... ";
                
        estadoActual = new JLabel(default_message);
        add(estadoActual);
        estadoActual.setFont(font);
        estadoActual.setForeground(Colores.font_tborder);        
    }   
    
    public void addMensajeEstadoActual(String msj){
        m = m+" "+msj;
        estadoActual.setText(m);
    }
    public void setMensaje(String msj) {
        m = " ";
        m = msj;
        this.estadoActual.setText(m);
    }
    
    public String getMensaje() {
        return this.estadoActual.getText();
    }
}
