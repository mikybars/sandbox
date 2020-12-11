package com.inditex.rrhh.icmclcwb.api.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TipoEstadoValidacionDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoEstadoValidacionEnum {

    ONLINE(1, new TipoEstadoValidacionDto(1)), 
    OFFLINE(2, new TipoEstadoValidacionDto(2)); 

    private final Integer id;

    private final TipoEstadoValidacionDto dto;

}
