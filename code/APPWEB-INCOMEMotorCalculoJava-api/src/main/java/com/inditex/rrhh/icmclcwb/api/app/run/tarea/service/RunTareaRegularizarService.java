package com.inditex.rrhh.icmclcwb.api.app.run.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunTareaRegularizarService {

  void run(@NonNull @Valid RunTareaDto runTarea);

}
