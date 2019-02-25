package com.inditex.rrhh.icmclcwb.api.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoTareaEnum {

    PENDIENTE_DATOS(1L, new EstadoTareaDto(1L)), EN_CURSO_DATOS(2L, new EstadoTareaDto(2L)),
    PENDIENTE_CALCULO(3L, new EstadoTareaDto(3L)), EN_CURSO_CALCULO(4L, new EstadoTareaDto(4L)),
    PENDIENTE_CONSOLIDACION(5L, new EstadoTareaDto(5L)), EN_CURSO_CONSOLIDACION(6L, new EstadoTareaDto(6L)),
    FINALIZADO_SIN_ERRORES(7L, new EstadoTareaDto(7L)), FINALIZADO_CON_ERRORES(8L, new EstadoTareaDto(8L)),
    ERROR(9L, new EstadoTareaDto(9L));

    private final Long id;

    private final EstadoTareaDto dto;

}
