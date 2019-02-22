package com.inditex.rrhh.icmclcwb.api.app.proceso.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoRecolectarDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoEmpleadoEstadoDto;

public interface ProcesoEmpleadoEstadoAsyncService {
	
	CompletableFuture<Void> save(List<ProcesoEmpleadoEstadoDto> procesoEmpleadoEstado);

    CompletableFuture<Void> save(RunProcesoRecolectarDto runProcesoRecolectar, @Valid ProcesoDto proceso);

}
