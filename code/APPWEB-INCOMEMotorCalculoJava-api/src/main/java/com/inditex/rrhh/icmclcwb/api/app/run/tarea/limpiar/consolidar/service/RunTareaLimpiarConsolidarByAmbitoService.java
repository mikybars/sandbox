package com.inditex.rrhh.icmclcwb.api.app.run.tarea.limpiar.consolidar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface RunTareaLimpiarConsolidarByAmbitoService {

  void run(@NotNull @Valid RunTareaDto runTarea);

}
