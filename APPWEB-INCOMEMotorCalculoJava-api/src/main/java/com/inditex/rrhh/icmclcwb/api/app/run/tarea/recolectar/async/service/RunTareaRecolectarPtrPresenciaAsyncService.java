package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;

public interface RunTareaRecolectarPtrPresenciaAsyncService {

    CompletableFuture<Void> tiposHorasByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> presenciaDetalleComisionable(final RunTareaDto runTarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    CompletableFuture<Void> presenciaTotalizadaTiendaSeccion(final RunTareaDto runTarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    CompletableFuture<Void> presenciaTotalizadaTienda(final RunTareaDto runTarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    CompletableFuture<Void> presenciaDetalleComisionablePersonaByRunTarea(final RunTareaDto runTarea);

    CompletableFuture<Void> presenciaTotalLocalizacionSeccionByRunTarea(final RunTareaDto runTarea);

}