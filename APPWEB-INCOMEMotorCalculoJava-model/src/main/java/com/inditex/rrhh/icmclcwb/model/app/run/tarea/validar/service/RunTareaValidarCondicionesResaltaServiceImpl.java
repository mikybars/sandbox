/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarCondicionesResaltaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunPrevalidar;

/**
 * @author mdelrio
 *
 */
@Component("condicionesResaltaV1")
@Validated
public class RunTareaValidarCondicionesResaltaServiceImpl implements RunPrevalidar {

    @Autowired
    private TareaFaseAccionService tareaFaseAccionService;

    @Autowired
    private RunTareaAmbitoValidarCondicionesResaltaService runTareaAmbitoValidarCondicionesResaltaService;

    @Override
    public List<ValidacionDto> execute(@NotNull @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaFaseAccionDto tareaFaseAccion) {
        this.tareaFaseAccionService.updateFechaInicio(tareaFaseAccion);
        final List<ValidacionDto> validaciones = runTarea.getTarea()
            .getAmbito()
            .stream()
            .map(item -> this.runTareaAmbitoValidarCondicionesResaltaService
                .execute(runTarea, item, tareaFaseAccion))
            .collect(Collectors.toList());
        this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion, EstadoTareaFaseAccionEnum.OK.getDto());

        return validaciones;
    }

}
