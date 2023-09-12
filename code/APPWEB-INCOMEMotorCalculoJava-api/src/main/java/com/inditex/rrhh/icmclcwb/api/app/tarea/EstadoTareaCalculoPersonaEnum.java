package com.inditex.rrhh.icmclcwb.api.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPersonaDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoTareaCalculoPersonaEnum {

  PENDIENTE(1, new EstadoTareaPersonaDto(1)), OK(2, new EstadoTareaPersonaDto(2)), KO(3,
      new EstadoTareaPersonaDto(3));

  private final Integer id;

  private final EstadoTareaPersonaDto dto;

}
