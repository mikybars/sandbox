package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunTareaRecolectarPtrPresenciaAsyncServiceImpl implements RunTareaRecolectarPtrPresenciaAsyncService {

  @Autowired
  private RunTareaRecolectarPtrPresenciaService tareaRecolectarPtrPresenciaService;

  @Override
  public CompletableFuture<Void> presenciaDetalleComisionablePersonaByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarPtrPresenciaService.presenciaDetalleComisionablePersonaByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> presenciaEmpleadoTiendaByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarPtrPresenciaService.presenciaEmpleadoTiendaByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> presenciaDetallePersonaIncluidoCommerceByRunTarea(
      final RunTareaDto runTarea) {
    this.tareaRecolectarPtrPresenciaService.presenciaDetalleIncluidoCommercePersonaByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> presenciaDetallePersonaHorasSindicalesByRunTarea(
      final RunTareaDto runTarea) {
    this.tareaRecolectarPtrPresenciaService.presenciaDetallePersonaHorasSindicalesByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
