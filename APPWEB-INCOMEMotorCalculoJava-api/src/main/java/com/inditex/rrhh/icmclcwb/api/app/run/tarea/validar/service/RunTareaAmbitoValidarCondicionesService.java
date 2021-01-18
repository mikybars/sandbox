/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

/**
 * @author mdelrio
 *
 */
public interface RunTareaAmbitoValidarCondicionesService {

    /**
     * @param runTarea
     * @param tareaAmbito
     * @return
     */
    Boolean validarCondicionesAmbito(@Valid RunTareaDto runTarea, @Valid TareaAmbitoDto tareaAmbito);

}
