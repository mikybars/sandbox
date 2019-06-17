package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaRecolectarPtrPresenciaService {

    void tiposHorasByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void presenciaTotalLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void presenciaDetalleComisionablePersonaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void presenciaDetalleComisionableLocalizacionPersonaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void presenciaEmpleadoTiendaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void presenciaTotalCadenaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void updateActivoCadenaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

}
