package com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TrabajoRecolectarPtrVentaAsyncService {

    CompletableFuture<Void> ventaDetalleEmpleado(final TrabajoDto trabajo,
            final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) throws Exception;

    CompletableFuture<Void> ventaTotalizadaTienda(final TrabajoDto trabajo,
            final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque) throws Exception;

}