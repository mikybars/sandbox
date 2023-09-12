package com.inditex.rrhh.icmclcwb.api.app.trabajo;

import com.inditex.rrhh.icmclcwb.dto.EstadoTrabajoDTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoTrabajoEnum {

  PENDIENTE(1, new EstadoTrabajoDTO().id(1)), EN_CURSO(2, new EstadoTrabajoDTO().id(2)), OK(3,
      new EstadoTrabajoDTO().id(3)),
  KO(4,
      new EstadoTrabajoDTO().id(4));

  private final Integer id;

  private final EstadoTrabajoDTO dto;

}
