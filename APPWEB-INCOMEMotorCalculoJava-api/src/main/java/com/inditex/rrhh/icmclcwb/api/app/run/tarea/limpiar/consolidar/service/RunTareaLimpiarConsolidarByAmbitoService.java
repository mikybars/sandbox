package com.inditex.rrhh.icmclcwb.api.app.run.tarea.limpiar.consolidar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface RunTareaLimpiarConsolidarByAmbitoService {

  void run(@NotNull @Valid RunTareaDto runTarea);

}
