package com.inditex.rrhh.icmclcwb.api.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.PuntoEjecucionDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PuntoEjecucionEnum {

  ANTES(1, new PuntoEjecucionDto(1)), DURANTE(2, new PuntoEjecucionDto(2)), DESPUES(3,
      new PuntoEjecucionDto(3)),
  ERROR(4, new PuntoEjecucionDto(4));

  private final Integer id;

  private final PuntoEjecucionDto dto;

}
