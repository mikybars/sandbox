package com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunTareaAmbitoRecolectarPtrVentaEcommerceService {

  void ventaOnlineEntregaDomicilioCadenaByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @Valid TareaAmbitoDto tareaAmbito);

  void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @Valid TareaAmbitoDto tareaAmbito);

  void ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @Valid TareaAmbitoDto tareaAmbito);

  void ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NonNull @Valid TareaAmbitoDto tareaAmbito);

  void ventaOnlineIpodLocalizacionPersonaByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NonNull @Valid TareaAmbitoDto tareaAmbito);

  void ventaRangoOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NonNull @Valid TareaAmbitoDto tareaAmbito);

  void ventaRangoOnlineSintLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NonNull @Valid TareaAmbitoDto tareaAmbito);

  void ventaRangoOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NonNull @Valid TareaAmbitoDto tareaAmbito);

  void ventaRangoOnlineEntregaDomicilioLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NonNull @Valid TareaAmbitoDto tareaAmbito);

}
