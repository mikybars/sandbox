package com.inditex.rrhh.icmclcwb.api.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaEmpleadoDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoTareaEmpleadoEnum {

    PENDIENTE(1L, new EstadoTareaEmpleadoDto(1L)), FINALIZADO(2L, new EstadoTareaEmpleadoDto(2L)),
    ERROR(3L, new EstadoTareaEmpleadoDto(3L));

    private final Long id;

    private final EstadoTareaEmpleadoDto dto;

}
