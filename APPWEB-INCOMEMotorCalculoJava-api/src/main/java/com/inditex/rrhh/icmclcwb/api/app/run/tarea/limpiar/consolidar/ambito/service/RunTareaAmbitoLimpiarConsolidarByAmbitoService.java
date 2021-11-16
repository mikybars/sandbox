package com.inditex.rrhh.icmclcwb.api.app.run.tarea.limpiar.consolidar.ambito.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface RunTareaAmbitoLimpiarConsolidarByAmbitoService {

  void run(@NotNull @Valid RunTareaDto runTarea, @NotNull @Valid TareaAmbitoDto tareaAmbitoDto);

}
