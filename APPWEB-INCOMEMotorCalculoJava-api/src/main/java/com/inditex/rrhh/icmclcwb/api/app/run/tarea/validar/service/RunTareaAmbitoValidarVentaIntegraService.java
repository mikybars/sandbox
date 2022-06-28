package com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service;

/*
 * Copyright (c) 2022. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;

import javax.validation.Valid;

public interface RunTareaAmbitoValidarVentaIntegraService {

  /**
   * Some javadoc. Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @return Some javadoc.
   */
  ValidacionDto execute(@Valid RunTareaDto runTareaDto, @Valid TareaAmbitoDto tareaAmbito,
      @Valid final TareaFaseAccionDto tareaFaseAccion);

}
