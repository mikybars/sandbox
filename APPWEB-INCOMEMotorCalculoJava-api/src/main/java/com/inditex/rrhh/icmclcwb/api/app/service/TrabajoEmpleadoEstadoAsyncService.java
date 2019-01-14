package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoRunDatosDto;

public interface TrabajoEmpleadoEstadoAsyncService {
	
	CompletableFuture<Void> save(List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstado) throws Exception;

    CompletableFuture<Void> save(TrabajoRunDatosDto trabajoRunDatos, @Valid TrabajoDto trabajo) throws Exception;

}
