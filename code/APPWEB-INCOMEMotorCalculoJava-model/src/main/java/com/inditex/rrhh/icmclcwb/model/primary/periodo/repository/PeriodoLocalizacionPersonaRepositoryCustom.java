package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import org.jspecify.annotations.NonNull;

public interface PeriodoLocalizacionPersonaRepositoryCustom {

  void mergePeriodoLocalizacionPersona(@NonNull RunTareaDto tareaDto);

  void limpiezaPeriodoLocalizacionPersona(@NonNull RunTareaDto tareaDto, @NonNull TareaAmbitoDto tareaAmbitoDto);

}
