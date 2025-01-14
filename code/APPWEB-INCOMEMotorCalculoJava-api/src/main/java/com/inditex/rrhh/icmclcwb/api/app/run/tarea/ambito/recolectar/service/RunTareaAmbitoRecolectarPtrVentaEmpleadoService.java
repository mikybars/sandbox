package com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunTareaAmbitoRecolectarPtrVentaEmpleadoService {

  void ventaFisicaLocalizacionPersonaByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NonNull @Valid TareaAmbitoDto tareaAmbito);

}
