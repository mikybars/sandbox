package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.CounterFunctionalMetric;
import com.inditex.aqsw.libmonitoringcenter.functionalmetrics.aop.annotations.TimerFunctionalMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service.RunTareaProcesarCondicionesAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service.RunTareaProcesarPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service.RunTareaProcesarVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaProcesarService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class RunTareaProcesarServiceImpl implements RunTareaProcesarService {

    @Autowired
    private RunTareaProcesarVentaAsyncService runTareaProcesarVentaAsyncService;

    @Autowired
    private RunTareaProcesarPresenciaAsyncService runTareaProcesarPresenciaAsyncService;
    
    @Autowired
    private RunTareaProcesarCondicionesAsyncService runTareaProcesarCondicionesAsyncService;

    @Auditoria
    @TimerFunctionalMetric(metricName = "RunTareaProcesarService.run.timer", metricGroupName = "RunTareaProcesarServiceGroup", metricDescription = "RunTareaProcesarService.run.timer")
    @CounterFunctionalMetric(metricName = "RunTareaProcesarService.run.counter", metricGroupName = "RunTareaProcesarServiceGroup", metricDescription = "RunTareaProcesarService.run.counter")
    @Override
    public void run(@NotNull @Valid RunTareaDto runTarea) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfWait = new ArrayList<>();

        try {
            // Actualizar importe de estructuras minimo garantizado
            CompletableFuture<Void> cfUpdateImporteEstructuraPoliticas = runTareaProcesarCondicionesAsyncService
                    .updateImporteEstructuraPoliticas(runTarea);
            AsyncUtils.exceptionally(cfUpdateImporteEstructuraPoliticas, cf);
            
             //Actualizar flags de presencias activas
            CompletableFuture<Void> cfUpdateSeccionPresenciasActivas = runTareaProcesarPresenciaAsyncService
                    .updateActivoLocalizacionPersonaPresencia(runTarea);
            AsyncUtils.exceptionally(cfUpdateSeccionPresenciasActivas, cf, cfWait);

            //TODO [JAVIEREV] Esto queda por si necesitamos arreglar rápidamente algún caso extraño con presencias 0,
            // pero no debería darse nunca (y, por tanto, podríamos eliminarlo)

//            /*-------------------------------------------------------------*/
//            AsyncUtils.waitAllOfIsOk(cf, cf);
//            /*-------------------------------------------------------------*/
//
//            //Actualizar flags de presencias totales con minutos a cero
//            CompletableFuture<Void> cfUpdatePresenciasActivasVacio = runTareaProcesarPresenciaAsyncService
//                .updateActivoLocalizacionVacio(runTarea);
//            AsyncUtils.exceptionally(cfUpdatePresenciasActivasVacio, cf);
//
//            //Actualizar flags de presencias localizacion persona con minutos a cero
//            CompletableFuture<Void> cfUpdateSeccionPresenciasActivasVacio = runTareaProcesarPresenciaAsyncService
//                .updateActivoLocalizacionPersonaPresenciaVacio(runTarea);
//            AsyncUtils.exceptionally(cfUpdateSeccionPresenciasActivasVacio, cf);

            CompletableFuture<Void> cfTotalizarDevolucion = runTareaProcesarVentaAsyncService.totalizarDevolucionLocalizacion(runTarea);
            AsyncUtils.exceptionally(cfTotalizarDevolucion, cf, cfWait);

            CompletableFuture<Void> cfTotalizarVentaPersonaSeccion = runTareaProcesarVentaAsyncService.totalizarVentaPersonaSeccion(runTarea);
            AsyncUtils.exceptionally(cfTotalizarVentaPersonaSeccion, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/
            
            // Calcular localizacion abierta
            CompletableFuture<Void> cfSaveAbierto = runTareaProcesarVentaAsyncService.saveAbierto(runTarea);
            AsyncUtils.exceptionally(cfSaveAbierto, cf, cfWait);

            // Calcular localizacion seccion abierta
            CompletableFuture<Void> cfSaveAbiertoSeccion = runTareaProcesarVentaAsyncService.saveAbiertoSeccion(runTarea);
            AsyncUtils.exceptionally(cfSaveAbiertoSeccion, cf, cfWait);

            // Calcular ventas localizacion realizadas por personas por venta simplificado
            CompletableFuture<Void> cfVentasPorVentaSimplificado = runTareaProcesarVentaAsyncService.totalizarVentaPersonasPorVenta(runTarea, TipoCalculoEnum.POR_VENTA_SIMPLIFICADA);
            AsyncUtils.exceptionally(cfVentasPorVentaSimplificado, cf, cfWait);

            // Calcular ventas localizacion realizadas por personas por venta
            CompletableFuture<Void> cfVentasPorVenta =
                runTareaProcesarVentaAsyncService.totalizarVentaPersonasPorVenta(runTarea, TipoCalculoEnum.POR_VENTA);
            AsyncUtils.exceptionally(cfVentasPorVenta, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // Calcular importe comision vendedores por venta
            CompletableFuture<Void> cfCalcularImporteComisionVendedores =
                runTareaProcesarVentaAsyncService.calcularImporteComisionVendedores(runTarea);
            AsyncUtils.exceptionally(cfCalcularImporteComisionVendedores, cf, cfWait);

            // Calcular localizacion cerrada
            CompletableFuture<Void> cfSaveCerrado = runTareaProcesarVentaAsyncService.saveCerrado(runTarea);
            AsyncUtils.exceptionally(cfSaveCerrado, cf, cfWait);

            // Calcular localizacion seccion cerrada
            CompletableFuture<Void> cfSaveCerradoSeccion = runTareaProcesarVentaAsyncService.saveCerradoSeccion(runTarea);
            AsyncUtils.exceptionally(cfSaveCerradoSeccion, cf, cfWait);


            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // Generar presencias horas fijas en desplazamientos
            CompletableFuture<Void> cfPresenciasHorasFijasDesplazamientos = runTareaProcesarPresenciaAsyncService.presenciasHorasFijasDesplazamientos(runTarea);
            AsyncUtils.exceptionally(cfPresenciasHorasFijasDesplazamientos, cf, cfWait);

            // Generar presencias horas fijas en la localizacion de la persona
            CompletableFuture<Void> cfPresenciasHorasFijas = runTareaProcesarPresenciaAsyncService.presenciasHorasFijas(runTarea);
            AsyncUtils.exceptionally(cfPresenciasHorasFijas, cf, cfWait);


            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // Actualizar flags de presencias activas
            cfUpdateSeccionPresenciasActivas = runTareaProcesarPresenciaAsyncService
                .updateActivoLocalizacionPersonaPresencia(runTarea);
            AsyncUtils.exceptionally(cfUpdateSeccionPresenciasActivas, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // Compensar presencia total localizacion persona con las manuales
            CompletableFuture<Void> cfCompensarPresenciaPersonaLocalizacion = runTareaProcesarPresenciaAsyncService
                .compensarLocalizacionPersonaPresencia(runTarea);
            AsyncUtils.exceptionally(cfCompensarPresenciaPersonaLocalizacion, cf, cfWait);

            // Compensar presencia total localizacion con las manuales
            CompletableFuture<Void> cfCompensarPresenciaLocalizacion = runTareaProcesarPresenciaAsyncService
                .compensarLocalizacion(runTarea);
            AsyncUtils.exceptionally(cfCompensarPresenciaLocalizacion, cf, cfWait);

            // Compensar presencia total localizacion con las manuales para incluido ecommerce
            CompletableFuture<Void> cfCompensarPresenciaLocalizacionEcommerce = runTareaProcesarPresenciaAsyncService
                .compensarLocalizacionEcommerce(runTarea);
            AsyncUtils.exceptionally(cfCompensarPresenciaLocalizacionEcommerce, cf, cfWait);

            CompletableFuture<Void> cfTotalizarPresenciaLocalizacion = runTareaProcesarPresenciaAsyncService
                .totalizarLocalizacion(runTarea);
            AsyncUtils.exceptionally(cfTotalizarPresenciaLocalizacion, cf, cfWait);

            CompletableFuture<Void> cfTotalizarPresenciaEcommerceLocalizacion = runTareaProcesarPresenciaAsyncService
                .totalizarEcommerceLocalizacion(runTarea);
            AsyncUtils.exceptionally(cfTotalizarPresenciaEcommerceLocalizacion, cf, cfWait);

            // Empleados por venta
            CompletableFuture<Void> cfTotalizarEmpleadosPorVenta = runTareaProcesarPresenciaAsyncService.totalizarEmpleadosPorVenta(runTarea);
            AsyncUtils.exceptionally(cfTotalizarEmpleadosPorVenta, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // Indicadores de presencia
            CompletableFuture<Void> cfIndicadorPresencia = runTareaProcesarPresenciaAsyncService
                    .indicadorPresencia(runTarea);
            AsyncUtils.exceptionally(cfIndicadorPresencia, cf, cfWait);
            
            // Indicadores de presencia con desplazamiento
            CompletableFuture<Void> cfIndicadorPresenciaDesplazamiento = runTareaProcesarPresenciaAsyncService
                    .indicadorPresenciaDesplazamiento(runTarea);
            AsyncUtils.exceptionally(cfIndicadorPresenciaDesplazamiento, cf, cfWait);
            
            // Indicadores de presencia con desplazamiento base
            CompletableFuture<Void> cfIndicadorPresenciaDesplazamientoBase = runTareaProcesarPresenciaAsyncService
                    .indicadorPresenciaDesplazamientoBase(runTarea);
            AsyncUtils.exceptionally(cfIndicadorPresenciaDesplazamientoBase, cf, cfWait);
            
            // Indicadores de presencia con desplazamiento base sobre desplazamiento misma localizacion
            CompletableFuture<Void> cfIndicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion = runTareaProcesarPresenciaAsyncService
                    .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(runTarea);
            AsyncUtils.exceptionally(cfIndicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion, cf, cfWait);

            // Presencias totales de agrupaciones
            CompletableFuture<Void> cfCalcularPresenciasTotalesAgrupacion = runTareaProcesarPresenciaAsyncService
                .calcularPresenciasTotalesAgrupacion(runTarea);
            AsyncUtils.exceptionally(cfCalcularPresenciasTotalesAgrupacion, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // Reparto de ventas online entrega domicilio en tiendas de cadenas agrupadas -
            // por ventas
            CompletableFuture<Void> cfRepartoAgrupaciones = runTareaProcesarVentaAsyncService
                    .repartoVentaEntregaDomicilioAgrupaciones(runTarea);
            AsyncUtils.exceptionally(cfRepartoAgrupaciones, cf, cfWait);

            // Reparto de ventas online entrega domicilio en tiendas de cadenas agrupadas -
            // por presencia
            CompletableFuture<Void> cfRepartoPresenciaAgrupaciones = runTareaProcesarVentaAsyncService
                    .repartoVentaEntregaDomicilioPorPresenciaAgrupaciones(runTarea);
            AsyncUtils.exceptionally(cfRepartoPresenciaAgrupaciones, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            // Reparto de ventas online entrega domicilio por sección
            CompletableFuture<Void> cfRepartoVentaOnlineEntregaDomicilioSeccion = runTareaProcesarVentaAsyncService
                .repartoVentaEntregaDomicilioSeccion(runTarea);
            AsyncUtils.exceptionally(cfRepartoVentaOnlineEntregaDomicilioSeccion, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/

            CompletableFuture<Void> cfTrasladar = runTareaProcesarVentaAsyncService.trasladar(runTarea);
            AsyncUtils.exceptionally(cfTrasladar, cf, cfWait);

            CompletableFuture<Void> cfCompensar = runTareaProcesarVentaAsyncService.compensar(runTarea);
            AsyncUtils.exceptionally(cfCompensar, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/
            
            CompletableFuture<Void> cfCompensarOnlineSeccionCerrada = runTareaProcesarVentaAsyncService.compensarOnlineSeccionCerrada(runTarea);
            AsyncUtils.exceptionally(cfCompensarOnlineSeccionCerrada, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/
            
            CompletableFuture<Void> cfUpdateActivoTrasladadasSeccion = runTareaProcesarVentaAsyncService.updateActivoTrasladadasSeccion(runTarea);
            AsyncUtils.exceptionally(cfUpdateActivoTrasladadasSeccion, cf, cfWait);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/
            
            CompletableFuture<Void> cfAgruparOnlineSeccionDia = runTareaProcesarVentaAsyncService.agruparOnlineSeccionDia(runTarea);
            AsyncUtils.exceptionally(cfAgruparOnlineSeccionDia, cf, cfWait);
            
            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cfWait);
            /*-------------------------------------------------------------*/
            
            CompletableFuture<Void> cfUpdateActivoTrasladadasTotalizado = runTareaProcesarVentaAsyncService.updateActivoTrasladadasTotalizado(runTarea);
            AsyncUtils.exceptionally(cfUpdateActivoTrasladadasTotalizado, cf, cfWait);
            
            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}
