package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrPresenciaService;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaRecolectarPtrPresenciaServiceImpl implements RunTareaRecolectarPtrPresenciaService {

  @Autowired
  private RunTareaAmbitoRecolectarPtrPresenciaService runTareaAmbitoRecolectarPtrPresenciaService;

  @Override
  public void presenciaDetalleComisionablePersonaByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarPtrPresenciaService
            .presenciaDetallePersonaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void presenciaEmpleadoTiendaByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarPtrPresenciaService
            .presenciaEmpleadoTiendaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void presenciaDetalleIncluidoCommercePersonaByRunTarea(
      @NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarPtrPresenciaService
            .presenciaDetallePersonaIncluidoEcommerceByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void presenciaDetallePersonaHorasSindicalesByRunTarea(
      @NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarPtrPresenciaService
            .presenciaDetallePersonaHorasSindicalesByRunTareaAndTareaAmbito(runTarea, item));
  }

}
