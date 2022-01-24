package com.inditex.rrhh.icmclcwb.api.app;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ComisClaseEmpleadoEnum {

  EMPLEADO_EXTERNO_BRASIL(99), EMPLEADO_EXTERNO_BOSNIA(2);

  private final Integer id;

}
