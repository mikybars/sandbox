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
import com.inditex.rrhh.icmclcwb.api.app.async.service.PtrAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarCondicionesService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

/**
 * @author mdelrio
 *
 */
@Service
@Validated
public class RunTareaAmbitoValidarCondicionesServiceImpl implements RunTareaAmbitoValidarCondicionesService {

    @Autowired
    private ComisAsyncService comisAsyncService;

    @Autowired
    private PtrAsyncService ptrAsyncService;

    @Override
    public Boolean validarCondicionesAmbito(@Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        final Boolean validacion = Boolean.TRUE;
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final CompletableFuture<List<IdPersonaLocalCondicionesDto>> cfCondicionesHistorico = this.comisAsyncService
                .findCondicionesHistorico(runTareaDto, tareaAmbito);
            AsyncUtils.exceptionally(cfCondicionesHistorico, cf);

            final CompletableFuture<List<IdPersonaLocalCondicionesDto>> cfCondicionesDesplazamiento = this.comisAsyncService
                .findCondicionesDesplazamiento(runTareaDto, tareaAmbito);
            AsyncUtils.exceptionally(cfCondicionesDesplazamiento, cf);

            final CompletableFuture<List<IdPersonaLocalCondicionesDto>> cfCondicionesResalta = this.comisAsyncService
                .findCondicionesResalta(runTareaDto, tareaAmbito);
            AsyncUtils.exceptionally(cfCondicionesResalta, cf);

            final CompletableFuture<List<IdPersonaLocalCondicionesDto>> cfBajasIt = this.comisAsyncService
                .findBajasIt(runTareaDto, tareaAmbito);
            AsyncUtils.exceptionally(cfCondicionesResalta, cf);

            final CompletableFuture<List<IdPersonaLocalCarenciaDto>> cfCarencia = this.comisAsyncService
                .findCarencia(runTareaDto, tareaAmbito);
            AsyncUtils.exceptionally(cfCarencia, cf);

            AsyncUtils.waitAllOfIsOk(cf, cf);

            final List<IdPersonaLocalCondicionesDto> condicionesHistorico = AsyncUtils.get(cfCondicionesHistorico);
            final List<IdPersonaLocalCondicionesDto> condicionesDesplazamiento = AsyncUtils
                .get(cfCondicionesDesplazamiento);
            final List<IdPersonaLocalCondicionesDto> condicionesResalta = AsyncUtils.get(cfCondicionesResalta);
            final List<IdPersonaLocalCondicionesDto> bajasIt = AsyncUtils.get(cfBajasIt);
            final List<IdPersonaLocalCarenciaDto> carencia = AsyncUtils.get(cfCarencia);


        } catch (final Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
        return validacion;
    }

}
