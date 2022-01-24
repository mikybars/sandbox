package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPersonaDto;

import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaCalculoPersonaAsyncService {

  CompletableFuture<Void> mergePersonaCalculoByAmbito(RunTareaDto runTareaDto);

  CompletableFuture<Void> updateWithEstado(RunTareaDto runTareaDto, EstadoTareaPersonaDto estadoActual,
      EstadoTareaPersonaDto estadoNuevo);

  CompletableFuture<Void> mergePersonaCalculoByAmbitoPersona(RunTareaDto runTareaDto);

  CompletableFuture<Void> mergePersonaCalculoByAmbitoLocalizacion(RunTareaDto runTareaDto);

}
