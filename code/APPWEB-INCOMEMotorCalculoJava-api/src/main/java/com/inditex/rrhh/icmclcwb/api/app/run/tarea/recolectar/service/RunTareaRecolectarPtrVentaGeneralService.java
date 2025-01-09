package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunTareaRecolectarPtrVentaGeneralService {

  void ventaFisicaLocalizacionSeccionByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void ventaFisicaCadenaByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void ventaRangoFisicaLocalizacionSeccionByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void devolucionRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(@NonNull @Valid RunTareaDto runTarea);

  void devolucionVentaOriginalOtraTiendaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(
      @NonNull @Valid RunTareaDto runTarea);

  void ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaAndTareaAmbito(@NonNull @Valid RunTareaDto runTarea);

}
