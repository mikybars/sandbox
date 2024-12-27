package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface TareaAmbitoGlobalLocalizacionService {

  void mergeLocalizacion(@Valid @NonNull final RunTareaDto runTareaDto);

}
