package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoEstadoDto;

@Async("repositoryPrimaryExecutor")
public interface TareaEmpleadoEstadoAsyncService {
	
	CompletableFuture<Void> save(List<TareaEmpleadoEstadoDto> tareaEmpleadoEstado);

    CompletableFuture<Void> save(RunTareaRecolectarDto runTareaRecolectar, @Valid TareaDto tarea);

}
