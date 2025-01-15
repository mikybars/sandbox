package com.inditex.rrhh.icmclcwb.api.app.periodo.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import jakarta.validation.constraints.NotNull;

public interface PeriodoPersonaService {

  void mergePeriodoPersona(@NotNull final RunTareaDto tareaDto);

  void limpiezaPeriodoPersona(@NotNull final RunTareaDto tareaDto, @NotNull final TareaAmbitoDto tareaAmbitoDto);

}
