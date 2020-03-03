package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import javax.validation.Valid;

public interface RunTareaProcesarEstructuraService {

    void updateActivoTopes(@Valid final TareaDto tarea);

}
