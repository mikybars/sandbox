package com.inditex.rrhh.icmclcwb.api.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class TypeHealthEnumTest {

  @Test
  void getIdTest() {
    assertEquals(1, TypeHealthEnum.AMIGA_HEALTH_STATUS_UP.getId());
    assertEquals(2, TypeHealthEnum.VALIDATE_RESPONSE_STATUS_CODE_OK.getId());
  }

  @Test
  void getByIdTest() {
    assertEquals(TypeHealthEnum.AMIGA_HEALTH_STATUS_UP, TypeHealthEnum.getById(1));
    assertEquals(TypeHealthEnum.VALIDATE_RESPONSE_STATUS_CODE_OK, TypeHealthEnum.getById(2));
    assertNull(TypeHealthEnum.getById(3));
  }

}
