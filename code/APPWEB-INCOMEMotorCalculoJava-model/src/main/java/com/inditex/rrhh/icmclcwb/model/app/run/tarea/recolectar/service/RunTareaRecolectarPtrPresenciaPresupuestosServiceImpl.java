package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrPresenciaPresupuestosService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrPresenciaPresupuestosService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaRecolectarPtrPresenciaPresupuestosServiceImpl
    implements RunTareaRecolectarPtrPresenciaPresupuestosService {

  private final RunTareaAmbitoRecolectarPtrPresenciaPresupuestosService runTareaAmbitoRecolectarPtrPresenciaPresupuestosService;

  @Override
  public void presenciaEmpleadoTiendaByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarPtrPresenciaPresupuestosService
            .presenciaEmpleadoTiendaByRunTareaAndTareaAmbito(runTarea, item));
  }

}
