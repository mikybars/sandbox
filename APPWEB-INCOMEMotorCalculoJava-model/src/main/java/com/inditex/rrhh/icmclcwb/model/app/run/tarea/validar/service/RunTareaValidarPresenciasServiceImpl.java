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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarPresenciasService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunPrevalidar;

/**
 * @author mdelrio
 *
 */
@Component("presenciasV1")
@Validated
public class RunTareaValidarPresenciasServiceImpl implements RunPrevalidar {

    @Autowired
    private RunTareaAmbitoValidarPresenciasService runTareaAmbitoValidarPresenciasService;

    @Override
    public void execute(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea()
            .getAmbito()
            .stream()
            .forEach(item -> this.runTareaAmbitoValidarPresenciasService
                .execute(runTarea, item));
    }

}
