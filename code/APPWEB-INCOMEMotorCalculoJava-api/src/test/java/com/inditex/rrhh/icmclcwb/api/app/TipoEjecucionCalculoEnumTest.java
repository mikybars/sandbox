package com.inditex.rrhh.icmclcwb.api.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TipoEjecucionCalculoEnumTest {

  @Test
  void getIdTest() {
    assertEquals("1", TipoEjecucionCalculoEnum.MANUAL.getId());
    assertEquals("2", TipoEjecucionCalculoEnum.PROGRAMADO.getId());
    assertEquals("8", TipoEjecucionCalculoEnum.SIMULACION.getId());
  }

}
