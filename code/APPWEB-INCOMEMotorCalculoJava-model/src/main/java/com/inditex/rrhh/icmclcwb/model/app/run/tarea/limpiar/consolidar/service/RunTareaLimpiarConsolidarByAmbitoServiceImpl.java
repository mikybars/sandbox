package com.inditex.rrhh.icmclcwb.model.app.run.tarea.limpiar.consolidar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.limpiar.consolidar.ambito.service.RunTareaAmbitoLimpiarConsolidarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.limpiar.consolidar.service.RunTareaLimpiarConsolidarByAmbitoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaLimpiarConsolidarByAmbitoServiceImpl implements RunTareaLimpiarConsolidarByAmbitoService {

  private final RunTareaAmbitoLimpiarConsolidarByAmbitoService runTareaAmbitoLimpiarConsolidarByAmbitoService;

  @Override
  public void run(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoLimpiarConsolidarByAmbitoService
            .run(runTarea, item));
  }

}
