/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface TareaCalculoAsyncService {

    /**
     * @param runTareaDto
     * @param idPersonaLocalChallengeDto
     * @return
     */
    @Async("regularizarExecutor")
    CompletableFuture<Void> regularizarChallenge(RunTareaDto runTareaDto,
            IdPersonaLocalChallengeDto idPersonaLocalChallengeDto);

}
