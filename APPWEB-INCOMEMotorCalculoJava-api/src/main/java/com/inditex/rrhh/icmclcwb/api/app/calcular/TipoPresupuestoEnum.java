package com.inditex.rrhh.icmclcwb.api.app.calcular;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoPresupuestoEnum {

  MENSUAL(1, "01"), BIMENSUAL(2, "02"), TRIMESTRAL(3, "03"), CUATRIMESTRAL(4, "04"), SEMESTRAL(5, "05"), ANUAL(6,
      "06"),
  ABIERTO(7, "07");

  private final Integer id;

  private final String idMeta4;

}
