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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarBajaItService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;

/**
 * @author mdelrio
 *
 */
@Service
@Validated
public class RunTareaAmbitoValidarBajaItServiceImpl
        implements RunTareaAmbitoValidarBajaItService {

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
            final CompletableFuture<List<IdPersonaLocalCondicionesDto>> cfBajasIt = this.comisAsyncService
                .findBajasIt(runTareaDto, tareaAmbito);
            AsyncUtils.exceptionally(cfBajasIt, cf);

            AsyncUtils.waitAllOfIsOk(cf, cf);

            final List<IdPersonaLocalCondicionesDto> bajasIt = AsyncUtils.get(cfBajasIt);

            this.primaryTemporaryTableRepositoryCustom.createTempComisBajaIt();
            this.primaryTemporaryTableRepositoryCustom.insertTempComisBajaIt(bajasIt);

            final List<IdPersonaLocalCondicionesDto> bajaItValidationResult = this.primaryTemporaryTableRepositoryCustom
                .validateTempComisBajaIt();

            this.primaryTemporaryTableRepositoryCustom.deleteTempComisBajaIt();
        } catch (final Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
        return validacion;
    }

}
