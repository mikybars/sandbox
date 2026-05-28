package com.inditex.rrhh.icmclcwb.model.app.service;

import static java.util.Collections.emptyList;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraDataResponseDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.dto.VentaIntegraRequestDto;
import com.inditex.rrhh.icmclcwb.api.ventaintegra.service.VentaIntegraService;
import com.inditex.rrhh.icmclcwb.model.app.annotation.NuevoMotor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@NuevoMotor
public class VentaIntegraServiceNoOp implements VentaIntegraService {

  @Override
  public List<VentaIntegraDataResponseDto> getTiendasVentaNoIntegra(final VentaIntegraRequestDto data) {
    log.warn("getTiendasVentaNoIntegra invoked but disabled in nuevo motor. Returning empty list.");
    return emptyList();
  }
}
