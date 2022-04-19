package com.inditex.rrhh.icmclcwb.api.app.tarea;

/*
 * Copyright (c) 2022. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TipoFallidaEnumTest {

  @Test
  void getIdTest() {
    assertEquals(1, TipoFallidaEnum.PERSONAS.getId());
    assertEquals(2, TipoFallidaEnum.MOTIVOS_DESPLAZAMIENTO.getId());
  }

}
