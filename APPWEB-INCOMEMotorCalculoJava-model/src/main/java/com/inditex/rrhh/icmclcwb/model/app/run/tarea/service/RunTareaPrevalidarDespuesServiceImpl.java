/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPrevalidarDespuesService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.PuntoEjecucionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunPrevalidarFactory;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * @author mdelrio
 *
 */
@Service
@Validated
public class RunTareaPrevalidarDespuesServiceImpl implements RunTareaPrevalidarDespuesService {

    @Autowired
    private RunPrevalidarFactory runPrevalidarFactory;

    @Autowired
    private AccionService accionService;

    @Autowired
    private TareaFaseAccionService tareaFaseAccionService;

    @Override
    public List<ValidacionDto> run(@NotNull @Valid final RunTareaDto runTareaDto,
            @NotNull @Valid final FaseDto faseDto) {
        final TareaDto tareaDto = runTareaDto.getTarea();
        final Map<Integer, List<TareaFaseAccionDto>> fases = this.tareaFaseAccionService
            .findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(tareaDto.getId(), faseDto.getId(),
                    PuntoEjecucionEnum.DESPUES.getId())
            .stream()
            .sorted(Comparator.comparingInt(TareaFaseAccionDto::getPeso)
                .reversed())
            .collect(Collectors.groupingBy(TareaFaseAccionDto::getPeso));

        return fases.keySet()
            .stream()
            .map(peso -> Flux
                .fromIterable(fases.get(peso))
                .parallel()
                .runOn(Schedulers.newElastic("async-reactor-prevalidar-despues"))
                .map(tareaFaseAccion -> {
                    return this.runPrevalidarFactory
                        .getRunPrevalidar(
                                this.accionService.findAccionDtoById(tareaFaseAccion.getIdAccion()).getNombre())
                        .execute(runTareaDto, tareaFaseAccion);
                })
                .sequential()
                .collectList()
                .block()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toList()))
            .flatMap(List::stream)
            .collect(Collectors.toList());

    }

}
