package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoRepositoryCustom;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaCalculoServiceImpl implements TareaCalculoService {

  @Autowired
  private TareaCalculoRepositoryCustom tareaCalculoRepositoryCustom;

  @Override
  public void regularizarChallenge(@Valid @NotNull final RunTareaDto runTareaDto,
      @Valid @NotNull final IdPersonaLocalChallengeDto idPersonaLocalChallengeDto) {
    tareaCalculoRepositoryCustom.regularizarChallenge(runTareaDto.getTarea(), idPersonaLocalChallengeDto);
  }

}
