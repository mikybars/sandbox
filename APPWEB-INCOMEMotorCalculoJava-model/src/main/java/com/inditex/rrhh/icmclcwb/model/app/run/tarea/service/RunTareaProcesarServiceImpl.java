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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service.RunTareaProcesarVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaProcesarService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class RunTareaProcesarServiceImpl implements RunTareaProcesarService {

    @Autowired
    private RunTareaProcesarVentaAsyncService runTareaProcesarVentaAsyncService;

    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public void run(@NotNull @Valid RunTareaDto runTarea) {

        List<CompletableFuture<?>> cf = new ArrayList<>();

        // Reparto de ventas online entrega domicilio en tiendas de cadenas no agrupadas
        CompletableFuture<Void> cfRepartoCadenas = runTareaProcesarVentaAsyncService.repartoVentaEntregaDomicilioCadenas(runTarea);
        AsyncUtils.exceptionally(cfRepartoCadenas, cf);

        // Suma de ventas fisicas por agrupacion de cadena
        CompletableFuture<Void> cfVentaFisicaAgrupacion = runTareaProcesarVentaAsyncService.ventaFisicaAgrupacionCadena(runTarea);
        AsyncUtils.exceptionally(cfVentaFisicaAgrupacion, cf);

        //TODO: reparto de ventas por seccion, el código comentado a continuación probablemente cambie
        // Suma de ventas fisicas por agrupacion de cadena y seccion
        CompletableFuture<Void> cfVentaFisicaAgrupacionSeccion = runTareaProcesarVentaAsyncService.ventaFisicaAgrupacionCadenaSeccion(runTarea);
//        AsyncUtils.exceptionally(cfVentaFisicaAgrupacionSeccion, cf);

        // Suma de ventas online entrega domicilio por agrupacion de cadena
        CompletableFuture<Void> cfVentaEntregaDomicilioAgrupacion = runTareaProcesarVentaAsyncService.ventaOnlineEntregaTiendaAgrupacionCadena(runTarea);
        AsyncUtils.exceptionally(cfVentaEntregaDomicilioAgrupacion, cf);

        //TODO: reparto de ventas por seccion, el código comentado a continuación probablemente cambie
        // Suma de ventas online entrega domicilio por agrupacion de cadena y seccion
        CompletableFuture<Void> cfVentaEntregaDomicilioAgrupacionSeccion = runTareaProcesarVentaAsyncService.ventaOnlineEntregaTiendaAgrupacionCadenaSeccion(runTarea);
//        AsyncUtils.exceptionally(cfVentaEntregaDomicilioAgrupacionSeccion, cf);

        /*-------------------------------------------------------------*/
        AsyncUtils.waitAllOfIsOk(cf, cf);
        /*-------------------------------------------------------------*/

        // Reparto de ventas online entrega domicilio en tiendas de cadenas agrupadas
        CompletableFuture<Void> cfRepartoAgrupaciones = runTareaProcesarVentaAsyncService.repartoVentaEntregaDomicilioAgrupaciones(runTarea);
        AsyncUtils.exceptionally(cfRepartoAgrupaciones, cf);

        /*-------------------------------------------------------------*/
        AsyncUtils.waitAllOfIsOk(cf, cf);
        /*-------------------------------------------------------------*/


        // Suma de ventas totales por localizaciones
        CompletableFuture<Void> cfVentasLocalizacionTienda = runTareaProcesarVentaAsyncService.ventaLocalizacionTienda(runTarea);
        AsyncUtils.exceptionally(cfVentasLocalizacionTienda, cf);

        /*-------------------------------------------------------------*/
        AsyncUtils.waitAllOfIsOk(cf, cf);
        /*-------------------------------------------------------------*/

        // Suma de ventas por localizaciones y seccion
        CompletableFuture<Void> cfVentasLocalizacionSeccion = runTareaProcesarVentaAsyncService.ventaLocalizacionSeccion(runTarea);
        AsyncUtils.exceptionally(cfVentasLocalizacionSeccion, cf);

        /*-------------------------------------------------------------*/
        AsyncUtils.waitAllOfIsOk(cf, cf);
        /*-------------------------------------------------------------*/

        /* Días abiertos*/
        CompletableFuture<Void> cfSaveAbierto = runTareaProcesarVentaAsyncService.saveAbierto(runTarea);
        AsyncUtils.exceptionally(cfSaveAbierto, cf);

        /* Días festivos*/
        CompletableFuture<Void> cfSaveCerrado = runTareaProcesarVentaAsyncService.saveCerrado(runTarea);
        AsyncUtils.exceptionally(cfSaveCerrado, cf);

        /*-------------------------------------------------------------*/
        AsyncUtils.waitAllOfIsOk(cf, cf);
        /*-------------------------------------------------------------*/

        CompletableFuture<Void> cfTrasladar = runTareaProcesarVentaAsyncService.trasladar(runTarea);
        AsyncUtils.exceptionally(cfTrasladar, cf);

        CompletableFuture<Void> cfCompensar = runTareaProcesarVentaAsyncService.compensar(runTarea);
        AsyncUtils.exceptionally(cfCompensar, cf);
    }

}
