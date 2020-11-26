package com.inditex.rrhh.icmclcwb.api.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TipoAccionValidacionDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoAccionValidacionEnum {

    NO_REINTENTAR(1, new TipoAccionValidacionDto(1)), 
    ESPERAR_LLAMADA(2, new TipoAccionValidacionDto(2)),
    REENCOLAR_DELAY(3, new TipoAccionValidacionDto(3)),
    REENCOLAR(4, new TipoAccionValidacionDto(4)); 

    private final Integer id;

    private final TipoAccionValidacionDto dto;

}
