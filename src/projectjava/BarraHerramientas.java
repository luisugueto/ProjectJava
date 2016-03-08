package projectjava;

import controller.Controlador;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BarraHerramientas extends JPanel
{
    
    String texts[] = {"Nuevo", "Abrir", "Guardar", "Guardar Todo...", "Imprimir", "Tablas Termodinamica"};
    String tts[] = { "Crea un nuevo Ciclo.",
                     "Abre un Ciclo desde un archivo.",
                     "Guarda el Ciclo actual.",
                     "Guarda todos los Ciclos abiertos.",
                     "Imprime el Ciclo actual",
                     "Abre las tablas de valores de vapor de agua (A-4, A-5, A-6)"};
    
    ArrayList botones;
    boolean activos[] = new boolean[]{true, true, false, false, false, true};
    
    Controlador controlador;
    
    String toToggle[] = { "GUARDAR", "GUARDAR TODO...", "IMPRIMIR"};
    boolean toggled;
    
   BarraHerramientas (Controlador controlador, boolean tipo)
    {
        super();
        setBackground(Colores.main);
        this.controlador = controlador;
        ((FlowLayout)this.getLayout()).setAlignment(FlowLayout.LEFT);
        toggled = false;
        
        botones = new ArrayList();
        
        int i=1;
        for (String txt : texts)
        {
            Boton boton = new Boton();
            boton.setName(texts[i-1].toUpperCase());
            boton.addActionListener(controlador);
            boton.setSize(24, 24);
            boton.setBorder(BorderFactory.createEmptyBorder());
            boton.setBorderPainted(false); 
            boton.setContentAreaFilled(false); 
            boton.setFocusPainted(false); 
            boton.setOpaque(false);
            boton.setToolTipText(tts[i-1]);
            boton.setBEText(tts[i-1]);
            
//            boton.setIcon(controlador.crearImagen("/images/Iconos/"+texts[i-1]+".png", "Boton "+texts[i-1]));
//            add(boton);
            
            boton.setVisible(activos[i-1]);
            
            botones.add(boton);
            
            i++;
        }

    }
   
}
