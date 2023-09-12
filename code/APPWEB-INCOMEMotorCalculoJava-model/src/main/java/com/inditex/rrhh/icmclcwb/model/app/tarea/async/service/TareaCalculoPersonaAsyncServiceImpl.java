package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaCalculoPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaCalculoPersonaAsyncServiceImpl implements TareaCalculoPersonaAsyncService {

  @Autowired
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Override
  public CompletableFuture<Void> mergePersonaCalculoByAmbito(final RunTareaDto runTareaDto) {
    tareaCalculoPersonaService.mergePersonaCalculoByAmbito(runTareaDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> mergePersonaCalculoByAmbitoLocalizacion(final RunTareaDto runTareaDto) {
    tareaCalculoPersonaService.mergePersonaCalculoByAmbitoLocalizacion(runTareaDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> mergePersonaCalculoByAmbitoPersona(final RunTareaDto runTareaDto) {
    tareaCalculoPersonaService.mergePersonaCalculoByAmbitoPersona(runTareaDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> updateWithEstado(final RunTareaDto runTareaDto, EstadoTareaPersonaDto estadoActual,
      EstadoTareaPersonaDto estadoNuevo) {
    tareaCalculoPersonaService.updateWithEstado(runTareaDto, estadoActual, estadoNuevo);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
