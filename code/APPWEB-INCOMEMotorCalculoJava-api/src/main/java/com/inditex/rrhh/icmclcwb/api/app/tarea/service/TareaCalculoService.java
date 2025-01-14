package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface TareaCalculoService {

  void regularizarChallenge(@Valid @NonNull final RunTareaDto runTareaDto,
      @Valid @NonNull final IdPersonaLocalChallengeDto idPersonaLocalChallengeDto);

}
