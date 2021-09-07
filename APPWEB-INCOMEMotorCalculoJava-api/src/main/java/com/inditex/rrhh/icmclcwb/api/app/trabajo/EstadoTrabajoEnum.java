package com.inditex.rrhh.icmclcwb.api.app.trabajo;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.dto.EstadoTrabajoDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoTrabajoEnum {

    PENDIENTE(1, new EstadoTrabajoDTO()), EN_CURSO(2, new EstadoTrabajoDTO()), OK(3, new EstadoTrabajoDTO()), KO(4,
            new EstadoTrabajoDTO());

    private final Integer id;

    private final EstadoTrabajoDTO dto;

}
