package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.validar.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaValidarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarTiposHoraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.service.RunTareaRecolectarValidarTiposHoraService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RunTareaRecolectarValidarTiposHoraAsyncServiceImpl
    implements RunTareaRecolectarValidarTiposHoraAsyncService {

  private final RunTareaRecolectarValidarTiposHoraService runTareaRecolectarValidarTiposHoraService;

  @Override
  public CompletableFuture<List<RunTareaValidarDto>> run(RunTareaDto runTarea) {
    return CompletableFuture.completedFuture(runTareaRecolectarValidarTiposHoraService.run(runTarea));
  }

}
