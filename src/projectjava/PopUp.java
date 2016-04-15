/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import controller.Controlador;
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
    String nombreCampo, valor;
    Formulas form = new Formulas();
    Grafico grafico = new Grafico();
       
    public void agregarItem(String name){
        item = new JMenuItem(name);
        item.setName(name);
        item.addActionListener(this);
        add(item);
    }
    
    public void setNombrecampo(String name){
        this.nombreCampo = name;
    }
    
    public String getNombreCampo(){ return nombreCampo; }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String fuente = ((JComponent)ae.getSource()).getName();
        
        switch (fuente){
            case "Mostrar Formula":
                if(nombreCampo.equals("Disponibilidad"))
                    JOptionPane.showMessageDialog(this, form.getFormulaDisponibilidad());
                
                break;
            case "Mostrar Gráfico":
                grafico.setName(nombreCampo);
                grafico.iniciar();
                break;
            case "Valor":
                    JOptionPane.showMessageDialog(this, valor);
                 break;
                
            default:              
                System.out.println("No existente.");
                break;
        }
    }
    
    public void setValor(String val){ this.valor = val; }
    
}
