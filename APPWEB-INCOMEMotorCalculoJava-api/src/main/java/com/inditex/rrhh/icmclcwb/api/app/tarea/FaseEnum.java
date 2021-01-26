package com.inditex.rrhh.icmclcwb.api.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter

@RequiredArgsConstructor
public enum FaseEnum {

    RECOLECTAR(1, new FaseDto(1)),
    VALIDAR_RECOLECCION(2, new FaseDto(2)), 
    PROCESAR(3, new FaseDto(3)),
    CALCULAR(4, new FaseDto(4)),
    REGULARIZAR_CHALLENGE(5, new FaseDto(5)), 
    REGULARIZAR(6, new FaseDto(6)), 
    AJUSTAR(7, new FaseDto(7));

    private final Integer id;

    private final FaseDto dto;

}
