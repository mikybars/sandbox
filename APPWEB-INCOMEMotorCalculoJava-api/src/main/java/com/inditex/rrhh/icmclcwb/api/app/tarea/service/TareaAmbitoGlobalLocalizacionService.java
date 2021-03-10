package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface TareaAmbitoGlobalLocalizacionService {

    void mergeLocalizacion(@Valid @NotNull final RunTareaDto runTareaDto);

}
