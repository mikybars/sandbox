package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrVentaGeneralService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrVentaGeneralService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaRecolectarPtrVentaGeneralServiceImpl implements RunTareaRecolectarPtrVentaGeneralService {

  private final RunTareaAmbitoRecolectarPtrVentaGeneralService runTareaAmbitoRecolectarPtrVentaGeneralService;

  @Override
  public void ventaFisicaLocalizacionSeccionByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarPtrVentaGeneralService
            .ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaFisicaCadenaByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarPtrVentaGeneralService
            .ventaFisicaCadenaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaRangoFisicaLocalizacionSeccionByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarPtrVentaGeneralService
            .ventaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void devolucionRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(
      @NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarPtrVentaGeneralService
            .devolucionRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void devolucionVentaOriginalOtraTiendaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(
      @NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarPtrVentaGeneralService
            .devolucionVentaOriginalOtraTiendaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea,
                item));
  }

  @Override
  public void ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaAndTareaAmbito(
      @NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarPtrVentaGeneralService
            .ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaAndTareaAmbito(runTarea, item));
  }

}
