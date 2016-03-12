package projectjava;

import controller.Controlador;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import projectjava.Colores;

/**
 *
 * @author POSTGRADO
 */
public class BarraMenu extends JMenuBar
{
    Ventana ventana = new Ventana();
    int tipo;
    private KeyStroke accelerator;
    String menuText[] = {"Archivo", "Grafico", "Usuarios", "Ayuda"};
    JMenu menus[];
    
    String archivoText[]   = {"Nuevo", /*"Abrir", "Guardar", "Guardar todo",
                              "Guardar Como...", "Cerrar todo","Imprimir",
                              "Configuración",*/ "Salir"},
            
           graficoText[] = {"Ver Gráfico"},
            
           usuarioText[] = {"Nuevo Usuario", "Lista de Usuarios"},
            
           ayudaText[]   = {"Información","Reportar error"};
    
    String textItems[][] = {archivoText, graficoText, usuarioText, ayudaText};
    
    String toToggle [] = {"Nuevo"};
    boolean menusActivos;
    
    Controlador controlador;
            
    BarraMenu (Controlador controlador, int tipo)
    {
        super();
        this.controlador = controlador;
        this.setBackground(Colores.main);
        menusActivos = true;
        crearMenus();
        setTipo(tipo);
        if (getTipo() == 2) toggleMenus();
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
        
       // JMenu archivo = getMenu("Archivo");
       // for (String n : toToggle) getMenuItem(archivo, n).setEnabled(menusActivos);
       getMenu("Usuarios").setVisible(menusActivos);
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
               
              if(texto.equalsIgnoreCase("Acerca de..."))
              { 
                jm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, KeyEvent.CTRL_MASK));
              }
              if(texto.equalsIgnoreCase("REPORTAR ERROR"))
              { 
                jm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, KeyEvent.CTRL_MASK));
              }
            }
        }
    }
    
    public void setTipo(int tipo){this.tipo = tipo;}
    private int getTipo(){ return this.tipo;}
    
}
