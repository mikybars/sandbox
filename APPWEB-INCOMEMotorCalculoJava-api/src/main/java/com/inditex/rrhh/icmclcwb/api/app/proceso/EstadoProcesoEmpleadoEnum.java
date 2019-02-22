package com.inditex.rrhh.icmclcwb.api.app.proceso;

import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.EstadoProcesoEmpleadoDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoProcesoEmpleadoEnum {

    PENDIENTE(1L, new EstadoProcesoEmpleadoDto(1L)), FINALIZADO(2L, new EstadoProcesoEmpleadoDto(2L)),
    ERROR(3L, new EstadoProcesoEmpleadoDto(3L));

    private final Long id;

    private final EstadoProcesoEmpleadoDto dto;

}
