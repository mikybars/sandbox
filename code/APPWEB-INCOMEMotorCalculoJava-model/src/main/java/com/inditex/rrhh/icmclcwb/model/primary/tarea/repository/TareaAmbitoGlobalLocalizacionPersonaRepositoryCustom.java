package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import jakarta.validation.constraints.NotNull;

public interface TareaAmbitoGlobalLocalizacionPersonaRepositoryCustom {

  void mergePersonaLocalizacion(@NotNull final RunTareaDto tareaDto);

}
