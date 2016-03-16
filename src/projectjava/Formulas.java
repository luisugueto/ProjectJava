/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

/**
 *
 * @author Luis
 */
public class Formulas {
    
    float disponibilidad, puntoDePedido, cantidadDePedido, materialesObsoletos, inventarios, costos,
          factorDeUtilización,tiempoTotaldeFuncionamiento, TiempoIndisponibilidadxManten, costoTotalManten,
          tiempoTotalOperativo, tiempoTotalDisponible;
    int nItemsPuntoPedidoVigente, nItemsInventario,nItemsCantPedidoVigente, 
        valorInventarioMaterialesObsoletos, valorTotalInventario, valorTotalInventarioManten, 
        valorTotalActivosOperacionales, cantidadTotalUnidadesProducidas;
    
    public float disponibilidad(){
        disponibilidad = tiempoTotaldeFuncionamiento/tiempoTotaldeFuncionamiento+TiempoIndisponibilidadxManten;
        return disponibilidad;
    }
    
}
