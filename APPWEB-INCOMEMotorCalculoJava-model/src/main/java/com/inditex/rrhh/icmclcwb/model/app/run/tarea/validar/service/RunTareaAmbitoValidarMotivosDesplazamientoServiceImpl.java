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
import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarMotivosDesplazamientoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;
import com.inditex.rrhh.icmclcwb.ms.app.tarea.SenderTarea;
import org.slf4j.Logger;

/**
 * @author mdelrio
 *
 */
@Validated
@Service
public class RunTareaAmbitoValidarMotivosDesplazamientoServiceImpl
        implements RunTareaAmbitoValidarMotivosDesplazamientoService {

    @Autowired
    private ComisAsyncService comisAsyncService;

    @Autowired
    private TareaFaseAccionService tareaFaseAccionService;

    @Autowired
    private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

    @Autowired
    @Qualifier("motivosProperties")
    private PrevalidarPropertiesDto motivosProperties;

    @Autowired
    private AccionService accionService;

    @Autowired
    private SenderTarea senderTarea;

    @Autowired
    private Logger log;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ValidacionDto execute(@Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito,
            @Valid final TareaFaseAccionDto tareaFaseAccion) {
        final Boolean validacion = Boolean.TRUE;
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            final CompletableFuture<List<IdMotivoDesplazamientoDto>> cfMotivoDesplazamiento = this.comisAsyncService
                .findMotivoDesplazamiento(runTareaDto, tareaAmbito);
            AsyncUtils.exceptionally(cfMotivoDesplazamiento, cf);

            AsyncUtils.waitAllOfIsOk(cf, cf);

            final List<IdMotivoDesplazamientoDto> motivosSil = AsyncUtils.get(cfMotivoDesplazamiento);

            this.primaryTemporaryTableRepositoryCustom.createTempMotivoDesplazamientoComis();
            this.primaryTemporaryTableRepositoryCustom.createTempMotivoDesplazamientoMeta4();

            this.primaryTemporaryTableRepositoryCustom.insertTempMotivoDesplazamientoComis(motivosSil);
            // this.primaryTemporaryTableRepositoryCustom.insertTempMotivoDesplazamientoMeta4(motivosmeta4);

            final List<IdMotivoDesplazamientoDto> motivos = this.primaryTemporaryTableRepositoryCustom
                .validateTempMotivoDesplazamiento();

            this.primaryTemporaryTableRepositoryCustom.deleteTempMotivoDesplazamientoComis();
            this.primaryTemporaryTableRepositoryCustom.deleteTempMotivoDesplazamientoMeta4();


        } catch (final Exception e) {
            this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
                    EstadoTareaFaseAccionEnum.ERROR.getDto());
            AsyncUtils.cancel(cf);
            throw e;
        }
        return ValidacionDto.builder()
            .result(validacion)
            .idTareaFaseAccion(tareaFaseAccion.getId())
            .reaccionPeso(tareaFaseAccion.getReaccionPeso())
            .build();
    }

}
