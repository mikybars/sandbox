package com.inditex.rrhh.icmclcwb.api.app;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoEjecucionCalculoEnum {

  MANUAL("1"), PROGRAMADO("2"), SIMULACION("8");

  private final String id;

}
