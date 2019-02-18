package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTareaRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaRecolectarPtrPresenciaAsyncService {

    CompletableFuture<Void> tiposHoras(final TareaDto tarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    CompletableFuture<Void> presenciaDetalleEmpleado(final TareaDto tarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    CompletableFuture<Void> presenciaTotalizadaTienda(final TareaDto tarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

}