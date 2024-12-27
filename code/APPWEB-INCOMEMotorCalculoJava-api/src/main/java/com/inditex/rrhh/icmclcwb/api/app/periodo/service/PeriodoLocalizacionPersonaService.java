package com.inditex.rrhh.icmclcwb.api.app.periodo.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import org.jspecify.annotations.NonNull;

public interface PeriodoLocalizacionPersonaService {

  void mergePeriodoLocalizacionPersona(@NonNull final RunTareaDto tareaDto);

  void limpiezaPeriodoLocalizacionPersona(@NonNull RunTareaDto tareaDto, @NonNull TareaAmbitoDto tareaAmbitoDto);

}
