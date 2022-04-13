package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

/*
 * Copyright (c) 2022. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionFallidasDto;

public interface TareaFaseAccionFallidasService {

  /**
   * Guarda en TAREA_FASE_ACCION_FALLIDAS.
   *
   * @param src TareaFaseAccionFallidasDto
   */
  void save(TareaFaseAccionFallidasDto src);

}
