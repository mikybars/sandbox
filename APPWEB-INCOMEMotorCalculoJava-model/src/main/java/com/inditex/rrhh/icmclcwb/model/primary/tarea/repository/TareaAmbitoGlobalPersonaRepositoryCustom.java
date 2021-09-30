package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface TareaAmbitoGlobalPersonaRepositoryCustom {

    void mergePersona(@NotNull RunTareaDto tareaDto);

}
