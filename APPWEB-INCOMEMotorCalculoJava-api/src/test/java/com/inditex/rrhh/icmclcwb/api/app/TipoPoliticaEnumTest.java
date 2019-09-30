package com.inditex.rrhh.icmclcwb.api.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoPoliticaEnum;

@RunWith(MockitoJUnitRunner.class)
public class TipoPoliticaEnumTest {

    @Test
    public void testId() {
        assertEquals("004", TipoPoliticaEnum.ANTIGUEDAD.getIdMeta4());
    }
    
    @Test
    public void testFromIdMeta4() {
        assertEquals(TipoPoliticaEnum.fromIdMeta4("004"), TipoPoliticaEnum.ANTIGUEDAD);
    }
    
    @Test
    public void testFromId() {
        assertEquals(TipoPoliticaEnum.fromId(4L), TipoPoliticaEnum.ANTIGUEDAD);
    }
    
    @Test
    public void testFromIdMeta4MethodReturnsNull() {
        assertNull(TipoPoliticaEnum.fromIdMeta4("000"));
    }
    
    @Test
    public void testFromIdMethodReturnsNull() {
        assertNull(TipoPoliticaEnum.fromId(0L));
    }
    
}
