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
import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarMotivosDesplazamientoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
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
    private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

    @Autowired
    private AccionService accionService;

    @Autowired
    private SenderTarea senderTarea;

    @Autowired
    private TareaFaseAccionService tareaFaseAccionService;

    @Autowired
    private Logger log;

    @Override
    public Boolean execute(@Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito,
            @Valid final TareaFaseAccionDto tareaFaseAccion) {
        final Boolean validacion = Boolean.TRUE;
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        try {
            this.tareaFaseAccionService.updateFechaInicio(tareaFaseAccion);
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


            if (!motivos.isEmpty()) {
                this.log.error(
                        "RunTareaAmbitoValidarMotivosDesplazamientoService :: Error validando motivos :: Items: {}",
                        motivos);
                final AccionDto accion = this.accionService.findAccionDtoById(tareaFaseAccion.getIdAccion());
                if (accion.getEsReaccionReintento()) {
                    if (accion.getEsReaccionEsperar()) {
                        this.senderTarea.sendWithDelay(runTareaDto.getTarea(), accion.getReintentoDelay());
                    }
                    this.senderTarea.send(runTareaDto.getTarea());
                }
            }

            this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion, EstadoTareaFaseAccionEnum.OK.getDto());

        } catch (final Exception e) {
            AsyncUtils.cancel(cf);
            throw e;
        }
        return validacion;
    }

}
