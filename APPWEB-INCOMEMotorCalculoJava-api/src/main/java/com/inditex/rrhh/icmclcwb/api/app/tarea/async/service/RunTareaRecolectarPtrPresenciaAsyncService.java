package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;

public interface RunTareaRecolectarPtrPresenciaAsyncService {

    CompletableFuture<Void> tiposHoras(final RunTareaDto runTarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    CompletableFuture<Void> presenciaDetalleEmpleado(final RunTareaDto runTarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    CompletableFuture<Void> presenciaTotalizadaTienda(final RunTareaDto runTarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

}