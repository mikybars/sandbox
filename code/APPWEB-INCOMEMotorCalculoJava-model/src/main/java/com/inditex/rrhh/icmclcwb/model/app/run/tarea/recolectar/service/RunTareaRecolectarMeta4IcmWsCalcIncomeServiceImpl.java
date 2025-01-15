package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarMeta4IcmWsCalcIncomeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaRecolectarMeta4IcmWsCalcIncomeServiceImpl
    implements RunTareaRecolectarMeta4IcmWsCalcIncomeService {

  private final RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService;

  @Override
  public void fechaAmbitoAndEmpresaByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .fechaAmbitoAndEmpresaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void personaByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .personaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void localizacionByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .localizacionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void empleadosPresenciaByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .empleadosPresenciaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void coefJornadaByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .coefJornadaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void flagCalculaByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .flagCalculaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void presenciaManualByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .presenciaManualByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void presenciaManualLocalizacionByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .presenciaManualWlocByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaManualLocalizacionByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .ventaManualWlocByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void estructurasComByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .estructurasComByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void estructurasPolByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .estructurasPolByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void tiendasComisionableByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .tiendasComisionableByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void configuracionVentaOnlineByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .configuracionVentaOnlineByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void agrupacionesCadenaByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .agrupacionesCadenaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void localizacionesOnlineByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .localizacionesOnlineByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void empleadosDesplazamientoByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .empleadosDesplazamientoByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ausenciasByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .ausenciasByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void configuraciones(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .configuracionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void confChallengeDiasMinimosByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .confChallengeDiasMinimosByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void presupuestosWlocByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .presupuestosWlocByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void confPrecioHoraByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .confPrecioHoraByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void confChallengeTipoVentaByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .confChallengeTipoVentaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void presupuestosRangoByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .presupuestosRangoByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaCongeladaByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .ventaCongeladaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void desplazamientoRealByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .desplazamientoRealByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void localizacionCadenaByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .localizacionCadenaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void estructurasPolCadenaByRunTarea(
      @NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .estructurasPolCadenaByRunTareaAndAmbito(runTarea, item));
  }

  @Override
  public void empleadosCadenaByRunTarea(
      @NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .empleadosCadenaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void tiposHoraByRunTarea(
      @NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .tiposHoraByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void estadoWlocByRunTarea(
      @NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .estadoWlocByRunTareaAndTareaAmbito(runTarea, item));
  }
}
