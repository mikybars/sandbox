package com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import org.springframework.scheduling.annotation.Async;

@Async
public interface RunTareaConsolidarPeriodoAsyncService {

  CompletableFuture<Void> mergePeriodoPersona(RunTareaDto runTarea);

  CompletableFuture<Void> mergePeriodoCalculoPersona(RunTareaDto runTarea);

  CompletableFuture<Void> mergePeriodoLocalizacion(RunTareaDto runTarea);

  CompletableFuture<Void> mergePeriodoLocalizacionPersona(RunTareaDto runTarea);

  CompletableFuture<Void> limpiezaPeriodoCalculoPersona(RunTareaDto runTarea, TareaAmbitoDto tareaAmbitoDto);

  CompletableFuture<Void> limpiezaPeriodoLocalizacionPersona(RunTareaDto runTarea, TareaAmbitoDto tareaAmbitoDto);

  CompletableFuture<Void> limpiezaPeriodoLocalizacion(RunTareaDto runTarea, TareaAmbitoDto tareaAmbitoDto);

  CompletableFuture<Void> limpiezaPeriodoPersona(RunTareaDto runTarea, TareaAmbitoDto tareaAmbitoDto);

}
