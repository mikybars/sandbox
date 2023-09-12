package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaAmbitoGlobalLocalizacionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaAmbitoGlobalLocalizacionAsyncServiceImpl implements TareaAmbitoGlobalLocalizacionAsyncService {

  @Autowired
  private TareaAmbitoGlobalLocalizacionService tareaAmbitoGlobalLocalizacionService;

  @Override
  public CompletableFuture<Void> mergeLocalizacion(final RunTareaDto runTareaDto) {
    tareaAmbitoGlobalLocalizacionService.mergeLocalizacion(runTareaDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
