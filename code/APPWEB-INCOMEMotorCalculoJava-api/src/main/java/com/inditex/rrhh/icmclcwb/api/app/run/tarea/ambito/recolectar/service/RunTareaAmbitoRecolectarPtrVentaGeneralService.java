package com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunTareaAmbitoRecolectarPtrVentaGeneralService {

  void ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NonNull @Valid TareaAmbitoDto tareaAmbito);

  void ventaFisicaCadenaByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NonNull @Valid TareaAmbitoDto tareaAmbito);

  void ventaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NonNull @Valid TareaAmbitoDto tareaAmbito);

  void devolucionRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NonNull @Valid TareaAmbitoDto tareaAmbito);

  void devolucionVentaOriginalOtraTiendaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(
      @Valid RunTareaDto runTarea, @NonNull @Valid TareaAmbitoDto tareaAmbito);

  void ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaAndTareaAmbito(
      @Valid RunTareaDto runTarea, @NonNull @Valid TareaAmbitoDto tareaAmbito);

}
