package com.inditex.rrhh.icmclcwb.api.app.proceso;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TipoProcesoEnumTest {

  @Test
  void ofTest() {
    assertEquals(TipoProcesoEnum.CONFIRMACION, TipoProcesoEnum.of(1));
    assertEquals(TipoProcesoEnum.EXPORTACION, TipoProcesoEnum.of(2));
    assertEquals(TipoProcesoEnum.ANULACION_CONFIRMACION, TipoProcesoEnum.of(3));
    assertEquals(TipoProcesoEnum.ANULACION_EXPORTACION, TipoProcesoEnum.of(4));
  }

  @Test
  void ofDtoTest() {
    assertEquals(TipoProcesoEnum.CONFIRMACION, TipoProcesoEnum.of(TipoProcesoEnum.CONFIRMACION.getDto()));
    assertEquals(TipoProcesoEnum.EXPORTACION, TipoProcesoEnum.of(TipoProcesoEnum.EXPORTACION.getDto()));
    assertEquals(TipoProcesoEnum.ANULACION_CONFIRMACION, TipoProcesoEnum.of(TipoProcesoEnum.ANULACION_CONFIRMACION.getDto()));
    assertEquals(TipoProcesoEnum.ANULACION_EXPORTACION, TipoProcesoEnum.of(TipoProcesoEnum.ANULACION_EXPORTACION.getDto()));
  }

}
