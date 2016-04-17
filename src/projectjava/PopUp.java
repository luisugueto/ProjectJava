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
    String nombreCampo;
    String valor;
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
                if (nombreCampo.equals("Mantenimiento \npredictivo"))
                    JOptionPane.showMessageDialog(this, form.formMantenPredictivo);
                if (nombreCampo.equals("Mantenimiento \npreventivo"))
                    JOptionPane.showMessageDialog(this, form.formMantenPreventivo);
                if (nombreCampo.equals("Planificación"))
                    JOptionPane.showMessageDialog(this, form.formPlanificacion);
                if (nombreCampo.equals("Programación"))
                    JOptionPane.showMessageDialog(this, form.formProgramacion);
                if (nombreCampo.equals("Ejecución"))
                    JOptionPane.showMessageDialog(this, form.formEjecucion);
                if (nombreCampo.equals("Punto de pedido"))
                    JOptionPane.showMessageDialog(this, form.formPuntoPedido);
                if (nombreCampo.equals("Cantidad de pedido"))
                    JOptionPane.showMessageDialog(this, form.formCantidadPedido);
                if (nombreCampo.equals("Materiales \nobsoletos"))
                    JOptionPane.showMessageDialog(this, form.formMaterialesObsoletos);
                if (nombreCampo.equals("ACR"))
                    JOptionPane.showMessageDialog(this, form.formAnalisisCausaRaiz);
                if (nombreCampo.equals("Mantenimiento \nplanificado"))
                    JOptionPane.showMessageDialog(this, form.formMantenPlanificado);
                if (nombreCampo.equals("Inventarios"))
                    JOptionPane.showMessageDialog(this, form.formInventarios);
                if (nombreCampo.equals("Factor de utilización de \nla capacidad instalada"))
                    JOptionPane.showMessageDialog(this, form.formFactorUtilizacion);
                if (nombreCampo.equals("Confiabilidad"))
                    JOptionPane.showMessageDialog(this, form.formConfiabilidad);
                if (nombreCampo.equals("MTTR"))
                    JOptionPane.showMessageDialog(this, form.formMTTR);
                if (nombreCampo.equals("Disponibilidad"))
                    JOptionPane.showMessageDialog(this, form.formDisponibilidad);
                if (nombreCampo.equals("Costos"))
                    JOptionPane.showMessageDialog(this, form.formCostos);              
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
