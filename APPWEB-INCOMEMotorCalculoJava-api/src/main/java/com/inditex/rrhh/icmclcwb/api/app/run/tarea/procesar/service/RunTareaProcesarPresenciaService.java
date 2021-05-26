package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaProcesarPresenciaService {

    void updateActivoLocalizacionPersonaPresencia(@Valid RunTareaDto runTarea);

    void compensarLocalizacion(@Valid RunTareaDto runTarea);

    void compensarLocalizacionPersonaPresencia(@Valid RunTareaDto runTarea);

    void presenciasIncluidoVentaPersona(@Valid RunTareaDto runTarea);

    void totalizarLocalizacion(@Valid RunTareaDto runTarea);

    void calcularPresenciasTotalesAgrupacion(@Valid RunTareaDto runTarea);

    void updateActivoLocalizacionVacio(@Valid RunTareaDto runTarea);

    void updateActivoLocalizacionPersonaPresenciaVacio(@Valid RunTareaDto runTarea);

    void indicadorPresencia(@Valid RunTareaDto runTarea);

    void indicadorPresenciaDesplazamiento(@Valid RunTareaDto runTarea);

    void indicadorPresenciaDesplazamientoBase(@Valid RunTareaDto runTarea);

    void indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(@Valid RunTareaDto runTarea);

    void totalizarEcommerceLocalizacion(@Valid RunTareaDto runTarea);

    void totalizarEmpleadosPorVenta(@Valid RunTareaDto runTarea);

    void presenciasHorasFijas(@Valid RunTareaDto runTarea);

    void presenciasHorasFijasDesplazamientos(@Valid RunTareaDto runTarea);

    void indicadorPersonaPorVenta(@Valid RunTareaDto runTarea);

    void indicadorPersonaPorVentaSimplificada(@Valid RunTareaDto runTarea);

    void compensarChallenge(@Valid RunTareaDto runTarea);

    void indicadorDesplazamientoDirectoVenta(@Valid RunTareaDto runTarea);

    void compensarLocalizacionManual(@Valid RunTareaDto runTarea);

}
