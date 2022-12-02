package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;
/*
 * Copyright (c) 2022. Inditex
 */

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrMonacoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service.RunTareaRecolectarPtrMonacoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunTareaRecolectarPtrMonacoAsyncServiceImpl implements RunTareaRecolectarPtrMonacoAsyncService {

  @Autowired
  private RunTareaRecolectarPtrMonacoServiceImpl runTareaRecolectarPtrMonacoServiceImpl;

  @Override
  public CompletableFuture<Void> presenciaDetallePersonaIncluidoCommerceByRunTarea(final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoServiceImpl.presenciaDetallePersonaIncluidoCommerceByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> presenciaDetalleComisionablePersonaByRunTarea(final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoServiceImpl.presenciaDetalleComisionablePersonaByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ventaFisicaLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoServiceImpl.ventaFisicaLocalizacionSeccionByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ventaOnlinePickingLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoServiceImpl.ventaOnlinePickingLocalizacionSeccionByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ventaOnlineIpodLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoServiceImpl.ventaOnlineIpodLocalizacionSeccionByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoServiceImpl.ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ventaFisicaLocalizacionSeccionRepartoOnlineByRunTarea(final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoServiceImpl.ventaFisicaLocalizacionSeccionRepartoOnlineByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
