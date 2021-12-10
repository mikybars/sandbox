package com.inditex.rrhh.icmclcwb.api.app.calcular.service;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPresupuestoEnum;

import org.junit.jupiter.api.Test;

class TipoPresupuestoEnumTest {

  @Test
  void getIdTest() {
    assertEquals(1, TipoPresupuestoEnum.MENSUAL.getId());
    assertEquals(2, TipoPresupuestoEnum.BIMENSUAL.getId());
    assertEquals(3, TipoPresupuestoEnum.TRIMESTRAL.getId());
    assertEquals(4, TipoPresupuestoEnum.CUATRIMESTRAL.getId());
    assertEquals(5, TipoPresupuestoEnum.SEMESTRAL.getId());
    assertEquals(6, TipoPresupuestoEnum.ANUAL.getId());
    assertEquals(7, TipoPresupuestoEnum.ABIERTO.getId());
  }

  @Test
  void getIdMeta4Test() {
    assertEquals("01", TipoPresupuestoEnum.MENSUAL.getIdMeta4());
    assertEquals("02", TipoPresupuestoEnum.BIMENSUAL.getIdMeta4());
    assertEquals("03", TipoPresupuestoEnum.TRIMESTRAL.getIdMeta4());
    assertEquals("04", TipoPresupuestoEnum.CUATRIMESTRAL.getIdMeta4());
    assertEquals("05", TipoPresupuestoEnum.SEMESTRAL.getIdMeta4());
    assertEquals("06", TipoPresupuestoEnum.ANUAL.getIdMeta4());
    assertEquals("07", TipoPresupuestoEnum.ABIERTO.getIdMeta4());
  }

}
