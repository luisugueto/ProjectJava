package spev;

import controller.Controlador;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author POSTGRADO
 */
public class BarraMenu extends JMenuBar
{
    private KeyStroke accelerator;
    String menuText[] = {"Archivo", "Reportes", "Ayuda"};
    JMenu menus[];
    
    String archivoText[]   = {"Nuevo", "Abrir", "Guardar", /*"Guardar todo",*/
                              "Guardar Como...", "Cerrar todo","Imprimir",
                              /*"Configuración",*/ "Salir"},
            
           reportesText[] = {"Historial Actual", "Estado Actual", "Reporte Completo"},
            
           ayudaText[]   = {"Información","Reportar error", "Ver Logs",
                            "Tablas Termodinámica","Acerca de..."};
    
    String textItems[][] = {archivoText, reportesText, ayudaText};
    
    String toToggle [] = {"Guardar",/* "Guardar todo",*/ "Guardar Como...", "Cerrar todo","Imprimir"};
    boolean menusActivos;
    
    Controlador controlador;
            
    BarraMenu (Controlador controlador)
    {
        super();
        this.controlador = controlador;
        this.setBackground(Colores.main);
        menusActivos = true;
        crearMenus();
        toggleMenus();
    }
    
    public void setAccelerator(KeyStroke keyStroke) {
                KeyStroke oldAccelerator = accelerator;
                this.accelerator = keyStroke;
                repaint();
                revalidate();
                firePropertyChange("accelerator", oldAccelerator, accelerator);
    }
    
    public KeyStroke getAccelerator() {
        return accelerator;
    }
    
    public void toggleMenus () {
        menusActivos = !menusActivos;
        
        JMenu archivo = getMenu("Archivo");
        for (String n : toToggle) getMenuItem(archivo, n).setEnabled(menusActivos);
                
        getMenu("Reportes").setEnabled(menusActivos);
    }
    
    private JMenu getMenu (String name) {
        for (JMenu m : menus) if (m.getName().equals(name)) return m;
        return null;
    }
    
    private JMenuItem getMenuItem (String name) {
        name = name.toUpperCase();
        for (JMenu m : menus) {
            for (int i=0; i<m.getItemCount(); i++) {
                JMenuItem mi = m.getItem(i);
                if (mi.getName().equals(name)) return mi;
            }
        }
        return null;
    }
    
    private JMenuItem getMenuItem (JMenu m, String name) {
        name = name.toUpperCase();
        for (int i=0; i<m.getItemCount(); i++) {
            JMenuItem mi = m.getItem(i);
            if (mi.getName().equals(name)) return mi;
        }
        return null;
    }
    
    private void crearMenus ()
    {
        
       menus = new JMenu[menuText.length];
       
       for (int i=0; i<menuText.length ; i++)
       {
           JMenu menu = new JMenu(menuText[i]);
           menu.setName(menuText[i]);
           menus[i] = menu;
           this.add(menu);
           menu.setForeground(Colores.font_tborder); 
           
           for (String item : textItems[i])
           {
               JMenuItem jm = new JMenuItem(item);
               jm.setName(item.toUpperCase());
               jm.setBackground(Colores.main);
               jm.setForeground(Colores.font_tborder);
               jm.addActionListener(controlador);
               menu.add(jm);
               
               String texto = jm.getText();
               
              if(texto.equalsIgnoreCase("Nuevo"))
              { 
                jm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
              }
              if(texto.equalsIgnoreCase("Abrir"))
              { 
                jm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
              }
              if(texto.equalsIgnoreCase("Guardar como..."))
              { 
                jm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
              }
              if(texto.equalsIgnoreCase("Cerrar todo"))
              { 
                jm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.CTRL_MASK));
              }
              if(texto.equalsIgnoreCase("Configuración"))
              { 
                jm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, KeyEvent.CTRL_MASK));
              }
              if(texto.equalsIgnoreCase("Gráfico"))
              { 
                jm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_MASK));
              }
              if(texto.equalsIgnoreCase("Acerca de..."))
              { 
                jm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, KeyEvent.CTRL_MASK));
              }
              if(texto.equalsIgnoreCase("Imprimir"))
              { 
                jm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));
              }
              if(texto.equalsIgnoreCase("FONDO"))
              { 
                jm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_MASK));
              }
              if(texto.equalsIgnoreCase("REPORTAR ERROR"))
              { 
                jm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, KeyEvent.CTRL_MASK));
              }
            }
        }
    }
}
