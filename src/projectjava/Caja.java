package projectjava;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Caja extends JPanel {
    
    public Caja (String titulo, String valor, int w, int h, int x, int y) {
        titulo = "<html><b><h4>"+titulo+"</h4></b>";
        JLabel t = new JLabel(titulo+"<br><br>"+valor+"</html>");
        add(t);
        setToolTipText(valor);
        setBounds(x, y, w, h);
        setBorder(BorderFactory.createLineBorder(Color.black, 2));
        this.setBackground(Color.white);
    }
    
    public Caja (String titulo, String valor, int w, int h, int x, int y, Color color) {
        JLabel t = new JLabel(titulo);
        add(t);
        setBounds(200, 200, 100, 100);
        this.setSize(w, h);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }
}
