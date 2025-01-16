package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrVentaEmpleadoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrVentaEmpleadoService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaRecolectarPtrVentaEmpleadoServiceImpl implements RunTareaRecolectarPtrVentaEmpleadoService {

  @Autowired
  private RunTareaAmbitoRecolectarPtrVentaEmpleadoService runTareaAmbitoRecolectarPtrVentaEmpleadoService;

  @Override
  public void ventaFisicaLocalizacionPersonaByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarPtrVentaEmpleadoService
            .ventaFisicaLocalizacionPersonaByRunTareaAndTareaAmbito(runTarea, item));
  }

}
