package com.inditex.rrhh.icmclcwb.api.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoOpcionCalculoEnum;

@RunWith(MockitoJUnitRunner.class)
public class TipoOpcionCalculoEnumTest {

    @Test
    public void testId() {
        assertEquals("02", TipoOpcionCalculoEnum.DESTINO.getIdMeta4());
    }
    
    @Test
    public void testFromIdMeta4() {
        assertEquals(TipoOpcionCalculoEnum.fromIdMeta4("02"), TipoOpcionCalculoEnum.DESTINO);
    }
    
    @Test
    public void testFromId() {
        assertEquals(TipoOpcionCalculoEnum.fromId(2), TipoOpcionCalculoEnum.DESTINO);
    }
    
    @Test
    public void testFromIdMeta4MethodReturnsNull() {
        assertNull(TipoOpcionCalculoEnum.fromIdMeta4("00"));
    }
    
    @Test
    public void testFromIdMethodReturnsNull() {
        assertNull(TipoOpcionCalculoEnum.fromId(0));
    }
}
