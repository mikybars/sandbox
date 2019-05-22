package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaProcesarPresenciaService {

    void compensar(@Valid RunTareaDto runTarea);

    void updateActivo(@Valid RunTareaDto runTarea);

    void updateActivoTotalizado(@Valid RunTareaDto runTarea);

}
