package com.inditex.rrhh.icmclcwb.api.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter

@RequiredArgsConstructor
public enum AccionEnum {

  MOTIVOS(1, AccionDto.builder().id(1).build()), CONDICIONES_HISTORICO(2, AccionDto.builder()
      .id(2)
      .build()),
  FECHAS(3, AccionDto.builder().id(3).build()), PRESENCIAS(4, AccionDto.builder().id(4).build()), BAJA(
      5,
      AccionDto.builder().id(5).build()),
  CARENCIA(6, AccionDto.builder()
      .id(6)
      .build()),
  RESALTA(7,
      AccionDto.builder().id(7).build()),
  DESPLAZAMIENTO(8, AccionDto.builder().id(8).build());

  private final Integer id;

  private final AccionDto dto;

}
