package com.inditex.rrhh.icmclcwb.api.app.trabajo;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.EstadoTrabajoEmpleadoDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoTrabajoEmpleadoEnum {

    PENDIENTE(1L, new EstadoTrabajoEmpleadoDto(1L)), FINALIZADO(2L, new EstadoTrabajoEmpleadoDto(2L)),
    ERROR(3L, new EstadoTrabajoEmpleadoDto(3L));

    private final Long id;

    private final EstadoTrabajoEmpleadoDto dto;

}
