package com.inditex.rrhh.icmclcwb.api.app.periodo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoPeriodoCalculoPersonaEnum {

  SIN_CALCULAR(1, new EstadoPeriodoCalculoPersonaDto(1)), CALCULADO(2,
      new EstadoPeriodoCalculoPersonaDto(2)),
  CONFIRMADO(3,
      new EstadoPeriodoCalculoPersonaDto(3)),
  CALCULADO_ERROR(4,
      new EstadoPeriodoCalculoPersonaDto(4)),
  EXPORTADO(5,
      new EstadoPeriodoCalculoPersonaDto(5)),
  RECUPERADO(6,
      new EstadoPeriodoCalculoPersonaDto(6)),
  PAGADO(7,
      new EstadoPeriodoCalculoPersonaDto(7));

  private final Integer id;

  private final EstadoPeriodoCalculoPersonaDto dto;

}
