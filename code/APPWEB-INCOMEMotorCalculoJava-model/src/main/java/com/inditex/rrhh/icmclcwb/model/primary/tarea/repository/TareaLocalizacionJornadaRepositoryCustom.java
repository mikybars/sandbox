package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface TareaLocalizacionJornadaRepositoryCustom {

  void procesar(@NotNull RunTareaDto runTareaDto);
}
