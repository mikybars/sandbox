package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.validar.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaValidarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarLocalizacionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.service.RunTareaRecolectarValidarLocalizacionHistoricoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunTareaRecolectarValidarLocalizacionHistoricoAsyncServiceImpl
    implements RunTareaRecolectarValidarLocalizacionHistoricoAsyncService {

  @Autowired
  private RunTareaRecolectarValidarLocalizacionHistoricoService runTareaRecolectarValidarLocalizacionHistoricoService;

  @Override
  public CompletableFuture<List<RunTareaValidarDto>> run(RunTareaDto runTarea) {
    return CompletableFuture.completedFuture(runTareaRecolectarValidarLocalizacionHistoricoService.run(runTarea));
  }

}
