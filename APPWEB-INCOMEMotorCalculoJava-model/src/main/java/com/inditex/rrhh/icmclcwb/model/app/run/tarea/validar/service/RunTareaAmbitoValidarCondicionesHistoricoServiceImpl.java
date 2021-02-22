/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.async.service.ComisAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.async.service.PtrAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarCondicionesHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
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

    @Autowired
    private ValidacionMapper validacionMapper;

    @Autowired
    @Qualifier("historicoProperties")
    private PrevalidarPropertiesDto historicoProperties;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ValidacionDto execute(@Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito,
            @Valid final TareaFaseAccionDto tareaFaseAccion) {
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        final List<IdPersonaLocalCondicionesDto> historicoValidationResult;
        try {
            final CompletableFuture<List<IdPersonaLocalCondicionesDto>> cfCondicionesHistorico = this.comisAsyncService
                .findCondicionesHistorico(runTareaDto, tareaAmbito);
            AsyncUtils.exceptionally(cfCondicionesHistorico, cf);

            AsyncUtils.waitAllOfIsOk(cf, cf);

            final List<IdPersonaLocalCondicionesDto> condicionesHistorico = AsyncUtils.get(cfCondicionesHistorico);

            this.primaryTemporaryTableRepositoryCustom.createTempComisHistorico();
            this.primaryTemporaryTableRepositoryCustom.insertTempComisHistorico(condicionesHistorico);

            historicoValidationResult = this.primaryTemporaryTableRepositoryCustom
                .validateTempComisHistorico(runTareaDto.getTarea());

            this.primaryTemporaryTableRepositoryCustom.deleteTempComisHistorico();

        } catch (final Exception e) {
            this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
                    EstadoTareaFaseAccionEnum.ERROR.getDto());
            AsyncUtils.cancel(cf);
            throw e;
        }

        return this.validacionMapper.idPersonaLocalCondicionesDtoTovalidacionDto(tareaAmbito, tareaFaseAccion,
                historicoValidationResult);
    }

}
