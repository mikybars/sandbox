package com.inditex.rrhh.icmclcwb.api.app.proceso;

import java.util.Objects;
import java.util.stream.Stream;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoSistemaDestinoEnum {
  SIL(1, new TipoSistemaDestinoDTO(1, "01", "SIL")),
  AS400(2, new TipoSistemaDestinoDTO(2, "02", "AS400")),
  SOLUCION_GLOBAL(3, new TipoSistemaDestinoDTO(3, "03", "SOLUCION_GLOBAL")),
  UNDEFINED(null, null);

  private final Integer id;

  private final TipoSistemaDestinoDTO dto;

  public static TipoSistemaDestinoEnum of(final Integer id) {
    return Stream.of(values())
        .filter(obj -> Objects.equals(obj.getId(), id))
        .findAny()
        .orElse(UNDEFINED);
  }

  public static TipoSistemaDestinoEnum of(final TipoSistemaDestinoDTO dto) {
    return Stream.of(values())
        .filter(obj -> Objects.equals(obj.getDto(), dto))
        .findAny()
        .orElse(UNDEFINED);
  }

}
