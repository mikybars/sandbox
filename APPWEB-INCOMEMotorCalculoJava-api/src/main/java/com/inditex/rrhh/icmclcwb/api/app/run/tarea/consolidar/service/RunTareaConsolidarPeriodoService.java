package com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.service;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaConsolidarPeriodoService {

    void mergePeriodoCalculoPersona(@NotNull final RunTareaDto tareaDto);

    void mergePeriodoPersona(@NotNull final RunTareaDto tareaDto);

    void mergePeriodoLocalizacion(@NotNull final RunTareaDto tareaDto);

    void mergePeriodoLocalizacionPersona(@NotNull final RunTareaDto tareaDto);
}
