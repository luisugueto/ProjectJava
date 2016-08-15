/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectjava;

import java.text.ParseException;
import java.util.ArrayList;
import model.DB;

/**
 *
 * @author Luis
 */
public class Formulas {
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
    
    
    String ACR, mantenPredictivo, mantenPrevetivo, mantenPlanificado, planificacion, programacion, ejecucion,
          gestionProyectos, confiabilidad, MTTR, disponibilidad, puntoPedido, cantidadPedido, materialesObsoletos,
          inventarios, costos, factorUtilizacion;
    
    
    //Variables reservadas para resultados individuales
    float nSistemasCubiertosACR, nTotalSistemas, hHombreMantenPredictivo, hHombreTotalesManten, hHombreMantenPreventivo,
        hHombreMantenPlanifiPro,hHombreTotalesMantenDisp, nOTejeDen20CostPlan, nTotalOTeje, nTotalOTpro, cantOTretrab, 
       /* cantOTeje,*/ nProyecEjeDent15Plan, nTotalProyecEje, tiempoMedFallar, tiempoMedRep, timeTotalFunc, timeTotalIndisManten,
        nItemsPtoPedidoVig, nTotalItemsInvent, nItemsCantPedidoVig, valorInventMatObso, valorTotalInventario, 
        valorTotalInventaManten, valorTotalActOpera, costoTotalManten, cantTotalUnidProd, timeTotalOpera, timeTotalDisp, sumaTiempoRep,
        nTotalRep;
    
    //Contador de Vueltas de Ciclos por Mes y Año
    int numVueltas = 0;
    
    //Acumulador de Resultados de Ciclos por Mes y Año
    float acumRes = 0;
    
    //ArrayList de variables Reservadas Para Obtener Listado por Meses, Años.
    ArrayList mantenPredictivoA = new ArrayList();
    ArrayList acrA = new ArrayList();
    ArrayList mantenPreventivoA = new ArrayList();
    ArrayList mantenPlanificadoA = new ArrayList();
    ArrayList planificacionA = new ArrayList();
    ArrayList programacionA = new ArrayList();
    ArrayList ejecucionA = new ArrayList();
    ArrayList gestionProyectosA = new ArrayList();
    ArrayList confiabilidadA = new ArrayList();
    ArrayList mttrA = new ArrayList();
    ArrayList disponibilidadA = new ArrayList();
    ArrayList puntoPedidoA = new ArrayList();
    ArrayList cantidadPedidoA = new ArrayList();
    ArrayList materialesObsoletosA = new ArrayList();
    ArrayList inventariosA = new ArrayList();
    ArrayList costosA = new ArrayList();
    ArrayList factorUtilizacionA = new ArrayList();

    //Variable reservada para obtener resultados de los datos por Mes y Año.
    public float mantenPredictivoR, acrR, mantenPreventivoR, mantenPlanificadoR, planificacionR, programacionR, ejecucionR,
          gestionProyectosR, confiabilidadR, mttrR, disponibilidadR, puntoPedidoR, cantidadPedidoR, materialesObsoletosR,
          inventariosR, costosR, factorUtilizacionR;
    
    private static volatile Formulas instance = null;
    
    Formulas(){}
    
