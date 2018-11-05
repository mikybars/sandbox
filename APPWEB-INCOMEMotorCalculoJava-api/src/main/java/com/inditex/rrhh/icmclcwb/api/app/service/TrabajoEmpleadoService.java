package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoDto;

public interface TrabajoEmpleadoService {

	TrabajoEmpleadoDto save(@Valid TrabajoEmpleadoDto trabajo);
	
	CompletableFuture<Void> save(@Valid List<TrabajoEmpleadoDto> trabajoEmpleadoDto);

	Boolean existsByIdEmpleado(String idEmpleado);


}
