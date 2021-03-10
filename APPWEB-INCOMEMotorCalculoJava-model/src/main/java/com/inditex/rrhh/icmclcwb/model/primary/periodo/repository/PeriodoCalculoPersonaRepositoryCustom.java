package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import javax.validation.constraints.NotNull;

public interface PeriodoCalculoPersonaRepositoryCustom {

    void mergePeriodoCalculoPersona(@NotNull RunTareaDto tareaDto);

}
