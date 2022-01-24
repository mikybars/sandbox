package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructuraspol.dto.EstructurasPolResultItemDto;

import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaPersonaEstructuraPoliticaAsyncService {

  CompletableFuture<Void> save(List<ComisionEmpleadoResultItemDto> src, TareaDto tarea);

  CompletableFuture<Void> saveEstructurasPolResultItemDto(List<EstructurasPolResultItemDto> src, TareaDto tarea);

}
