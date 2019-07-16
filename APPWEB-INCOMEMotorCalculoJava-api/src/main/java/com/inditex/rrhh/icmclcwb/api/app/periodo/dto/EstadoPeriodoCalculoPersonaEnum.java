package com.inditex.rrhh.icmclcwb.api.app.periodo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoPeriodoCalculoPersonaEnum {

    SIN_CALCULAR(1L, new EstadoPeriodoCalculoPersonaDto(1L)), CALCULADO(2L, new EstadoPeriodoCalculoPersonaDto(2L)),
    CONFIRMADO(3L, new EstadoPeriodoCalculoPersonaDto(3L)), CALCULADO_ERROR(4L, new EstadoPeriodoCalculoPersonaDto(4L)),
    EXPORTADO(5L, new EstadoPeriodoCalculoPersonaDto(5L)), RECUPERADO(6L, new EstadoPeriodoCalculoPersonaDto(6L)),
    PAGADO(7L, new EstadoPeriodoCalculoPersonaDto(7L));

    private final Long id;

    private final EstadoPeriodoCalculoPersonaDto dto;

}
