package com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;

import javax.validation.Valid;

public interface RunTareaAmbitoValidarFechasService {

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  ValidacionDto execute(@Valid RunTareaDto runTareaDto, @Valid TareaAmbitoDto tareaAmbito,
      @Valid final TareaFaseAccionDto tareaFaseAccion);

}
