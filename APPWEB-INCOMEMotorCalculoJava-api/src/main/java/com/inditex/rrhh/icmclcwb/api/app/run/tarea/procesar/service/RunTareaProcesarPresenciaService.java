package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaProcesarPresenciaService {

    void compensarLocalizacionSeccion(@Valid RunTareaDto runTarea);

    void updateActivoLocalizacionPersonaSeccionPresencia(@Valid RunTareaDto runTarea);

    void updateActivoTotalizadoLocalizacion(@Valid RunTareaDto runTarea);

    void updateActivoTotalizadoLocalizacionSeccion(@Valid RunTareaDto runTarea);

    void compensarLocalizacion(@Valid RunTareaDto runTarea);

    void updateActivoLocalizacionPersonaPresenciaSeccion(@Valid RunTareaDto runTarea);

}
