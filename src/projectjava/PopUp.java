/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import controller.Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    String nombreCampo;
    String valor;
    Formulas form = new Formulas();
    Grafico grafico = new Grafico();
    Controlador control = Controlador.getInstance();
       
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
                if (nombreCampo.equals("Mantenimiento \npredictivo"))
                    JOptionPane.showMessageDialog(this, form.formMantenPredictivo, "Formula", JOptionPane.INFORMATION_MESSAGE);
                if (nombreCampo.equals("Mantenimiento \npreventivo"))
                    JOptionPane.showMessageDialog(this, form.formMantenPreventivo, "Formula", JOptionPane.INFORMATION_MESSAGE);
                if (nombreCampo.equals("Planificación"))
                    JOptionPane.showMessageDialog(this, form.formPlanificacion, "Formula", JOptionPane.INFORMATION_MESSAGE);
                if (nombreCampo.equals("Programación"))
                    JOptionPane.showMessageDialog(this, form.formProgramacion, "Formula", JOptionPane.INFORMATION_MESSAGE);
                if (nombreCampo.equals("Ejecución"))
                    JOptionPane.showMessageDialog(this, form.formEjecucion, "Formula", JOptionPane.INFORMATION_MESSAGE);
                if (nombreCampo.equals("Punto de pedido"))
                    JOptionPane.showMessageDialog(this, form.formPuntoPedido, "Formula", JOptionPane.INFORMATION_MESSAGE);
                if (nombreCampo.equals("Cantidad de pedido"))
                    JOptionPane.showMessageDialog(this, form.formCantidadPedido, "Formula", JOptionPane.INFORMATION_MESSAGE);
                if (nombreCampo.equals("Materiales \nobsoletos"))
                    JOptionPane.showMessageDialog(this, form.formMaterialesObsoletos, "Formula", JOptionPane.INFORMATION_MESSAGE);
                if (nombreCampo.equals("ACR"))
                    JOptionPane.showMessageDialog(this, form.formAnalisisCausaRaiz, "Formula", JOptionPane.INFORMATION_MESSAGE);
                if (nombreCampo.equals("Mantenimiento \nplanificado"))
                    JOptionPane.showMessageDialog(this, form.formMantenPlanificado, "Formula", JOptionPane.INFORMATION_MESSAGE);
                if (nombreCampo.equals("Inventarios"))
                    JOptionPane.showMessageDialog(this, form.formInventarios, "Formula", JOptionPane.INFORMATION_MESSAGE);
                if (nombreCampo.equals("Factor de utilización de \nla capacidad instalada"))
                    JOptionPane.showMessageDialog(this, form.formFactorUtilizacion, "Formula", JOptionPane.INFORMATION_MESSAGE);
                if (nombreCampo.equals("Confiabilidad"))
                    JOptionPane.showMessageDialog(this, form.formConfiabilidad, "Formula", JOptionPane.INFORMATION_MESSAGE);
                if (nombreCampo.equals("MTTR"))
                    JOptionPane.showMessageDialog(this, form.formMTTR, "Formula", JOptionPane.INFORMATION_MESSAGE);
                if (nombreCampo.equals("Disponibilidad"))
                    JOptionPane.showMessageDialog(this, form.formDisponibilidad, "Formula", JOptionPane.INFORMATION_MESSAGE);
                if (nombreCampo.equals("Costos"))
                    JOptionPane.showMessageDialog(this, form.formCostos, "Formula", JOptionPane.INFORMATION_MESSAGE);              
                break;
            case "Mostrar Gráfico":
                control.setNombreGrafico(nombreCampo);
                try {
                    grafico.iniciar();
                } catch (Exception ex) {
                    Logger.getLogger(PopUp.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Valor":
                    JOptionPane.showMessageDialog(this, valor, "Valor", JOptionPane.INFORMATION_MESSAGE);
                 break;
                
            default:              
                System.out.println("No existente.");
                break;
        }
    }
    
    public void setValor(String val){ this.valor = val; }
    
}
