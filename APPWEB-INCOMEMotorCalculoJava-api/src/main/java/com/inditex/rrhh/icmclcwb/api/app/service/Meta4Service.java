/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.MotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

/**
 * @author mdelrio
 *
 */
public interface Meta4Service {

    /**
     * @param runTareaDto
     * @param tareaAmbito
     * @return
     */
    List<MotivoDesplazamientoDto> findMotivosDesplazamientoAux(RunTareaDto runTareaDto,
            @Valid TareaAmbitoDto tareaAmbito);

    /**
     * @param runTareaDto
     * @param tareaAmbito
     * @return
     */
    List<MotivoDesplazamientoDto> findMotivosDesplazamientoGlobal(RunTareaDto runTareaDto,
            @Valid TareaAmbitoDto tareaAmbito);

}
