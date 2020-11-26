package com.inditex.rrhh.icmclcwb.api.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPrevalidacionDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoTareaPrevalidacionEnum {

    EN_CURSO_VALIDACION(1, new EstadoTareaPrevalidacionDto(1)), 
    PENDIENTE_REVALIDACION(2, new EstadoTareaPrevalidacionDto(2)), 
    ERROR(3, new EstadoTareaPrevalidacionDto(3));

    private final Integer id;

    private final EstadoTareaPrevalidacionDto dto;

}
