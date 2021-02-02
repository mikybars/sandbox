/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPrevalidarService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunPrevalidarFactory;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * @author mdelrio
 *
 */
@Service
@Validated
public class RunTareaPrevalidarServiceImpl implements RunTareaPrevalidarService {

    @Autowired
    private RunPrevalidarFactory runPrevalidarFactory;

    @Autowired
    private AccionService accionService;

    @Override
    public void run(@NotNull @Valid final RunTareaDto runTareaDto,
            @NotNull @Valid final List<TareaFaseAccionDto> tareaFaseAccionDto) {

        Flux.fromIterable(tareaFaseAccionDto)
            .parallel()
            .runOn(Schedulers.newElastic("async-reactor-prevalidar"))
            .map(tareaFaseAccion -> {
                this.runPrevalidarFactory
                    .getRunPrevalidar(this.accionService.findAccionDtoById(tareaFaseAccion.getIdAccion()).getNombre())
                    .execute(runTareaDto);
                return Flux.empty();
            })
            .sequential()
            .collectList()
            .block();
    }

}
