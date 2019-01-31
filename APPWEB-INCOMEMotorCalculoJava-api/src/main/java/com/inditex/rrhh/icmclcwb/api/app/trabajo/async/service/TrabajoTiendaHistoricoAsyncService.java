package com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaHistoricoDto;

public interface TrabajoTiendaHistoricoAsyncService {

	CompletableFuture<Void> save(final List<TrabajoTiendaHistoricoDto> trabajoTiendaHistorico, final TrabajoDto trabajo) throws Exception;

}
