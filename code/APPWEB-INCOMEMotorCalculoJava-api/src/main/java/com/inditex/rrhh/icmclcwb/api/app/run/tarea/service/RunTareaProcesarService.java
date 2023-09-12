package com.inditex.rrhh.icmclcwb.api.app.run.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface RunTareaProcesarService {

  void run(@NotNull @Valid final RunTareaDto runTarea);

}
