package com.inditex.rrhh.icmclcwb.api.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPersonaDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoTareaCalculoPersonaEnum {

    PENDIENTE(1L, new EstadoTareaPersonaDto(1L)), OK(2L, new EstadoTareaPersonaDto(2L)),
    KO(3L, new EstadoTareaPersonaDto(3L));

    private final Long id;

    private final EstadoTareaPersonaDto dto;

}
