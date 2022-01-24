package com.inditex.rrhh.icmclcwb.api.app.calcular;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoComisionEnum {

  COMISION("001"), RESALTA_FUNCION("002"), RESALTA_PERSONAL("003"), RESALTA_TIENDA("004"), INCENTIVO(
      "005"),
  COMISION_POR_TOPES("006"), MANUAL("007"), COMISION_DIARIA("008"), PRIMA("009"), AJUSTE_MANUAL(
      "010"),
  CHALLENGE_PRINCIPAL(
      "011"),
  CHALLENGE_SECUNDARIO(
      "012"),
  PRECIO_HORA("013"), RESALTA_MANUAL("014"), COMISION_PROVINCIA(
      "015"),
  PRIMA_FUNCION("016"), PRIMA_PERSONAL("017");

  private final String id;

}
