/**
 *
 */
package com.inditex.rrhh.icmclcwb.api.app.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

/**
 * @author mdelrio
 *
 */
@Async
public interface PtrAsyncService {

    /**
     * @param runTareaDto
     * @param tareaAmbito
     * @return
     */
    CompletableFuture<PresenciaOrigenDto> findPresenciasOrigenAndFecha(@Valid RunTareaDto runTareaDto,
            @Valid TareaAmbitoDto tareaAmbito);

    /**
     * @param runTareaDto
     * @param tareaAmbito
     * @return
     */
    CompletableFuture<PresenciaOrigenDto> findPresenciasOrigenAndFechaEs(@Valid RunTareaDto runTareaDto,
            @Valid TareaAmbitoDto tareaAmbito);

}
