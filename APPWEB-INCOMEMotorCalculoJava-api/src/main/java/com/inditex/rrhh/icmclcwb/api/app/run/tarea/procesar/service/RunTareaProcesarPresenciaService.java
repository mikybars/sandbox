package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaProcesarPresenciaService {

    void updateActivoLocalizacionPersonaPresencia(@Valid RunTareaDto runTarea);

    void updateActivoLocalizacion(@Valid RunTareaDto runTarea);

    void compensarLocalizacion(@Valid RunTareaDto runTarea);

    void compensarLocalizacionPersonaPresencia(@Valid RunTareaDto runTarea);

    void totalizarLocalizacion(@Valid RunTareaDto runTarea);

}
