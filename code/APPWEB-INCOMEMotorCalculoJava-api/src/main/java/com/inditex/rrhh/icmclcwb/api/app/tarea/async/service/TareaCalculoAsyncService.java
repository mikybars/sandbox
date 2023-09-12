package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import org.springframework.scheduling.annotation.Async;

public interface TareaCalculoAsyncService {

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param idPersonaLocalChallengeDto Some javadoc.
   * @return Some javadoc.
   */
  @Async("regularizarExecutor")
  CompletableFuture<Void> regularizarChallenge(RunTareaDto runTareaDto,
      IdPersonaLocalChallengeDto idPersonaLocalChallengeDto);

}
