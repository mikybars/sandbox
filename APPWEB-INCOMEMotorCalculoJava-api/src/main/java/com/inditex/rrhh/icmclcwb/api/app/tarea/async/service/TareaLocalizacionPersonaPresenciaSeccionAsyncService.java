package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.constraints.NotNull;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;

@Async("repositoryPrimaryExecutor")
public interface TareaLocalizacionPersonaPresenciaSeccionAsyncService {

    CompletableFuture<Void> save(@NotNull List<PtrPresenciaDetalleResultItemDto> src, @NotNull TareaDto tareaDto);

}
