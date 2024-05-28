package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalLocalizacionService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoGlobalLocalizacionRepositoryCustom;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaAmbitoGlobalLocalizacionServiceImpl implements TareaAmbitoGlobalLocalizacionService {

  @Autowired
  private TareaAmbitoGlobalLocalizacionRepositoryCustom tareaAmbitoGlobalLocalizacionRepositoryCustom;

  @Override
  public void mergeLocalizacion(@Valid @NotNull final RunTareaDto runTareaDto) {
    tareaAmbitoGlobalLocalizacionRepositoryCustom.mergeLocalizacion(runTareaDto);
  }

}
