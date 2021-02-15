/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPrevalidarDuranteService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.PuntoEjecucionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunPrevalidarFactory;
import com.inditex.rrhh.icmclcwb.ms.app.tarea.SenderTarea;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * @author mdelrio
 *
 */
@Service
@Validated
public class RunTareaPrevalidarDuranteServiceImpl implements RunTareaPrevalidarDuranteService {

    @Autowired
    private RunPrevalidarFactory runPrevalidarFactory;

    @Autowired
    private AccionService accionService;

    @Autowired
    private TareaFaseAccionService tareaFaseAccionService;

    @Autowired
    private TareaFaseService tareaFaseService;

    @Autowired
    private SenderTarea senderTarea;

    @Override
    public void run(@NotNull @Valid final RunTareaDto runTareaDto,
            @NotNull @Valid final FaseDto faseDto,
            @NotNull @Valid final AccionDto accionDto) {
        final TareaDto tareaDto = runTareaDto.getTarea();
        final List<ValidacionDto> validaciones = this.tareaFaseAccionService
            .findValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion(tareaDto.getId(), faseDto.getId(),
                    PuntoEjecucionEnum.DURANTE.getId())
            .stream()
            .map(a -> Flux
                .fromIterable(
                        this.tareaFaseAccionService
                            .findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucionAndPeso(
                                    tareaDto.getId(), faseDto.getId(), accionDto.getId(),
                                    PuntoEjecucionEnum.DURANTE.getId(), a))
                .parallel()
                .runOn(Schedulers.newElastic("async-reactor-prevalidar-durante"))
                .map(tareaFaseAccion -> {
                    return this.runPrevalidarFactory
                        .getRunPrevalidar(
                                this.accionService.findAccionDtoById(tareaFaseAccion.getIdAccion()).getNombre())
                        .execute(runTareaDto, tareaFaseAccion);
                })
                .sequential()
                .collectList()
                .block())
            .flatMap(List::stream)
            .flatMap(List::stream)
            .collect(Collectors.toList());

        validaciones.stream()
            .filter(e -> Boolean.FALSE.equals(e.getResult()))
            .forEach(e -> {
                final TareaFaseAccionDto tareaFaseAccion = this.tareaFaseAccionService
                    .findById(e.getIdTareaFaseAccion());
                final TareaFaseDto tareaFase = this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(
                        runTareaDto.getTarea().getId(), faseDto.getId());
                this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
                        EstadoTareaFaseAccionEnum.KO.getDto());
                this.tareaFaseService.updateFechaFinAndEstado(tareaFase,
                        EstadoTareaFaseEnum.KO.getDto());
                final AccionDto accion = this.accionService
                    .findAccionDtoById(tareaFaseAccion.getIdAccion());
                if (Boolean.TRUE.equals(accion.getEsReaccionReintento()) && (this.tareaFaseAccionService
                    .countReintentosByIdTareaAndIdAccionAndIdEstado(
                            tareaFaseAccion, tareaFase) < accion.getReintentoMax())) {
                    if (Boolean.TRUE.equals(accion.getEsReaccionEsperar())) {
                        this.senderTarea.sendWithDelay(runTareaDto.getTarea(),
                                accion.getReintentoDelay());
                    } else {
                        this.senderTarea.send(runTareaDto.getTarea());
                    }
                }
                this.tareaFaseAccionService.updateFechaInicioAndFechaFinAndEstadoAndActivoByIdTareaFaseAndEstadoActual(
                        tareaFase,
                        EstadoTareaFaseAccionEnum.PENDIENTE.getDto(),
                        EstadoTareaFaseAccionEnum.NO_EJECUTADA.getDto());
                this.tareaFaseService.updateFechaInicioAndFechaFinAndEstadoByIdTareaAndEstadoActual(
                        runTareaDto.getTarea(),
                        EstadoTareaFaseEnum.PENDIENTE.getDto(),
                        EstadoTareaFaseEnum.NO_EJECUTADA.getDto());
                this.tareaFaseService.updateActivo(runTareaDto);
                throw new ValidationException("Error validando");
            });

    }

}
