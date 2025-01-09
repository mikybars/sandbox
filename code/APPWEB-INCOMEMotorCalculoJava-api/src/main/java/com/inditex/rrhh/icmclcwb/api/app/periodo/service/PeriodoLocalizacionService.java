package com.inditex.rrhh.icmclcwb.api.app.periodo.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import org.jspecify.annotations.NonNull;

public interface PeriodoLocalizacionService {

  void mergePeriodoLocalizacion(@NonNull final RunTareaDto tareaDto);

  void limpiezaPeriodoLocalizacion(@NonNull final RunTareaDto tareaDto, @NonNull final TareaAmbitoDto tareaAmbitoDto);

}
