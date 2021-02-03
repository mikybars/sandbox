/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPrevalidarAntesService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.PuntoEjecucionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
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
public class RunTareaPrevalidarAntesServiceImpl implements RunTareaPrevalidarAntesService {

    @Autowired
    private RunPrevalidarFactory runPrevalidarFactory;

    @Autowired
    private AccionService accionService;

    @Autowired
    private TareaFaseAccionService tareaFaseAccionService;

    @Override
    public void run(@NotNull @Valid final RunTareaDto runTareaDto,
            @NotNull @Valid final FaseDto faseDto) {
        final TareaDto tareaDto = runTareaDto.getTarea();
        this.tareaFaseAccionService
            .findValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion(tareaDto.getId(), faseDto.getId(),
                    PuntoEjecucionEnum.ANTES.getId())
            .stream()
            .forEach(
                    a -> Flux
                        .fromIterable(
                                this.tareaFaseAccionService
                                    .findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucionAndPeso(
                                            tareaDto.getId(), faseDto.getId(), PuntoEjecucionEnum.ANTES.getId(), a))
                        .parallel()
                        .runOn(Schedulers.newElastic("async-reactor-prevalidar-antes"))
                        .map(tareaFaseAccion -> {
                            this.runPrevalidarFactory
                                .getRunPrevalidar(
                                        this.accionService.findAccionDtoById(tareaFaseAccion.getIdAccion()).getNombre())
                                .execute(runTareaDto, tareaFaseAccion);
                            return Flux.empty();
                        })
                        .sequential()
                        .collectList()
                        .block());
    }

}
