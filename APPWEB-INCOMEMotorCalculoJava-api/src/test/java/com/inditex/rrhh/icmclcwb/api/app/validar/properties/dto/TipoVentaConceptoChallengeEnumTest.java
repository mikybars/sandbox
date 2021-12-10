package com.inditex.rrhh.icmclcwb.api.app.validar.properties.dto;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoChallengeEnum;

import org.junit.jupiter.api.Test;

class TipoVentaConceptoChallengeEnumTest {

  @Test
  void getIdTest() {
    assertEquals(1L, TipoVentaConceptoChallengeEnum.VENTA_CAJA.getId());
    assertEquals(2L, TipoVentaConceptoChallengeEnum.DEVOLUCIONES_OTRAS_TIENDAS.getId());
    assertEquals(3L, TipoVentaConceptoChallengeEnum.IPOD.getId());
    assertEquals(4L, TipoVentaConceptoChallengeEnum.SINT.getId());
    assertEquals(5L, TipoVentaConceptoChallengeEnum.ENTREGA_TIENDA.getId());
    assertEquals(6L, TipoVentaConceptoChallengeEnum.ENTREGA_DOMICILIO.getId());
  }

  @Test
  void getIdMeta4Test() {
    assertEquals("01", TipoVentaConceptoChallengeEnum.VENTA_CAJA.getIdMeta4());
    assertEquals("02", TipoVentaConceptoChallengeEnum.DEVOLUCIONES_OTRAS_TIENDAS.getIdMeta4());
    assertEquals("03", TipoVentaConceptoChallengeEnum.IPOD.getIdMeta4());
    assertEquals("04", TipoVentaConceptoChallengeEnum.SINT.getIdMeta4());
    assertEquals("05", TipoVentaConceptoChallengeEnum.ENTREGA_TIENDA.getIdMeta4());
    assertEquals("06", TipoVentaConceptoChallengeEnum.ENTREGA_DOMICILIO.getIdMeta4());
  }

}
