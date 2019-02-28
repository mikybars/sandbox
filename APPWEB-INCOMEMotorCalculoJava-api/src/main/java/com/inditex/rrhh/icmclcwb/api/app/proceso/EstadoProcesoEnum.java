package com.inditex.rrhh.icmclcwb.api.app.proceso;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.EstadoProcesoDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoProcesoEnum {

    PENDIENTE_RECOLECTAR(1L, new EstadoProcesoDto(1L)), EN_CURSO_RECOLECTAR(2L, new EstadoProcesoDto(2L)),
    PENDIENTE_CALCULAR(3L, new EstadoProcesoDto(3L)), EN_CURSO_CALCULAR(4L, new EstadoProcesoDto(4L)),
    PENDIENTE_CONSOLIDAR(5L, new EstadoProcesoDto(5L)), EN_CURSO_CONSOLIDAR(6L, new EstadoProcesoDto(6L)),
    FINALIZADO_SIN_ERRORES(7L, new EstadoProcesoDto(7L)), FINALIZADO_CON_ERRORES(8L, new EstadoProcesoDto(8L)),
    ERROR(9L, new EstadoProcesoDto(9L));

    private final Long id;

    private final EstadoProcesoDto dto;

}
