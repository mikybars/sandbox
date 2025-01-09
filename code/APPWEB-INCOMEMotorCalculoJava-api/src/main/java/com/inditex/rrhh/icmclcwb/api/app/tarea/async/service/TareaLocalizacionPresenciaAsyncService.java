package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.presenciamanualwloc.dto.PresenciaManualWlocResultItemDto;

import org.jspecify.annotations.NonNull;
import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaLocalizacionPresenciaAsyncService {

  CompletableFuture<Void> save(@NonNull List<PresenciaManualWlocResultItemDto> src,
      @NonNull TareaDto tareaDto);

}
