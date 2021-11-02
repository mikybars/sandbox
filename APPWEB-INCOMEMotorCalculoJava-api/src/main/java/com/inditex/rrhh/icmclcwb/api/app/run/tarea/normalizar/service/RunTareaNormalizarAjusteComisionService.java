/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.app.run.tarea.normalizar.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

/**
 * @author javierev
 */
public interface RunTareaNormalizarAjusteComisionService {

    void normalizarAjusteComision(@Valid final TareaDto tarea);

}
