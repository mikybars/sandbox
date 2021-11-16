package com.inditex.rrhh.icmclcwb.api.app.run.tarea.service;

/*
 * Copyright (c) 2021. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface RunTareaNormalizarService {

  void run(@NotNull @Valid final RunTareaDto runTarea);

}
