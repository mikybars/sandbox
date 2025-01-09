package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrPresenciaPresupuestosService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrPresenciaPresupuestosService;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaRecolectarPtrPresenciaPresupuestosServiceImpl
    implements RunTareaRecolectarPtrPresenciaPresupuestosService {

  @Autowired
  private RunTareaAmbitoRecolectarPtrPresenciaPresupuestosService runTareaAmbitoRecolectarPtrPresenciaPresupuestosService;

  @Override
  public void presenciaEmpleadoTiendaByRunTarea(@NonNull @Valid RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> runTareaAmbitoRecolectarPtrPresenciaPresupuestosService
            .presenciaEmpleadoTiendaByRunTareaAndTareaAmbito(runTarea, item));
  }

}
