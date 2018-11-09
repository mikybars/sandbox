package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstadoDto;

public interface TrabajoEmpleadoEstadoService {

	TrabajoEmpleadoEstadoDto save(@Valid TrabajoEmpleadoEstadoDto trabajoEmpleadoEstado);
	
	CompletableFuture<Void> save(@Valid List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstado);

}
