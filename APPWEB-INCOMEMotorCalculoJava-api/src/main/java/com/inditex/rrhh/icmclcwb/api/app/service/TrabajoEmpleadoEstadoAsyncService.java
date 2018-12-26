package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstadoDto;

public interface TrabajoEmpleadoEstadoAsyncService {
	
	CompletableFuture<Void> save(List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstado) throws Exception;

}
