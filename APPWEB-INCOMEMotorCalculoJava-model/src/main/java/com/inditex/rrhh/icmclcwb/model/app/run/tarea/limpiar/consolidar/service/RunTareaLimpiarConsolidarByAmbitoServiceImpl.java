package com.inditex.rrhh.icmclcwb.model.app.run.tarea.limpiar.consolidar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.limpiar.consolidar.ambito.service.RunTareaAmbitoLimpiarConsolidarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.limpiar.consolidar.service.RunTareaLimpiarConsolidarByAmbitoService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaLimpiarConsolidarByAmbitoServiceImpl implements RunTareaLimpiarConsolidarByAmbitoService {

  @Autowired
  private RunTareaAmbitoLimpiarConsolidarByAmbitoService runTareaAmbitoLimpiarConsolidarByAmbitoService;

  @Override
  public void run(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoLimpiarConsolidarByAmbitoService
            .run(runTarea, item));
  }

}
