/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.async.service.ComisAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.MotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarMotivosDesplazamientoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

/**
 * @author mdelrio
 *
 */
@Service
@Validated
public class RunTareaAmbitoValidarMotivosDesplazamientoServiceImpl
        implements RunTareaAmbitoValidarMotivosDesplazamientoService {

    @Autowired
    private ComisAsyncService comisAsyncService;

    @Override
    public Boolean validarMotivosDesplazamiento(@Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        final Boolean validacion = Boolean.TRUE;
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final CompletableFuture<List<MotivoDesplazamientoDto>> cfMotivoDesplazamiento = this.comisAsyncService
                .findMotivoDesplazamiento(runTareaDto, tareaAmbito);
            AsyncUtils.exceptionally(cfMotivoDesplazamiento, cf);

            AsyncUtils.waitAllOfIsOk(cf, cf);

            final List<MotivoDesplazamientoDto> motivosSil = AsyncUtils.get(cfMotivoDesplazamiento);

            // validacion = motivosMeta4Aux.containsAll(motivosSil);
            // validacion = motivosMeta4Global.containsAll(motivosSil);

        } catch (final Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
        return validacion;
    }

}
