/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.app.run.tarea.normalizar.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import javax.validation.Valid;

public interface RunTareaNormalizarAjusteComisionService {

  void normalizarAjusteComision(@Valid final TareaDto tarea);

}
