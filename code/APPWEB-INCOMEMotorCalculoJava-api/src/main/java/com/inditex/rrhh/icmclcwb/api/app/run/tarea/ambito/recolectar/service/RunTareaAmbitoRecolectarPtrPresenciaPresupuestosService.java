package com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunTareaAmbitoRecolectarPtrPresenciaPresupuestosService {

  void presenciaEmpleadoTiendaByRunTareaAndTareaAmbito(@NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaAmbitoDto tareaAmbito);

}
