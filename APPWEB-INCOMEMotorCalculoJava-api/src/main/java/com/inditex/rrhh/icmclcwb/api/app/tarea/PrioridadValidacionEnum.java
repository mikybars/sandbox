package com.inditex.rrhh.icmclcwb.api.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.PrioridadValidacionDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PrioridadValidacionEnum {

    HI(1, new PrioridadValidacionDto(1)), 
    LO(2, new PrioridadValidacionDto(2)); 

    private final Integer id;

    private final PrioridadValidacionDto dto;

}
