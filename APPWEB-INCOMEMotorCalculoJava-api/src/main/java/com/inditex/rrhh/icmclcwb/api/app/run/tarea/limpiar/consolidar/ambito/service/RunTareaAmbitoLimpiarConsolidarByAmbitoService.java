/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.run.tarea.limpiar.consolidar.ambito.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

/**
 * @author mdelrio
 *
 */
public interface RunTareaAmbitoLimpiarConsolidarByAmbitoService {

    void run(@NotNull @Valid RunTareaDto runTarea, @NotNull @Valid TareaAmbitoDto tareaAmbitoDto);

}
