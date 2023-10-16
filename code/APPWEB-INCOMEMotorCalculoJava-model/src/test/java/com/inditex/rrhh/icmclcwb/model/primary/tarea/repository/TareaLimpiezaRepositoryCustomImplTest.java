/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoLimpiezaEnum;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
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

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaLimpiezaRepositoryCustom, "sqlUpdateFechaFinalizacion", SQL_UPDATE_FECHA, true);
    FieldUtils.writeField(this.tareaLimpiezaRepositoryCustom, "sqlUpdateEstado", SQL_UPDATE_ESTADO, true);
    // FieldUtils.writeField(this.tareaLimpiezaRepositoryCustom, "batchSize", 100, true);
  }

  @Test
  public void updateFechaFinalizacionTest() {

    this.tareaLimpiezaRepositoryCustom.updateFechaFinalizacion(12L);
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
