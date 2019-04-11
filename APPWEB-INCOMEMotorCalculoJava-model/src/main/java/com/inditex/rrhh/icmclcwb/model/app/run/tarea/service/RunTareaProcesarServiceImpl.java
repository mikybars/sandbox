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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaProcesarVentaLocalizacionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaProcesarService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class RunTareaProcesarServiceImpl implements RunTareaProcesarService {
    
    @Autowired
    private RunTareaProcesarVentaLocalizacionAsyncService runTareaProcesarVentaLocalizacionAsyncService; 

    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public RunTareaDto run(@NotNull @Valid RunTareaDto runTarea) {
        
        List<CompletableFuture<?>> cf = new ArrayList<>();
        
        // Suma de ventas totales por localizaciones 
        CompletableFuture<Void> cfVentasLocalizacionTienda = runTareaProcesarVentaLocalizacionAsyncService.ventaLocalizacionTienda(runTarea);
        AsyncUtils.exceptionally(cfVentasLocalizacionTienda, cf);
        
        /*-------------------------------------------------------------*/
        AsyncUtils.waitAllOfIsOk(cf, cf);
        /*-------------------------------------------------------------*/
        
        // Suma de ventas por localizaciones y seccion
        CompletableFuture<Void> cfVentasLocalizacionSeccion = runTareaProcesarVentaLocalizacionAsyncService.ventaLocalizacionSeccion(runTarea);
        AsyncUtils.exceptionally(cfVentasLocalizacionSeccion, cf);
        
        /*-------------------------------------------------------------*/
        AsyncUtils.waitAllOfIsOk(cf, cf);
        /*-------------------------------------------------------------*/
        
        /* Días abiertos*/
        CompletableFuture<Void> cfSaveAbierto = runTareaProcesarVentaLocalizacionAsyncService.saveAbierto(runTarea);
        AsyncUtils.exceptionally(cfSaveAbierto, cf);
        
        /* Días festivos*/
        CompletableFuture<Void> cfSaveCerrado = runTareaProcesarVentaLocalizacionAsyncService.saveCerrado(runTarea);
        AsyncUtils.exceptionally(cfSaveCerrado, cf);
        
        /*-------------------------------------------------------------*/
        AsyncUtils.waitAllOfIsOk(cf, cf);
        /*-------------------------------------------------------------*/
        
        return runTarea;
    }

}
