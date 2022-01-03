package com.inditex.rrhh.icmclcwb.api.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoTareaEnum {

  PENDIENTE(1, new EstadoTareaDto(1)), EN_CURSO(2, new EstadoTareaDto(2)), FINALIZADO_SIN_ERRORES(3,
      new EstadoTareaDto(3)),
  FINALIZADO_CON_ERRORES(4,
      new EstadoTareaDto(4)),
  ERROR(5, new EstadoTareaDto(5)), ERROR_VALIDANDO(6, new EstadoTareaDto(6));

  private final Integer id;

  private final EstadoTareaDto dto;

}
