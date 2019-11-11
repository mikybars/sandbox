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

            /* Días abiertos */
            CompletableFuture<Void> cfSaveAbierto = runTareaProcesarVentaAsyncService.saveAbierto(runTarea);
            AsyncUtils.exceptionally(cfSaveAbierto, cf);
            
            CompletableFuture<Void> cfSaveAbiertoSeccion = runTareaProcesarVentaAsyncService.saveAbiertoSeccion(runTarea);
            AsyncUtils.exceptionally(cfSaveAbiertoSeccion, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

            /* Días festivos */
            CompletableFuture<Void> cfSaveCerrado = runTareaProcesarVentaAsyncService.saveCerrado(runTarea);
            AsyncUtils.exceptionally(cfSaveCerrado, cf);
            
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

            // Desactivar las ventas originales para días en los que se hayan trasladado ventas de festivos
            CompletableFuture<Void> cfUpdateActivo = runTareaProcesarVentaAsyncService.updateActivoTrasladadas(runTarea);
            AsyncUtils.exceptionally(cfUpdateActivo, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}
