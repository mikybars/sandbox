package com.inditex.rrhh.icmclcwb.api.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter

@RequiredArgsConstructor
public enum FaseEnum {

  RECOLECTAR(1,
      new FaseDto(1)),
  VALIDAR_RECOLECCION(2,
      new FaseDto(2)),
  PROCESAR(3,
      new FaseDto(3)),
  CALCULAR(4,
      new FaseDto(4)),
  REGULARIZAR_CHALLENGE(5,
      new FaseDto(5)),
  REGULARIZAR(6,
      new FaseDto(6)),
  AJUSTAR(7,
      new FaseDto(7)),
  NORMALIZAR(8,
      new FaseDto(8)),
  CONSOLIDAR(9,
      new FaseDto(9)),
  MIGRAR(10,
      new FaseDto(10));

  private final Integer id;

  private final FaseDto dto;

  public static FaseEnum fromId(final Integer id) {
    FaseEnum result = null;
    for (final FaseEnum value : FaseEnum.values()) {
      if (value.id.equals(id)) {
        result = value;
      }
    }
    return result;
  }

}
