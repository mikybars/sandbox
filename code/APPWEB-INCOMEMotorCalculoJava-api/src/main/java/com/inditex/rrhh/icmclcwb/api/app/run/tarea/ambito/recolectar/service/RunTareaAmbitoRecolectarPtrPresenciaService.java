package com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunTareaAmbitoRecolectarPtrPresenciaService {

  void presenciaDetallePersonaByRunTareaAndTareaAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void presenciaEmpleadoTiendaByRunTareaAndTareaAmbito(final RunTareaDto runTarea,
      final TareaAmbitoDto tareaAmbito);

  void presenciaDetallePersonaIncluidoEcommerceByRunTareaAndTareaAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

  void presenciaDetallePersonaHorasSindicalesByRunTareaAndTareaAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

}
