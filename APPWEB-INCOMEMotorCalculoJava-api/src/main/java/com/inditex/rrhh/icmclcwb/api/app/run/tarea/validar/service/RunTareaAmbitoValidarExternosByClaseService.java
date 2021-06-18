/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;

public interface RunTareaAmbitoValidarExternosByClaseService {

    ValidacionDto execute(@Valid RunTareaDto runTarea, @Valid TareaAmbitoDto tareaAmbito,
            @Valid final TareaFaseAccionDto tareaFaseAccion);

}
