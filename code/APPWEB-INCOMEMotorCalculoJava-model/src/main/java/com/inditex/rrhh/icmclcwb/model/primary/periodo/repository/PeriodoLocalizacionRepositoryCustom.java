package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import org.jspecify.annotations.NonNull;

public interface PeriodoLocalizacionRepositoryCustom {

  void mergePeriodoLocalizacion(@NonNull RunTareaDto tareaDto);

  void limpiezaPeriodoLocalizacion(@NonNull RunTareaDto tareaDto, @NonNull TareaAmbitoDto tareaAmbitoDto);

}
