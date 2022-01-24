package com.inditex.rrhh.icmclcwb.api.app.tarea;

/*
 * Copyright (c) 2021. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoLimpiezaDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoLimpiezaEnum {

  PENDIENTE(1, new EstadoLimpiezaDto(1)), EN_CURSO(2, new EstadoLimpiezaDto(2)), OK(3,
      new EstadoLimpiezaDto(3)),
  KO(4, new EstadoLimpiezaDto(4));

  private final Integer id;

  private final EstadoLimpiezaDto dto;

}
