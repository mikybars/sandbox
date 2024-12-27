package com.inditex.rrhh.icmclcwb.api.app.run.tarea.service;

/*
 * Copyright (c) 2021. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunTareaNormalizarService {

  void run(@NonNull @Valid final RunTareaDto runTarea);

}
