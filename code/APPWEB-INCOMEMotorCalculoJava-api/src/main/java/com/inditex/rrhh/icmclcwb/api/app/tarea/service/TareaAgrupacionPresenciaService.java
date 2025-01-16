package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface TareaAgrupacionPresenciaService {

  void calcularPresenciasTotalesAgrupacion(@Valid @NotNull final TareaDto tarea);

}
