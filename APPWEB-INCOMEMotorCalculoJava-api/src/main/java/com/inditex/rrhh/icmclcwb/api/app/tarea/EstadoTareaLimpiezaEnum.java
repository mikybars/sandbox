/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.app.tarea;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author javierev
 */
@Getter
@RequiredArgsConstructor
public enum EstadoTareaLimpiezaEnum {

    PENDIENTE(1), OK(2), KO(3);

    private final Integer Id;

}
