package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.validar.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaValidarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarLocalizacionPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.service.RunTareaRecolectarValidarTiendaPresenciaSeccionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunTareaRecolectarValidarTiendaPresenciaSeccionAsyncServiceImpl
    implements RunTareaRecolectarValidarLocalizacionPresenciaAsyncService {

  @Autowired
  private RunTareaRecolectarValidarTiendaPresenciaSeccionService runTareaRecolectarValidarTiendaPresenciaSeccionService;

  @Override
  public CompletableFuture<List<RunTareaValidarDto>> run(RunTareaDto runTarea) {
    return CompletableFuture.completedFuture(runTareaRecolectarValidarTiendaPresenciaSeccionService.run(runTarea));
  }

}
