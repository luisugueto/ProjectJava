/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spev;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author Luis
 */
public class BarraDeEstado extends JTabbedPane
{
    JTextArea estadoActual, historialEventos, valores;
    JScrollPane scroll; 
    public String default_message, historial, valor;
    private final Font font = new Font("Arial", Font.BOLD, 11);
    
    BarraDeEstado ()
    {
        super();
        this.default_message = " ";
        estadoActual = new JTextArea(default_message);
        historialEventos = new JTextArea(4, 100);
        valores = new JTextArea(default_message);
        
        estadoActual.setFont(font);
        historialEventos.setFont(font);
        valores.setFont(font);
        historialEventos.setForeground(Color.BLUE);
        
        estadoActual.setForeground(Colores.font_tborder);
        historialEventos.setForeground(Colores.font_tborder);
        valores.setForeground(Colores.font_tborder);
        
        JScrollPane scroll = new JScrollPane (historialEventos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JScrollBar bar = new JScrollBar();
        scroll.add(bar);
        estadoActual.setSize(100, 300);
        historialEventos.setSize(100, 300);
        valores.setSize(100, 300);
        
        estadoActual.setEditable(false);
        historialEventos.setEditable(false);
        valores.setEditable(false);
    
        addTab("Estado Actual", estadoActual);
        add(scroll, "Historial de Eventos");
        addTab("Valores", valores);
    }   
    
    public void addMensajeEstadoActual(String msj){
        estadoActual.append(msj);
    }
    public void addMensajeHistorialEventos(String msj){
        historialEventos.append(msj);
    }
    public void addMensajeValores(String msj){
        valores.append(msj);
    }
    public void setMensaje(String msj) {
        this.estadoActual.setText(msj);
    }
    public void setMensajeHistorial(String msj) {
        this.historialEventos.setText(msj);
    }
    public void setMensajeValores(String msj) {
        this.valores.setText(msj);
    }
    public String getMensaje() {
        return this.estadoActual.getText();
    }
}
