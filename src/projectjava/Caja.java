package projectjava;

import java.awt.Color;
import java.awt.Label;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Caja extends JPanel {
    
    public Caja (String titulo, int w, int h, String valor) {
        Label t = new Label(titulo);
        this.setSize(w, h);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }
}