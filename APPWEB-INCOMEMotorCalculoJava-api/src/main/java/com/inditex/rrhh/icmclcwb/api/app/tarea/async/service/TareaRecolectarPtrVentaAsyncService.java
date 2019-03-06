package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaRecolectarPtrVentaAsyncService {

    CompletableFuture<Void> ventaDetalleEmpleado(final TareaDto tarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    CompletableFuture<Void> ventaTotalizadaTienda(final TareaDto tarea,
            final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

}