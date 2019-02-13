package com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoRecolectarDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

public interface TrabajoTiendaEstadoAsyncService {

    CompletableFuture<Void> save(RunTrabajoRecolectarDto runTrabajoRecolectar, TrabajoDto trabajo);

}
