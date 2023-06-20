package com.inditex.rrhh.icmclcwb.api.ventaintegra.service;

/*
 * Copyright (c) 2022. Inditex
 */
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraDataResponseDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraRequestDto;

public interface VentaIntegraService {

  /**
   * Recuperar las tiendas con venta no integra en un periodo determinado.
   *
   * @param data VentaIntegraRequestDto - Datos para ejecutar la peticion.
   * @return List of VentaIntegraDataResponseDto.
   */
  List<VentaIntegraDataResponseDto> getTiendasVentaNoIntegra(VentaIntegraRequestDto data, Long idTrabajo, Long idTarea);

}
