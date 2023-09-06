package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaAmbitoGlobalPersonaAsyncServiceImpl implements TareaAmbitoGlobalPersonaAsyncService {

  @Autowired
  private TareaAmbitoGlobalPersonaService tareaAmbitoGlobalPersonaService;

  @Override
  public CompletableFuture<Void> mergePersona(final RunTareaDto runTareaDto) {
    tareaAmbitoGlobalPersonaService.mergePersona(runTareaDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
