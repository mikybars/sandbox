package com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TrabajoRecolectarMeta4IcmWsCalcIncomeAsyncService {

    CompletableFuture<Void> tiendasHistorico(final TrabajoDto trabajo,
            final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque);

    CompletableFuture<Void> tiendasEmpleadoHistorico(final TrabajoDto trabajo,
            final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque);

    CompletableFuture<Void> condicionesEmpleados(final TrabajoDto trabajo,
            final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque);

    CompletableFuture<Void> empleadosTienda(final TrabajoDto trabajo,
            final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque);

    CompletableFuture<Void> tiendasPresencia(final TrabajoDto trabajo,
            final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque);

    CompletableFuture<Void> tiendasComisionable(final TrabajoDto trabajo,
            final RunTrabajoRecolectarBloqueDto runTrabajoRecolectarBloque);

}