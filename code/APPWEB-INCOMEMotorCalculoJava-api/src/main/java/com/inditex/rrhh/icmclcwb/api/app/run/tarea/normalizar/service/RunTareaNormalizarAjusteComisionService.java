package com.inditex.rrhh.icmclcwb.api.app.run.tarea.normalizar.service;

/*
 * Copyright (c) 2021. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.Valid;

public interface RunTareaNormalizarAjusteComisionService {

  void normalizarAjusteComision(@Valid final TareaDto tarea);

}
