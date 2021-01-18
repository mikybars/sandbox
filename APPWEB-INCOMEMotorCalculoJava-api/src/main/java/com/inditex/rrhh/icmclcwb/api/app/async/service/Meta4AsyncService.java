/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.dto.MotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

/**
 * @author mdelrio
 *
 */
@Async
public interface Meta4AsyncService {

    /**
     * @param runTareaDto
     * @param tareaAmbito
     * @return
     */
    CompletableFuture<List<MotivoDesplazamientoDto>> findMotivosDesplazamientoAux(@Valid RunTareaDto runTareaDto,
            @Valid TareaAmbitoDto tareaAmbito);

    /**
     * @param runTareaDto
     * @param tareaAmbito
     * @return
     */
    CompletableFuture<List<MotivoDesplazamientoDto>> findMotivosDesplazamientoGlobal(@Valid RunTareaDto runTareaDto,
            @Valid TareaAmbitoDto tareaAmbito);

}
