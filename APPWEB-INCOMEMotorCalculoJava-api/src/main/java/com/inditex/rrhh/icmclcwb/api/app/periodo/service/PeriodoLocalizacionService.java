package com.inditex.rrhh.icmclcwb.api.app.periodo.service;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

public interface PeriodoLocalizacionService {

    void mergePeriodoLocalizacion(@NotNull final RunTareaDto tareaDto);

    void limpiezaPeriodoLocalizacion(@NotNull final RunTareaDto tareaDto, @NotNull final TareaAmbitoDto tareaAmbitoDto);

}
