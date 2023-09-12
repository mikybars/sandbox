package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalLocalizacionPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaAmbitoGlobalLocalizacionPersonaAsyncServiceImpl
    implements TareaAmbitoGlobalLocalizacionPersonaAsyncService {

  @Autowired
  private TareaAmbitoGlobalLocalizacionPersonaService tareaLocalizacionPersonaService;

  @Override
  public CompletableFuture<Void> mergePersonaLocalizacion(final RunTareaDto tarea) {
    tareaLocalizacionPersonaService.mergePersonaLocalizacion(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
