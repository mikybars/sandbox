package com.inditex.rrhh.icmclcwb.api.app.periodo.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import org.jspecify.annotations.NonNull;

public interface PeriodoPersonaService {

  void mergePeriodoPersona(@NonNull final RunTareaDto tareaDto);

  void limpiezaPeriodoPersona(@NonNull final RunTareaDto tareaDto, @NonNull final TareaAmbitoDto tareaAmbitoDto);

}
