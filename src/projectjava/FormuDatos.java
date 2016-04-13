/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import model.DB;

/**
 *
 * @author Ypsis
 */
public class FormuDatos extends javax.swing.JFrame {

    /**
     * Creates new form FormuDatos
     */
      DB datos = DB.getInstance();
    ResultSet resultados = null;

    int num, id;
    
    Calendar calendario = new GregorianCalendar();
    int dia, mes, anio;
    String mess = " ", diaa = " ";
    
    public FormuDatos() {
        initComponents();
        setSize(584, 520);
        setLocationRelativeTo(null);
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = calendario.get(Calendar.MONTH)+1;
        if (mes < 10) mess = "0"+mes; else mess = ""+mes;
        if (dia < 10) diaa = "0"+dia; else diaa = ""+dia;
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
        cancelar = new javax.swing.JButton();
        fecha = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        check = new javax.swing.JCheckBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        valorTotalInventManten = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nItemsPtPedidoVigente = new javax.swing.JTextField();
        tiempoTotalFunc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        valorTotalActivosOperac = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        valorInventMatObs = new javax.swing.JTextField();
        nItemsCantPedidoVigente = new javax.swing.JTextField();
        tiempoTotalDisp = new javax.swing.JTextField();
        cantidadTotalUnidProduc = new javax.swing.JTextField();
        tiempoTotalOper = new javax.swing.JTextField();
        nTotalItemsInvent = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tiempoIndisManten = new javax.swing.JTextField();
        costoTotalManten = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tiempoMedioReparar = new javax.swing.JTextField();
        valorTotalInvent = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        valorInventMatObs1 = new javax.swing.JTextField();
        tiempoTotalDisp1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        valorTotalInventManten1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        hHTotMan = new javax.swing.JTextField();
        hHManPred = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        valorTotalActivosOperac1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        hHManPre = new javax.swing.JTextField();
        cantidadTotalUnidProduc1 = new javax.swing.JTextField();
        tiempoTotalOper1 = new javax.swing.JTextField();
        hHManPlPr = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        nTotSis = new javax.swing.JTextField();
        costoTotalManten1 = new javax.swing.JTextField();
        canOTret = new javax.swing.JLabel();
        nTotalProEje = new javax.swing.JLabel();
        nProEjedPlan = new javax.swing.JLabel();
        nSisCubSisCRaiz = new javax.swing.JTextField();
        nOTejeCosPl = new javax.swing.JTextField();
        nTotOTpro = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        hHTotManDis = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        procesar.setText("Procesar");
        procesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarActionPerformed(evt);
            }
        });
        getContentPane().add(procesar);
        procesar.setBounds(140, 470, 90, 23);

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar);
        cancelar.setBounds(320, 470, 90, 23);

        fecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        fecha.setText("1/1/2016");
        fecha.setToolTipText("Formato Correcto. Ejm: 14/04/2016");
        getContentPane().add(fecha);
        fecha.setBounds(470, 10, 103, 22);

        jLabel16.setText("Fecha:");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(410, 10, 60, 22);

        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });
        getContentPane().add(check);
        check.setBounds(570, 10, 21, 21);

        jPanel2.setLayout(null);

        jLabel14.setText("<html>Tiempo Total Disponible:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(300, 390, 110, 30);

        valorTotalInventManten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorTotalInventMantenActionPerformed(evt);
            }
        });
        jPanel2.add(valorTotalInventManten);
        valorTotalInventManten.setBounds(450, 60, 111, 30);

        jLabel3.setText("<html>Nº Total de items<br>en inventario:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 220, 140, 50);
        jPanel2.add(nItemsPtPedidoVigente);
        nItemsPtPedidoVigente.setBounds(160, 170, 110, 30);
        jPanel2.add(tiempoTotalFunc);
        tiempoTotalFunc.setBounds(160, 120, 113, 30);

        jLabel8.setText("<html>Valor Total<br>del Inventario:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(300, 10, 140, 28);
        jPanel2.add(valorTotalActivosOperac);
        valorTotalActivosOperac.setBounds(450, 120, 110, 30);

        jLabel5.setText("<html>Tiempo medio<br>para reparar:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 0, 140, 40);

        jLabel10.setText("<html>Valor Total de los Activos <br>Operacionales:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(300, 100, 130, 50);

        jLabel6.setText("<html>Tiempo total<br>de funcionamiento:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(10, 60, 140, 28);

        valorInventMatObs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorInventMatObsActionPerformed(evt);
            }
        });
        jPanel2.add(valorInventMatObs);
        valorInventMatObs.setBounds(160, 390, 110, 30);
        jPanel2.add(nItemsCantPedidoVigente);
        nItemsCantPedidoVigente.setBounds(160, 280, 110, 30);
        jPanel2.add(tiempoTotalDisp);
        tiempoTotalDisp.setBounds(450, 390, 110, 30);
        jPanel2.add(cantidadTotalUnidProduc);
        cantidadTotalUnidProduc.setBounds(450, 230, 110, 30);
        jPanel2.add(tiempoTotalOper);
        tiempoTotalOper.setBounds(450, 280, 110, 30);
        jPanel2.add(nTotalItemsInvent);
        nTotalItemsInvent.setBounds(160, 230, 110, 30);

        jLabel4.setText("<html>Nº  de Items con cantidad de Pedido vigente:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 270, 140, 50);
        jPanel2.add(tiempoIndisManten);
        tiempoIndisManten.setBounds(160, 60, 113, 30);
        jPanel2.add(costoTotalManten);
        costoTotalManten.setBounds(450, 170, 110, 30);

        jLabel11.setText("<html>Costo Total del Mantenimiento:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(300, 170, 140, 30);

        jLabel13.setText("<html>Tiempo Total Operativo:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(300, 280, 100, 30);

        jLabel12.setText("<html>Cantidad Total de las Unidades Producidas:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(300, 230, 140, 30);

        jLabel15.setText("<html>Valor del Inventario de Materiales Obsoletos:");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(10, 380, 140, 50);

        tiempoMedioReparar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiempoMedioRepararActionPerformed(evt);
            }
        });
        jPanel2.add(tiempoMedioReparar);
        tiempoMedioReparar.setBounds(160, 10, 113, 29);
        jPanel2.add(valorTotalInvent);
        valorTotalInvent.setBounds(450, 10, 111, 30);

        jLabel9.setText("<html>Valor Total de los Inventarios para Mantenimiento:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(300, 50, 150, 40);

        jLabel7.setText("<html>Tiempo de indisponiblidad<br>por manten.:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 100, 140, 50);

        jLabel2.setText("<html>Nº de Items por<br>Punto de Pedido vigente:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 150, 140, 50);

        jLabel18.setText("<html>Tiempo Total Disponible:");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(300, 330, 110, 30);

        valorInventMatObs1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorInventMatObs1ActionPerformed(evt);
            }
        });
        jPanel2.add(valorInventMatObs1);
        valorInventMatObs1.setBounds(160, 330, 110, 30);
        jPanel2.add(tiempoTotalDisp1);
        tiempoTotalDisp1.setBounds(450, 330, 110, 30);

        jLabel19.setText("<html>Valor del Inventario de Materiales Obsoletos:");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(10, 320, 140, 50);

        jTabbedPane1.addTab("R.- 1", jPanel2);

        jPanel3.setLayout(null);

        valorTotalInventManten1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorTotalInventManten1ActionPerformed(evt);
            }
        });
        jPanel3.add(valorTotalInventManten1);
        valorTotalInventManten1.setBounds(450, 60, 111, 30);

        jLabel20.setText("<html>Horas-Hombre de Mantenimiento Planificado <br>y Programado:");
        jPanel3.add(jLabel20);
        jLabel20.setBounds(10, 210, 140, 70);
        jPanel3.add(hHTotMan);
        hHTotMan.setBounds(160, 180, 110, 30);
        jPanel3.add(hHManPred);
        hHManPred.setBounds(160, 130, 113, 30);

        jLabel21.setText("<html>Nº de OT ejecutadas dentro del ±20% de los costos planificados.");
        jPanel3.add(jLabel21);
        jLabel21.setBounds(300, 10, 140, 40);
        jPanel3.add(valorTotalActivosOperac1);
        valorTotalActivosOperac1.setBounds(450, 120, 110, 30);

        jLabel22.setText("<html>Nº de Sistemas<br>Cubiertos por un<br>Sistema Causa Raiz:");
        jPanel3.add(jLabel22);
        jLabel22.setBounds(10, 10, 140, 40);

        jLabel23.setText("<html>Nº Total de OT <br> Programadas:");
        jPanel3.add(jLabel23);
        jLabel23.setBounds(300, 100, 130, 50);

        jLabel24.setText("<html>Nº Total de<br>Sistemas:");
        jPanel3.add(jLabel24);
        jLabel24.setBounds(10, 70, 140, 30);
        jPanel3.add(hHManPre);
        hHManPre.setBounds(160, 290, 110, 30);
        jPanel3.add(cantidadTotalUnidProduc1);
        cantidadTotalUnidProduc1.setBounds(450, 230, 110, 30);
        jPanel3.add(tiempoTotalOper1);
        tiempoTotalOper1.setBounds(450, 280, 110, 30);
        jPanel3.add(hHManPlPr);
        hHManPlPr.setBounds(160, 230, 110, 30);

        jLabel25.setText("<html>Horas Hombre de<br>Mantenimiento Preventivo:");
        jPanel3.add(jLabel25);
        jLabel25.setBounds(10, 280, 140, 50);
        jPanel3.add(nTotSis);
        nTotSis.setBounds(160, 70, 113, 30);
        jPanel3.add(costoTotalManten1);
        costoTotalManten1.setBounds(450, 170, 110, 30);

        canOTret.setText("<html>Cantidad de OT con retrabajo:");
        jPanel3.add(canOTret);
        canOTret.setBounds(300, 170, 140, 30);

        nTotalProEje.setText("<html>Nº Total de Proyectos Ejecutados:");
        jPanel3.add(nTotalProEje);
        nTotalProEje.setBounds(300, 280, 100, 40);

        nProEjedPlan.setText("<html>Nº de Proyectos Ejecutados dentro del ±15 de lo planificado:");
        jPanel3.add(nProEjedPlan);
        nProEjedPlan.setBounds(300, 220, 140, 50);

        nSisCubSisCRaiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nSisCubSisCRaizActionPerformed(evt);
            }
        });
        jPanel3.add(nSisCubSisCRaiz);
        nSisCubSisCRaiz.setBounds(160, 20, 113, 30);
        jPanel3.add(nOTejeCosPl);
        nOTejeCosPl.setBounds(450, 10, 111, 30);

        nTotOTpro.setText("<html>Nº Total de OT  Ejecutadas:");
        jPanel3.add(nTotOTpro);
        nTotOTpro.setBounds(300, 50, 150, 40);

        jLabel30.setText("<html>Horas Hombre de<br>Mantenimiento Predictivo:");
        jPanel3.add(jLabel30);
        jLabel30.setBounds(10, 110, 140, 50);

        jLabel31.setText("<html>Horas-Hombre totales<br> de Mantenimiento:");
        jPanel3.add(jLabel31);
        jLabel31.setBounds(10, 160, 140, 50);

        hHTotManDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hHTotManDisActionPerformed(evt);
            }
        });
        jPanel3.add(hHTotManDis);
        hHTotManDis.setBounds(160, 340, 110, 30);

        jLabel33.setText("<html>Horas-Hombre totales<br> de Mantenimientos Disponibles:");
        jPanel3.add(jLabel33);
        jLabel33.setBounds(10, 330, 140, 50);

        jTabbedPane1.addTab("R.- 2", jPanel3);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 50, 580, 410);

        jLabel17.setText("<html><h2>Registro de datos");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(40, 10, 220, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        // TODO add your handling code here:
        if(!check.isSelected()) fecha.setEditable(true);
        if(check.isSelected()) fecha.setEditable(false);
    }//GEN-LAST:event_checkActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void procesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procesarActionPerformed
      try { resultados = datos.getId();
            while (resultados.next()) { num = resultados.getInt(1); }
        } catch (Exception e) {
        }
        num++;

        datos.insertGeneral("datos", ""+num, ""+id, ""+fecha.getText(),""+tiempoMedioReparar.getText(), ""+tiempoTotalFunc.getText(),
            ""+tiempoIndisManten.getText(),""+nItemsCantPedidoVigente.getText(),""+nTotalItemsInvent.getText(), ""+valorInventMatObs.getText(),
            ""+valorTotalInvent.getText(), ""+valorTotalInventManten.getText(), ""+valorTotalActivosOperac.getText(), ""+costoTotalManten.getText(),
            ""+cantidadTotalUnidProduc.getText(), ""+tiempoTotalOper.getText(), ""+tiempoTotalDisp.getText());
        JOptionPane.showMessageDialog(null, "Registro Exitoso.");
        dispose();
    }//GEN-LAST:event_procesarActionPerformed

    private void valorTotalInventMantenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorTotalInventMantenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorTotalInventMantenActionPerformed

    private void valorInventMatObsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorInventMatObsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorInventMatObsActionPerformed

    private void tiempoMedioRepararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiempoMedioRepararActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tiempoMedioRepararActionPerformed

    private void valorInventMatObs1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorInventMatObs1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorInventMatObs1ActionPerformed

    private void valorTotalInventManten1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorTotalInventManten1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorTotalInventManten1ActionPerformed

    private void nSisCubSisCRaizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nSisCubSisCRaizActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nSisCubSisCRaizActionPerformed

    private void hHTotManDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hHTotManDisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hHTotManDisActionPerformed

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
            java.util.logging.Logger.getLogger(FormuDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormuDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormuDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormuDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
           //     new FormuDatos().setVisible(true);
            }
        });
    }
    
    public void setId(int id){ this.id = id; }
    public int getId(){ return this.id; }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel canOTret;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField cantidadTotalUnidProduc;
    private javax.swing.JTextField cantidadTotalUnidProduc1;
    private javax.swing.JCheckBox check;
    private javax.swing.JTextField costoTotalManten;
    private javax.swing.JTextField costoTotalManten1;
    private javax.swing.JFormattedTextField fecha;
    private javax.swing.JTextField hHManPlPr;
    private javax.swing.JTextField hHManPre;
    private javax.swing.JTextField hHManPred;
    private javax.swing.JTextField hHTotMan;
    private javax.swing.JTextField hHTotManDis;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField nItemsCantPedidoVigente;
    private javax.swing.JTextField nItemsPtPedidoVigente;
    private javax.swing.JTextField nOTejeCosPl;
    private javax.swing.JLabel nProEjedPlan;
    private javax.swing.JTextField nSisCubSisCRaiz;
    private javax.swing.JLabel nTotOTpro;
    private javax.swing.JTextField nTotSis;
    private javax.swing.JTextField nTotalItemsInvent;
    private javax.swing.JLabel nTotalProEje;
    private javax.swing.JButton procesar;
    private javax.swing.JTextField tiempoIndisManten;
    private javax.swing.JTextField tiempoMedioReparar;
    private javax.swing.JTextField tiempoTotalDisp;
    private javax.swing.JTextField tiempoTotalDisp1;
    private javax.swing.JTextField tiempoTotalFunc;
    private javax.swing.JTextField tiempoTotalOper;
    private javax.swing.JTextField tiempoTotalOper1;
    private javax.swing.JTextField valorInventMatObs;
    private javax.swing.JTextField valorInventMatObs1;
    private javax.swing.JTextField valorTotalActivosOperac;
    private javax.swing.JTextField valorTotalActivosOperac1;
    private javax.swing.JTextField valorTotalInvent;
    private javax.swing.JTextField valorTotalInventManten;
    private javax.swing.JTextField valorTotalInventManten1;
    // End of variables declaration//GEN-END:variables
}
