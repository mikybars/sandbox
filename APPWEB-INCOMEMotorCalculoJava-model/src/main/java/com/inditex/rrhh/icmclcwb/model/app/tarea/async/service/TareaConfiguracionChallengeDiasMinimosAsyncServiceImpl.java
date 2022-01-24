package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaConfiguracionChallengeDiasMinimosAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionChallengeDiasMinimosDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaConfiguracionChallengeDiasMinimosService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResultItemDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaConfiguracionChallengeDiasMinimosAsyncServiceImpl
    implements TareaConfiguracionChallengeDiasMinimosAsyncService {

  @Autowired
  private TareaConfiguracionChallengeDiasMinimosService tareaConfiguracionChallengeDiasMinimosService;

  @Override
  public CompletableFuture<Void> save(List<TareaConfiguracionChallengeDiasMinimosDto> src, TareaDto tarea) {
    tareaConfiguracionChallengeDiasMinimosService.save(src, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> saveConfChDiasMinimosResultItemDto(List<ConfChDiasMinimosResultItemDto> src,
      TareaDto tarea) {
    tareaConfiguracionChallengeDiasMinimosService.saveConfChDiasMinimosResultItemDto(src, tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
