package com.inditex.rrhh.icmclcwb.api.app.trabajo;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.EstadoTrabajoDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoTrabajoEnum {

    PENDIENTE(1, new EstadoTrabajoDto(1)), EN_CURSO(2, new EstadoTrabajoDto(2)), OK(3, new EstadoTrabajoDto(3)), KO(4,
            new EstadoTrabajoDto(4));

    private final Integer id;

    private final EstadoTrabajoDto dto;

}
