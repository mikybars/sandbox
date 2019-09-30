package com.inditex.rrhh.icmclcwb.api.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TipoAmbitoEnumTest {

    @Test
    public void testId() {
        assertEquals("2", TipoAmbitoEnum.ORIGEN.getIcmIdAmbitoEjec());
    }
    
    @Test
    public void testFromIdMethod() {
        assertEquals(TipoAmbitoEnum.fromId(2L), TipoAmbitoEnum.ORIGEN);
    }
    
    @Test
    public void testFromIdMethodReturnsNull() {
        assertNull(TipoAmbitoEnum.fromId(0L));
    }
    
}
