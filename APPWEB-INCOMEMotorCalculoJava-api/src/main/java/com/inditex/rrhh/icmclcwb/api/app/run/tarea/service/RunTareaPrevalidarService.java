/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.run.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;

/**
 * @author mdelrio
 *
 */
public interface RunTareaPrevalidarService {

    /**
     * @param runTareaDto
     * @param tareaFaseAccion
     */
    void run(@NotNull @Valid RunTareaDto runTareaDto, @NotNull @Valid List<TareaFaseAccionDto> tareaFaseAccion);

}
