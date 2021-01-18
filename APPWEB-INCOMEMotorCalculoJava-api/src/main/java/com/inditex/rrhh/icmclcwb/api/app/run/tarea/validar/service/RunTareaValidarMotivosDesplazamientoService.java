/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

/**
 * @author mdelrio
 *
 */
public interface RunTareaValidarMotivosDesplazamientoService {

    /**
     * @param runTarea
     */
    void validarMotivosDesplazamiento(@NotNull @Valid RunTareaDto runTarea);

}
