package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalLocalizacionPersonaService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoGlobalLocalizacionPersonaRepositoryCustom;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaAmbitoGlobalLocalizacionPersonaServiceImpl implements TareaAmbitoGlobalLocalizacionPersonaService {

  @Autowired
  private TareaAmbitoGlobalLocalizacionPersonaRepositoryCustom tareaAmbitoGlobalLocalizacionPersonaRepositoryCustom;

  @Override
  public void mergePersonaLocalizacion(@Valid @NotNull final RunTareaDto runTareaDto) {
    tareaAmbitoGlobalLocalizacionPersonaRepositoryCustom.mergePersonaLocalizacion(runTareaDto);
  }

}
