/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import model.DB;

/**
 *
 * @author Luis
 */
public final class Formulas {
    //Formulas
    String formAnalisisCausaRaiz = "Número de sistemas cubiertos por un Análisis de Causa Raíz/Número total de sistemas";
    String formMantenPredictivo = "Horas Hombre de Mantenimiento Predictivo/Horas Hombre totales de Mantenimiento";
    String formMantenPreventivo = "Horas Hombre de Mantenimiento Preventivo/Horas Hombre totales de Mantenimiento";
    String formMantenPlanificado = "Horas Hombre de Mantenimiento Planificado y Programado/Horas Hombre totales de Mantenimiento Disponibles";
    String formPlanificacion = "Nº de OT ejecutadas dentro del + ó - 20% de los Costos Planificados/Nº total de OT ejecutadas";
    String formProgramacion = "Nº de OT ejecutadas/Nº de OT programadas";
    String formEjecucion = "Cantidad de OT con Retrabajo/Cantidad de OT Ejecutadas";
    String formGestionProyectos = "Nº de Proyectos Ejecutados dentro del + ó - 15% de lo Planificado/Nº total de Proyectos Ejecutados";
    String formConfiabilidad = "Tiempo para Medio para Fallar - Menan Time To Failure(MTTF)";
    String formMTTR = "Tiempo Medio para Reparar-Mean Time To Repair(MTTF)";
    String formDisponibilidad = "Formula: Tiempo total de Funcionamiento/Tiempo Total de Funcionamiento  \n+  Tiempo Indisponibilidad por Mantenimiento";  
    String formPuntoPedido = "Nº de ítems con Punto de Pedido vigente/Nº Total de ítems en Inventario";
    String formCantidadPedido = "Nº de ítems con Cantidad de Pedido Vigente/Nº total de ítems en Inventario";
    String formMaterialesObsoletos = "Valor del inventario de Materiales Obsoletos/Valor total del Inventario";
    String formInventarios = "Valor total de los Inventarios para Mantenimiento/Valor total de los Activos Operacionales";
    String formCostos = "Costo total del Mantenimiento/Cantidad total de Unidades Producidas";
    String formFactorUtilizacion = "Tiempo total Operativo/Tiempo total Disponible";
    
    float ACR, mantenPredictivo, mantenPrevetivo, mantenPlanificado, planificacion, programacion, ejecucion,
          gestionProyectos, confiabilidad, MTTR, disponibilidad, puntoPedido, cantidadPedido, materialesObsoletos,
          inventarios, costos, factorUtilizacion;
    
    float nSistemasCubiertosACR, nTotalSistemas, hHombreMantenPredictivo, hHombreTotalesManten, hHombreMantenPreventivo,
        hHombreMantenPlanifiPro,hHombreTotalesMantenDisp, nOTejeDen20CostPlan, nTotalOTeje, nTotalOTpro, cantOTretrab, 
       /* cantOTeje,*/ nProyecEjeDent15Plan, nTotalProyecEje, tiempoMedFallar, tiempoMedRep, timeTotalFunc, timeTotalIndisManten,
        nItemsPtoPedidoVig, nTotalItemsInvent, nItemsCantPedidoVig, valorInventMatObso, valorTotalInventario, 
        valorTotalInventaManten, valorTotalActOpera, costoTotalManten, cantTotalUnidProd, timeTotalOpera, timeTotalDisp, sumaTiempoRep,
        nTotalRep;
    
        DB datos = DB.getInstance();

    Formulas(){
    }
    
