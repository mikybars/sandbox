package com.inditex.rrhh.icmclcwb.api.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoTareaEnum {

    PENDIENTE_RECOLECTAR(1L, new EstadoTareaDto(1L)), EN_CURSO_RECOLECTAR(2L, new EstadoTareaDto(2L)),
    PENDIENTE_CALCULAR(3L, new EstadoTareaDto(3L)), EN_CURSO_CALCULAR(4L, new EstadoTareaDto(4L)),
    PENDIENTE_CONSOLIDAR(5L, new EstadoTareaDto(5L)), EN_CURSO_CONSOLIDAR(6L, new EstadoTareaDto(6L)),
    FINALIZADO_SIN_ERRORES(7L, new EstadoTareaDto(7L)), FINALIZADO_CON_ERRORES(8L, new EstadoTareaDto(8L)),
    ERROR(9L, new EstadoTareaDto(9L));

    private final Long id;

    private final EstadoTareaDto dto;

}
