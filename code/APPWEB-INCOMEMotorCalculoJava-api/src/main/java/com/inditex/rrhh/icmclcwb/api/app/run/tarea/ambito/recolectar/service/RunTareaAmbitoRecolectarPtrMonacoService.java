package com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service;

/*
 * Copyright (c) 2022. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunTareaAmbitoRecolectarPtrMonacoService {

  void ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NonNull @Valid TareaAmbitoDto tareaAmbito);

  void ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NonNull @Valid TareaAmbitoDto tareaAmbito);

  void ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @Valid TareaAmbitoDto tareaAmbito);

  void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @Valid TareaAmbitoDto tareaAmbito);

  void ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NonNull @Valid TareaAmbitoDto tareaAmbito);

  void presenciaDetalleComisionablePersonaByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NonNull @Valid TareaAmbitoDto tareaAmbito);

  void presenciaDetallePersonaIncluidoCommerceByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NonNull @Valid TareaAmbitoDto tareaAmbito);
}
