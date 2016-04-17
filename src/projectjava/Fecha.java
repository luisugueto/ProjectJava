/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import controller.Controlador;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import model.DB;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Luis
 */
public class Fecha extends javax.swing.JFrame {

    /**
     * Creates new form Fecha
     */
    Controlador control;
    AreaTrabajo area;
    UtilDateModel model = new UtilDateModel();
    UtilDateModel model1 = new UtilDateModel();
    JDatePanelImpl datePanel,datePanel1;
    JDatePickerImpl botonFecha, botonFecha1;
    Properties p = new Properties();

    JPanel panel = new JPanel();
    
    JLabel label1 = new JLabel("Desde");
    JLabel label2 = new JLabel("Hasta");
    JLabel label3 = new JLabel("Fecha");  
    String mess = "";
    String diaa = "";
    
    public Fecha(Controlador controlador){
        initComponents();
        ButtonTabComponent boton;
        this.control = controlador;
        
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        
        // 1 DATEPANEL
        datePanel = new JDatePanelImpl(model, p);
        botonFecha = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        panel.add(label3);
        panel.add(botonFecha);
        
        add(panel);       
        
        panel.setSize(260, 100);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(260, 140);      
    }   
    
    public Fecha(int num) {
        initComponents();
        
        ButtonTabComponent boton;
    
        label1.setVisible(true);
        label2.setVisible(true);
        
        /*for (int n=0; n<num; n++){
            if(n==0) panel.add(label1);
            if(n==1) panel.add(label2);
            crearFechas();
        }*/
        
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        
        // 1 DATEPANEL
        datePanel = new JDatePanelImpl(model, p);
        botonFecha = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        panel.add(label1);
        panel.add(botonFecha);
        
        
        // 2 DATEPANEL
        datePanel1 = new JDatePanelImpl(model1, p);
        botonFecha1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
        panel.add(label2);
        panel.add(botonFecha1);

        add(panel);       
        
        panel.setSize(260, 100);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(260, 140);      
    }
    
    
    public void crearFechas(){
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(model, p);
        botonFecha = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        
        panel.setSize(260, 100);
        panel.add(botonFecha);

        add(panel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingrese fecha:");
        setPreferredSize(new java.awt.Dimension(250, 270));

        aceptar.setText("Aceptar");
        aceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aceptarMouseClicked(evt);
            }
        });
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(aceptar)
                .addGap(18, 18, 18)
                .addComponent(cancelar)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(cancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        dispose();
        DB datos = DB.getInstance();
        int mes = botonFecha.getModel().getMonth()+1;
        int dia = botonFecha.getModel().getDay();
        if(dia<10) diaa = "0"+dia;
        if (mes<10) mess = "0"+mes;
        
        datos.getId(botonFecha.getModel().getDay()+"-"+mess+"-"+botonFecha.getModel().getYear(), 3);
        control.setFecha(datos.getResultado());
        if(datos.getResultado()!=null) control.dibujar();
        else JOptionPane.showMessageDialog(this, "No existe registro en esta fecha.");
       /* Grafico grafico = new Grafico();
             
        grafico.setDiaDesde(botonFecha.getModel().getDay());
        grafico.setMesDesde(botonFecha.getModel().getMonth());
        grafico.setAnioDesde(botonFecha.getModel().getYear());
        
        grafico.setDiaHasta(botonFecha1.getModel().getDay());
        grafico.setMesHasta(botonFecha1.getModel().getMonth());
        grafico.setAnioHasta(botonFecha1.getModel().getYear());
        
        grafico.iniciar();
        */
    }//GEN-LAST:event_aceptarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void aceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aceptarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_aceptarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Fecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             //   new Fecha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    // End of variables declaration//GEN-END:variables
}
