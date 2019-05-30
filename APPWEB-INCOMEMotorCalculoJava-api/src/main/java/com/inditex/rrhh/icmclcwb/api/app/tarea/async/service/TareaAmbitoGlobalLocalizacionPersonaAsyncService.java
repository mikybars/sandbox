package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;

@Async("repositoryPrimaryExecutor")
public interface TareaAmbitoGlobalLocalizacionPersonaAsyncService {

    CompletableFuture<Void> savePtrPresenciaEmpleadosTiendaResponse(PtrPresenciaEmpleadosTiendaResponseDto dto,
            TareaDto tarea);

    CompletableFuture<Void> mergePersonaLocalizacion(RunTareaDto tarea);

}
