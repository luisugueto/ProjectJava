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
    
    PopClickListener(MouseEvent e, String name, String valor){
        switch (name){
            case "Mantenimiento \npredictivo":
                menu.agregarItem("Valor");
                menu.setValor(valor);
                menu.agregarItem("Mostrar Formula");
                menu.agregarItem("Mostrar Gráfico");
                menu.setNombrecampo("Mantenimiento \npredictivo");
                menu.show(e.getComponent(), e.getX(), e.getY());  
                break;
            case "Mantenimiento \npreventivo":
                menu.agregarItem("Valor");
                menu.setValor(valor);
                menu.agregarItem("Mostrar Formula");
                menu.agregarItem("Mostrar Gráfico");
                menu.setNombrecampo("Mantenimiento \npreventivo");
                menu.show(e.getComponent(), e.getX(), e.getY());
                break;
            case "Planificación":
                menu.agregarItem("Mostrar Formula");
                menu.agregarItem("Mostrar Gráfico");
                menu.setNombrecampo("Planificación");
                menu.show(e.getComponent(), e.getX(), e.getY());
                break;
            case "Programación":
                menu.agregarItem("Mostrar Formula");
                menu.agregarItem("Mostrar Gráfico");
                menu.setNombrecampo("Programación");
                menu.show(e.getComponent(), e.getX(), e.getY());
                break;
            case "Ejecución":
                menu.agregarItem("Mostrar Formula");
                menu.agregarItem("Mostrar Gráfico");
                menu.setNombrecampo("Ejecución");
                menu.show(e.getComponent(), e.getX(), e.getY());
                break;
            case "Gestión de las \nparadas de planta":
                menu.agregarItem("Mostrar Formula");
                menu.agregarItem("Mostrar Gráfico");
                menu.setNombrecampo("Gestión de las \nparadas de planta");
                menu.show(e.getComponent(), e.getX(), e.getY());
                break;
            case "Punto de pedido":
                menu.agregarItem("Mostrar Formula");
                menu.agregarItem("Mostrar Gráfico");
                menu.setNombrecampo("Punto de pedido");
                menu.show(e.getComponent(), e.getX(), e.getY());
                break;
            case "Cantidad de pedido":
                menu.agregarItem("Mostrar Formula");
                menu.agregarItem("Mostrar Gráfico");
                menu.setNombrecampo("Cantidad de pedido");
                menu.show(e.getComponent(), e.getX(), e.getY());
                break;
            case "Materiales \nobsoletos":
                menu.agregarItem("Mostrar Formula");
                menu.agregarItem("Mostrar Gráfico");
                menu.setNombrecampo("Materiales \nobsoletos");
                menu.show(e.getComponent(), e.getX(), e.getY());
                break;
            case "ACR":
                menu.agregarItem("Mostrar Formula");
                menu.agregarItem("Mostrar Gráfico");
                menu.setNombrecampo("ACR");
                menu.show(e.getComponent(), e.getX(), e.getY());
                break;
            case "Mantenimiento \nplanificado":
                menu.agregarItem("Mostrar Formula");
                menu.agregarItem("Mostrar Gráfico");
                menu.setNombrecampo("Mantenimiento \nplanificado");
                menu.show(e.getComponent(), e.getX(), e.getY());
                break;
            case "Inventarios":
                menu.agregarItem("Mostrar Formula");
                menu.agregarItem("Mostrar Gráfico");
                menu.setNombrecampo("Inventarios");
                menu.show(e.getComponent(), e.getX(), e.getY());
                break;
            case "Factor de utilización de \nla capacidad instalada":
                menu.agregarItem("Mostrar Formula");
                menu.agregarItem("Mostrar Gráfico");
                menu.setNombrecampo("Factor de utilización de \nla capacidad instalada");
                menu.show(e.getComponent(), e.getX(), e.getY());
                break;
            case "Confiabilidad":
                menu.agregarItem("Mostrar Formula");
                menu.agregarItem("Mostrar Gráfico");
                menu.setNombrecampo("Confiabilidad");
                menu.show(e.getComponent(), e.getX(), e.getY());
                break;
            case "MTTR":
                menu.agregarItem("Mostrar Formula");
                menu.agregarItem("Mostrar Gráfico");
                menu.setNombrecampo("MTTR");
                menu.show(e.getComponent(), e.getX(), e.getY());
                break;
            case "Disponibilidad":
                menu.agregarItem("Mostrar Formula");
                menu.agregarItem("Mostrar Gráfico");
                menu.setNombrecampo("Disponibilidad");
                menu.show(e.getComponent(), e.getX(), e.getY());
                break;
            case "Costos":
                menu.agregarItem("Mostrar Formula");
                menu.agregarItem("Mostrar Gráfico");
                menu.setNombrecampo("Costos");
                menu.show(e.getComponent(), e.getX(), e.getY());
                break;
            case "Ingresos":
                menu.agregarItem("Mostrar Formula");
                menu.agregarItem("Mostrar Gráfico");
                menu.setNombrecampo("Ingresos");
                menu.show(e.getComponent(), e.getX(), e.getY());
                break;
            case "AO":
                menu.agregarItem("Mostrar Formula");
                menu.agregarItem("Mostrar Gráfico");
                menu.setNombrecampo("AO");
                menu.show(e.getComponent(), e.getX(), e.getY());
                break;
            case "EBIT":
                menu.agregarItem("Mostrar Formula");
                menu.agregarItem("Mostrar Gráfico");
                menu.setNombrecampo("EBIT");
                menu.show(e.getComponent(), e.getX(), e.getY());
                break;
            case "EVA":
                menu.agregarItem("Mostrar Formula");
                menu.agregarItem("Mostrar Gráfico");
                menu.setNombrecampo("EVA");
                menu.show(e.getComponent(), e.getX(), e.getY());
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
