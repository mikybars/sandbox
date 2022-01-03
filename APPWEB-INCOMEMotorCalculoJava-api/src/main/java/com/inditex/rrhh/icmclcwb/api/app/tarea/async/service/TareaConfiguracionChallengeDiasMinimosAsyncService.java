package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionChallengeDiasMinimosDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResultItemDto;

import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaConfiguracionChallengeDiasMinimosAsyncService {

  CompletableFuture<Void> save(
      List<TareaConfiguracionChallengeDiasMinimosDto> src, TareaDto tarea);

  CompletableFuture<Void> saveConfChDiasMinimosResultItemDto(List<ConfChDiasMinimosResultItemDto> src,
      TareaDto tarea);

}
