package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarMeta4IcmWsCalcIncomeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaRecolectarMeta4IcmWsCalcIncomeServiceImpl
    implements RunTareaRecolectarMeta4IcmWsCalcIncomeService {

  @Autowired
  private RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService;

  @Override
  public void fechaAmbitoAndEmpresaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .fechaAmbitoAndEmpresaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void personaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .personaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void localizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .localizacionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void empleadosPresenciaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .empleadosPresenciaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void coefJornadaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .coefJornadaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void flagCalculaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .flagCalculaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void presenciaManualByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .presenciaManualByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void presenciaManualLocalizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .presenciaManualWlocByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaManualLocalizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .ventaManualWlocByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void estructurasComByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .estructurasComByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void estructurasPolByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .estructurasPolByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void tiendasComisionableByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .tiendasComisionableByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void configuracionVentaOnlineByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .configuracionVentaOnlineByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void agrupacionesCadenaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .agrupacionesCadenaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void localizacionesOnlineByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .localizacionesOnlineByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void empleadosDesplazamientoByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .empleadosDesplazamientoByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ausenciasByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .ausenciasByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void configuraciones(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .configuracionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void confChallengeDiasMinimosByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .confChallengeDiasMinimosByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void presupuestosWlocByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .presupuestosWlocByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void confPrecioHoraByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .confPrecioHoraByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void confChallengeTipoVentaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .confChallengeTipoVentaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void presupuestosRangoByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .presupuestosRangoByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaCongeladaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .ventaCongeladaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void desplazamientoRealByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .desplazamientoRealByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void localizacionCadenaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .localizacionCadenaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void estructurasPolCadenaByRunTarea(
      @NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .estructurasPolCadenaByRunTareaAndAmbito(runTarea, item));
  }

  @Override
  public void empleadosCadenaByRunTarea(
      @NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .empleadosCadenaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void tiposHoraByRunTarea(
      @NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .tiposHoraByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void estadoWlocByRunTarea(
      @NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService
            .estadoWlocByRunTareaAndTareaAmbito(runTarea, item));
  }
}
