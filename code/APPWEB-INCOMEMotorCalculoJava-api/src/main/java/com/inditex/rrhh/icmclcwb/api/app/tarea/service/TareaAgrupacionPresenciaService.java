package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface TareaAgrupacionPresenciaService {

  void calcularPresenciasTotalesAgrupacion(@Valid @NonNull final TareaDto tarea);

}
