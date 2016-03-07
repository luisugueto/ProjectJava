/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author raven
 */
public abstract class AbsControlador implements ActionListener,
                                MouseMotionListener, MouseListener, Serializable
{
    @Override
    public abstract void actionPerformed(ActionEvent e);
    @Override
    public abstract void mouseDragged(MouseEvent e);
    @Override
    public abstract void mouseMoved(MouseEvent e);
    @Override
    public abstract void mouseClicked(MouseEvent e);
    @Override
    public abstract void mousePressed(MouseEvent e);
    @Override
    public abstract void mouseReleased(MouseEvent e);
    @Override
    public abstract void mouseEntered(MouseEvent e);
    @Override
    public abstract void mouseExited(MouseEvent e);
    
    /** Devuelve un ImageIcon o Nulo si la ruta es errónea
     * @param path = ruta al archivo
     * @param description = descripcion breve
     * @return ImageIcon */
    public ImageIcon crearImagen(String path,
                                               String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("No se pudo encontrar el archivo: " + path);
            return null;
        }
    }
    
}
