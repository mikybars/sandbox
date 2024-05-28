package com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;

import jakarta.validation.Valid;

public interface RunTareaAmbitoValidarCondicionesDesplazamientoService {

  /**
   * Some javadoc.
   *
   * @param runTarea Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  ValidacionDto execute(@Valid RunTareaDto runTarea, @Valid TareaAmbitoDto tareaAmbito,
      @Valid final TareaFaseAccionDto tareaFaseAccion);

}
