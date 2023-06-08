package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionVentaIntegraDto;

public interface TareaFaseAccionVentaIntegraService {

  /**
   * Guarda en TAREA_FASE_ACCION_VENTA_INBTEGRA.
   *
   * @param src TareaFaseAccionVentaIntegraDto
   */
  void save(List<TareaFaseAccionVentaIntegraDto> src);

}
