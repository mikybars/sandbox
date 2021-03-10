package com.inditex.rrhh.icmclcwb.api.app.periodo.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import javax.validation.constraints.NotNull;

public interface PeriodoLocalizacionPersonaService {

    void mergePeriodoLocalizacionPersona(@NotNull final RunTareaDto tareaDto);

}
