package com.inditex.rrhh.icmclcwb.api.app.proceso;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TipoSistemaDestinoEnumTest {

  @Test
  void ofTest() {
    assertEquals(TipoSistemaDestinoEnum.SIL, TipoSistemaDestinoEnum.of(1));
    assertEquals(TipoSistemaDestinoEnum.AS400, TipoSistemaDestinoEnum.of(2));
    assertEquals(TipoSistemaDestinoEnum.SOLUCION_GLOBAL, TipoSistemaDestinoEnum.of(3));
  }

  @Test
  void ofDtoTest() {
    assertEquals(TipoSistemaDestinoEnum.SIL, TipoSistemaDestinoEnum.of(TipoSistemaDestinoEnum.SIL.getDto()));
    assertEquals(TipoSistemaDestinoEnum.AS400, TipoSistemaDestinoEnum.of(TipoSistemaDestinoEnum.AS400.getDto()));
    assertEquals(TipoSistemaDestinoEnum.SOLUCION_GLOBAL, TipoSistemaDestinoEnum.of(TipoSistemaDestinoEnum.SOLUCION_GLOBAL.getDto()));
  }

}
