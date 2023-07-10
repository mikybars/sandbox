/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.primary.limpieza.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
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
import org.mockito.Spy;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class LimpiezaRepositoryCustomImplTest {

  private final static String SQL_PERSONAS_TAREA_CALCULO_AJUSTE_COMISION = "SQL PERSONAS TAREA CALCULO AJUSTE COMISION";

  private final static String SQL_LIMPIEZA_TAREA_CALCULO_AJUSTE_COMISION = "SQL LIMPIEZA TAREA CALCULO AJUSTE COMISION";

  private final static String SQL_TAREA_FASE = "SQL TAREA FASE";

  private final static String SQL_TAREA_FASE_ACCION = "SQL TAREA FASE ACCION";

  private final static String SQL_TAREA_FASE_ACCION_DATO = "SQL TAREA FASE ACCION DATO";

  private final static String SQL_TAREA_FASE_ACCION_VENTA_INTEGRA = "SQL TAREA FASE ACCION VENTA INTEGRA";

  private final static String SQL_LIMPIEZA_TAREA_FASE = "SQL LIMPIEZA TAREA FASE";

  private final static String SQL_LIMPIEZA_TAREA_FASE_ACCION = "SQL LIMPIEZA TAREA FASE ACCION";

  private final static String SQL_LIMPIEZA_TAREA_FASE_ACCION_DATO = "SQL LIMPIEZA TAREA FASE ACCION DATO";

  private final static String SQL_LIMPIEZA_TAREA_FASE_ACCION_VENTA_INTEGRA = "SQL LIMPIEZA TAREA FASE ACCION VENTA INTEGRA";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Spy
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
    FieldUtils.writeField(this.limpiezaRepositoryCustom,
        "sqlTareaFase",
        SQL_TAREA_FASE, true);
    FieldUtils.writeField(this.limpiezaRepositoryCustom,
        "sqlTareaFaseAccion",
        SQL_TAREA_FASE_ACCION, true);
    FieldUtils.writeField(this.limpiezaRepositoryCustom,
        "sqlTareaFaseAccionDato",
        SQL_TAREA_FASE_ACCION_DATO, true);
    FieldUtils.writeField(this.limpiezaRepositoryCustom,
        "sqlTareaFaseAccionVentaIntegra",
        SQL_TAREA_FASE_ACCION_VENTA_INTEGRA, true);
    FieldUtils.writeField(this.limpiezaRepositoryCustom,
        "sqlLimpiezaTareaFase",
        SQL_LIMPIEZA_TAREA_FASE, true);
    FieldUtils.writeField(this.limpiezaRepositoryCustom,
        "sqlLimpiezaTareaFaseAccion",
        SQL_LIMPIEZA_TAREA_FASE_ACCION, true);
    FieldUtils.writeField(this.limpiezaRepositoryCustom,
        "sqlLimpiezaTareaFaseAccionDato",
        SQL_LIMPIEZA_TAREA_FASE_ACCION_DATO, true);
    FieldUtils.writeField(this.limpiezaRepositoryCustom,
        "sqlLimpiezaTareaFaseAccionVentaIntegra",
        SQL_LIMPIEZA_TAREA_FASE_ACCION_VENTA_INTEGRA, true);

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

  @Test
  void limpiezaTareaFaseAccionVentaIntegraTest() {
    final String idTareaFaseAccion = "181818";
    final long idTarea = 191919L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    when(this.namedParameterJdbcTemplate.query(eq(SQL_TAREA_FASE_ACCION_VENTA_INTEGRA),
        any(MapSqlParameterSource.class), any(
            RowMapper.class)))
        .thenReturn(Arrays.asList(IdTareaFaseAccionDto.builder()
            .idTareaFaseAccion(idTareaFaseAccion)
            .build()));

    this.limpiezaRepositoryCustom.limpiezaTareaFaseAccionVentaIntegra(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).batchUpdate(eq(SQL_LIMPIEZA_TAREA_FASE_ACCION_VENTA_INTEGRA),
        this.paramsCaptor.capture());

    final MapSqlParameterSource[] paramsArray = this.paramsCaptor.getValue();
    assertEquals(1, paramsArray.length);

    final MapSqlParameterSource params = paramsArray[0];
    // Parametros: idTareaFaseAccion
    assertEquals(1, params.getValues().size());
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE_ACCION));
    assertEquals(idTareaFaseAccion, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE_ACCION));
  }

  @Test
  void limpiezaTareaFaseAccionDatoTest() {
    final String idTareaFaseAccion = "181818";
    final long idTarea = 191919L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    when(this.namedParameterJdbcTemplate.query(eq(SQL_TAREA_FASE_ACCION_DATO),
        any(MapSqlParameterSource.class), any(
            RowMapper.class)))
        .thenReturn(Arrays.asList(IdTareaFaseAccionDto.builder()
            .idTareaFaseAccion(idTareaFaseAccion)
            .build()));

    this.limpiezaRepositoryCustom.limpiezaTareaFaseAccionDato(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).batchUpdate(eq(SQL_LIMPIEZA_TAREA_FASE_ACCION_DATO),
        this.paramsCaptor.capture());

    final MapSqlParameterSource[] paramsArray = this.paramsCaptor.getValue();
    assertEquals(1, paramsArray.length);

    final MapSqlParameterSource params = paramsArray[0];
    // Parametros: idTareaFaseAccion
    assertEquals(1, params.getValues().size());
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE_ACCION));
    assertEquals(idTareaFaseAccion, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE_ACCION));
  }

  @Test
  void limpiezaTareaFaseAccionTest() {
    final String idTareaFase = "181818";
    final long idTarea = 191919L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    when(this.namedParameterJdbcTemplate.query(eq(SQL_TAREA_FASE_ACCION),
        any(MapSqlParameterSource.class), any(
            RowMapper.class)))
        .thenReturn(Arrays.asList(IdTareaFaseDto.builder()
            .idTareaFase(idTareaFase)
            .build()));

    this.limpiezaRepositoryCustom.limpiezaTareaFaseAccion(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).batchUpdate(eq(SQL_LIMPIEZA_TAREA_FASE_ACCION),
        this.paramsCaptor.capture());

    final MapSqlParameterSource[] paramsArray = this.paramsCaptor.getValue();
    assertEquals(1, paramsArray.length);

    final MapSqlParameterSource params = paramsArray[0];
    // Parametros: idTareaFase
    assertEquals(1, params.getValues().size());
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE));
    assertEquals(idTareaFase, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE));
  }

  @Test
  void limpiezaTareaProfundaTest() {
    final long idTarea = 191919L;
    final long idAmbito = 181818L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);
    tarea.setFechaInicioPeriodo(LocalDate.now());
    final TareaAmbitoDto ambito = new TareaAmbitoDto();
    ambito.setId(idAmbito);
    ambito.setIdTarea(idTarea);
    ambito.setCclIdOrigen("60");

    doNothing().when(this.limpiezaRepositoryCustom).limpieza(tarea, ambito);

    this.limpiezaRepositoryCustom.limpiezaTareaProfunda(tarea, ambito);

    verify(this.namedParameterJdbcTemplate, times(1)).batchUpdate(eq(SQL_LIMPIEZA_TAREA_FASE),
        this.paramsCaptor.capture());

    final MapSqlParameterSource[] paramsArray = this.paramsCaptor.getValue();
    assertEquals(1, paramsArray.length);

    final MapSqlParameterSource params = paramsArray[0];
    // Parametros: idTarea & fechaInicioPeriodo
    assertEquals(2, params.getValues().size());
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO));
    assertEquals(Date.from(TimeUtils.toInstant(tarea.getFechaInicioPeriodo())),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO));

    verify(this.limpiezaRepositoryCustom, times(1)).limpieza(tarea, ambito);
    verify(this.limpiezaRepositoryCustom, times(1)).limpiezaTareaFaseAccionDato(tarea);
    verify(this.limpiezaRepositoryCustom, times(1)).limpiezaTareaFaseAccion(tarea);
    verify(this.limpiezaRepositoryCustom, times(1)).limpiezaTareaFaseAccionVentaIntegra(tarea);

  }

}
