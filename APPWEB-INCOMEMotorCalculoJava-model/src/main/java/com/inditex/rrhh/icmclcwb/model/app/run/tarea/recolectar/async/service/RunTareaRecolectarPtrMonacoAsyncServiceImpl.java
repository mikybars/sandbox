package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

/*
 * Copyright (c) 2022. Inditex
 */
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrMonacoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrMonacoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunTareaRecolectarPtrMonacoAsyncServiceImpl implements RunTareaRecolectarPtrMonacoAsyncService {

  @Autowired
  private RunTareaRecolectarPtrMonacoService runTareaRecolectarPtrMonacoService;

  @Override
  public CompletableFuture<Void> presenciaDetallePersonaIncluidoCommerceByRunTarea(final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoService.presenciaDetallePersonaIncluidoCommerceByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> presenciaDetalleComisionablePersonaByRunTarea(final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoService.presenciaDetalleComisionablePersonaByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ventaFisicaLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoService.ventaFisicaLocalizacionSeccionByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ventaOnlinePickingLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoService.ventaOnlinePickingLocalizacionSeccionByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ventaOnlineIpodLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoService.ventaOnlineIpodLocalizacionSeccionByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoService.ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ventaFisicaLocalizacionSeccionRepartoOnlineByRunTarea(final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoService.ventaFisicaLocalizacionSeccionRepartoOnlineByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
