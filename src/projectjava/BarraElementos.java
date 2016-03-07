package projectjava;

import controller.Controlador;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class BarraElementos extends JPanel
{
    JButton botonh1, botonh2, botonh3;
    JButton botonesH[] = { botonh1, botonh2, botonh3};
    
    JButton botonp1, botonp2;
    JButton botonesP[] = { botonp1, botonp2};
    
    Controlador controlador;
    JPanel piezas = new JPanel();
    JPanel herramientas = new JPanel();
    JPanel piezasP = new JPanel(new BorderLayout());
    JPanel herramientasP = new JPanel(new BorderLayout());
        
    BarraElementos (Controlador controlador)
    {
        super(new BorderLayout());
        this.controlador = controlador;
        this.setBackground(Colores.main);
        setPreferredSize(new Dimension(85, 150));
        ((BorderLayout)this.getLayout()).setHgap(5);
        ((BorderLayout)this.getLayout()).setVgap(0);
        
        herramientas.setLayout(new FlowLayoutV(FlowLayoutV.LEFT, 8, 8));
        herramientas.setPreferredSize(new Dimension(80, 150));
        herramientas.setBackground(Colores.inside_panel);
        herramientasP.setBackground(Colores.main);
        herramientasP.add(herramientas);
        herramientasP.setBorder(new TitledBorder("Utiles"));
        ((TitledBorder)herramientasP.getBorder()).setTitleFont(new Font("Arial", Font.BOLD, 10));
        ((TitledBorder)herramientasP.getBorder()).setTitleColor(Colores.font_tborder);

        
        piezas.setLayout(new FlowLayoutV(FlowLayoutV.LEFT, 8, 8));
        piezas.setPreferredSize(new Dimension(64, 150));
        piezas.setBackground(Colores.inside_panel);
        piezasP.add(piezas);
        piezasP.setBackground(Colores.main);
        piezasP.setBorder(new TitledBorder("Piezas"));
        ((TitledBorder)piezasP.getBorder()).setTitleFont(new Font("Arial", Font.BOLD, 10));
        ((TitledBorder)piezasP.getBorder()).setTitleColor(Colores.font_tborder);

        int i=1;
        for (JButton boton : botonesH)
        {
            boton = new JButton();
            boton.setName("BOTONEH"+i);
            boton.addActionListener(controlador);
            boton.setIcon(new ImageIcon("icons/botoneh"+i+".png"));
            boton.setSize(24, 24);
            boton.setBorder(BorderFactory.createEmptyBorder());
            boton.setBorderPainted(false); 
            boton.setContentAreaFilled(false); 
            boton.setFocusPainted(false); 
            boton.setOpaque(false);
            herramientas.add(boton);
            
            i++;
        }
        
        i=1;
        for (JButton boton : botonesP)
        {
            boton = new JButton();
            boton.setName("BOTONEP"+i);
            boton.addActionListener(controlador);
            boton.setIcon(new ImageIcon("icons/botonep"+i+".png"));
            boton.setSize(24, 24);
            boton.setBorder(BorderFactory.createEmptyBorder());
            boton.setBorderPainted(false); 
            boton.setContentAreaFilled(false); 
            boton.setFocusPainted(false); 
            boton.setOpaque(false);
            piezas.add(boton);
            i++;
        }
        
        this.add(herramientasP, BorderLayout.PAGE_START);
        this.add(piezasP);
        
    }
}
