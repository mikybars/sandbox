package com.inditex.rrhh.icmclcwb.api.app.trabajo;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.EstadoTrabajoDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoTrabajoEnum {

    PENDIENTE_DATOS(1L, new EstadoTrabajoDto(1L)), EN_CURSO_DATOS(2L, new EstadoTrabajoDto(2L)),
    PENDIENTE_CALCULO(3L, new EstadoTrabajoDto(3L)), EN_CURSO_CALCULO(4L, new EstadoTrabajoDto(4L)),
    PENDIENTE_CONSOLIDACION(5L, new EstadoTrabajoDto(5L)), EN_CURSO_CONSOLIDACION(6L, new EstadoTrabajoDto(6L)),
    FINALIZADO_SIN_ERRORES(7L, new EstadoTrabajoDto(7L)), FINALIZADO_CON_ERRORES(8L, new EstadoTrabajoDto(8L)),
    ERROR(9L, new EstadoTrabajoDto(9L));

    private final Long id;

    private final EstadoTrabajoDto dto;

}
