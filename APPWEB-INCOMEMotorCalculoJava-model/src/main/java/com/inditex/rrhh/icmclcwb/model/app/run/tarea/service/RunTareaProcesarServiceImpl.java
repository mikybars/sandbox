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
    public RunTareaDto run(@NotNull @Valid RunTareaDto runTarea) {
        
        List<CompletableFuture<?>> cf = new ArrayList<>();
        
        // Suma de ventas por agrupacion de cadena
        CompletableFuture<Void> cfVentaFisicaAgrupacion = runTareaProcesarVentaAsyncService.ventaFisicaAgrupacionCadena(runTarea);
        AsyncUtils.exceptionally(cfVentaFisicaAgrupacion, cf);
        
        CompletableFuture<Void> cfVentaOnlineEntregaTiendaAgrupacion = runTareaProcesarVentaAsyncService.ventaOnlineEntregaTiendaAgrupacionCadena(runTarea);
        AsyncUtils.exceptionally(cfVentaOnlineEntregaTiendaAgrupacion, cf);
        
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
        
        return runTarea;
    }

}
