package com.inditex.rrhh.icmclcwb.api.app.tarea;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AcccionEnumTest {

  @Test
  void getIdTest() {
    assertEquals(1, AccionEnum.MOTIVOS.getId());
    assertEquals(2, AccionEnum.CONDICIONES_HISTORICO.getId());
    assertEquals(3, AccionEnum.FECHAS.getId());
    assertEquals(4, AccionEnum.PRESENCIAS.getId());
    assertEquals(5, AccionEnum.BAJA.getId());
    assertEquals(6, AccionEnum.CARENCIA.getId());
    assertEquals(7, AccionEnum.RESALTA.getId());
    assertEquals(8, AccionEnum.DESPLAZAMIENTO.getId());
  }

}
