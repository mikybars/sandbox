package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaEstadoDto;

public interface TrabajoTiendaEstadoAsyncService {

	CompletableFuture<Void> save(List<TrabajoTiendaEstadoDto> trabajoTiendaEstado, TrabajoDto trabajo) throws Exception;

}
