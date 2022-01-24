package com.inditex.rrhh.icmclcwb.api.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoTareaFaseEnum {

  PENDIENTE(1, new EstadoTareaFaseDto(1)), KO(2, new EstadoTareaFaseDto(2)), OK(3,
      new EstadoTareaFaseDto(3)),
  NO_EJECUTADA(4, new EstadoTareaFaseDto(4));

  private final Integer id;

  private final EstadoTareaFaseDto dto;

}
