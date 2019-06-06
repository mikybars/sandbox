package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaProcesarPresenciaService {

    void updateActivoLocalizacionPersonaPresencia(@Valid RunTareaDto runTarea);

    void updateActivoTotalizadoLocalizacion(@Valid RunTareaDto runTarea);

    void compensarLocalizacion(@Valid RunTareaDto runTarea);

}
