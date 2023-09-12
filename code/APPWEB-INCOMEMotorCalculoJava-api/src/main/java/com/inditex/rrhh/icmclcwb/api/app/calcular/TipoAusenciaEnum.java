package com.inditex.rrhh.icmclcwb.api.app.calcular;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoAusenciaEnum {

  BAJA_IT(1, "1"), VACACIONES(2, "2");

  private final Integer id;

  private final String idMeta4;

}
