package com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoRecolectarDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoEmpleadoEstadoDto;

public interface TrabajoEmpleadoEstadoAsyncService {
	
	CompletableFuture<Void> save(List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstado) throws Exception;

    CompletableFuture<Void> save(RunTrabajoRecolectarDto runTrabajoRecolectar, @Valid TrabajoDto trabajo) throws Exception;

}
