package com.inditex.rrhh.icmclcwb.api.app.calcular;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SistemaDestinoEnum {

  SIL("01"), AS400("02"), SOLUCION_GLOBAL("03"), NONE("-01");

  private final String idMeta4;

}
