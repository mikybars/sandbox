package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service.RunTareaProcesarCondicionesAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarCondicionesService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarVentaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunTareaProcesarCondicionesAsyncServiceImpl implements RunTareaProcesarCondicionesAsyncService {

  @Autowired
  private RunTareaProcesarVentaService tareaProcesarVentaService;

  @Autowired
  private RunTareaProcesarCondicionesService tareaProcesarCondicionesService;

  @Override
  public CompletableFuture<Void> updateImporteEstructuraPoliticas(final RunTareaDto runTarea) {
    this.tareaProcesarVentaService.updateImporteEstructuraPoliticas(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> updateActivoPresupuestosBandaExcepcion(final RunTareaDto runTarea) {
    this.tareaProcesarCondicionesService.updateActivoPresupuestosBandaExcepcion(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> updateActivoPresupuestosBandasSinExcepcion(final RunTareaDto runTarea) {
    this.tareaProcesarCondicionesService.updateActivoPresupuestosBandasSinExcepcion(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> updateActivoEstructurasTopes(final TareaDto tarea) {
    this.tareaProcesarCondicionesService.updateActivoEstructuraTopes(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> relacionarPresupuestosEstructurasSinDesplazamiento(final TareaDto tarea) {
    this.tareaProcesarCondicionesService.relacionarPresupuestosEstructurasSinDesplazamiento(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> relacionarPresupuestosEstructurasDesplazamiento(final TareaDto tarea) {
    this.tareaProcesarCondicionesService.relacionarPresupuestosEstructurasDesplazamiento(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> desactivarChallengeOpcionOrigen(final RunTareaDto runTarea) {
    this.tareaProcesarCondicionesService.desactivarChallengeOpcionOrigen(runTarea.getTarea());
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> desactivarManualOrdinalDoble(final RunTareaDto runTarea) {
    this.tareaProcesarCondicionesService.desactivarManualOrdinalDoble(runTarea.getTarea());
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> crearChallengeOpcionOrigen(final RunTareaDto runTarea) {
    this.tareaProcesarCondicionesService.crearChallengeOpcionOrigen(runTarea.getTarea());
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> igualarBandasOrigenDestino(final RunTareaDto runTarea) {
    this.tareaProcesarCondicionesService.igualarBandasOrigenDestino(runTarea.getTarea());
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> establecerBandaOpcionOrigen(final RunTareaDto runTarea) {
    this.tareaProcesarCondicionesService.establecerBandaOpcionOrigen(runTarea.getTarea());
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> desactivarGlobalSeccionOpcionOrigen(final RunTareaDto runTarea) {
    this.tareaProcesarCondicionesService.desactivarGlobalSeccionOpcionOrigen(runTarea.getTarea());
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> crearGlobalSeccionOpcionOrigen(final RunTareaDto runTarea) {
    this.tareaProcesarCondicionesService.crearGlobalSeccionOpcionOrigen(runTarea.getTarea());
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }
}
