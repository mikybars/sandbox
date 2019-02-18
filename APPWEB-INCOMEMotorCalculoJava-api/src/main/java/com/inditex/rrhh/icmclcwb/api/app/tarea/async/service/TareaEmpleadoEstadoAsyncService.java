package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTareaRecolectarDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoEstadoDto;

public interface TareaEmpleadoEstadoAsyncService {
	
	CompletableFuture<Void> save(List<TareaEmpleadoEstadoDto> tareaEmpleadoEstado);

    CompletableFuture<Void> save(RunTareaRecolectarDto runTareaRecolectar, @Valid TareaDto tarea);

}
