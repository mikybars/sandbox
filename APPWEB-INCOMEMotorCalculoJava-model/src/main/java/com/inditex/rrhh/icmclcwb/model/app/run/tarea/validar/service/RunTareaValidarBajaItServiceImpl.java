/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarBajaItService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunPrevalidar;

/**
 * @author mdelrio
 *
 */
@Component("validarBajaItV1")
@Validated
public class RunTareaValidarBajaItServiceImpl implements RunPrevalidar {

    @Autowired
    private RunTareaAmbitoValidarBajaItService runTareaAmbitoValidarBajaItService;

    @Override
    public void execute(@NotNull @Valid final RunTareaDto runTarea,
            @NotNull @Valid final TareaFaseAccionDto tareaFaseAccion) {
        runTarea.getTarea()
            .getAmbito()
            .stream()
            .forEach(item -> this.runTareaAmbitoValidarBajaItService
                .execute(runTarea, item, tareaFaseAccion));
    }

}
