/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Luis
 */
public class PopClickListener extends MouseAdapter{
    
    PopUp menu = new PopUp();
    
    PopClickListener(MouseEvent e, String name){
        
        switch (name){
            case "Mantenimiento \npredictivo":
                menu.agregarItem("Mostrar Formula");
                menu.agregarItem("Prueba");
                menu.show(e.getComponent(), e.getX(), e.getY());  
                break;
            case "Mantenimiento \npreventivo":
                menu.agregarItem("Mostrar Formula");
                menu.agregarItem("Mostrar Gráfico");
                menu.show(e.getComponent(), e.getX(), e.getY());
                break;
            case "Planificación":
                break;
            case "Programación":
                break;
            case "Ejecución":
                break;
            case "Gestión de las \nparadas de planta":
                break;
            case "Punto de pedido":
                break;
            case "Cantidad de pedido":
                break;
            case "Materiales \nobsoletos":
                break;
            case "ACR":
                break;
            case "Mantenimiento \nplanificado":
                break;
            case "Inventarios":
                break;
            case "Factor de utilización de \nla capacidad instalada":
                break;
            case "Confiabilidad":
                break;
            case "MTTR":
                break;
            case "Disponibilidad":
                break;
            case "Costos":
                break;
            case "Ingresos":
                break;
            case "AO":
                break;
            case "EBIT":
                break;
            case "EVA":
                break;
                
            default:
                System.out.println("No existente.");
                break;
        
        }
        
        
    }
    
    public void mousePressed(MouseEvent e)
    {
        if(e.isPopupTrigger())
            doPop(e);
        PopUp menu = new PopUp();
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
   
    
    private void doPop(MouseEvent e){
        PopUp menu = new PopUp();
        menu.show(e.getComponent(), e.getX(), e.getY());
    }
}
