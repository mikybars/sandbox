package com.inditex.rrhh.icmclcwb.api.app.tarea;

/*
 * Copyright (c) 2022. Inditex
 */
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoFallidaEnum {

  PERSONAS(1), MOTIVOS_DESPLAZAMIENTO(2);

  private final Integer id;
}
