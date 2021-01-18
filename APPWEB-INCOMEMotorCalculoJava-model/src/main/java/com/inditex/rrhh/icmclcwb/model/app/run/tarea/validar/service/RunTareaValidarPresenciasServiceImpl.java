/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarPresenciasService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaValidarPresenciasService;

/**
 * @author mdelrio
 *
 */
@Service
@Validated
public class RunTareaValidarPresenciasServiceImpl implements RunTareaValidarPresenciasService {

    @Autowired
    private RunTareaAmbitoValidarPresenciasService runTareaAmbitoValidarPresenciasService;

    @Override
    public void validarPresencias(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea()
            .getAmbito()
            .stream()
            .forEach(item -> this.runTareaAmbitoValidarPresenciasService
                .validarPresenciasAmbito(runTarea, item));
    }

}
