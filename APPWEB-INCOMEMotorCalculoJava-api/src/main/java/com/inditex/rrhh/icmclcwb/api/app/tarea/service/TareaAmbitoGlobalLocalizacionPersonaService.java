package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface TareaAmbitoGlobalLocalizacionPersonaService {

  void mergePersonaLocalizacion(@Valid @NotNull RunTareaDto runTareaDto);

}
