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
        assertEquals(TipoPoliticaEnum.fromId(4), TipoPoliticaEnum.ANTIGUEDAD);
    }
    
    @Test
    public void testFromIdMeta4MethodReturnsNull() {
        //No debería existir un tipo de política con id negativo
        assertNull(TipoPoliticaEnum.fromIdMeta4("-001"));
    }
    
    @Test
    public void testFromIdMethodReturnsNull() {
        //No debería existir un tipo de política con id negativo
        assertNull(TipoPoliticaEnum.fromId(-1));
    }
    
}
