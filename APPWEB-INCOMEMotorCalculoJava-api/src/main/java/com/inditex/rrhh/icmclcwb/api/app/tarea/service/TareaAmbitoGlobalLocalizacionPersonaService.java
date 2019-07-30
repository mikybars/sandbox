package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface TareaAmbitoGlobalLocalizacionPersonaService {

    void mergePersonaLocalizacion(@NotNull RunTareaDto runTareaDto);

}
