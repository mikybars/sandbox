package com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunTareaConsolidarByAmbitoLocalizacionService {

  void run(@NonNull @Valid RunTareaDto runTarea);

}
