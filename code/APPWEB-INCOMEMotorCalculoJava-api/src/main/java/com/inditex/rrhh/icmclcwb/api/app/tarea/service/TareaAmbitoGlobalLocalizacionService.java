package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface TareaAmbitoGlobalLocalizacionService {

  void mergeLocalizacion(@Valid @NotNull final RunTareaDto runTareaDto);

}
