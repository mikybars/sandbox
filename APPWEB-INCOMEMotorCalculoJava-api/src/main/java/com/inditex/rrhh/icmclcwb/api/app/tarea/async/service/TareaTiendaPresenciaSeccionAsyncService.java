package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;

@Async("repositoryPrimaryExecutor")
public interface TareaTiendaPresenciaSeccionAsyncService {

    CompletableFuture<Void> save(List<PtrPresenciaTotalizadoResultItemDto> dto, TareaDto tarea);

    CompletableFuture<Void> compensar(@Valid final RunTareaDto runTarea);

}
