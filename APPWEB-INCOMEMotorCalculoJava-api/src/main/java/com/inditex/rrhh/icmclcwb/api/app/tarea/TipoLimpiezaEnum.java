package com.inditex.rrhh.icmclcwb.api.app.tarea;

/*
 * Copyright (c) 2021. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoLimpiezaDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public enum TipoLimpiezaEnum {

  COMPLETA(1, new TipoLimpiezaDto(1)), PARCIAL(2, new TipoLimpiezaDto(2));

  private final Integer id;

  private final TipoLimpiezaDto dto;

}
