package com.inditex.rrhh.icmclcwb.api.app.run.tarea.limpiar.consolidar.ambito.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunTareaAmbitoLimpiarConsolidarByAmbitoService {

  void run(@NonNull @Valid RunTareaDto runTarea, @NonNull @Valid TareaAmbitoDto tareaAmbitoDto);

}
