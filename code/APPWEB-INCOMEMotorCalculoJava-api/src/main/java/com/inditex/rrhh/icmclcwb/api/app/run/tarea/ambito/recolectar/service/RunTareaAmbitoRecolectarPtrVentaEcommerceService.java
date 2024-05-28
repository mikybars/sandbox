package com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface RunTareaAmbitoRecolectarPtrVentaEcommerceService {

  void ventaOnlineEntregaDomicilioCadenaByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @Valid TareaAmbitoDto tareaAmbito);

  void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @Valid TareaAmbitoDto tareaAmbito);

  void ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @Valid TareaAmbitoDto tareaAmbito);

  void ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NotNull @Valid TareaAmbitoDto tareaAmbito);

  void ventaOnlineIpodLocalizacionPersonaByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NotNull @Valid TareaAmbitoDto tareaAmbito);

  void ventaRangoOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NotNull @Valid TareaAmbitoDto tareaAmbito);

  void ventaRangoOnlineSintLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NotNull @Valid TareaAmbitoDto tareaAmbito);

  void ventaRangoOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NotNull @Valid TareaAmbitoDto tareaAmbito);

  void ventaRangoOnlineEntregaDomicilioLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NotNull @Valid TareaAmbitoDto tareaAmbito);

}
