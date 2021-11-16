package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaGeneralAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrVentaGeneralService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunTareaRecolectarPtrVentaGeneralAsyncServiceImpl
    implements RunTareaRecolectarPtrVentaGeneralAsyncService {

  @Autowired
  private RunTareaRecolectarPtrVentaGeneralService tareaRecolectarPtrVentaService;

  @Override
  public CompletableFuture<Void> ventaFisicaLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarPtrVentaService.ventaFisicaLocalizacionSeccionByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ventaFisicaCadenaByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarPtrVentaService.ventaFisicaCadenaByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ventaRangoFisicaLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarPtrVentaService.ventaRangoFisicaLocalizacionSeccionByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> devolucionRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(
      final RunTareaDto runTarea) {
    this.tareaRecolectarPtrVentaService.devolucionRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> devolucionVentaOriginalOtraTiendaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(
      final RunTareaDto runTarea) {
    this.tareaRecolectarPtrVentaService
        .devolucionVentaOriginalOtraTiendaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ventaFisicaLocalizacionSeccionRepartoOnlineByRunTarea(
      final RunTareaDto runTarea) {
    this.tareaRecolectarPtrVentaService
        .ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaAndTareaAmbito(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
