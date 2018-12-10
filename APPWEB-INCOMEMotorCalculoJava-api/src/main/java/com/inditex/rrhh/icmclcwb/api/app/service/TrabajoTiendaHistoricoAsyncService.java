package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaHistoricoDto;

public interface TrabajoTiendaHistoricoAsyncService {

	CompletableFuture<Void> save(final List<TrabajoTiendaHistoricoDto> trabajoTiendaHistorico, final TrabajoDto trabajo);

}
