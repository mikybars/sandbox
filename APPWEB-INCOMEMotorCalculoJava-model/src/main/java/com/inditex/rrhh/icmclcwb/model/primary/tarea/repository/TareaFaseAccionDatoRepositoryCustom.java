package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

/*
 * Copyright (c) 2022. Inditex
 */
import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccionDato;

public interface TareaFaseAccionDatoRepositoryCustom {

  /**
   * Guarda en TAREA_FASE_ACCION_DATO.
   *
   * @param src List of TareaFaseAccionDato
   */
  void save(List<TareaFaseAccionDato> src);
}
