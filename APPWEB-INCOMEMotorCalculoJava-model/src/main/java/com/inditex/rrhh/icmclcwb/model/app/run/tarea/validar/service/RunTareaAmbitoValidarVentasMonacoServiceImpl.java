package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarVentasMonacoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;

import javax.validation.Valid;

public class RunTareaAmbitoValidarVentasMonacoServiceImpl implements RunTareaAmbitoValidarVentasMonacoService {

    /**
     * Some javadoc.
     *
     * @param runTareaDto Some javadoc.
     * @param tareaAmbito Some javadoc.
     * @param tareaFaseAccion Some javadoc.
     * @return Some javadoc.
     */
    @Override
    public ValidacionDto execute(
        @Valid final RunTareaDto runTareaDto,
        @Valid final TareaAmbitoDto tareaAmbito,
        @Valid final TareaFaseAccionDto tareaFaseAccion) {
        //TODO Punto de partida de la validacion fake
        return null;
    }
}
