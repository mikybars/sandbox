package com.inditex.rrhh.icmclcwb.api.app.calcular;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoOpcionCalculoEnum {

  ORIGEN(1, "01"), DESTINO(2, "02"), MEJOR_OPCION(3, "03"), SIN_COMISION_VARIABLE(4, "04");

  private final Integer id;

  private final String idMeta4;

}
