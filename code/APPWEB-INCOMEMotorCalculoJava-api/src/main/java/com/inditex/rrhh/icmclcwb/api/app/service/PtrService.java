package com.inditex.rrhh.icmclcwb.api.app.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import javax.validation.Valid;

public interface PtrService {

  /**
   * Some javadoc.
   *
   * @param runTarea Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  PresenciaOrigenDto findPresenciasOrigenAndFecha(@Valid final RunTareaDto runTarea,
      @Valid final TareaAmbitoDto tareaAmbito);

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  PresenciaOrigenDto findPresenciasOrigenAndFechaEs(@Valid final RunTareaDto runTareaDto,
      @Valid final TareaAmbitoDto tareaAmbito);

}
