package com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import org.jspecify.annotations.NonNull;

public interface RunTareaConsolidarPeriodoService {

  void mergePeriodoCalculoPersona(@NonNull final RunTareaDto tareaDto);

  void mergePeriodoPersona(@NonNull final RunTareaDto tareaDto);

  void mergePeriodoLocalizacion(@NonNull final RunTareaDto tareaDto);

  void mergePeriodoLocalizacionPersona(@NonNull final RunTareaDto tareaDto);

  void limpiezaPeriodoCalculoPersona(@NonNull final RunTareaDto tareaDto,
      @NonNull final TareaAmbitoDto tareaAmbitoDto);

  void limpiezaPeriodoLocalizacionPersona(@NonNull final RunTareaDto tareaDto,
      @NonNull final TareaAmbitoDto tareaAmbitoDto);

  void limpiezaPeriodoLocalizacion(@NonNull final RunTareaDto tareaDto, @NonNull final TareaAmbitoDto tareaAmbitoDto);

  void limpiezaPeriodoPersona(@NonNull final RunTareaDto tareaDto, @NonNull final TareaAmbitoDto tareaAmbitoDto);

}
