package com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TrabajoRecolectarPtrPresenciaAsyncService {

    CompletableFuture<Void> tiposHoras(final TrabajoDto trabajo,
            final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque);

    CompletableFuture<Void> presenciaDetalleEmpleado(final TrabajoDto trabajo,
            final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque);

    CompletableFuture<Void> presenciaTotalizadaTienda(final TrabajoDto trabajo,
            final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque);

}