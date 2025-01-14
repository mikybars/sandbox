package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import org.jspecify.annotations.NonNull;

public interface TareaLocalizacionPersonaJornadaRepositoryCustom {

  void procesar(@NonNull RunTareaDto runTareaDto);
}
