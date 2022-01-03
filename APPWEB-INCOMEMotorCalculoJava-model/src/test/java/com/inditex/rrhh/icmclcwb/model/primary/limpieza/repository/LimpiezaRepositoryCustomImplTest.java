/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.primary.limpieza.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class LimpiezaRepositoryCustomImplTest {

  private final static String SQL_PERSONAS_TAREA_CALCULO_AJUSTE_COMISION = "SQL PERSONAS TAREA CALCULO AJUSTE COMISION";

  private final static String SQL_LIMPIEZA_TAREA_CALCULO_AJUSTE_COMISION = "SQL LIMPIEZA TAREA CALCULO AJUSTE COMISION";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private LimpiezaRepositoryCustomImpl limpiezaRepositoryCustom;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource[]> paramsCaptor;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.limpiezaRepositoryCustom,
        "sqlPersonasTareaCalculoAjusteComision",
        SQL_PERSONAS_TAREA_CALCULO_AJUSTE_COMISION, true);
    FieldUtils.writeField(this.limpiezaRepositoryCustom,
        "sqlLimpiezaTareaCalculoAjusteComision",
        SQL_LIMPIEZA_TAREA_CALCULO_AJUSTE_COMISION, true);
    FieldUtils.writeField(this.limpiezaRepositoryCustom, "batchSize", 1, true);
  }

  @Test
  void limpiezaTareaCalculoAjusteComisionTest() {

    final String idPersonaLocal = "92929";
    final String orPersonaLocal = "1";

    when(this.namedParameterJdbcTemplate.query(eq(SQL_PERSONAS_TAREA_CALCULO_AJUSTE_COMISION),
        any(MapSqlParameterSource.class), any(
            RowMapper.class)))
                .thenReturn(Arrays.asList(IdPersonaLocalDto.builder()
                    .idPersonaLocal(idPersonaLocal)
                    .stdOrHrPeriod(orPersonaLocal)
                    .build()));

    final long idTarea = 191919L;
    final LocalDate fechaInicioPeriodo = LocalDate.of(2021, 1, 1);
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);
    tarea.setFechaInicioPeriodo(fechaInicioPeriodo);
    this.limpiezaRepositoryCustom.limpiezaTareaCalculoAjusteComision(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).batchUpdate(eq(SQL_LIMPIEZA_TAREA_CALCULO_AJUSTE_COMISION),
        this.paramsCaptor.capture());

    final MapSqlParameterSource[] paramsArray = this.paramsCaptor.getValue();
    assertEquals(1, paramsArray.length);
    final MapSqlParameterSource params = paramsArray[0];
    // parametros: idTarea, fechaInicioPeriodo, cclIdPerson, stdOrHrPeriod
    assertEquals(4, params.getValues().size());
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO));
    assertEquals(TimeUtils.toDate(fechaInicioPeriodo),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO));
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
    assertEquals(idPersonaLocal, params.getValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON));
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
    assertEquals(orPersonaLocal, params.getValue(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD));
  }

}
