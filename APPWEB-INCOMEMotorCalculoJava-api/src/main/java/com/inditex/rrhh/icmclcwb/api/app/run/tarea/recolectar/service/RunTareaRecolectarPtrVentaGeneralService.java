package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

public interface RunTareaRecolectarPtrVentaGeneralService {

    void ventaFisicaLocalizacionSeccionByRunTarea(@Valid final RunTareaDto runTarea);

    void ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaAmbitoDto tareaAmbito);

    void ventaFisicaLocalizacionByRunTarea(@Valid final RunTareaDto runTarea);

}