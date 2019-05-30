package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

@Async
public interface RunTareaRecolectarPtrPresenciaAsyncService {

    CompletableFuture<Void> tiposHorasByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> presenciaDetalleComisionablePersonaByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> presenciaTotalLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> presenciaEmpleadoTiendaByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> presenciaTotalLocalizacionByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> presenciaDetalleComisionableLocalizacionPersonaByRunTarea(final RunTareaDto runTarea);

}
