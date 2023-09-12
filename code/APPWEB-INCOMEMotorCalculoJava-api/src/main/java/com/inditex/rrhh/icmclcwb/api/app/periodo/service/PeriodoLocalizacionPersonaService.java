package com.inditex.rrhh.icmclcwb.api.app.periodo.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import javax.validation.constraints.NotNull;

public interface PeriodoLocalizacionPersonaService {

  void mergePeriodoLocalizacionPersona(@NotNull final RunTareaDto tareaDto);

  void limpiezaPeriodoLocalizacionPersona(@NotNull RunTareaDto tareaDto, @NotNull TareaAmbitoDto tareaAmbitoDto);

}
