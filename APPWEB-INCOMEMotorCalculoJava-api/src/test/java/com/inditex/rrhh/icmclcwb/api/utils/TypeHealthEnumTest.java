package com.inditex.rrhh.icmclcwb.api.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TypeHealthEnumTest {

    @Test
    public void getIdTest() {
        assertEquals(TypeHealthEnum.AMIGA_HEALTH_STATUS_UP.getId(), 1);
        assertEquals(TypeHealthEnum.VALIDATE_RESPONSE_STATUS_CODE_OK.getId(), 2);
    }

    @Test
    public void gtByIdTest() {
        assertEquals(TypeHealthEnum.getById(1), TypeHealthEnum.AMIGA_HEALTH_STATUS_UP);
        assertEquals(TypeHealthEnum.getById(2), TypeHealthEnum.VALIDATE_RESPONSE_STATUS_CODE_OK);
        assertNull(TypeHealthEnum.getById(3));
    }

}
