package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import javax.validation.constraints.NotNull;

public interface PeriodoLocalizacionRepositoryCustom {

    void mergePeriodoLocalizacion(@NotNull RunTareaDto tareaDto);

}
