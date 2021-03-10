package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface TareaAmbitoGlobalLocalizacionPersonaService {

    void mergePersonaLocalizacion(@Valid @NotNull RunTareaDto runTareaDto);

}
