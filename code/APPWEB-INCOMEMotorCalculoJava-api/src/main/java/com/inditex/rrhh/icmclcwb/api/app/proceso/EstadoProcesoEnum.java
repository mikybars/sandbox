package com.inditex.rrhh.icmclcwb.api.app.proceso;

import java.util.Objects;
import java.util.stream.Stream;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EstadoProcesoEnum {
  PENDIENTE(1, new EstadoProcesoDTO(1, "PENDIENTE")),
  EN_CURSO(2, new EstadoProcesoDTO(2, "EN CURSO")),
  FINALIZADO_SIN_ERRORES(3, new EstadoProcesoDTO(3, "FINALIZADO SIN ERRORES")),
  FINALIZADO_CON_ERRORES(4, new EstadoProcesoDTO(4, "FINALIZADO CON ERRORES")),
  ERROR(5, new EstadoProcesoDTO(5, "ERROR")),
  ERROR_VALIDACION(6, new EstadoProcesoDTO(6, "ERROR VALIDACION")),
  UNDEFINED(null, null);

  private final Integer id;

  private final EstadoProcesoDTO dto;

  public static EstadoProcesoEnum of(final Integer id) {
    return Stream.of(values())
        .filter(obj -> Objects.equals(obj.getId(), id))
        .findAny()
        .orElse(UNDEFINED);
  }

  public static EstadoProcesoEnum of(final EstadoProcesoDTO dto) {
    return Stream.of(values())
        .filter(obj -> Objects.equals(obj.getDto(), dto))
        .findAny()
        .orElse(UNDEFINED);
  }

}
