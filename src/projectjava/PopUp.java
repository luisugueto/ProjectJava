/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 *
 * @author Luis
 */
public class PopUp extends JPopupMenu implements ActionListener{
    JMenuItem item;
       
    public void agregarItem(String name){
        item = new JMenuItem(name);
        item.setName(name);
        item.addActionListener(this);
        add(item);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String fuente = ((JComponent)ae.getSource()).getName();
        
        switch (fuente){
            case "Mostrar Formula":
                JOptionPane.showMessageDialog(this, "Prueba");
                break;
            case "Mostrar Gráfico":
                JOptionPane.showMessageDialog(this, "Prueba");
                break;
                
            default:              
                System.out.println("No existente.");
                break;
        }
    }
    
}
