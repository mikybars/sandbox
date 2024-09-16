package com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface RunTareaAmbitoRecolectarPtrVentaEmpleadoService {

  void ventaFisicaLocalizacionPersonaByRunTareaAndTareaAmbito(@Valid RunTareaDto runTarea,
      @NotNull @Valid TareaAmbitoDto tareaAmbito);

}
