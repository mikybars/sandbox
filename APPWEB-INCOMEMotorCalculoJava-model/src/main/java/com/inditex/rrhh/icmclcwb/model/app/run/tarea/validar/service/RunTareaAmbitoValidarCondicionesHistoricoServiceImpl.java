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
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarCondicionesHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;

/**
 * @author mdelrio
 *
 */
@Service
@Validated
public class RunTareaAmbitoValidarCondicionesHistoricoServiceImpl
        implements RunTareaAmbitoValidarCondicionesHistoricoService {

    @Autowired
    private ComisAsyncService comisAsyncService;

    @Autowired
    private TareaFaseAccionService tareaFaseAccionService;

    @Autowired
    private PtrAsyncService ptrAsyncService;

    @Autowired
    private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

    @Override
    public ValidacionDto execute(@Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito,
            @Valid final TareaFaseAccionDto tareaFaseAccion) {
        final Boolean validacion = Boolean.TRUE;
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final CompletableFuture<List<IdPersonaLocalCondicionesDto>> cfCondicionesHistorico = this.comisAsyncService
                .findCondicionesHistorico(runTareaDto, tareaAmbito);
            AsyncUtils.exceptionally(cfCondicionesHistorico, cf);

            AsyncUtils.waitAllOfIsOk(cf, cf);

            final List<IdPersonaLocalCondicionesDto> condicionesHistorico = AsyncUtils.get(cfCondicionesHistorico);

            this.primaryTemporaryTableRepositoryCustom.createTempComisHistorico();
            this.primaryTemporaryTableRepositoryCustom.insertTempComisHistorico(condicionesHistorico);

            final List<IdPersonaLocalCondicionesDto> historicoValidationResult = this.primaryTemporaryTableRepositoryCustom
                .validateTempComisHistorico(runTareaDto.getTarea());

            this.primaryTemporaryTableRepositoryCustom.deleteTempComisHistorico();

        } catch (final Exception e) {
            this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
                    EstadoTareaFaseAccionEnum.ERROR.getDto());
            AsyncUtils.cancel(cf);
            throw e;
        }
        return ValidacionDto.builder().result(validacion).idTareaFaseAccion(tareaFaseAccion.getId()).build();
    }

}
