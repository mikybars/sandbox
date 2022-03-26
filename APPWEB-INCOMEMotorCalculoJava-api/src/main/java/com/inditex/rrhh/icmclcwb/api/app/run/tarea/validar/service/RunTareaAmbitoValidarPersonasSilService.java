package com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;

import javax.validation.Valid;

public interface RunTareaAmbitoValidarPersonasSilService {

  /**
   * Some javadoc.
   *
   * @param runTarea Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @param tareaFaseAccion Some javadoc.
   * @return Some javadoc.
   */
  ValidacionDto execute(final @Valid RunTareaDto runTarea, final @Valid TareaAmbitoDto tareaAmbito,
      final @Valid TareaFaseAccionDto tareaFaseAccion);

}
