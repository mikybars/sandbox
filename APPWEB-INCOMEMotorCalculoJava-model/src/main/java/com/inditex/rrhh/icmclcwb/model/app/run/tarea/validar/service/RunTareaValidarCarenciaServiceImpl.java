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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarCarenciaService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunPrevalidar;

/**
 * @author mdelrio
 *
 */
@Component("validarCarenciaV1")
@Validated
public class RunTareaValidarCarenciaServiceImpl implements RunPrevalidar {

    @Autowired
    private RunTareaAmbitoValidarCarenciaService runTareaAmbitoValidarCarenciaService;

    @Override
    public void execute(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea()
            .getAmbito()
            .stream()
            .forEach(item -> this.runTareaAmbitoValidarCarenciaService
                .execute(runTarea, item));
    }

}
