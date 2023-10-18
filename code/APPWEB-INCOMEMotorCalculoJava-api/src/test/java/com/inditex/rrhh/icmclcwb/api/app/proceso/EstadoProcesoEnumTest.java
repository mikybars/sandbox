package com.inditex.rrhh.icmclcwb.api.app.proceso;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EstadoProcesoEnumTest {

    @Test
    void ofTest() {
        assertEquals(EstadoProcesoEnum.PENDIENTE, EstadoProcesoEnum.of(1));
        assertEquals(EstadoProcesoEnum.EN_CURSO, EstadoProcesoEnum.of(2));
        assertEquals(EstadoProcesoEnum.FINALIZADO_SIN_ERRORES, EstadoProcesoEnum.of(3));
        assertEquals(EstadoProcesoEnum.FINALIZADO_CON_ERRORES, EstadoProcesoEnum.of(4));
        assertEquals(EstadoProcesoEnum.ERROR, EstadoProcesoEnum.of(5));
        assertEquals(EstadoProcesoEnum.ERROR_VALIDACION, EstadoProcesoEnum.of(6));
    }

    @Test
    void ofDtoTest() {
        assertEquals(EstadoProcesoEnum.PENDIENTE, EstadoProcesoEnum.of(EstadoProcesoEnum.PENDIENTE.getDto()));
        assertEquals(EstadoProcesoEnum.EN_CURSO, EstadoProcesoEnum.of(EstadoProcesoEnum.EN_CURSO.getDto()));
        assertEquals(EstadoProcesoEnum.FINALIZADO_SIN_ERRORES, EstadoProcesoEnum.of(EstadoProcesoEnum.FINALIZADO_SIN_ERRORES.getDto()));
        assertEquals(EstadoProcesoEnum.FINALIZADO_CON_ERRORES, EstadoProcesoEnum.of(EstadoProcesoEnum.FINALIZADO_CON_ERRORES.getDto()));
        assertEquals(EstadoProcesoEnum.ERROR, EstadoProcesoEnum.of(EstadoProcesoEnum.ERROR.getDto()));
        assertEquals(EstadoProcesoEnum.ERROR_VALIDACION, EstadoProcesoEnum.of(EstadoProcesoEnum.ERROR_VALIDACION.getDto()));
    }

}
