/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.app.run.tarea.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

/**
 * @author javierev
 */
public interface RunTareaNormalizarService {

    void run(@NotNull @Valid final RunTareaDto runTarea);

}
