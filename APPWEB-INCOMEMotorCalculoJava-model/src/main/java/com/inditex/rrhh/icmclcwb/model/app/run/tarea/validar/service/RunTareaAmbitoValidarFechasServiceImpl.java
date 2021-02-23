/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.time.LocalDate;
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
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarFechasPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarFechasService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.util.AsyncUtils;

/**
 * @author mdelrio
 *
 */
@Service
@Validated
public class RunTareaAmbitoValidarFechasServiceImpl implements RunTareaAmbitoValidarFechasService {

    @Autowired
    private ComisAsyncService comisAsyncService;

    @Autowired
    private TareaFaseAccionService tareaFaseAccionService;

    @Autowired
    private ValidacionMapper validacionMapper;

    @Autowired
    @Qualifier("fechasProperties")
    private PrevalidarFechasPropertiesDto fechasProperties;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ValidacionDto execute(@Valid final RunTareaDto runTareaDto,
            @Valid final TareaAmbitoDto tareaAmbito,
            @Valid final TareaFaseAccionDto tareaFaseAccion) {
        final List<CompletableFuture<?>> cf = new ArrayList<>();
        final List<IdPersonaLocalFechaIncidenciaDto> incidencias = new ArrayList<>();
        try {

            // Se comprueba desde x meses antes del período del cálculo
            final LocalDate fechaInicio = runTareaDto.getTarea()
                .getFechaInicioPeriodo()
                .minusMonths(this.fechasProperties.getSincronizacion().getMeses());
            final CompletableFuture<List<IdPersonaLocalFechaIncidenciaDto>> cfIncidencias = this.comisAsyncService
                .findFechasIncidencias(fechaInicio, tareaAmbito);
            AsyncUtils.exceptionally(cfIncidencias, cf);

            final CompletableFuture<List<IdPersonaLocalFechaIncidenciaDto>> cfDesplazamientos = this.comisAsyncService
                .findFechasDesplazamientos(fechaInicio, tareaAmbito);

            AsyncUtils.exceptionally(cfDesplazamientos, cf);

            AsyncUtils.waitAllOfIsOk(cf, cf);
            incidencias.addAll(AsyncUtils.get(cfIncidencias));
            incidencias.addAll(AsyncUtils.get(cfDesplazamientos));

        } catch (final Exception e) {
            this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
                    EstadoTareaFaseAccionEnum.ERROR.getDto());
            AsyncUtils.cancel(cf);
            throw e;
        }
        return this.validacionMapper.idPersonaLocalFechaIncidenciaDtoToValidacionDto(tareaAmbito, tareaFaseAccion,
                incidencias);
    }

}
