package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaProcesarPresenciaService {

    void updateActivoLocalizacionPersonaPresencia(@Valid RunTareaDto runTarea);

    void updateActivoLocalizacion(@Valid RunTareaDto runTarea);

    void compensarLocalizacion(@Valid RunTareaDto runTarea);

    void compensarLocalizacionEcommerce(@Valid RunTareaDto runTarea);

    void compensarLocalizacionPersonaPresencia(@Valid RunTareaDto runTarea);

    void totalizarLocalizacion(@Valid RunTareaDto runTarea);

    void updateActivoLocalizacionEcommerce(@Valid RunTareaDto runTarea);

    void calcularPresenciasTotalesAgrupacion(@Valid RunTareaDto runTarea);

    void updateActivoLocalizacionVacio(@Valid RunTareaDto runTarea);

    void updateActivoLocalizacionPersonaPresenciaVacio(@Valid RunTareaDto runTarea);

}
