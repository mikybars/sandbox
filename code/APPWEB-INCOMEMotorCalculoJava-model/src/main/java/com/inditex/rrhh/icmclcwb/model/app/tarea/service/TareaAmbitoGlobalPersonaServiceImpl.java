package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalPersonaService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoGlobalPersonaRepositoryCustom;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaAmbitoGlobalPersonaServiceImpl implements TareaAmbitoGlobalPersonaService {

  @Autowired
  private TareaAmbitoGlobalPersonaRepositoryCustom tareaAmbitoGlobalPersonaRepositoryCustom;

  @Override
  public void mergePersona(@Valid @NotNull final RunTareaDto runTareaDto) {
    tareaAmbitoGlobalPersonaRepositoryCustom.mergePersona(runTareaDto);
  }

}
