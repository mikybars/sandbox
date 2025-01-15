package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

public interface PeriodoLocalizacionPersonaRepositoryCustom {

  void mergePeriodoLocalizacionPersona(@NotNull RunTareaDto tareaDto);

  void limpiezaPeriodoLocalizacionPersona(@NotNull RunTareaDto tareaDto, @NotNull TareaAmbitoDto tareaAmbitoDto);

}
