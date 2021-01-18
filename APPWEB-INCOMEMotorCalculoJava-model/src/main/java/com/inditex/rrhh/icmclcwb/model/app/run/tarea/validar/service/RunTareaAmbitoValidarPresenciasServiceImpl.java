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
import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarPresenciasService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

/**
 * @author mdelrio
 *
 */
@Service
@Validated
public class RunTareaAmbitoValidarPresenciasServiceImpl implements RunTareaAmbitoValidarPresenciasService {

    @Autowired
    private ComisAsyncService comisAsyncService;

    @Autowired
    private PtrAsyncService ptrAsyncService;

    @Override
    public Boolean validarPresenciasAmbito(@Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        Boolean validacion = Boolean.TRUE;
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final CompletableFuture<PresenciaOrigenDto> cfPresenciaComis = this.comisAsyncService
                .findPresenciasOrigenAndFecha(runTareaDto, tareaAmbito);
            AsyncUtils.exceptionally(cfPresenciaComis, cf);

            final CompletableFuture<PresenciaOrigenDto> cfPresenciaPtr = this.ptrAsyncService
                .findPresenciasOrigenAndFecha(runTareaDto, tareaAmbito);
            AsyncUtils.exceptionally(cfPresenciaPtr, cf);

            AsyncUtils.waitAllOfIsOk(cf, cf);

            final PresenciaOrigenDto presenciaComis = AsyncUtils.get(cfPresenciaComis);
            final PresenciaOrigenDto presenciaPtr = AsyncUtils.get(cfPresenciaPtr);

            validacion = presenciaComis.getHorasSeccion4().equals(presenciaPtr.getHorasSeccion4());
        } catch (final Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
        return validacion;
    }

}
