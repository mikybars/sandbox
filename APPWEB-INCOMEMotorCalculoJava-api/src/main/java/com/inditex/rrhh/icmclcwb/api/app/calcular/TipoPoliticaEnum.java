package com.inditex.rrhh.icmclcwb.api.app.calcular;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoPoliticaEnum {

  SIN_ASIGNAR(0, "000"), HORAS_FIJAS(1, "001"), EXCLUIDO_DENOMINADOR(2, "002"), CARENCIA(3, "003"), ANTIGUEDAD(4,
      "004"),
  BAJA_IT(5, "005"), VACACIONES(6, "006"), MINIMO_GARANTIZADO(7, "007"), MAXIMO_GARANTIZADO(8, "008");

  private final Integer id;

  private final String idMeta4;

}
