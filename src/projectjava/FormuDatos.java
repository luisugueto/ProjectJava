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
        setSize(600, 580);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tiemMedRep = new javax.swing.JTextField();
        tiemTotFunc = new javax.swing.JTextField();
        tiemIndMan = new javax.swing.JTextField();
        nItPtPdV = new javax.swing.JTextField();
        nTotItInv = new javax.swing.JTextField();
        vValInvMatOb = new javax.swing.JTextField();
        valTotInv = new javax.swing.JTextField();
        valTotInvMant = new javax.swing.JTextField();
        valTotAcOp = new javax.swing.JTextField();
        cosTotMan = new javax.swing.JTextField();
        canTotUnPro = new javax.swing.JTextField();
        tiemTotOper = new javax.swing.JTextField();
        tiemTotDis = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        nSisCubSisCRaiz = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        nTotSis = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cosTotUnPro = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        nTotalOTeje = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        hHTotMan = new javax.swing.JTextField();
        hHManPred = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        nTotOTpro = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        hHManPre = new javax.swing.JTextField();
        nProEjePl = new javax.swing.JTextField();
        nTotProyEje = new javax.swing.JTextField();
        hHManPlPr = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        canOTret = new javax.swing.JTextField();
        label24 = new javax.swing.JLabel();
        label26 = new javax.swing.JLabel();
        label25 = new javax.swing.JLabel();
        nOTejeCosPl = new javax.swing.JTextField();
        label122 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        hHTotManDis = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        sumTiemRep = new javax.swing.JTextField();
        label27 = new javax.swing.JLabel();
        nTotRep = new javax.swing.JTextField();
        label28 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        procesar.setText("Procesar");
        procesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarActionPerformed(evt);
            }
        });
        getContentPane().add(procesar);
        procesar.setBounds(150, 510, 90, 23);

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar);
        cancelar.setBounds(330, 510, 90, 23);

        fecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        fecha.setText("1/1/2016");
        fecha.setToolTipText("Formato Correcto. Ejm: 14/04/2016");
        getContentPane().add(fecha);
        fecha.setBounds(440, 10, 103, 22);

        jLabel16.setText("Fecha:");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(380, 10, 60, 22);

        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });
        getContentPane().add(check);
        check.setBounds(540, 10, 21, 21);

        jPanel2.setLayout(null);

        jLabel3.setText("<html>Nº Total de items<br>en inventario:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 210, 140, 50);

        jLabel8.setText("<html>Valor Total<br>del Inventario:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 330, 140, 28);

        jLabel5.setText("<html>Tiempo medio<br>para reparar:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 0, 140, 40);

        jLabel10.setText("<html>Valor Total de los Activos <br>Operacionales:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(310, 0, 130, 50);

        jLabel6.setText("<html>Tiempo total<br>de funcionamiento:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(10, 60, 140, 28);

        jLabel11.setText("<html>Costo Total del Mantenimiento:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(310, 70, 140, 30);

        jLabel13.setText("<html>Tiempo Total Operativo:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(310, 230, 100, 30);

        jLabel12.setText("<html>Cantidad Total de las Unidades Producidas:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(310, 130, 140, 30);

        jLabel9.setText("<html>Valor Total de los Inventarios para Mantenimiento:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(10, 370, 150, 40);

        jLabel7.setText("<html>Tiempo de indisponiblidad<br>por manten.:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 100, 140, 50);

        jLabel2.setText("<html>Nº de Items con<br>Punto de Pedido vigente:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 150, 140, 50);

        jLabel18.setText("<html>Tiempo Total Disponible:");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(310, 280, 110, 30);

        jLabel19.setText("<html>Valor del Inventario de Materiales Obsoletos:");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(10, 270, 140, 50);
        jPanel2.add(tiemMedRep);
        tiemMedRep.setBounds(160, 10, 110, 30);

        tiemTotFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiemTotFuncActionPerformed(evt);
            }
        });
        jPanel2.add(tiemTotFunc);
        tiemTotFunc.setBounds(160, 60, 110, 30);
        jPanel2.add(tiemIndMan);
        tiemIndMan.setBounds(160, 110, 110, 30);
        jPanel2.add(nItPtPdV);
        nItPtPdV.setBounds(160, 170, 110, 30);
        jPanel2.add(nTotItInv);
        nTotItInv.setBounds(160, 230, 110, 30);
        jPanel2.add(vValInvMatOb);
        vValInvMatOb.setBounds(160, 280, 110, 30);
        jPanel2.add(valTotInv);
        valTotInv.setBounds(160, 330, 110, 30);
        jPanel2.add(valTotInvMant);
        valTotInvMant.setBounds(160, 380, 110, 30);
        jPanel2.add(valTotAcOp);
        valTotAcOp.setBounds(460, 10, 110, 30);
        jPanel2.add(cosTotMan);
        cosTotMan.setBounds(460, 70, 110, 30);
        jPanel2.add(canTotUnPro);
        canTotUnPro.setBounds(460, 130, 110, 30);
        jPanel2.add(tiemTotOper);
        tiemTotOper.setBounds(460, 230, 110, 30);
        jPanel2.add(tiemTotDis);
        tiemTotDis.setBounds(460, 280, 110, 30);

        jLabel26.setText("<html>Nº de Sistemas<br>Cubiertos por un<br>Sistema Causa Raiz:");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(310, 320, 140, 40);

        nSisCubSisCRaiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nSisCubSisCRaizActionPerformed(evt);
            }
        });
        jPanel2.add(nSisCubSisCRaiz);
        nSisCubSisCRaiz.setBounds(460, 330, 113, 30);

        jLabel27.setText("<html>Nº Total de<br>Sistemas:");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(310, 370, 140, 30);
        jPanel2.add(nTotSis);
        nTotSis.setBounds(460, 370, 113, 30);

        jLabel14.setText("<html>Costo Total de Unidades Producidas:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(310, 180, 140, 30);
        jPanel2.add(cosTotUnPro);
        cosTotUnPro.setBounds(460, 180, 110, 30);

        jTabbedPane1.addTab("R.- 1", jPanel2);

        jPanel3.setLayout(null);

        nTotalOTeje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nTotalOTejeActionPerformed(evt);
            }
        });
        jPanel3.add(nTotalOTeje);
        nTotalOTeje.setBounds(160, 330, 111, 30);

        jLabel20.setText("<html>Horas-Hombre de Mantenimiento Planificado <br>y Programado:");
        jPanel3.add(jLabel20);
        jLabel20.setBounds(10, 100, 140, 70);
        jPanel3.add(hHTotMan);
        hHTotMan.setBounds(160, 70, 110, 30);
        jPanel3.add(hHManPred);
        hHManPred.setBounds(160, 20, 113, 30);

        jLabel21.setText("<html>Nº de OT ejecutadas dentro del ±20% de los costos planificados.");
        jPanel3.add(jLabel21);
        jLabel21.setBounds(10, 280, 140, 40);
        jPanel3.add(nTotOTpro);
        nTotOTpro.setBounds(160, 380, 110, 30);

        jLabel23.setText("<html>Nº Total de OT <br> Programadas:");
        jPanel3.add(jLabel23);
        jLabel23.setBounds(10, 360, 130, 50);
        jPanel3.add(hHManPre);
        hHManPre.setBounds(160, 180, 110, 30);
        jPanel3.add(nProEjePl);
        nProEjePl.setBounds(450, 80, 110, 30);
        jPanel3.add(nTotProyEje);
        nTotProyEje.setBounds(450, 130, 110, 30);
        jPanel3.add(hHManPlPr);
        hHManPlPr.setBounds(160, 120, 110, 30);

        jLabel25.setText("<html>Horas Hombre de<br>Mantenimiento Preventivo:");
        jPanel3.add(jLabel25);
        jLabel25.setBounds(10, 170, 140, 50);
        jPanel3.add(canOTret);
        canOTret.setBounds(450, 20, 110, 30);

        label24.setText("<html>Cantidad de OT con retrabajo:");
        jPanel3.add(label24);
        label24.setBounds(300, 20, 140, 30);

        label26.setText("<html>Nº Total de Proyectos Ejecutados:");
        jPanel3.add(label26);
        label26.setBounds(300, 130, 100, 40);

        label25.setText("<html>Nº de Proyectos Ejecutados dentro del ±15 de lo planificado:");
        jPanel3.add(label25);
        label25.setBounds(300, 70, 140, 50);
        jPanel3.add(nOTejeCosPl);
        nOTejeCosPl.setBounds(160, 280, 111, 30);

        label122.setText("<html>Nº Total de OT  Ejecutadas:");
        jPanel3.add(label122);
        label122.setBounds(10, 320, 150, 40);

        jLabel30.setText("<html>Horas Hombre de<br>Mantenimiento Predictivo:");
        jPanel3.add(jLabel30);
        jLabel30.setBounds(10, 0, 140, 50);

        jLabel31.setText("<html>Horas-Hombre totales<br> de Mantenimiento:");
        jPanel3.add(jLabel31);
        jLabel31.setBounds(10, 50, 140, 50);

        hHTotManDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hHTotManDisActionPerformed(evt);
            }
        });
        jPanel3.add(hHTotManDis);
        hHTotManDis.setBounds(160, 230, 110, 30);

        jLabel33.setText("<html>Horas-Hombre totales<br> de Mantenimientos Disponibles:");
        jPanel3.add(jLabel33);
        jLabel33.setBounds(10, 220, 140, 50);
        jPanel3.add(sumTiemRep);
        sumTiemRep.setBounds(450, 180, 110, 30);

        label27.setText("<html>Sumatoria de los tiempos para reparar:");
        jPanel3.add(label27);
        label27.setBounds(300, 180, 100, 40);
        jPanel3.add(nTotRep);
        nTotRep.setBounds(450, 230, 110, 30);

        label28.setText("<html>Nº Total de Reparaciones: ");
        jPanel3.add(label28);
        label28.setBounds(300, 230, 100, 40);

        jTabbedPane1.addTab("R.- 2", jPanel3);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 50, 580, 450);

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
        
        datos.insertGeneral("datos", ""+num, ""+id, ""+fecha.getText(), ""+tiemMedRep.getText(), ""+tiemTotFunc.getText(), ""+tiemIndMan.getText(), ""+nItPtPdV.getText(),
        ""+nTotItInv.getText(), ""+vValInvMatOb.getText(), ""+valTotInv.getText(), ""+valTotInvMant.getText(),
        ""+valTotAcOp.getText(), ""+cosTotMan.getText(), ""+canTotUnPro.getText(), ""+cosTotUnPro.getText() ,""+tiemTotOper.getText(),
        ""+tiemTotDis.getText(), ""+nSisCubSisCRaiz.getText(), ""+nTotSis.getText(), ""+hHManPred.getText(),
        ""+hHTotMan.getText(), ""+hHManPlPr.getText(), ""+hHManPre.getText(), ""+hHTotManDis.getText(),
        ""+nOTejeCosPl.getText(), ""+nTotalOTeje.getText(), ""+nTotOTpro.getText(), ""+canOTret.getText(),
        ""+nProEjePl.getText(), ""+nTotProyEje.getText(), ""+sumTiemRep.getText(), ""+nTotRep.getText());
        JOptionPane.showMessageDialog(null, "Registro Exitoso.");
        dispose();
    }//GEN-LAST:event_procesarActionPerformed

    private void nTotalOTejeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nTotalOTejeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nTotalOTejeActionPerformed

    private void hHTotManDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hHTotManDisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hHTotManDisActionPerformed

    private void tiemTotFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiemTotFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tiemTotFuncActionPerformed

    private void nSisCubSisCRaizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nSisCubSisCRaizActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nSisCubSisCRaizActionPerformed

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
    private javax.swing.JTextField canOTret;
    private javax.swing.JTextField canTotUnPro;
    private javax.swing.JButton cancelar;
    private javax.swing.JCheckBox check;
    private javax.swing.JTextField cosTotMan;
    private javax.swing.JTextField cosTotUnPro;
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
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel label122;
    private javax.swing.JLabel label24;
    private javax.swing.JLabel label25;
    private javax.swing.JLabel label26;
    private javax.swing.JLabel label27;
    private javax.swing.JLabel label28;
    private javax.swing.JTextField nItPtPdV;
    private javax.swing.JTextField nOTejeCosPl;
    private javax.swing.JTextField nProEjePl;
    private javax.swing.JTextField nSisCubSisCRaiz;
    private javax.swing.JTextField nTotItInv;
    private javax.swing.JTextField nTotOTpro;
    private javax.swing.JTextField nTotProyEje;
    private javax.swing.JTextField nTotRep;
    private javax.swing.JTextField nTotSis;
    private javax.swing.JTextField nTotalOTeje;
    private javax.swing.JButton procesar;
    private javax.swing.JTextField sumTiemRep;
    private javax.swing.JTextField tiemIndMan;
    private javax.swing.JTextField tiemMedRep;
    private javax.swing.JTextField tiemTotDis;
    private javax.swing.JTextField tiemTotFunc;
    private javax.swing.JTextField tiemTotOper;
    private javax.swing.JTextField vValInvMatOb;
    private javax.swing.JTextField valTotAcOp;
    private javax.swing.JTextField valTotInv;
    private javax.swing.JTextField valTotInvMant;
    // End of variables declaration//GEN-END:variables
}
