package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import javax.validation.Valid;

public interface TareaAgrupacionPresenciaService {

    void procesarPresenciaAgrupacion(@Valid RunTareaDto runTarea);
}
