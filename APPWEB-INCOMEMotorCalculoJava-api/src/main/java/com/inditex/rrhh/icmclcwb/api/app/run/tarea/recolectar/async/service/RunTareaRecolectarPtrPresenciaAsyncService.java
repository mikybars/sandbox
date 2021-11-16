package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import org.springframework.scheduling.annotation.Async;

@Async
public interface RunTareaRecolectarPtrPresenciaAsyncService {

  CompletableFuture<Void> presenciaDetalleComisionablePersonaByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> presenciaEmpleadoTiendaByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> presenciaDetallePersonaIncluidoCommerceByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> presenciaDetallePersonaHorasSindicalesByRunTarea(final RunTareaDto runTarea);

}
