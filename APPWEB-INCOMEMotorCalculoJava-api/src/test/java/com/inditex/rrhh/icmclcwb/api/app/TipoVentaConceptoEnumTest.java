package com.inditex.rrhh.icmclcwb.api.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TipoVentaConceptoEnumTest {

    @Test
    public void testId() {
        assertEquals("05", TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getIdMeta4());
    }
    
    @Test
    public void testFromIdMeta4() {
        assertEquals(TipoVentaConceptoEnum.fromIdMeta4("05"), TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS);
    }
    
    @Test
    public void testFromId() {
        assertEquals(TipoVentaConceptoEnum.fromId(5L), TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS);
    }
    
    @Test
    public void testFromIdMeta4MethodReturnsNull() {
        assertNull(TipoVentaConceptoEnum.fromIdMeta4("00"));
    }
    
    @Test
    public void testFromIdMethodReturnsNull() {
        assertNull(TipoVentaConceptoEnum.fromId(0L));
    }
}
