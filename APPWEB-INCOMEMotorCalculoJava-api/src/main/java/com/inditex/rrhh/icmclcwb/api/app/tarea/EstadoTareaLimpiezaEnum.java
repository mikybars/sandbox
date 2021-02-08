/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaLimpiezaDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author javierev
 */
@Getter
@RequiredArgsConstructor
public enum EstadoTareaLimpiezaEnum {

    PENDIENTE(1, new EstadoTareaLimpiezaDto(1)), OK(2, new EstadoTareaLimpiezaDto(2)), KO(3,
            new EstadoTareaLimpiezaDto(3));

    private final Integer Id;

    private final EstadoTareaLimpiezaDto dto;

}
