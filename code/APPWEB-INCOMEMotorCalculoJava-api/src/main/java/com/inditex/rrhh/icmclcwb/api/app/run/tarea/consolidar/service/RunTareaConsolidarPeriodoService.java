package com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import jakarta.validation.constraints.NotNull;

public interface RunTareaConsolidarPeriodoService {

  void mergePeriodoCalculoPersona(@NotNull final RunTareaDto tareaDto);

  void mergePeriodoPersona(@NotNull final RunTareaDto tareaDto);

  void mergePeriodoLocalizacion(@NotNull final RunTareaDto tareaDto);

  void mergePeriodoLocalizacionPersona(@NotNull final RunTareaDto tareaDto);

  void limpiezaPeriodoCalculoPersona(@NotNull final RunTareaDto tareaDto,
      @NotNull final TareaAmbitoDto tareaAmbitoDto);

  void limpiezaPeriodoLocalizacionPersona(@NotNull final RunTareaDto tareaDto,
      @NotNull final TareaAmbitoDto tareaAmbitoDto);

  void limpiezaPeriodoLocalizacion(@NotNull final RunTareaDto tareaDto, @NotNull final TareaAmbitoDto tareaAmbitoDto);

  void limpiezaPeriodoPersona(@NotNull final RunTareaDto tareaDto, @NotNull final TareaAmbitoDto tareaAmbitoDto);

}
