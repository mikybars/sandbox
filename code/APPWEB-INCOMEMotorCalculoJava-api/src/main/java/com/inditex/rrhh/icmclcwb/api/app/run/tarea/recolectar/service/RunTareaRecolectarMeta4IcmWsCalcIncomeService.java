package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunTareaRecolectarMeta4IcmWsCalcIncomeService {

  void personaByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void localizacionByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void tiendasComisionableByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void presenciaManualByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void empleadosPresenciaByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void coefJornadaByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void flagCalculaByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void configuracionVentaOnlineByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void agrupacionesCadenaByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void localizacionesOnlineByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void empleadosDesplazamientoByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void estructurasPolByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void estructurasComByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void ausenciasByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void configuraciones(@NonNull @Valid final RunTareaDto runTarea);

  void confChallengeDiasMinimosByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void presupuestosWlocByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void confPrecioHoraByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void confChallengeTipoVentaByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void presupuestosRangoByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void ventaCongeladaByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void fechaAmbitoAndEmpresaByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void desplazamientoRealByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void presenciaManualLocalizacionByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void ventaManualLocalizacionByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void localizacionCadenaByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void estructurasPolCadenaByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void empleadosCadenaByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void tiposHoraByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void estadoWlocByRunTarea(
      @NonNull @Valid RunTareaDto runTarea);
}
