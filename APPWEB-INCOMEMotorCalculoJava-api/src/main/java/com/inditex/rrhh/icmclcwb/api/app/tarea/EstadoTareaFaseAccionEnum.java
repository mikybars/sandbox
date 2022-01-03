package com.inditex.rrhh.icmclcwb.api.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseAccionDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoTareaFaseAccionEnum {

  PENDIENTE(1, new EstadoTareaFaseAccionDto(1)), KO(2, new EstadoTareaFaseAccionDto(2)), OK(3,
      new EstadoTareaFaseAccionDto(3)),
  NO_EJECUTADA(4,
      new EstadoTareaFaseAccionDto(4)),
  ERROR(5, new EstadoTareaFaseAccionDto(5));

  private final Integer id;

  private final EstadoTareaFaseAccionDto dto;

}
