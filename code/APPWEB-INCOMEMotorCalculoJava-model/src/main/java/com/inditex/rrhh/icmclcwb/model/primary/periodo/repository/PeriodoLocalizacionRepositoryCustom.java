package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import javax.validation.constraints.NotNull;

public interface PeriodoLocalizacionRepositoryCustom {

  void mergePeriodoLocalizacion(@NotNull RunTareaDto tareaDto);

  void limpiezaPeriodoLocalizacion(@NotNull RunTareaDto tareaDto, @NotNull TareaAmbitoDto tareaAmbitoDto);

}
