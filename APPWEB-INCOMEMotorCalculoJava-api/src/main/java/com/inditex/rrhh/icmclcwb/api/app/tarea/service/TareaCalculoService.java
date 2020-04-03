package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface TareaCalculoService {

    void regularizarChallenge(RunTareaDto runTareaDto, @NotNull final IdPersonaLocalChallengeDto idPersonaLocalChallengeDto);

}
