package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

/*
 * Copyright (c) 2022. Inditex
 */
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDatoDto;

public interface TareaFaseAccionDatoService {

  /**
   * Guarda en TAREA_FASE_ACCION_DATO.
   *
   * @param src TareaFaseAccionDatoDto
   */
  void save(List<TareaFaseAccionDatoDto> src);

}
