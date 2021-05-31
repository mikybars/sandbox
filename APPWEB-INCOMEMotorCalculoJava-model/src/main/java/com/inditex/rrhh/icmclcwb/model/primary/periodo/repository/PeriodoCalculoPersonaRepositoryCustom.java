package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

public interface PeriodoCalculoPersonaRepositoryCustom {

    void mergePeriodoCalculoPersona(@NotNull RunTareaDto tareaDto);

    void limpiezaPeriodoCalculoPersona(@NotNull RunTareaDto tareaDto, @NotNull TareaAmbitoDto tareaAmbitoDto);

}
