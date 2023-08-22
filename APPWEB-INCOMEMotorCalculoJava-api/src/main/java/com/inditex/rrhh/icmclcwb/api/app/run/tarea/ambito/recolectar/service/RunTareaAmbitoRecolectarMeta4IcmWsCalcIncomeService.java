package com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService {

  void fechaAmbitoAndEmpresaByRunTareaAndTareaAmbito(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbito);

  void personaByRunTareaAndTareaAmbito(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbito);

  void localizacionCadenaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void empleadosCadenaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void localizacionByRunTareaAndTareaAmbito(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbito);

  void empleadosPresenciaByRunTareaAndTareaAmbito(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbito);

  void coefJornadaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void flagCalculaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void presenciaManualByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void tiendasComisionableByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void configuracionVentaOnlineByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NotNull @Valid TareaAmbitoDto tareaAmbito);

  void agrupacionesCadenaByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void localizacionesOnlineByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void empleadosDesplazamientoByRunTareaAndTareaAmbito(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbito);

  void estructurasComByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void estructurasPolByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void estructurasPolCadenaByRunTareaAndAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void ausenciasByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void configuracionByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void confChallengeDiasMinimosByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void presupuestosWlocByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void confPrecioHoraByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void confChallengeTipoVentaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void presupuestosRangoByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void ventaCongeladaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void desplazamientoRealByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void presenciaManualWlocByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void ventaManualWlocByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void tiposHoraByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbitoDto);

  void estadoWlocByRunTareaAndTareaAmbito(@NotNull @Valid RunTareaDto runTarea,
      @NotNull @Valid TareaAmbitoDto tareaAmbito);
}
