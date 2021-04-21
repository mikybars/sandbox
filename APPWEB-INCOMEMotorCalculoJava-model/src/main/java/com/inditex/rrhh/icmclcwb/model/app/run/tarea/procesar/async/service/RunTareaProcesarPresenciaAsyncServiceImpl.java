package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service.RunTareaProcesarPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class RunTareaProcesarPresenciaAsyncServiceImpl implements RunTareaProcesarPresenciaAsyncService {

    @Autowired
    private RunTareaProcesarPresenciaService runTareaProcesarPresenciaService;

    @Override
    public CompletableFuture<Void> compensarLocalizacion(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.compensarLocalizacion(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> compensarLocalizacionEcommerce(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.compensarLocalizacionEcommerce(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> totalizarLocalizacion(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.totalizarLocalizacion(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> totalizarEcommerceLocalizacion(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.totalizarEcommerceLocalizacion(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> totalizarEmpleadosPorVenta(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.totalizarEmpleadosPorVenta(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> updateActivoLocalizacionPersonaPresencia(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.updateActivoLocalizacionPersonaPresencia(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> updateActivoLocalizacionPersonaPresenciaVacio(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.updateActivoLocalizacionPersonaPresenciaVacio(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> compensarLocalizacionPersonaPresencia(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.compensarLocalizacionPersonaPresencia(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> compensarChallenge(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.compensarChallenge(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> presenciasIncluidoVentaPersona(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.presenciasIncluidoVentaPersona(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> updateActivoLocalizacionVacio(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.updateActivoLocalizacionVacio(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> calcularPresenciasTotalesAgrupacion(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.calcularPresenciasTotalesAgrupacion(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> indicadorPresencia(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.indicadorPresencia(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> indicadorPresenciaDesplazamiento(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.indicadorPresenciaDesplazamiento(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> indicadorPresenciaDesplazamientoBase(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.indicadorPresenciaDesplazamientoBase(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(
            final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService
            .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> presenciasHorasFijas(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.presenciasHorasFijas(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> presenciasHorasFijasDesplazamientos(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.presenciasHorasFijasDesplazamientos(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> indicadorPersonaPorVenta(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.indicadorPersonaPorVenta(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> indicadorPersonaPorVentaSimplificada(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.indicadorPersonaPorVentaSimplificada(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> indicadorDesplazamientoBaseDirectoVenta(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.indicadorDesplazamientoBaseDirectoVenta(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> indicadorDesplazamientoBaseDirectoVentaFicticias(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.indicadorDesplazamientoBaseDirectoVentaFicticias(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> indicadorDesplazamientoDirectoVenta(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.indicadorDesplazamientoDirectoVenta(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> indicadorDesplazamientoDirectoVentaFicticias(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.indicadorDesplazamientoDirectoVentaFicticias(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> compensarLocalizacionManual(final RunTareaDto runTarea) {
        this.runTareaProcesarPresenciaService.compensarLocalizacionManual(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
