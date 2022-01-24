package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.validar.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaValidarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.service.RunTareaRecolectarValidarLocalizacionPersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunTareaRecolectarValidarLocalizacionPersonaPresenciaAsyncServiceImpl
    implements RunTareaRecolectarValidarLocalizacionPersonaPresenciaAsyncService {

  @Autowired
  private RunTareaRecolectarValidarLocalizacionPersonaService runTareaRecolectarValidarLocalizacionPersonaPresenciaService;

  @Override
  public CompletableFuture<List<RunTareaValidarDto>> run(RunTareaDto runTarea) {
    return CompletableFuture
        .completedFuture(runTareaRecolectarValidarLocalizacionPersonaPresenciaService.run(runTarea));
  }

}
