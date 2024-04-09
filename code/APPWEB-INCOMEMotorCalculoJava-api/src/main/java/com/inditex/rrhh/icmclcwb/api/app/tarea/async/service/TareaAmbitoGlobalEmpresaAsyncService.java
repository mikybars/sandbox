package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaAmbitoGlobalEmpresaAsyncService {

  CompletableFuture<Void> save(@Valid @NotNull @NotEmpty List<TareaAmbitoGlobalEmpresaDto> src,
      @Valid @NotNull TareaDto tarea);

}
