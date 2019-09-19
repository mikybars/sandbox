package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import javax.validation.Valid;

public interface TareaAgrupacionPresenciaService {

    void calcularPresenciasTotalesAgrupacion(@Valid TareaDto tarea);
}
