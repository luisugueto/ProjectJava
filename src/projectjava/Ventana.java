/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import javax.swing.JFrame;

/**
 *
 * @author Luis 
 */
public class Ventana extends JFrame{
    
    Ventana(){
        super("ProjectJava");
        this.setVisible(true);
        this.setExtendedState(6);
        this.setLocation(0, 0);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
