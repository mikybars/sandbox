package com.inditex.rrhh.icmclcwb.model.app.run.tarea.consolidar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.async.service.RunTareaConsolidarPeriodoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.service.RunTareaConsolidarPeriodoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunTareaConsolidarPeriodoAsyncServiceImpl implements RunTareaConsolidarPeriodoAsyncService {

  @Autowired
  private RunTareaConsolidarPeriodoService runTareaConsolidarPeriodoService;

  @Override
  public CompletableFuture<Void> mergePeriodoPersona(final RunTareaDto runTarea) {
    this.runTareaConsolidarPeriodoService.mergePeriodoPersona(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> limpiezaPeriodoPersona(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbitoDto) {
    this.runTareaConsolidarPeriodoService.limpiezaPeriodoPersona(runTarea, tareaAmbitoDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> mergePeriodoCalculoPersona(final RunTareaDto runTarea) {
    this.runTareaConsolidarPeriodoService.mergePeriodoCalculoPersona(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> limpiezaPeriodoCalculoPersona(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbitoDto) {
    this.runTareaConsolidarPeriodoService.limpiezaPeriodoCalculoPersona(runTarea, tareaAmbitoDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> mergePeriodoLocalizacion(final RunTareaDto runTarea) {
    this.runTareaConsolidarPeriodoService.mergePeriodoLocalizacion(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> limpiezaPeriodoLocalizacion(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbitoDto) {
    this.runTareaConsolidarPeriodoService.limpiezaPeriodoLocalizacion(runTarea, tareaAmbitoDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> mergePeriodoLocalizacionPersona(final RunTareaDto runTarea) {
    this.runTareaConsolidarPeriodoService.mergePeriodoLocalizacionPersona(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> limpiezaPeriodoLocalizacionPersona(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbitoDto) {
    this.runTareaConsolidarPeriodoService.limpiezaPeriodoLocalizacionPersona(runTarea, tareaAmbitoDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
