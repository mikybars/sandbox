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
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarCondicionesResaltaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;

/**
 * @author mdelrio
 *
 */
@Service
@Validated
public class RunTareaAmbitoValidarCondicionesResaltaServiceImpl
        implements RunTareaAmbitoValidarCondicionesResaltaService {

    @Autowired
    private ComisAsyncService comisAsyncService;

    @Autowired
    private PtrAsyncService ptrAsyncService;

    @Autowired
    private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

    @Override
    public Boolean execute(@Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito) {
        final Boolean validacion = Boolean.TRUE;
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        try {

            final CompletableFuture<List<IdPersonaLocalCondicionesDto>> cfCondicionesResalta = this.comisAsyncService
                .findCondicionesResalta(runTareaDto, tareaAmbito);
            AsyncUtils.exceptionally(cfCondicionesResalta, cf);

            AsyncUtils.waitAllOfIsOk(cf, cf);

            final List<IdPersonaLocalCondicionesDto> condicionesResalta = AsyncUtils.get(cfCondicionesResalta);

            this.primaryTemporaryTableRepositoryCustom.createTempComisResalta();
            this.primaryTemporaryTableRepositoryCustom.insertTempComisResalta(condicionesResalta);

            final List<IdPersonaLocalCondicionesDto> resaltaValidationResult = this.primaryTemporaryTableRepositoryCustom
                .validateTempComisResalta(runTareaDto.getTarea());

            this.primaryTemporaryTableRepositoryCustom.deleteTempComisResalta();
        } catch (final Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
        return validacion;
    }

}
