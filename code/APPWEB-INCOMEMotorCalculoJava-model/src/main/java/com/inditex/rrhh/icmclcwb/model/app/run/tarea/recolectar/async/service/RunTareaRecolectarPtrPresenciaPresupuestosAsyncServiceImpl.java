package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrPresenciaPresupuestosAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrPresenciaPresupuestosService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RunTareaRecolectarPtrPresenciaPresupuestosAsyncServiceImpl
    implements RunTareaRecolectarPtrPresenciaPresupuestosAsyncService {

  private final RunTareaRecolectarPtrPresenciaPresupuestosService runTareaRecolectarPtrPresenciaPresupuestosService;

  @Override
  public CompletableFuture<Void> presenciaEmpleadoTiendaByRunTarea(RunTareaDto runTarea) {
    runTareaRecolectarPtrPresenciaPresupuestosService.presenciaEmpleadoTiendaByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
