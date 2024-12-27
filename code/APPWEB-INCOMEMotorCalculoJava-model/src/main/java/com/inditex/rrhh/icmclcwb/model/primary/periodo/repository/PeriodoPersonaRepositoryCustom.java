package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import org.jspecify.annotations.NonNull;

public interface PeriodoPersonaRepositoryCustom {

  void mergePeriodoPersona(@NonNull RunTareaDto tareaDto);

  void limpiezaPeriodoPersona(@NonNull RunTareaDto tareaDto, @NonNull TareaAmbitoDto tareaAmbitoDto);

}
