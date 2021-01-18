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
public interface RunTareaValidarPresenciasService {

    /**
     * @param runTarea
     */
    void validarPresencias(@NotNull @Valid RunTareaDto runTarea);

}
