package com.inditex.rrhh.icmclcwb.api.app.calcular;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoUnidadTiempoEnum {

  ANOS(1, "01"), MESES(2, "02"), SEMANAS(3, "03"), DIAS(4, "04"), HORAS(5, "05"), MINUTOS(6, "06"), NINGUNO(0, "00");

  private final Integer id;

  private final String idMeta4;

}
