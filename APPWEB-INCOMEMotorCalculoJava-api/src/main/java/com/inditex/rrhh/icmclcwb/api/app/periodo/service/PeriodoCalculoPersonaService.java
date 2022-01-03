package com.inditex.rrhh.icmclcwb.api.app.periodo.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import javax.validation.constraints.NotNull;

public interface PeriodoCalculoPersonaService {

  void mergePeriodoCalculoPersona(@NotNull final RunTareaDto tareaDto);

  void limpiezaPeriodoCalculoPersona(@NotNull final RunTareaDto tareaDto,
      @NotNull final TareaAmbitoDto tareaAmbitoDto);

}
