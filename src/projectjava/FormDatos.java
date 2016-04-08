/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import javax.swing.JPanel;
import model.DB;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Luis
 */
public class FormDatos extends javax.swing.JFrame {

    /**
     * Creates new form FormDatos
     */
    
    DB datos = DB.getInstance();
    ResultSet resultados = null;

    int num, id;
    
    Calendar calendario = new GregorianCalendar();
    int dia, mes, anio;
    String mess = " ", diaa = " ";
    
    public FormDatos() {
        initComponents();
        setExtendedState(3);
        setLocationRelativeTo(null);
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = calendario.get(Calendar.MONTH)+1;
        if (mes <= 10) mess = "0"+mes; else mess = ""+mes;
        if (dia <= 10) diaa = "0"+dia; else diaa = ""+dia;
        anio = calendario.get(Calendar.YEAR);
        fecha.setText(""+diaa+"/"+mess+"/"+anio);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        procesar = new javax.swing.JButton();
        tiempoMedioReparar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tiempoTotalFunc = new javax.swing.JTextField();
        tiempoIndisManten = new javax.swing.JTextField();
        nTotalItemsInvent = new javax.swing.JTextField();
        nItemsPtPedidoVigente = new javax.swing.JTextField();
        nItemsCantPedidoVigente = new javax.swing.JTextField();
        valorTotalInvent = new javax.swing.JTextField();
        valorTotalInventManten = new javax.swing.JTextField();
        costoTotalManten = new javax.swing.JTextField();
        valorTotalActivosOperac = new javax.swing.JTextField();
        cantidadTotalUnidProduc = new javax.swing.JTextField();
        tiempoTotalDisp = new javax.swing.JTextField();
        tiempoTotalOper = new javax.swing.JTextField();
        valorInventMatObs = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();
        fecha = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        check = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EVA");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(getMaximumSize());
        getContentPane().setLayout(null);

        procesar.setText("Procesar");
        procesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarActionPerformed(evt);
            }
        });
        getContentPane().add(procesar);
        procesar.setBounds(140, 450, 75, 23);

        tiempoMedioReparar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiempoMedioRepararActionPerformed(evt);
            }
        });
        getContentPane().add(tiempoMedioReparar);
        tiempoMedioReparar.setBounds(161, 57, 113, 29);

        jLabel1.setText("<html>Nº de Items por<br>Punto de Pedido<br>vigente:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 200, 120, 50);

        jLabel2.setText("<html>Tiempo medio<br>para reparar:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(12, 51, 107, 44);

        jLabel3.setText("<html>Nº Total de items<br>en inventario:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 260, 130, 40);

        jLabel4.setText("<html>Nº  de Items con cantidad de Pedido vigente:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 310, 130, 50);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 416, 216, 0);

        jLabel6.setText("<html>Tiempo total<br>de funcionamiento:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(12, 98, 92, 28);

        jLabel7.setText("<html>Tiempo de indisponiblidad<br>por manten.:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 140, 120, 50);

        jLabel8.setText("<html>Valor Total<br>del Inventario:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(300, 60, 71, 28);

        jLabel9.setText("<html>Valor Total de los<br>Inventarios para<br>Mantenimiento:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(300, 100, 82, 42);

        jLabel10.setText("<html>Valor Total de los Activos Operacionales:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(300, 160, 130, 40);

        jLabel11.setText("<html>Costo Total del Mantenimiento:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(300, 210, 120, 40);

        jLabel12.setText("<html>Cantidad Total de las Unidades Producidas:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(300, 260, 120, 60);

        jLabel13.setText("<html>Tiempo Total Operativo:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(300, 320, 100, 40);

        jLabel14.setText("<html>Tiempo Total Disponible:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(300, 370, 110, 40);
        getContentPane().add(tiempoTotalFunc);
        tiempoTotalFunc.setBounds(160, 150, 113, 30);
        getContentPane().add(tiempoIndisManten);
        tiempoIndisManten.setBounds(160, 100, 113, 30);
        getContentPane().add(nTotalItemsInvent);
        nTotalItemsInvent.setBounds(160, 270, 110, 30);
        getContentPane().add(nItemsPtPedidoVigente);
        nItemsPtPedidoVigente.setBounds(160, 210, 110, 30);
        getContentPane().add(nItemsCantPedidoVigente);
        nItemsCantPedidoVigente.setBounds(160, 320, 110, 30);
        getContentPane().add(valorTotalInvent);
        valorTotalInvent.setBounds(450, 60, 111, 30);

        valorTotalInventManten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorTotalInventMantenActionPerformed(evt);
            }
        });
        getContentPane().add(valorTotalInventManten);
        valorTotalInventManten.setBounds(450, 110, 111, 30);
        getContentPane().add(costoTotalManten);
        costoTotalManten.setBounds(450, 220, 110, 30);
        getContentPane().add(valorTotalActivosOperac);
        valorTotalActivosOperac.setBounds(450, 170, 110, 30);
        getContentPane().add(cantidadTotalUnidProduc);
        cantidadTotalUnidProduc.setBounds(450, 280, 110, 30);
        getContentPane().add(tiempoTotalDisp);
        tiempoTotalDisp.setBounds(450, 380, 110, 30);
        getContentPane().add(tiempoTotalOper);
        tiempoTotalOper.setBounds(450, 330, 110, 30);

        valorInventMatObs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorInventMatObsActionPerformed(evt);
            }
        });
        getContentPane().add(valorInventMatObs);
        valorInventMatObs.setBounds(160, 380, 110, 30);

        jLabel15.setText("<html>Valor del Inventario de Materiales Obsoletos:");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(10, 370, 140, 60);

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar);
        cancelar.setBounds(320, 450, 75, 23);

        fecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        fecha.setText("1/1/2016");
        fecha.setToolTipText("Formato Correcto. Ejm: 14/04/2016");
        getContentPane().add(fecha);
        fecha.setBounds(440, 10, 103, 22);

        jLabel16.setText("Fecha:");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(380, 10, 33, 22);

        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });
        getContentPane().add(check);
        check.setBounds(540, 10, 21, 21);

        jLabel17.setText("<html><h2>Registro de datos");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(40, 10, 220, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 40, 560, 10);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void procesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procesarActionPerformed
        // TODO add your handling code here:
        try { resultados = datos.getId();
                while (resultados.next()) { num = resultados.getInt(1); }
            } catch (Exception e) {   
            }
            num++;
            
         datos.insertGeneral("datos", ""+num, ""+id, ""+tiempoMedioReparar.getText(), ""+tiempoTotalFunc.getText(),
         ""+tiempoIndisManten.getText(),""+nTotalItemsInvent.getText(), ""+nItemsCantPedidoVigente.getText(), ""+valorInventMatObs.getText(),
         ""+valorTotalInvent.getText(), ""+valorTotalInventManten.getText(), ""+valorTotalActivosOperac.getText(), ""+costoTotalManten.getText(),
         ""+cantidadTotalUnidProduc.getText(), ""+tiempoTotalOper.getText(), ""+tiempoTotalDisp.getText(), ""+fecha.getText());
         
         dispose();
    }//GEN-LAST:event_procesarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        // TODO add your handling code here:
        if(!check.isSelected()) fecha.setEditable(true);
        if(check.isSelected()) fecha.setEditable(false);
    }//GEN-LAST:event_checkActionPerformed

    private void tiempoMedioRepararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiempoMedioRepararActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tiempoMedioRepararActionPerformed

    private void valorTotalInventMantenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorTotalInventMantenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorTotalInventMantenActionPerformed

    private void valorInventMatObsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorInventMatObsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorInventMatObsActionPerformed

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
            java.util.logging.Logger.getLogger(FormDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FormDatos().setVisible(true);
            }
        });
    }
    
    public void setId(int id){ this.id = id; }
    public int getId(){ return this.id; }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField cantidadTotalUnidProduc;
    private javax.swing.JCheckBox check;
    private javax.swing.JTextField costoTotalManten;
    private javax.swing.JFormattedTextField fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nItemsCantPedidoVigente;
    private javax.swing.JTextField nItemsPtPedidoVigente;
    private javax.swing.JTextField nTotalItemsInvent;
    private javax.swing.JButton procesar;
    private javax.swing.JTextField tiempoIndisManten;
    private javax.swing.JTextField tiempoMedioReparar;
    private javax.swing.JTextField tiempoTotalDisp;
    private javax.swing.JTextField tiempoTotalFunc;
    private javax.swing.JTextField tiempoTotalOper;
    private javax.swing.JTextField valorInventMatObs;
    private javax.swing.JTextField valorTotalActivosOperac;
    private javax.swing.JTextField valorTotalInvent;
    private javax.swing.JTextField valorTotalInventManten;
    // End of variables declaration//GEN-END:variables
}
