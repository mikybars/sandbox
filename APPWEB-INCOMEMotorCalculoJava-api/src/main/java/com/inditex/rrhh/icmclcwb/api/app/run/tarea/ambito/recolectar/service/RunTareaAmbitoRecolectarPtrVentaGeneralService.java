package com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface RunTareaAmbitoRecolectarPtrVentaGeneralService {

  void ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NotNull @Valid TareaAmbitoDto tareaAmbito);

  void ventaFisicaCadenaByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NotNull @Valid TareaAmbitoDto tareaAmbito);

  void ventaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NotNull @Valid TareaAmbitoDto tareaAmbito);

  void devolucionRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NotNull @Valid TareaAmbitoDto tareaAmbito);

  void devolucionVentaOriginalOtraTiendaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(
      @Valid RunTareaDto runTarea, @NotNull @Valid TareaAmbitoDto tareaAmbito);

  void ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaAndTareaAmbito(
      @Valid RunTareaDto runTarea, @NotNull @Valid TareaAmbitoDto tareaAmbito);

}