    //Constructor para hacer los calculos por Mes, Trimestre, Semestre y Anual.
    Formulas(String fecha, String tipo){
        if(tipo.equals("mes"))
        {
            DB datos = new DB();
            datos.setFecha(fecha);
            datos.getDatoPorPosicionMes(3);
            this.numVueltas = 0;
            for(int i = 0; i < datos.resultados.size(); i++){
                this.numVueltas++;
                
                //OBTIENE LOS DATOS
                datos.getDatoPorPosicionMes(18);  
                nSistemasCubiertosACR = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(19); 
                nTotalSistemas = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(20);
                hHombreMantenPredictivo = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(21);
                hHombreTotalesManten = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(23);
                hHombreMantenPreventivo = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(22);
                hHombreMantenPlanifiPro = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(24);
                hHombreTotalesMantenDisp = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(25);
                nOTejeDen20CostPlan = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(26);
                nTotalOTeje = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(27);
                nTotalOTpro = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(28);
                cantOTretrab = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(29);
                nProyecEjeDent15Plan = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(30);
                nTotalProyecEje = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(31);
                sumaTiempoRep = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(32);
                nTotalRep = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(5);
                tiempoMedFallar = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(4);
                tiempoMedRep = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(5);
                timeTotalFunc = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(6);
                timeTotalIndisManten = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(7);
                nItemsPtoPedidoVig = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(8);
                nTotalItemsInvent = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(7);
                nItemsCantPedidoVig = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(9);
                valorInventMatObso = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(10);
                valorTotalInventario = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(11);
                valorTotalInventaManten = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(12);
                valorTotalActOpera = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(13);
                costoTotalManten = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(14);
                cantTotalUnidProd = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(15);
                timeTotalOpera = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(16);
                timeTotalDisp = Float.parseFloat(String.valueOf(datos.resultados.get(i)));
            
                //EJECUTA LAS FORMULAS 
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
                
                //Agrega los resultados al ArrayList para categorizarlos por Mes y/o Año.                
                this.acrA.add(this.getACR());
                this.mantenPredictivoA.add(this.getMantenimientoPredictivo());
                this.mantenPreventivoA.add(this.getMantenimientoPreventivo());
                this.mantenPlanificadoA.add(this.getMantenimientoPlanificado());
                this.planificacionA.add(this.getPlanificacion());
                this.programacionA.add(this.getProgramacion());
                this.ejecucionA.add(this.getEjecucion());
                this.gestionProyectosA.add(this.getGestionProyectos());
                this.confiabilidadA.add(this.getConfiabilidad());
                this.mttrA.add(this.getMTTR());
                this.disponibilidadA.add(this.getDisponibilidad());
                this.puntoPedidoA.add(this.getPuntoPedido());
                this.cantidadPedidoA.add(this.getCantidadPedido());
                this.materialesObsoletosA.add(this.getMaterialesObsoletos());
                this.inventariosA.add(this.getInventarios());
                this.costosA.add(this.getCostos());
                this.factorUtilizacionA.add(this.getFactorUtilizacion());
            }
            for(int i = 0; i < acrA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.acrA.get(i))); }
            this.acrR = this.acumRes/this.numVueltas;
            for(int i = 0; i < mantenPredictivoA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.mantenPredictivoA.get(i))); }
            this.mantenPredictivoR = this.acumRes/this.numVueltas;
            for(int i = 0; i < mantenPreventivoA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.mantenPreventivoA.get(i))); }
            this.mantenPreventivoR = this.acumRes/this.numVueltas;
            for(int i = 0; i < mantenPlanificadoA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.mantenPlanificadoA.get(i))); }
            this.mantenPlanificadoR = this.acumRes/this.numVueltas;
            for(int i = 0; i < planificacionA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.planificacionA.get(i))); }
            this.planificacionR = this.acumRes/this.numVueltas;
            for(int i = 0; i < programacionA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.programacionA.get(i))); }
            this.programacionR = this.acumRes/this.numVueltas;
            for(int i = 0; i < ejecucionA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.ejecucionA.get(i))); }
            this.ejecucionR = this.acumRes/this.numVueltas;
            for(int i = 0; i < gestionProyectosA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.gestionProyectosA.get(i))); }
            this.gestionProyectosR = this.acumRes/this.numVueltas;
            for(int i = 0; i < confiabilidadA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.confiabilidadA.get(i))); }
            this.confiabilidadR = this.acumRes/this.numVueltas;
            for(int i = 0; i < mttrA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.mttrA.get(i))); }
            this.mttrR = this.acumRes/this.numVueltas;
            for(int i = 0; i < disponibilidadA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.disponibilidadA.get(i))); }
            this.disponibilidadR = this.acumRes/this.numVueltas;
            for(int i = 0; i < puntoPedidoA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.puntoPedidoA.get(i))); }
            this.puntoPedidoR = this.acumRes/this.numVueltas;
            for(int i = 0; i < cantidadPedidoA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.cantidadPedidoA.get(i))); }
            this.cantidadPedidoR = this.acumRes/this.numVueltas;
            for(int i = 0; i < materialesObsoletosA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.materialesObsoletosA.get(i))); }
            this.materialesObsoletosR = this.acumRes/this.numVueltas;
            for(int i = 0; i < inventariosA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.inventariosA.get(i))); }
            this.inventariosR = this.acumRes/this.numVueltas;
            for(int i = 0; i < costosA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.costosA.get(i))); }
            this.costosR = this.acumRes/this.numVueltas;
            for(int i = 0; i < factorUtilizacionA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.factorUtilizacionA.get(i))); }
            this.factorUtilizacionR = this.acumRes/this.numVueltas;
        }
        
        if(tipo.equals("trimestral"))
        {
            DB datos = new DB();
            datos.setFecha(fecha);
            datos.getDatoPorPosicionMes(3);
            this.numVueltas = 0;
            for(int i = 0; i < datos.resultados.size(); i++){
                this.numVueltas++;
                
                //OBTIENE LOS DATOS
                datos.getDatoPorPosicionMes(18);  
                nSistemasCubiertosACR = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(19); 
                nTotalSistemas = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(20);
                hHombreMantenPredictivo = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(21);
                hHombreTotalesManten = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(23);
                hHombreMantenPreventivo = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(22);
                hHombreMantenPlanifiPro = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(24);
                hHombreTotalesMantenDisp = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(25);
                nOTejeDen20CostPlan = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(26);
                nTotalOTeje = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(27);
                nTotalOTpro = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(28);
                cantOTretrab = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(29);
                nProyecEjeDent15Plan = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(30);
                nTotalProyecEje = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(31);
                sumaTiempoRep = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(32);
                nTotalRep = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(5);
                tiempoMedFallar = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(4);
                tiempoMedRep = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(5);
                timeTotalFunc = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(6);
                timeTotalIndisManten = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(7);
                nItemsPtoPedidoVig = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(8);
                nTotalItemsInvent = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(7);
                nItemsCantPedidoVig = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(9);
                valorInventMatObso = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(10);
                valorTotalInventario = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(11);
                valorTotalInventaManten = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(12);
                valorTotalActOpera = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(13);
                costoTotalManten = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(14);
                cantTotalUnidProd = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(15);
                timeTotalOpera = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(16);
                timeTotalDisp = Float.parseFloat(String.valueOf(datos.resultados.get(i)));
            
                //EJECUTA LAS FORMULAS 
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
                
                //Agrega los resultados al ArrayList para categorizarlos por Mes y/o Año.                
                this.acrA.add(this.getACR());
                this.mantenPredictivoA.add(this.getMantenimientoPredictivo());
                this.mantenPreventivoA.add(this.getMantenimientoPreventivo());
                this.mantenPlanificadoA.add(this.getMantenimientoPlanificado());
                this.planificacionA.add(this.getPlanificacion());
                this.programacionA.add(this.getProgramacion());
                this.ejecucionA.add(this.getEjecucion());
                this.gestionProyectosA.add(this.getGestionProyectos());
                this.confiabilidadA.add(this.getConfiabilidad());
                this.mttrA.add(this.getMTTR());
                this.disponibilidadA.add(this.getDisponibilidad());
                this.puntoPedidoA.add(this.getPuntoPedido());
                this.cantidadPedidoA.add(this.getCantidadPedido());
                this.materialesObsoletosA.add(this.getMaterialesObsoletos());
                this.inventariosA.add(this.getInventarios());
                this.costosA.add(this.getCostos());
                this.factorUtilizacionA.add(this.getFactorUtilizacion());
            }
            
            for(int i = 0; i < acrA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.acrA.get(i))); }
            this.acrR = this.acumRes/this.numVueltas;
            for(int i = 0; i < mantenPredictivoA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.mantenPredictivoA.get(i))); }
            this.mantenPredictivoR = this.acumRes/this.numVueltas;
            for(int i = 0; i < mantenPreventivoA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.mantenPreventivoA.get(i))); }
            this.mantenPreventivoR = this.acumRes/this.numVueltas;
            for(int i = 0; i < mantenPlanificadoA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.mantenPlanificadoA.get(i))); }
            this.mantenPlanificadoR = this.acumRes/this.numVueltas;
            for(int i = 0; i < planificacionA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.planificacionA.get(i))); }
            this.planificacionR = this.acumRes/this.numVueltas;
            for(int i = 0; i < programacionA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.programacionA.get(i))); }
            this.programacionR = this.acumRes/this.numVueltas;
            for(int i = 0; i < ejecucionA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.ejecucionA.get(i))); }
            this.ejecucionR = this.acumRes/this.numVueltas;
            for(int i = 0; i < gestionProyectosA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.gestionProyectosA.get(i))); }
            this.gestionProyectosR = this.acumRes/this.numVueltas;
            for(int i = 0; i < confiabilidadA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.confiabilidadA.get(i))); }
            this.confiabilidadR = this.acumRes/this.numVueltas;
            for(int i = 0; i < mttrA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.mttrA.get(i))); }
            this.mttrR = this.acumRes/this.numVueltas;
            for(int i = 0; i < disponibilidadA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.disponibilidadA.get(i))); }
            this.disponibilidadR = this.acumRes/this.numVueltas;
            for(int i = 0; i < puntoPedidoA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.puntoPedidoA.get(i))); }
            this.puntoPedidoR = this.acumRes/this.numVueltas;
            for(int i = 0; i < cantidadPedidoA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.cantidadPedidoA.get(i))); }
            this.cantidadPedidoR = this.acumRes/this.numVueltas;
            for(int i = 0; i < materialesObsoletosA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.materialesObsoletosA.get(i))); }
            this.materialesObsoletosR = this.acumRes/this.numVueltas;
            for(int i = 0; i < inventariosA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.inventariosA.get(i))); }
            this.inventariosR = this.acumRes/this.numVueltas;
            for(int i = 0; i < costosA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.costosA.get(i))); }
            this.costosR = this.acumRes/this.numVueltas;
            for(int i = 0; i < factorUtilizacionA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.factorUtilizacionA.get(i))); }
            this.factorUtilizacionR = this.acumRes/this.numVueltas;
        }
        if(tipo.equals("semestral"))
        {
            DB datos = new DB();
            datos.setFecha(fecha);
            datos.getDatoPorPosicionMes(3);
            this.numVueltas = 0;
            for(int i = 0; i < datos.resultados.size(); i++){
                this.numVueltas++;
                
                //OBTIENE LOS DATOS
                datos.getDatoPorPosicionMes(18);  
                nSistemasCubiertosACR = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(19); 
                nTotalSistemas = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(20);
                hHombreMantenPredictivo = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(21);
                hHombreTotalesManten = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(23);
                hHombreMantenPreventivo = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(22);
                hHombreMantenPlanifiPro = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(24);
                hHombreTotalesMantenDisp = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(25);
                nOTejeDen20CostPlan = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(26);
                nTotalOTeje = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(27);
                nTotalOTpro = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(28);
                cantOTretrab = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(29);
                nProyecEjeDent15Plan = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(30);
                nTotalProyecEje = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(31);
                sumaTiempoRep = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(32);
                nTotalRep = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(5);
                tiempoMedFallar = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(4);
                tiempoMedRep = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(5);
                timeTotalFunc = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(6);
                timeTotalIndisManten = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(7);
                nItemsPtoPedidoVig = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(8);
                nTotalItemsInvent = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(7);
                nItemsCantPedidoVig = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(9);
                valorInventMatObso = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(10);
                valorTotalInventario = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(11);
                valorTotalInventaManten = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(12);
                valorTotalActOpera = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(13);
                costoTotalManten = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(14);
                cantTotalUnidProd = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(15);
                timeTotalOpera = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(16);
                timeTotalDisp = Float.parseFloat(String.valueOf(datos.resultados.get(i)));
            
                //EJECUTA LAS FORMULAS 
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
                
                //Agrega los resultados al ArrayList para categorizarlos por Mes y/o Año.                
                this.acrA.add(this.getACR());
                this.mantenPredictivoA.add(this.getMantenimientoPredictivo());
                this.mantenPreventivoA.add(this.getMantenimientoPreventivo());
                this.mantenPlanificadoA.add(this.getMantenimientoPlanificado());
                this.planificacionA.add(this.getPlanificacion());
                this.programacionA.add(this.getProgramacion());
                this.ejecucionA.add(this.getEjecucion());
                this.gestionProyectosA.add(this.getGestionProyectos());
                this.confiabilidadA.add(this.getConfiabilidad());
                this.mttrA.add(this.getMTTR());
                this.disponibilidadA.add(this.getDisponibilidad());
                this.puntoPedidoA.add(this.getPuntoPedido());
                this.cantidadPedidoA.add(this.getCantidadPedido());
                this.materialesObsoletosA.add(this.getMaterialesObsoletos());
                this.inventariosA.add(this.getInventarios());
                this.costosA.add(this.getCostos());
                this.factorUtilizacionA.add(this.getFactorUtilizacion());
            }
            
            for(int i = 0; i < acrA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.acrA.get(i))); }
            this.acrR = this.acumRes/this.numVueltas;
            for(int i = 0; i < mantenPredictivoA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.mantenPredictivoA.get(i))); }
            this.mantenPredictivoR = this.acumRes/this.numVueltas;
            for(int i = 0; i < mantenPreventivoA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.mantenPreventivoA.get(i))); }
            this.mantenPreventivoR = this.acumRes/this.numVueltas;
            for(int i = 0; i < mantenPlanificadoA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.mantenPlanificadoA.get(i))); }
            this.mantenPlanificadoR = this.acumRes/this.numVueltas;
            for(int i = 0; i < planificacionA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.planificacionA.get(i))); }
            this.planificacionR = this.acumRes/this.numVueltas;
            for(int i = 0; i < programacionA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.programacionA.get(i))); }
            this.programacionR = this.acumRes/this.numVueltas;
            for(int i = 0; i < ejecucionA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.ejecucionA.get(i))); }
            this.ejecucionR = this.acumRes/this.numVueltas;
            for(int i = 0; i < gestionProyectosA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.gestionProyectosA.get(i))); }
            this.gestionProyectosR = this.acumRes/this.numVueltas;
            for(int i = 0; i < confiabilidadA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.confiabilidadA.get(i))); }
            this.confiabilidadR = this.acumRes/this.numVueltas;
            for(int i = 0; i < mttrA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.mttrA.get(i))); }
            this.mttrR = this.acumRes/this.numVueltas;
            for(int i = 0; i < disponibilidadA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.disponibilidadA.get(i))); }
            this.disponibilidadR = this.acumRes/this.numVueltas;
            for(int i = 0; i < puntoPedidoA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.puntoPedidoA.get(i))); }
            this.puntoPedidoR = this.acumRes/this.numVueltas;
            for(int i = 0; i < cantidadPedidoA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.cantidadPedidoA.get(i))); }
            this.cantidadPedidoR = this.acumRes/this.numVueltas;
            for(int i = 0; i < materialesObsoletosA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.materialesObsoletosA.get(i))); }
            this.materialesObsoletosR = this.acumRes/this.numVueltas;
            for(int i = 0; i < inventariosA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.inventariosA.get(i))); }
            this.inventariosR = this.acumRes/this.numVueltas;
            for(int i = 0; i < costosA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.costosA.get(i))); }
            this.costosR = this.acumRes/this.numVueltas;
            for(int i = 0; i < factorUtilizacionA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.factorUtilizacionA.get(i))); }
            this.factorUtilizacionR = this.acumRes/this.numVueltas;
        }
        if(tipo.equals("anual"))
        {
            DB datos = new DB();
            datos.setFecha(fecha);
            datos.getDatoPorPosicionMes(3);
            this.numVueltas = 0;
            for(int i = 0; i < datos.resultados.size(); i++){
                this.numVueltas++;
                
                //OBTIENE LOS DATOS
                datos.getDatoPorPosicionMes(18);  
                nSistemasCubiertosACR = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(19); 
                nTotalSistemas = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(20);
                hHombreMantenPredictivo = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(21);
                hHombreTotalesManten = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(23);
                hHombreMantenPreventivo = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(22);
                hHombreMantenPlanifiPro = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(24);
                hHombreTotalesMantenDisp = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(25);
                nOTejeDen20CostPlan = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(26);
                nTotalOTeje = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(27);
                nTotalOTpro = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(28);
                cantOTretrab = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(29);
                nProyecEjeDent15Plan = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(30);
                nTotalProyecEje = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(31);
                sumaTiempoRep = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(32);
                nTotalRep = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(5);
                tiempoMedFallar = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(4);
                tiempoMedRep = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(5);
                timeTotalFunc = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(6);
                timeTotalIndisManten = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(7);
                nItemsPtoPedidoVig = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(8);
                nTotalItemsInvent = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(7);
                nItemsCantPedidoVig = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(9);
                valorInventMatObso = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(10);
                valorTotalInventario = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(11);
                valorTotalInventaManten = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(12);
                valorTotalActOpera = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(13);
                costoTotalManten = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(14);
                cantTotalUnidProd = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(15);
                timeTotalOpera = Float.parseFloat(String.valueOf(datos.resultados.get(i)));

                datos.getDatoPorPosicionMes(16);
                timeTotalDisp = Float.parseFloat(String.valueOf(datos.resultados.get(i)));
            
                //EJECUTA LAS FORMULAS 
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
                
                //Agrega los resultados al ArrayList para categorizarlos por Mes y/o Año.                
                this.acrA.add(this.getACR());
                this.mantenPredictivoA.add(this.getMantenimientoPredictivo());
                this.mantenPreventivoA.add(this.getMantenimientoPreventivo());
                this.mantenPlanificadoA.add(this.getMantenimientoPlanificado());
                this.planificacionA.add(this.getPlanificacion());
                this.programacionA.add(this.getProgramacion());
                this.ejecucionA.add(this.getEjecucion());
                this.gestionProyectosA.add(this.getGestionProyectos());
                this.confiabilidadA.add(this.getConfiabilidad());
                this.mttrA.add(this.getMTTR());
                this.disponibilidadA.add(this.getDisponibilidad());
                this.puntoPedidoA.add(this.getPuntoPedido());
                this.cantidadPedidoA.add(this.getCantidadPedido());
                this.materialesObsoletosA.add(this.getMaterialesObsoletos());
                this.inventariosA.add(this.getInventarios());
                this.costosA.add(this.getCostos());
                this.factorUtilizacionA.add(this.getFactorUtilizacion());
            }
            
            for(int i = 0; i < acrA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.acrA.get(i))); }
            this.acrR = this.acumRes/this.numVueltas;
            for(int i = 0; i < mantenPredictivoA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.mantenPredictivoA.get(i))); }
            this.mantenPredictivoR = this.acumRes/this.numVueltas;
            for(int i = 0; i < mantenPreventivoA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.mantenPreventivoA.get(i))); }
            this.mantenPreventivoR = this.acumRes/this.numVueltas;
            for(int i = 0; i < mantenPlanificadoA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.mantenPlanificadoA.get(i))); }
            this.mantenPlanificadoR = this.acumRes/this.numVueltas;
            for(int i = 0; i < planificacionA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.planificacionA.get(i))); }
            this.planificacionR = this.acumRes/this.numVueltas;
            for(int i = 0; i < programacionA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.programacionA.get(i))); }
            this.programacionR = this.acumRes/this.numVueltas;
            for(int i = 0; i < ejecucionA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.ejecucionA.get(i))); }
            this.ejecucionR = this.acumRes/this.numVueltas;
            for(int i = 0; i < gestionProyectosA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.gestionProyectosA.get(i))); }
            this.gestionProyectosR = this.acumRes/this.numVueltas;
            for(int i = 0; i < confiabilidadA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.confiabilidadA.get(i))); }
            this.confiabilidadR = this.acumRes/this.numVueltas;
            for(int i = 0; i < mttrA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.mttrA.get(i))); }
            this.mttrR = this.acumRes/this.numVueltas;
            for(int i = 0; i < disponibilidadA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.disponibilidadA.get(i))); }
            this.disponibilidadR = this.acumRes/this.numVueltas;
            for(int i = 0; i < puntoPedidoA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.puntoPedidoA.get(i))); }
            this.puntoPedidoR = this.acumRes/this.numVueltas;
            for(int i = 0; i < cantidadPedidoA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.cantidadPedidoA.get(i))); }
            this.cantidadPedidoR = this.acumRes/this.numVueltas;
            for(int i = 0; i < materialesObsoletosA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.materialesObsoletosA.get(i))); }
            this.materialesObsoletosR = this.acumRes/this.numVueltas;
            for(int i = 0; i < inventariosA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.inventariosA.get(i))); }
            this.inventariosR = this.acumRes/this.numVueltas;
            for(int i = 0; i < costosA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.costosA.get(i))); }
            this.costosR = this.acumRes/this.numVueltas;
            for(int i = 0; i < factorUtilizacionA.size(); i++){ this.acumRes += Float.parseFloat(String.valueOf(this.factorUtilizacionA.get(i))); }
            this.factorUtilizacionR = this.acumRes/this.numVueltas;
        }
    }
    
    Formulas(String fecha){
                DB datos = new DB();
                datos.setFecha(fecha);
                //OBTIENE LOS DATOS
                datos.getDatoPorPosicion(18);  
                nSistemasCubiertosACR = datos.getResultad();
                
                datos.getDatoPorPosicion(19); 
                nTotalSistemas = datos.getResultad();
                
                datos.getDatoPorPosicion(20);
                hHombreMantenPredictivo = datos.getResultad();
                
                datos.getDatoPorPosicion(21);
                hHombreTotalesManten = datos.getResultad();
                
                datos.getDatoPorPosicion(23);
                hHombreMantenPreventivo = datos.getResultad();
                
                datos.getDatoPorPosicion(22);
                hHombreMantenPlanifiPro = datos.getResultad();
                
                datos.getDatoPorPosicion(24);
                hHombreTotalesMantenDisp = datos.getResultad();
                
                datos.getDatoPorPosicion(25);
                nOTejeDen20CostPlan = datos.getResultad();
                
                datos.getDatoPorPosicion(26);
                nTotalOTeje = datos.getResultad();
                
                datos.getDatoPorPosicion(27);
                nTotalOTpro = datos.getResultad();
                
                datos.getDatoPorPosicion(28);
                cantOTretrab = datos.getResultad();
                
                datos.getDatoPorPosicion(29);
                nProyecEjeDent15Plan = datos.getResultad();
                
                datos.getDatoPorPosicion(30);
                nTotalProyecEje = datos.getResultad();
                
                datos.getDatoPorPosicion(31);
                sumaTiempoRep = datos.getResultad();
                
                datos.getDatoPorPosicion(32);
                nTotalRep = datos.getResultad();
                
                datos.getDatoPorPosicion(5);
                tiempoMedFallar = datos.getResultad();
                
                datos.getDatoPorPosicion(4);
                tiempoMedRep = datos.getResultad();
                
                datos.getDatoPorPosicion(5);
                timeTotalFunc = datos.getResultad();
                
                datos.getDatoPorPosicion(6);
                timeTotalIndisManten = datos.getResultad();
                
                datos.getDatoPorPosicion(7);
                nItemsPtoPedidoVig = datos.getResultad();
                
                datos.getDatoPorPosicion(8);
                nTotalItemsInvent = datos.getResultad();
                
                datos.getDatoPorPosicion(7);
                nItemsCantPedidoVig = datos.getResultad();
                
                datos.getDatoPorPosicion(9);
                valorInventMatObso = datos.getResultad();
                
                datos.getDatoPorPosicion(10);
                valorTotalInventario = datos.getResultad();
                
                datos.getDatoPorPosicion(11);
                valorTotalInventaManten = datos.getResultad();
                
                datos.getDatoPorPosicion(12);
                valorTotalActOpera = datos.getResultad();
                
                datos.getDatoPorPosicion(13);
                costoTotalManten = datos.getResultad();
                
                datos.getDatoPorPosicion(14);
                cantTotalUnidProd = datos.getResultad();
                
                datos.getDatoPorPosicion(15);
                timeTotalOpera = datos.getResultad();
                
                datos.getDatoPorPosicion(16);
                timeTotalDisp = datos.getResultad();
                
                //EJECUTA LAS FORMULAS
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
    public void ACR(){ this.ACR = ""+this.nSistemasCubiertosACR/this.nTotalSistemas; }
    public void mantenimientoPredictivo(){ this.mantenPredictivo = ""+this.hHombreMantenPredictivo/this.hHombreTotalesManten;    }
    public void mantenimientoPreventivo(){ this.mantenPrevetivo = ""+this.hHombreMantenPreventivo/this.hHombreTotalesManten; }
    public void mantenimientoPlanificado(){ this.mantenPlanificado = ""+this.hHombreMantenPlanifiPro/this.hHombreTotalesMantenDisp; }
    public void planificacion(){ this.planificacion =  ""+this.nOTejeDen20CostPlan/this.nTotalOTeje; }
    public void programacion(){ this.programacion = ""+this.nTotalOTeje/this.nTotalOTpro; }
    public void ejecucion(){ this.ejecucion = ""+this.cantOTretrab/this.nTotalOTeje; }
    public void gestionProyectos(){ this.gestionProyectos = ""+this.nProyecEjeDent15Plan/this.nTotalProyecEje; }
    public void confiabilidad(){ this.confiabilidad = ""+this.tiempoMedRep; }
    public void MTTR(){ this.MTTR = ""+this.sumaTiempoRep/this.nTotalRep;}
    public void disponibilidad(){ this.disponibilidad = ""+this.timeTotalFunc/(this.timeTotalFunc+this.timeTotalIndisManten); }
    public void puntoPedido(){ this.puntoPedido = ""+this.nItemsPtoPedidoVig/this.nTotalItemsInvent; }
    public void cantidadPedido(){ this.cantidadPedido = ""+this.nItemsCantPedidoVig/this.nTotalItemsInvent; }
    public void materialesObsoletos(){ this.materialesObsoletos = ""+this.valorInventMatObso/this.valorTotalInventario; }
    public void inventarios(){ this.inventarios = ""+this.valorTotalInventaManten/this.valorTotalActOpera; }
    public void costos(){ this.costos = ""+this.costoTotalManten/this.cantTotalUnidProd; }
    public void factorUtilizacion(){ this.factorUtilizacion = ""+this.timeTotalOpera/this.timeTotalDisp; } 
    
    //GETTERS de las Formulas
    public String getACR(){ return String.valueOf(ACR);}
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
    
    public static synchronized Formulas getInstance() {
        if (instance == null) instance = new Formulas();
        return instance;
    }
}
