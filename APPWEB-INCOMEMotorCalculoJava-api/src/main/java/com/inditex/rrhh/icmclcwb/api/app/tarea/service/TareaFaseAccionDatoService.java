package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

/*
 * Copyright (c) 2022. Inditex
 */
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDatoDto;

public interface TareaFaseAccionDatoService {

  /**
   * Guarda en TAREA_FASE_ACCION_FALLIDAS.
   *
   * @param src TareaFaseAccionFallidasDto
   */
  void save(List<TareaFaseAccionDatoDto> src);

}
