package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.CounterMetric;
import com.inditex.aqsw.libmonitoringcenter.metrics.aop.annotations.TimerMetric;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
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

    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public void run(@NotNull @Valid RunTareaDto runTarea) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            // Actualizar flags de presencias activas
            CompletableFuture<Void> cfUpdateSeccionPresenciasActivas = runTareaProcesarPresenciaAsyncService
                    .updateActivoLocalizacionPersonaPresencia(runTarea);
            AsyncUtils.exceptionally(cfUpdateSeccionPresenciasActivas, cf);

            // Compensar presencia total localizacion persona con las manuales
            CompletableFuture<Void> cfCompensarPresenciaPersonaLocalizacion = runTareaProcesarPresenciaAsyncService
                    .compensarLocalizacionPersonaPresencia(runTarea);
            AsyncUtils.exceptionally(cfCompensarPresenciaPersonaLocalizacion, cf);
            
            // Compensar presencia total localizacion con las manuales
            CompletableFuture<Void> cfCompensarPresenciaLocalizacion = runTareaProcesarPresenciaAsyncService
                    .compensarLocalizacion(runTarea);
            AsyncUtils.exceptionally(cfCompensarPresenciaLocalizacion, cf);

            CompletableFuture<Void> cfTotalizarPresenciaLocalizacion = runTareaProcesarPresenciaAsyncService
                    .totalizarLocalizacion(runTarea);
            AsyncUtils.exceptionally(cfTotalizarPresenciaLocalizacion, cf);
            
            CompletableFuture<Void> cfTotalizarPresenciaEcommerceLocalizacion = runTareaProcesarPresenciaAsyncService
                    .totalizarEcommerceLocalizacion(runTarea);
            AsyncUtils.exceptionally(cfTotalizarPresenciaEcommerceLocalizacion, cf);
            
            // Compensar presencia total localizacion con las manuales para incluido ecommerce
            CompletableFuture<Void> cfCompensarPresenciaLocalizacionEcommerce = runTareaProcesarPresenciaAsyncService
                .compensarLocalizacionEcommerce(runTarea);
            AsyncUtils.exceptionally(cfCompensarPresenciaLocalizacionEcommerce, cf);
            
            // Indicadores de presencia
            CompletableFuture<Void> cfIndicadorPresencia = runTareaProcesarPresenciaAsyncService
                    .indicadorPresencia(runTarea);
            AsyncUtils.exceptionally(cfIndicadorPresencia, cf);
            
            // Indicadores de presencia con desplazamiento
            CompletableFuture<Void> cfIndicadorPresenciaDesplazamiento = runTareaProcesarPresenciaAsyncService
                    .indicadorPresenciaDesplazamiento(runTarea);
            AsyncUtils.exceptionally(cfIndicadorPresenciaDesplazamiento, cf);
            
            // Indicadores de presencia con desplazamiento base
            CompletableFuture<Void> cfIndicadorPresenciaDesplazamientoBase = runTareaProcesarPresenciaAsyncService
                    .indicadorPresenciaDesplazamientoBase(runTarea);
            AsyncUtils.exceptionally(cfIndicadorPresenciaDesplazamientoBase, cf);
            
            // Indicadores de presencia con desplazamiento base sobre desplazamiento misma localizacion
            CompletableFuture<Void> cfIndicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion = runTareaProcesarPresenciaAsyncService
                    .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(runTarea);
            AsyncUtils.exceptionally(cfIndicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

            //Actualizar flags de presencias totales con minutos a cero
            CompletableFuture<Void> cfUpdatePresenciasActivasVacio = runTareaProcesarPresenciaAsyncService
                    .updateActivoLocalizacionVacio(runTarea);
            AsyncUtils.exceptionally(cfUpdatePresenciasActivasVacio, cf);
            
            //Actualizar flags de presencias localizacion persona con minutos a cero
            CompletableFuture<Void> cfUpdateSeccionPresenciasActivasVacio = runTareaProcesarPresenciaAsyncService
                    .updateActivoLocalizacionPersonaPresenciaVacio(runTarea);
            AsyncUtils.exceptionally(cfUpdateSeccionPresenciasActivasVacio, cf);
            
            // Presencias totales de agrupaciones
            CompletableFuture<Void> cfCalcularPresenciasTotalesAgrupacion = runTareaProcesarPresenciaAsyncService
                .calcularPresenciasTotalesAgrupacion(runTarea);
            AsyncUtils.exceptionally(cfCalcularPresenciasTotalesAgrupacion, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

            // Reparto de ventas online entrega domicilio en tiendas de cadenas agrupadas -
            // por ventas
            CompletableFuture<Void> cfRepartoAgrupaciones = runTareaProcesarVentaAsyncService
                    .repartoVentaEntregaDomicilioAgrupaciones(runTarea);
            AsyncUtils.exceptionally(cfRepartoAgrupaciones, cf);

            // Reparto de ventas online entrega domicilio en tiendas de cadenas agrupadas -
            // por presencia
            CompletableFuture<Void> cfRepartoPresenciaAgrupaciones = runTareaProcesarVentaAsyncService
                    .repartoVentaEntregaDomicilioPorPresenciaAgrupaciones(runTarea);
            AsyncUtils.exceptionally(cfRepartoPresenciaAgrupaciones, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

            // Reparto de ventas online entrega domicilio por sección
            CompletableFuture<Void> cfRepartoVentaOnlineEntregaDomicilioSeccion = runTareaProcesarVentaAsyncService
                .repartoVentaEntregaDomicilioSeccion(runTarea);
            AsyncUtils.exceptionally(cfRepartoVentaOnlineEntregaDomicilioSeccion, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

            // Calcular localizacion abierta
            CompletableFuture<Void> cfSaveAbierto = runTareaProcesarVentaAsyncService.saveAbierto(runTarea);
            AsyncUtils.exceptionally(cfSaveAbierto, cf);
            
            // Calcular localizacion seccion abierta
            CompletableFuture<Void> cfSaveAbiertoSeccion = runTareaProcesarVentaAsyncService.saveAbiertoSeccion(runTarea);
            AsyncUtils.exceptionally(cfSaveAbiertoSeccion, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

            // Calcular localizacion cerrada
            CompletableFuture<Void> cfSaveCerrado = runTareaProcesarVentaAsyncService.saveCerrado(runTarea);
            AsyncUtils.exceptionally(cfSaveCerrado, cf);
            
            // Calcular localizacion seccion cerrada
            CompletableFuture<Void> cfSaveCerradoSeccion = runTareaProcesarVentaAsyncService.saveCerradoSeccion(runTarea);
            AsyncUtils.exceptionally(cfSaveCerradoSeccion, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/
            
            // TODO [JESTEVEZ] Comentar las llamadas a trasladar, compensar y updateActivoTrasladadas (las tres siguientes) si provocan problemas
            CompletableFuture<Void> cfTrasladar = runTareaProcesarVentaAsyncService.trasladar(runTarea);
            AsyncUtils.exceptionally(cfTrasladar, cf);

            CompletableFuture<Void> cfCompensar = runTareaProcesarVentaAsyncService.compensar(runTarea);
            AsyncUtils.exceptionally(cfCompensar, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/
            
            CompletableFuture<Void> cfCompensarOnlineSeccionCerrada = runTareaProcesarVentaAsyncService.compensarOnlineSeccionCerrada(runTarea);
            AsyncUtils.exceptionally(cfCompensarOnlineSeccionCerrada, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/
            
            CompletableFuture<Void> cfUpdateActivoTrasladadasSeccion = runTareaProcesarVentaAsyncService.updateActivoTrasladadasSeccion(runTarea);
            AsyncUtils.exceptionally(cfUpdateActivoTrasladadasSeccion, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/
            
            CompletableFuture<Void> cfAgruparOnlineSeccionDia = runTareaProcesarVentaAsyncService.agruparOnlineSeccionDia(runTarea);
            AsyncUtils.exceptionally(cfAgruparOnlineSeccionDia, cf);
            
            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/
            
            CompletableFuture<Void> cfUpdateActivoTrasladadasTotalizado = runTareaProcesarVentaAsyncService.updateActivoTrasladadasTotalizado(runTarea);
            AsyncUtils.exceptionally(cfUpdateActivoTrasladadasTotalizado, cf);
            
            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}
