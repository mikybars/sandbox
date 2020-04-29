package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaAgrupacionPresenciaService {

    void calcularPresenciasTotalesAgrupacion(@Valid @NotNull final TareaDto tarea);
}
