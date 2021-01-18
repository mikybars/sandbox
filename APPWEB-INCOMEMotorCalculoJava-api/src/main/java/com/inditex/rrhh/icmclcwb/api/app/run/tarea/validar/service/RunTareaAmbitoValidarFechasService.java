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
public interface RunTareaAmbitoValidarFechasService {

    /**
     * @param runTareaDto
     * @param tareaAmbito
     * @return
     */
    Boolean validarFechasAmbito(@Valid RunTareaDto runTareaDto, @Valid TareaAmbitoDto tareaAmbito);

}
