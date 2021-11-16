package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaCalculoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaCalculoAsyncServiceImpl implements TareaCalculoAsyncService {

  @Autowired
  private TareaCalculoService tareaCalculoService;

  @Override
  public CompletableFuture<Void> regularizarChallenge(final RunTareaDto runTareaDto,
      final IdPersonaLocalChallengeDto idPersonaLocalChallengeDto) {
    this.tareaCalculoService.regularizarChallenge(runTareaDto, idPersonaLocalChallengeDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