    Formulas(String fecha){
                datos.getId(18); 
                nSistemasCubiertosACR = Float.parseFloat(datos.getResultado());
                
                datos.getId(19); 
                nTotalSistemas = Float.parseFloat(datos.getResultado());
                
                datos.getId(20);
                hHombreMantenPredictivo = Float.parseFloat(datos.getResultado());
                
                datos.getId(21);
                hHombreTotalesManten = Float.parseFloat(datos.getResultado());
                
                datos.getId(23);
                hHombreMantenPreventivo = Float.parseFloat(datos.getResultado());
                
                datos.getId(22);
                hHombreMantenPlanifiPro = Float.parseFloat(datos.getResultado());
                
                datos.getId(24);
                hHombreTotalesMantenDisp = Float.parseFloat(datos.getResultado());
                
                datos.getId(25);
                nOTejeDen20CostPlan = Float.parseFloat(datos.getResultado());
                
                datos.getId(26);
                nTotalOTeje = Float.parseFloat(datos.getResultado());
                
                datos.getId(27);
                nTotalOTpro = Float.parseFloat(datos.getResultado());
                
                datos.getId(28);
                cantOTretrab = Float.parseFloat(datos.getResultado());
                
                datos.getId(29);
                nProyecEjeDent15Plan = Float.parseFloat(datos.getResultado());
                
                datos.getId(30);
                nTotalProyecEje = Float.parseFloat(datos.getResultado());
                
                datos.getId(31);
                sumaTiempoRep = Float.parseFloat(datos.getResultado());
                
                datos.getId(32);
                nTotalRep = Float.parseFloat(datos.getResultado());
                
                datos.getId(5);
                tiempoMedFallar = Float.parseFloat(datos.getResultado());
                
                datos.getId(4);
                tiempoMedRep = Float.parseFloat(datos.getResultado());
                
                datos.getId(5);
                timeTotalFunc = Float.parseFloat(datos.getResultado());
                
                datos.getId(6);
                timeTotalIndisManten = Float.parseFloat(datos.getResultado());
                
                datos.getId(7);
                nItemsPtoPedidoVig = Float.parseFloat(datos.getResultado());
                
                datos.getId(8);
                nTotalItemsInvent = Float.parseFloat(datos.getResultado());
                
                datos.getId(7);
                nItemsCantPedidoVig = Float.parseFloat(datos.getResultado());
                
                datos.getId(9);
                valorInventMatObso = Float.parseFloat(datos.getResultado());
                
                datos.getId(10);
                valorTotalInventario = Float.parseFloat(datos.getResultado());
                
                datos.getId(11);
                valorTotalInventaManten = Float.parseFloat(datos.getResultado());
                
                datos.getId(12);
                valorTotalActOpera = Float.parseFloat(datos.getResultado());
                
                datos.getId(13);
                costoTotalManten = Float.parseFloat(datos.getResultado());
                
                datos.getId(14);
                cantTotalUnidProd = Float.parseFloat(datos.getResultado());
                
                datos.getId(15);
                timeTotalOpera = Float.parseFloat(datos.getResultado());
                
                datos.getId(16);
                timeTotalDisp = Float.parseFloat(datos.getResultado());
                
                
                this.ACR();
                this.mantenimientoPredictivo();
                this.mantenimientoPreventivo();
                this.mantenimientoPlanificado();
                this.planificacion();
                this.programacion();
                this.ejecucion();
                this.gestionProyectos();
                this.confiabilidad();
                this.MTTR();
                this.disponibilidad();
                this.puntoPedido();
                this.cantidadPedido();
                this.materialesObsoletos();
                this.inventarios();
                this.costos();
                this.factorUtilizacion();
        }
    
    //CALCULANDO FORMULAS
    public void ACR(){ this.ACR = nSistemasCubiertosACR/nTotalSistemas; }
    public void mantenimientoPredictivo(){ this.mantenPredictivo = hHombreMantenPredictivo/hHombreTotalesManten; }
    public void mantenimientoPreventivo(){ this.mantenPrevetivo = hHombreMantenPreventivo/hHombreTotalesManten; }
    public void mantenimientoPlanificado(){ this.mantenPlanificado = hHombreMantenPlanifiPro/hHombreTotalesMantenDisp; }
    public void planificacion(){ this.planificacion =  nOTejeDen20CostPlan/nTotalOTeje; }
    public void programacion(){ this.programacion = nTotalOTeje/nTotalOTpro; }
    public void ejecucion(){ this.ejecucion = cantOTretrab/nTotalOTeje; }
    public void gestionProyectos(){ this.gestionProyectos = nProyecEjeDent15Plan/nTotalProyecEje; }
    public void confiabilidad(){ this.confiabilidad = tiempoMedRep; }
    public void MTTR(){ this.MTTR = sumaTiempoRep/nTotalRep;}
    public void disponibilidad(){ this.disponibilidad = timeTotalFunc/(timeTotalFunc+timeTotalIndisManten); }
    public void puntoPedido(){ this.puntoPedido = nItemsPtoPedidoVig/nTotalItemsInvent; }
    public void cantidadPedido(){ this.cantidadPedido = nItemsCantPedidoVig/nTotalItemsInvent; }
    public void materialesObsoletos(){ this.materialesObsoletos = valorInventMatObso/valorTotalInventario; }
    public void inventarios(){ this.inventarios = valorTotalInventaManten/valorTotalActOpera; }
    public void costos(){ this.costos = costoTotalManten/cantTotalUnidProd; }
    public void factorUtilizacion(){ this.factorUtilizacion = timeTotalOpera/timeTotalDisp; }
    
    //GETTERS de las Formulas
    public String getMantenimientoPredictivo(){ return String.valueOf(mantenPredictivo); }
    public String getMantenimientoPreventivo(){ return String.valueOf(mantenPrevetivo); }
    public String getMantenimientoPlanificado(){ return String.valueOf(mantenPlanificado); }
    public String getPlanificacion(){ return String.valueOf(planificacion); }
    public String getProgramacion(){ return String.valueOf(programacion); }
    public String getEjecucion(){ return String.valueOf(ejecucion); }
    public String getGestionProyectos(){ return String.valueOf(gestionProyectos); }
    public String getConfiabilidad(){ return String.valueOf(confiabilidad); }
    public String getMTTR(){ return String.valueOf(MTTR); }
    public String getDisponibilidad(){ return String.valueOf(disponibilidad); }
    public String getPuntoPedido(){ return String.valueOf(puntoPedido); }
    public String getCantidadPedido(){ return String.valueOf(cantidadPedido); }
    public String getMaterialesObsoletos(){ return String.valueOf(materialesObsoletos); }
    public String getInventarios(){ return String.valueOf(inventarios); }
    public String getCostos(){ return String.valueOf(costos); }
    public String getFactorUtilizacion(){ return String.valueOf(factorUtilizacion);}
}
