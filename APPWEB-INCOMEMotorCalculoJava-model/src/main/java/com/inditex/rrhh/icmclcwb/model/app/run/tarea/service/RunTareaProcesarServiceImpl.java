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
            
            CompletableFuture<Void> cfUpdateSeccionPresenciasActivasTotalizado = runTareaProcesarPresenciaAsyncService
                    .updateActivoLocalizacionPersonaPresenciaTotalizado(runTarea);
            AsyncUtils.exceptionally(cfUpdateSeccionPresenciasActivasTotalizado, cf);

            // Actualizar flags de presencias totales activas
            CompletableFuture<Void> cfUpdatePresenciasActivas = runTareaProcesarPresenciaAsyncService
                    .updateActivoLocalizacion(runTarea);
            AsyncUtils.exceptionally(cfUpdatePresenciasActivas, cf);
            
            //Actualizar flags de presencias totales activas por seccion totalizada
            CompletableFuture<Void> cfUpdatePresenciasActivasTotalizado = runTareaProcesarPresenciaAsyncService
                    .updateActivoLocalizacionTotalizado(runTarea);
            AsyncUtils.exceptionally(cfUpdatePresenciasActivasTotalizado, cf);

            // Compensar presencia total localizacion persona con las manuales
            CompletableFuture<Void> cfCompensarPresenciaPersonaLocalizacion = runTareaProcesarPresenciaAsyncService
                    .compensarLocalizacionPersonaPresencia(runTarea);
            AsyncUtils.exceptionally(cfCompensarPresenciaPersonaLocalizacion, cf);

            // Compensar presencia total localizacion con las manuales
            CompletableFuture<Void> cfCompensarPresenciaLocalizacion = runTareaProcesarPresenciaAsyncService
                    .compensarLocalizacion(runTarea);
            AsyncUtils.exceptionally(cfCompensarPresenciaLocalizacion, cf);

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

            // Suma de ventas totales por localizaciones
            CompletableFuture<Void> cfVentasLocalizacionTienda = runTareaProcesarVentaAsyncService
                    .ventaLocalizacionTienda(runTarea);
            AsyncUtils.exceptionally(cfVentasLocalizacionTienda, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

            // Suma de ventas por localizaciones y seccion
            CompletableFuture<Void> cfVentasLocalizacionSeccion = runTareaProcesarVentaAsyncService
                    .ventaLocalizacionSeccion(runTarea);
            AsyncUtils.exceptionally(cfVentasLocalizacionSeccion, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

            /* Días abiertos */
            CompletableFuture<Void> cfSaveAbierto = runTareaProcesarVentaAsyncService.saveAbierto(runTarea);
            AsyncUtils.exceptionally(cfSaveAbierto, cf);

            /* Días festivos */
            CompletableFuture<Void> cfSaveCerrado = runTareaProcesarVentaAsyncService.saveCerrado(runTarea);
            AsyncUtils.exceptionally(cfSaveCerrado, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/

            CompletableFuture<Void> cfTrasladar = runTareaProcesarVentaAsyncService.trasladar(runTarea);
            AsyncUtils.exceptionally(cfTrasladar, cf);

            CompletableFuture<Void> cfCompensar = runTareaProcesarVentaAsyncService.compensar(runTarea);
            AsyncUtils.exceptionally(cfCompensar, cf);

            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/
        } catch (Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
    }

}
