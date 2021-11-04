/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.app.tarea;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author javierev
 */

class FaseEnumTest {

    @Test
    void fromIdExistingValue() {
        final Integer id = FaseEnum.REGULARIZAR.getId();
        assertEquals(FaseEnum.REGULARIZAR, FaseEnum.fromId(id));
    }

    @Test
    void fromIdNonExistingValue() {
        final Integer id = -1;
        assertNull(FaseEnum.fromId(id));
    }

}
