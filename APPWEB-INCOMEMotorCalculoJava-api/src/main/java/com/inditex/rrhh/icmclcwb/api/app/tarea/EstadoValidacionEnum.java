package com.inditex.rrhh.icmclcwb.api.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoValidacionDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoValidacionEnum {

    OK(1, new EstadoValidacionDto(1)), 
    KO(2, new EstadoValidacionDto(2)),
    PLANIFICADA(3, new EstadoValidacionDto(3)),; 

    private final Integer id;

    private final EstadoValidacionDto dto;

}
