package com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service;

/*
 * Copyright (c) 2022. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;

import jakarta.validation.Valid;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface RunTareaAmbitoValidarCondicionesDesplazamientoSinChallengeService {

  /**
   * Some javadoc.
   *
   * @param runTareaDto Some javadoc.
   * @param tareaAmbito Some javadoc.
   * @param tareaFaseAccion Some javadoc.*
   * @return Some javadoc.
   */
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  ValidacionDto execute(@Valid RunTareaDto runTareaDto,
      @Valid TareaAmbitoDto tareaAmbito,
      @Valid TareaFaseAccionDto tareaFaseAccion);
}
