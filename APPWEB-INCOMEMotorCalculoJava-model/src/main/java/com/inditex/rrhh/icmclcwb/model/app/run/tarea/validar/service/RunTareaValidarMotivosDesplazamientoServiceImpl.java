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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarMotivosDesplazamientoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaValidarMotivosDesplazamientoService;

/**
 * @author mdelrio
 *
 */
@Service
@Validated
public class RunTareaValidarMotivosDesplazamientoServiceImpl implements RunTareaValidarMotivosDesplazamientoService {

    @Autowired
    private RunTareaAmbitoValidarMotivosDesplazamientoService runTareaAmbitoValidarMotivosDesplazamientoService;

    @Override
    public void validarMotivosDesplazamiento(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea()
            .getAmbito()
            .stream()
            .forEach(item -> this.runTareaAmbitoValidarMotivosDesplazamientoService
                .validarMotivosDesplazamiento(runTarea, item));
    }

}
