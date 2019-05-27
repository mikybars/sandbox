package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

public interface RunTareaRecolectarPtrPresenciaService {

    void tiposHorasByRunTarea(@Valid final RunTareaDto runTarea);

    void tiposHorasByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito);

    void presenciaDetalleComisionablePersonaByRunTarea(@Valid final RunTareaDto runTarea);

    void presenciaTotalLocalizacionSeccionByRunTarea(@Valid final RunTareaDto runTarea);

    void presenciaTiendaEmpleadoByRunTarea(@Valid final RunTareaDto runTarea);

    void personaPresenciaDetalleComisionableByRunTarea(@Valid final RunTareaDto runTarea);

    void presenciaEmpleadoTiendaByRunTarea(@Valid final RunTareaDto runTarea);

    void presenciaTotalLocalizacionByRunTarea(@Valid final RunTareaDto runTarea);

    void presenciaDetalleComisionableLocalizacionPersonaByRunTarea(@Valid final RunTareaDto runTarea);

}