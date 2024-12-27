package com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomeService {

  void fechaAmbitoAndEmpresaByRunTareaAndTareaAmbito(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbito);

  void personaByRunTareaAndTareaAmbito(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbito);

  void localizacionCadenaByRunTareaAndTareaAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void empleadosCadenaByRunTareaAndTareaAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void localizacionByRunTareaAndTareaAmbito(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbito);

  void empleadosPresenciaByRunTareaAndTareaAmbito(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbito);

  void coefJornadaByRunTareaAndTareaAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void flagCalculaByRunTareaAndTareaAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void presenciaManualByRunTareaAndTareaAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void tiendasComisionableByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void configuracionVentaOnlineByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NonNull @Valid TareaAmbitoDto tareaAmbito);

  void agrupacionesCadenaByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void localizacionesOnlineByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void empleadosDesplazamientoByRunTareaAndTareaAmbito(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbito);

  void estructurasComByRunTareaAndTareaAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void estructurasPolByRunTareaAndTareaAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void estructurasPolCadenaByRunTareaAndAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void ausenciasByRunTareaAndTareaAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void configuracionByRunTareaAndTareaAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void confChallengeDiasMinimosByRunTareaAndTareaAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void presupuestosWlocByRunTareaAndTareaAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void confPrecioHoraByRunTareaAndTareaAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void confChallengeTipoVentaByRunTareaAndTareaAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void presupuestosRangoByRunTareaAndTareaAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void ventaCongeladaByRunTareaAndTareaAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void desplazamientoRealByRunTareaAndTareaAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void presenciaManualWlocByRunTareaAndTareaAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void ventaManualWlocByRunTareaAndTareaAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void tiposHoraByRunTareaAndTareaAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbitoDto);

  void estadoWlocByRunTareaAndTareaAmbito(@NonNull @Valid RunTareaDto runTarea,
      @NonNull @Valid TareaAmbitoDto tareaAmbito);
}
