/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoLimpiezaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoLimpiezaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author javierev
 */
@RunWith(MockitoJUnitRunner.class)
public class TareaLimpiezaRepositoryCustomImplTest {

    private final static String SQL_SAVE_LIMPIEZA = "SAVE";

    private final static String SQL_UPDATE_FECHA = "UPDATE FECHA";

    private final static String SQL_UPDATE_ESTADO = "UPDATE ESTADO";

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Captor
    private ArgumentCaptor<String> sqlCaptor;

    @InjectMocks
    private TareaLimpiezaRepositoryCustomImpl tareaLimpiezaRepositoryCustom;

    @Before
    public void setup() throws IllegalAccessException {
        FieldUtils.writeField(this.tareaLimpiezaRepositoryCustom, "sqlSaveLimpieza", SQL_SAVE_LIMPIEZA, true);
        FieldUtils.writeField(this.tareaLimpiezaRepositoryCustom, "sqlUpdateFechaEjecucion", SQL_UPDATE_FECHA, true);
        FieldUtils.writeField(this.tareaLimpiezaRepositoryCustom, "sqlUpdateEstado", SQL_UPDATE_ESTADO, true);
        // FieldUtils.writeField(this.tareaLimpiezaRepositoryCustom, "batchSize", 100, true);
    }

    @Test
    public void saveTest() {

        final TareaLimpiezaDto limpieza = mock(TareaLimpiezaDto.class);
        when(limpieza.getTipo()).thenReturn(TipoLimpiezaEnum.COMPLETA.getDto());
        when(limpieza.getIdTarea()).thenReturn(12L);
        when(limpieza.getNombreUsuario()).thenReturn("usuario");
        when(limpieza.getEstado()).thenReturn(EstadoLimpiezaEnum.PENDIENTE.getDto());
        this.tareaLimpiezaRepositoryCustom.save(limpieza);
        verify(this.namedParameterJdbcTemplate).update(this.sqlCaptor.capture(), any(MapSqlParameterSource.class));
        assertEquals(SQL_SAVE_LIMPIEZA, this.sqlCaptor.getValue());

    }

    @Test
    public void updateFechaEjecucionTest() {

        this.tareaLimpiezaRepositoryCustom.updateFechaEjecucion(12L);
        verify(this.namedParameterJdbcTemplate).update(this.sqlCaptor.capture(), any(MapSqlParameterSource.class));
        assertEquals(SQL_UPDATE_FECHA, this.sqlCaptor.getValue());

    }

    @Test
    public void updateEstadoTest() {

        this.tareaLimpiezaRepositoryCustom.updateEstado(12L, EstadoLimpiezaEnum.KO.getDto());
        verify(this.namedParameterJdbcTemplate).update(this.sqlCaptor.capture(), any(MapSqlParameterSource.class));
        assertEquals(SQL_UPDATE_ESTADO, this.sqlCaptor.getValue());

    }

}
