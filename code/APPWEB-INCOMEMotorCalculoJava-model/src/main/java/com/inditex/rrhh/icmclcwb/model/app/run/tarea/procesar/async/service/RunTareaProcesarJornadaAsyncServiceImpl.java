package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service.RunTareaProcesarJornadaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarJornadaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunTareaProcesarJornadaAsyncServiceImpl implements RunTareaProcesarJornadaAsyncService {

  @Autowired
  private RunTareaProcesarJornadaService runTareaProcesarJornadaService;

  @Override
  public CompletableFuture<Void> procesarJornadaLocalizacionPersona(final RunTareaDto runTarea) {
    this.runTareaProcesarJornadaService.procesarJornadaLocalizacionPersona(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> procesarJornadaLocalizacion(final RunTareaDto runTarea) {
    this.runTareaProcesarJornadaService.procesarJornadaLocalizacion(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }
}
