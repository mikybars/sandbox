/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.async.service.Meta4AsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.MotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.Meta4Service;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

/**
 * @author mdelrio
 *
 */
@Service
public class Meta4AsyncServiceImpl implements Meta4AsyncService {

    @Autowired
    private Meta4Service meta4Service;

    @Override
    public CompletableFuture<List<MotivoDesplazamientoDto>> findMotivosDesplazamientoAux(
            @Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        return CompletableFuture
            .completedFuture(this.meta4Service.findMotivosDesplazamientoAux(runTareaDto, tareaAmbito));
    }

    @Override
    public CompletableFuture<List<MotivoDesplazamientoDto>> findMotivosDesplazamientoGlobal(
            @Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        return CompletableFuture
            .completedFuture(this.meta4Service.findMotivosDesplazamientoGlobal(runTareaDto, tareaAmbito));
    }

}
