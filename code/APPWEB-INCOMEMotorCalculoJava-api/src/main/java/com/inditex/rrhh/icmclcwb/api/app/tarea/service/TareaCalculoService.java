package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface TareaCalculoService {

  void regularizarChallenge(@Valid @NotNull final RunTareaDto runTareaDto,
      @Valid @NotNull final IdPersonaLocalChallengeDto idPersonaLocalChallengeDto);

}
