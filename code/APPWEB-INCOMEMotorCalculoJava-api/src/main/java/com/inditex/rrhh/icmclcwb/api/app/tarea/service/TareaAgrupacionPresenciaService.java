package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface TareaAgrupacionPresenciaService {

  void calcularPresenciasTotalesAgrupacion(@Valid @NotNull final TareaDto tarea);

}
