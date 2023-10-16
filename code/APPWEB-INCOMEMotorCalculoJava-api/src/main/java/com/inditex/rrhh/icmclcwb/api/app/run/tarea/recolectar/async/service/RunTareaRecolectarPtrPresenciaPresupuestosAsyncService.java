package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import org.springframework.scheduling.annotation.Async;

@Async
public interface RunTareaRecolectarPtrPresenciaPresupuestosAsyncService {

  CompletableFuture<Void> presenciaEmpleadoTiendaByRunTarea(final RunTareaDto runTarea);

}
