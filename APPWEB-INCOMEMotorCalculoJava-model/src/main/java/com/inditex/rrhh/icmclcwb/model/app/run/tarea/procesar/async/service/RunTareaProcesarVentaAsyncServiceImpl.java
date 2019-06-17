package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service.RunTareaProcesarVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class RunTareaProcesarVentaAsyncServiceImpl implements RunTareaProcesarVentaAsyncService {

    @Autowired
    private RunTareaProcesarVentaService tareaProcesarVentaService;

    @Override
    public CompletableFuture<Void> ventaLocalizacionSeccion(RunTareaDto runTarea) {
        tareaProcesarVentaService.ventaLocalizacionSeccion(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> ventaLocalizacionTienda(RunTareaDto runTarea) {
        tareaProcesarVentaService.ventaLocalizacionTienda(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> saveAbierto(RunTareaDto runTarea) {
        tareaProcesarVentaService.saveAbierto(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> saveCerrado(RunTareaDto runTarea) {
        tareaProcesarVentaService.saveCerrado(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> ventaOnlineEntregaTiendaAgrupacionCadena(@Valid RunTareaDto runTarea) {
        tareaProcesarVentaService.ventaOnlineEntregaDomicilioAgrupacionCadena(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> ventaFisicaAgrupacionCadena(@Valid RunTareaDto runTarea) {
        tareaProcesarVentaService.ventaFisicaAgrupacionCadena(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> trasladar(RunTareaDto runTarea) {
        tareaProcesarVentaService.trasladar(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> compensar(RunTareaDto runTarea) {
        tareaProcesarVentaService.compensar(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> repartoVentaEntregaDomicilioAgrupaciones(RunTareaDto runTarea) {
        tareaProcesarVentaService.repartoVentaEntregaDomicilioAgrupaciones(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> repartoVentaEntregaDomicilioPorPresenciaAgrupaciones(RunTareaDto runTarea) {
        tareaProcesarVentaService.repartoVentaEntregaDomicilioPorPresenciaAgrupaciones(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> repartoVentaEntregaDomicilioCadenas(RunTareaDto runTarea) {
        tareaProcesarVentaService.repartoVentaEntregaDomicilioCadenas(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> repartoVentaEntregaDomicilioPorPresenciaCadenas(RunTareaDto runTarea) {
        tareaProcesarVentaService.repartoVentaEntregaDomicilioPorPresenciaCadenas(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> repartoVentaEntregaDomicilioSeccion(RunTareaDto runTarea) {
        tareaProcesarVentaService.repartoVentaEntregaDomicilioSeccion(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
