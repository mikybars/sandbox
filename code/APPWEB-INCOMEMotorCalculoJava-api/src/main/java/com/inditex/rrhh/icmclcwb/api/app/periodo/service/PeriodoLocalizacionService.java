package com.inditex.rrhh.icmclcwb.api.app.periodo.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import jakarta.validation.constraints.NotNull;

public interface PeriodoLocalizacionService {

  void mergePeriodoLocalizacion(@NotNull final RunTareaDto tareaDto);

  void limpiezaPeriodoLocalizacion(@NotNull final RunTareaDto tareaDto, @NotNull final TareaAmbitoDto tareaAmbitoDto);

}
