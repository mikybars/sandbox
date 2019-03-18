package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

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
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaEcommerceAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaEmpleadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaGeneralAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarCondicionesService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

@Service
@Validated
public class RunTareaRecolectarCondicionesServiceImpl implements RunTareaRecolectarCondicionesService {

    @Autowired
    private RunTareaRecolectarPtrVentaGeneralAsyncService runTareaRecolectarPtrVentaGeneralAsyncService;
    
    @Autowired
    private RunTareaRecolectarPtrVentaEcommerceAsyncService runTareaRecolectarPtrVentaEcommerceAsyncService;
    
    @Autowired
    private RunTareaRecolectarPtrVentaEmpleadoAsyncService runTareaRecolectarPtrVentaEmpleadoAsyncService;

    @Autowired
    private RunTareaRecolectarPtrPresenciaAsyncService runTareaRecolectarPtrPresenciaAsyncService;
    
    @Auditoria
    @CounterMetric
    @TimerMetric
    @Override
    public RunTareaDto run(@NotNull @Valid final RunTareaDto runTarea) {
        List<CompletableFuture<?>> cf = new ArrayList<>();
        List<CompletableFuture<?>> cfWait = new ArrayList<>();
        try {
            // TODO Se detectan que datos son necesarios recuperar
            
            //Localizacion y seccion
            
            CompletableFuture<Void> cfVentaFisicaLocalizacionSeccion = runTareaRecolectarPtrVentaGeneralAsyncService.ventaFisicaLocalizacionSeccionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfVentaFisicaLocalizacionSeccion, cf, cfWait);
            
            CompletableFuture<Void> cfOnlineIpodLocalizacionSeccion = runTareaRecolectarPtrVentaEcommerceAsyncService.ventaOnlineIpodLocalizacionSeccionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfOnlineIpodLocalizacionSeccion, cf, cfWait);
            
            CompletableFuture<Void> cfOnlinePickingLocalizacionSeccion = runTareaRecolectarPtrVentaEcommerceAsyncService.ventaOnlinePickingLocalizacionSeccionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfOnlinePickingLocalizacionSeccion, cf, cfWait);
            
            CompletableFuture<Void> cfOnlineEntregaTiendaLocalizacionSeccion = runTareaRecolectarPtrVentaEcommerceAsyncService.ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfOnlineEntregaTiendaLocalizacionSeccion, cf, cfWait);

            CompletableFuture<Void> cfOnlineEntregaDomicilioLocalizacionSeccion = runTareaRecolectarPtrVentaEcommerceAsyncService.ventaOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfOnlineEntregaDomicilioLocalizacionSeccion, cf, cfWait);
            
            CompletableFuture<Void> cfPresenciasTotalLocalizacionSeccion = runTareaRecolectarPtrPresenciaAsyncService.presenciaTotalLocalizacionSeccionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfPresenciasTotalLocalizacionSeccion, cf, cfWait);
            
            //Localizacion 
            
            CompletableFuture<Void> cfVentaFisicaLocalizacion = runTareaRecolectarPtrVentaGeneralAsyncService.ventaFisicaLocalizacionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfVentaFisicaLocalizacion, cf, cfWait);
            
            CompletableFuture<Void> cfOnlineIpodLocalizacion = runTareaRecolectarPtrVentaEcommerceAsyncService.ventaOnlineIpodLocalizacionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfOnlineIpodLocalizacion, cf, cfWait);
            
            CompletableFuture<Void> cfOnlinePickingLocalizacion = runTareaRecolectarPtrVentaEcommerceAsyncService.ventaOnlinePickingLocalizacionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfOnlinePickingLocalizacion, cf, cfWait);
            
            CompletableFuture<Void> cfOnlineEntregaTiendaLocalizacion = runTareaRecolectarPtrVentaEcommerceAsyncService.ventaOnlineEntregaTiendaLocalizacionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfOnlineEntregaTiendaLocalizacion, cf, cfWait);
            
            CompletableFuture<Void> cfOnlineEntregaDomicilioLocalizacion = runTareaRecolectarPtrVentaEcommerceAsyncService.ventaOnlineEntregaDomicilioLocalizacionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfOnlineEntregaDomicilioLocalizacion, cf, cfWait);
            
            CompletableFuture<Void> cfFisicaPersonaLocalizacion = runTareaRecolectarPtrVentaEmpleadoAsyncService.ventaFisicaPersonaLocalizacionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfFisicaPersonaLocalizacion, cf, cfWait);
            
            
            //Operacion localizacion 
            
            CompletableFuture<Void> cfFisicaPersonaOperacionLocalizacion = runTareaRecolectarPtrVentaEmpleadoAsyncService.ventaFisicaPersonaOperacionLocalizacionByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfFisicaPersonaOperacionLocalizacion, cf, cfWait);
            
            //Persona
            
            CompletableFuture<Void> cfPresenciasDetalleComisionablePersona = runTareaRecolectarPtrPresenciaAsyncService.presenciaDetalleComisionablePersonaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfPresenciasDetalleComisionablePersona, cf, cfWait);
            
            //Localizacion Persona
            CompletableFuture<Void> cfOnlineIpodPersona= runTareaRecolectarPtrVentaEcommerceAsyncService.ventaOnlineIpodPersonaByRunTarea(runTarea);
            AsyncUtils.exceptionally(cfOnlineIpodPersona, cf, cfWait);
            
            
            /*-------------------------------------------------------------*/
            AsyncUtils.waitAllOfIsOk(cf, cf);
            /*-------------------------------------------------------------*/
        } catch (IcmclcwbException e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
        return runTarea;
    }
}
