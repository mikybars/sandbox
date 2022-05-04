package com.inditex.rrhh.icmclcwb.api.app.service;

/*
 * Copyright (c) 2022. Inditex
 */
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.VentaIntegraRequestDto;

public interface VentaIntegraService {

  /**
   * Recuperar las tiendas con venta no integra en un periodo determinado.
   *
   * @param data VentaIntegraRequestDto - Datos para ejecutar la peticion.
   * @return List of Integer - Lista de tiendas.
   */
  List<Integer> getTiendasVentaNoIntegra(VentaIntegraRequestDto data);

}
