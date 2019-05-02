package com.inditex.rrhh.icmclcwb.api.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoTareaEnum {

    PENDIENTE(1L, new EstadoTareaDto(1L)), EN_CURSO(2L, new EstadoTareaDto(2L)),
    FINALIZADO_SIN_ERRORES(3L, new EstadoTareaDto(3L)), FINALIZADO_CON_ERRORES(4L, new EstadoTareaDto(4L)),
    ERROR(5L, new EstadoTareaDto(5L));

    private final Long id;

    private final EstadoTareaDto dto;

}
