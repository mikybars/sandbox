/*
 * Copyright (c) 2021. Inditex
 */
package com.inditex.rrhh.icmclcwb.model.primary.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlComisConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class PrimaryTemporaryTableRepositoryCustomTest {

  private final static String ID_TAREA_PARAM = "idTarea";

  private final static String INACTIVO_PARAM = "inactivo";

  private final static String IMPORTE_PARAM = "importe";

  private final static Integer SQL_ZERO_VALUE = 0;

  private final static String FECHA_INICIO_PERIODO_PARAM = "fechaInicioPeriodo";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Mock
  private JdbcTemplate jdbcTemplate;

  @InjectMocks
  private PrimaryTemporaryTableRepositoryCustomImpl primaryTemporaryTableRepositoryCustom;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  // baja it

  private final static String SQL_CREATE_TEMP_COMIS_BAJA_IT = "SQL CREATE TEMP COMIS BAJA IT";

  private final static String SQL_INSERT_TEMP_COMIS_BAJA_IT = "SQL INSERT TEMP COMIS BAJA IT";

  private final static String SQL_VALIDATE_TEMP_COMIS_BAJA_IT = "SQL VALDIATE TEMP COMIS BAJA IT";

  private final static String SQL_DELETE_TEMP_COMIS_BAJA_IT = "SQL DELETE TEMP COMIS BAJA IT";

  // carencia

  private final static String SQL_CREATE_TEMP_COMIS_CARENCIA = "SQL CREATE TEMP COMIS CARENCIA";

  private final static String SQL_INSERT_TEMP_COMIS_CARENCIA = "SQL INSERT TEMP COMIS CARENCIA";

  private final static String SQL_VALIDATE_TEMP_COMIS_CARENCIA = "SQL VALDIATE TEMP COMIS CARENCIA";

  private final static String SQL_DELETE_TEMP_COMIS_CARENCIA = "SQL DELETE TEMP COMIS CARENCIA";

  // desplazamientos

  private final static String SQL_CREATE_TEMP_COMIS_DESPLAZAMIENTOS = "SQL CREATE TEMP COMIS DESPLAZAMIENTOS";

  private final static String SQL_INSERT_TEMP_COMIS_DESPLAZAMIENTOS = "SQL INSERT TEMP COMIS DESPLAZAMIENTOS";

  private final static String SQL_VALIDATE_TEMP_COMIS_DESPLAZAMIENTOS = "SQL VALDIATE TEMP COMIS DESPLAZAMIENTOS";

  private final static String SQL_DELETE_TEMP_COMIS_DESPLAZAMIENTOS = "SQL DELETE TEMP COMIS DESPLAZAMIENTOS";

  // historico

  private final static String SQL_CREATE_TEMP_COMIS_HISTORICO = "SQL CREATE TEMP COMIS HISTORICO";

  private final static String SQL_INSERT_TEMP_COMIS_HISTORICO = "SQL INSERT TEMP COMIS HISTORICO";

  private final static String SQL_VALIDATE_TEMP_COMIS_HISTORICO = "SQL VALDIATE TEMP COMIS HISTORICO";

  private final static String SQL_DELETE_TEMP_COMIS_HISTORICO = "SQL DELETE TEMP COMIS HISTORICO";

  // resalta

  private final static String SQL_CREATE_TEMP_COMIS_RESALTA = "SQL CREATE TEMP COMIS RESALTA";

  private final static String SQL_INSERT_TEMP_COMIS_RESALTA = "SQL INSERT TEMP COMIS RESALTA";

  private final static String SQL_VALIDATE_TEMP_COMIS_RESALTA = "SQL VALDIATE TEMP COMIS RESALTA";

  private final static String SQL_DELETE_TEMP_COMIS_RESALTA = "SQL DELETE TEMP COMIS RESALTA";

  // primas

  private final static String SQL_CREATE_TEMP_COMIS_PRIMAS = "SQL CREATE TEMP COMIS PRIMAS";

  private final static String SQL_INSERT_TEMP_COMIS_PRIMAS = "SQL INSERT TEMP COMIS PRIMAS";

  private final static String SQL_VALIDATE_TEMP_COMIS_PRIMAS = "SQL VALDIATE TEMP COMIS PRIMAS";

  private final static String SQL_DELETE_TEMP_COMIS_PRIMAS = "SQL DELETE TEMP COMIS PRIMAS";

  private final static String SQL_MERGE_DATE_RANGES_SECCION_NOT_EQUALS_TEMP_COMIS_PRIMAS =
      "SQL MERGE DATE RANGES SECCION NOT EQUALS TEMP COMIS PRIMAS";

  private final static String SQL_MERGE_DATE_RANGES_TEMP_COMIS_PRIMAS = "SQL MERGE DATE RANGES TEMP COMIS PRIMAS";

  // totalizacion tarea calculo

  private final static String SQL_CREATE_TEMP_CALCULO_POR_COMISION = "SQL CREATE TEMP CALCULO POR COMISION";

  private final static String SQL_MERGE_CALCULO_TEMP_CALCULO_POR_COMISION = "SQL MERGE TEMP CALCULO POR COMISION";

  private final static String SQL_MERGE_CALCULO_TEMP_CALCULO_SIN_COMISION = "SQL MERGE TEMP CALCULO SIN COMISION";

  private final static String SQL_DELETE_TEMP_CALCULO_POR_COMISION = "SQL DELETE TEMP CALCULO POR COMISION";

  // totalizacion tarea calculo ajuste

  private final static String SQL_CREATE_TEMP_CALCULO_AJUSTE_TOTALIZADO = "SQL CREATE TEMP CALCULO AJUSTE TOTALIZADO";

  private final static String SQL_MERGE_CALCULO_TEMP_CALCULO_AJUSTE_TOTALIZADO = "SQL MERGE TEMP CALCULO AJUSTE TOTALIZADO";

  private final static String SQL_DELETE_TEMP_CALCULO_AJUSTE_TOTALIZADO = "SQL DELETE TEMP CALCULO AJUSTE TOTALIZADO";

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom, "batchSize", 3, true);

    // baja it
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempComisBajaIt", SQL_CREATE_TEMP_COMIS_BAJA_IT, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlInsertTempComisBajaIt", SQL_INSERT_TEMP_COMIS_BAJA_IT, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlValidateTempComisBajaIt", SQL_VALIDATE_TEMP_COMIS_BAJA_IT, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempComisBajaIt", SQL_DELETE_TEMP_COMIS_BAJA_IT, true);

    // carencia
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempComisCarencia", SQL_CREATE_TEMP_COMIS_CARENCIA, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlInsertTempComisCarencia", SQL_INSERT_TEMP_COMIS_CARENCIA, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlValidateTempComisCarencia", SQL_VALIDATE_TEMP_COMIS_CARENCIA, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempComisCarencia", SQL_DELETE_TEMP_COMIS_CARENCIA, true);

    // desplazamientos
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempComisDesplazamiento", SQL_CREATE_TEMP_COMIS_DESPLAZAMIENTOS, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlInsertTempComisDesplazamiento", SQL_INSERT_TEMP_COMIS_DESPLAZAMIENTOS, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlValidateTempComisDesplazamiento", SQL_VALIDATE_TEMP_COMIS_DESPLAZAMIENTOS, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempComisDesplazamiento", SQL_DELETE_TEMP_COMIS_DESPLAZAMIENTOS, true);

    // historico
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempComisHistorico", SQL_CREATE_TEMP_COMIS_HISTORICO, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlInsertTempComisHistorico", SQL_INSERT_TEMP_COMIS_HISTORICO, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlValidateTempComisHistorico", SQL_VALIDATE_TEMP_COMIS_HISTORICO, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempComisHistorico", SQL_DELETE_TEMP_COMIS_HISTORICO, true);

    // resalta
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempComisResalta", SQL_CREATE_TEMP_COMIS_RESALTA, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlInsertTempComisResalta", SQL_INSERT_TEMP_COMIS_RESALTA, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlValidateTempComisResalta", SQL_VALIDATE_TEMP_COMIS_RESALTA, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempComisResalta", SQL_DELETE_TEMP_COMIS_RESALTA, true);

    // primas
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempComisPrimas", SQL_CREATE_TEMP_COMIS_PRIMAS, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlInsertTempComisPrimas", SQL_INSERT_TEMP_COMIS_PRIMAS, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlValidateTempComisPrimas", SQL_VALIDATE_TEMP_COMIS_PRIMAS, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempComisPrimas", SQL_DELETE_TEMP_COMIS_PRIMAS, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlMergeDateRangesTempComisPrimas", SQL_MERGE_DATE_RANGES_TEMP_COMIS_PRIMAS, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlMergeDateRangesSeccionNotEqualsTempComisPrimas",
        SQL_MERGE_DATE_RANGES_SECCION_NOT_EQUALS_TEMP_COMIS_PRIMAS, true);

    // totalizacion calculo por comision
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempCalculoPorComision", SQL_CREATE_TEMP_CALCULO_POR_COMISION, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlMergeCalculoTempCalculoPorComision", SQL_MERGE_CALCULO_TEMP_CALCULO_POR_COMISION, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlMergeCalculoTempCalculoSinComision", SQL_MERGE_CALCULO_TEMP_CALCULO_SIN_COMISION, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempCalculoPorComision", SQL_DELETE_TEMP_CALCULO_POR_COMISION, true);

    // totalizacion calculo ajuste
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlCreateTempCalculoAjusteTotalizado", SQL_CREATE_TEMP_CALCULO_AJUSTE_TOTALIZADO, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlMergeCalculoAjusteTotalizado", SQL_MERGE_CALCULO_TEMP_CALCULO_AJUSTE_TOTALIZADO, true);
    FieldUtils.writeField(this.primaryTemporaryTableRepositoryCustom,
        "sqlDeleteTempCalculoAjusteTotalizado", SQL_DELETE_TEMP_CALCULO_AJUSTE_TOTALIZADO, true);

  }

  // Inicio tests baja it

  @Test
  void createTempComisBajaItTest() {
    this.primaryTemporaryTableRepositoryCustom.createTempComisBajaIt();
    verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_COMIS_BAJA_IT);
  }

  @Test
  void insertTempComisBajaItTest() {

    final List<IdPersonaLocalCondicionesDto> condiciones = new ArrayList<>();
    final IdPersonaLocalCondicionesDto persona = mock(IdPersonaLocalCondicionesDto.class);
    condiciones.add(persona);

    this.primaryTemporaryTableRepositoryCustom.insertTempComisBajaIt(condiciones);
    verify(this.jdbcTemplate).batchUpdate(eq(SQL_INSERT_TEMP_COMIS_BAJA_IT),
        any(BatchPreparedStatementSetter.class));

  }

  @Test
  void validateTempComisBajaItTest() {

    final TareaDto tarea = mock(TareaDto.class);
    final long idTarea = 1234L;
    when(tarea.getId()).thenReturn(idTarea);

    this.primaryTemporaryTableRepositoryCustom.validateTempComisBajaIt(tarea);
    verify(this.namedParameterJdbcTemplate).query(eq(SQL_VALIDATE_TEMP_COMIS_BAJA_IT), this.paramsCaptor.capture(),
        any(RowMapper.class));

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(1, params.getValues().size());
    assertTrue(params.hasValue(ID_TAREA_PARAM));
    assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));

  }

  @Test
  void deleteTempComisBajaItTest() {
    this.primaryTemporaryTableRepositoryCustom.deleteTempComisBajaIt();
    verify(this.jdbcTemplate).update(SQL_DELETE_TEMP_COMIS_BAJA_IT);
  }

  // Fin tests baja it

  // Inicio tests carencias

  @Test
  void createTempComisCarenciaTest() {
    this.primaryTemporaryTableRepositoryCustom.createTempComisCarencia();
    verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_COMIS_CARENCIA);
  }

  @Test
  void insertTempComisCarenciaTest() {

    final List<IdPersonaLocalCarenciaDto> condiciones = new ArrayList<>();
    final IdPersonaLocalCarenciaDto persona = mock(IdPersonaLocalCarenciaDto.class);
    condiciones.add(persona);

    this.primaryTemporaryTableRepositoryCustom.insertTempComisCarencia(condiciones);
    verify(this.jdbcTemplate).batchUpdate(eq(SQL_INSERT_TEMP_COMIS_CARENCIA),
        any(BatchPreparedStatementSetter.class));

  }

  @Test
  void validateTempComisCarenciaTest() {

    final TareaDto tarea = mock(TareaDto.class);
    final long idTarea = 1234L;
    when(tarea.getId()).thenReturn(idTarea);

    this.primaryTemporaryTableRepositoryCustom.validateTempComisCarencia(tarea);
    verify(this.namedParameterJdbcTemplate).query(eq(SQL_VALIDATE_TEMP_COMIS_CARENCIA), this.paramsCaptor.capture(),
        any(RowMapper.class));

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(1, params.getValues().size());
    assertTrue(params.hasValue(ID_TAREA_PARAM));
    assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));

  }

  @Test
  void deleteTempComisCarenciaTest() {
    this.primaryTemporaryTableRepositoryCustom.deleteTempComisCarencia();
    verify(this.jdbcTemplate).update(SQL_DELETE_TEMP_COMIS_CARENCIA);
  }

  // Fin tests carencias

  // Inicio tests desplazamientos

  @Test
  void createTempComisDesplazamientoTest() {
    this.primaryTemporaryTableRepositoryCustom.createTempComisDesplazamiento();
    verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_COMIS_DESPLAZAMIENTOS);
  }

  @Test
  void insertTempComisDesplazamientoTest() {

    final List<IdPersonaLocalCondicionesDto> condiciones = new ArrayList<>();
    final IdPersonaLocalCondicionesDto persona = mock(IdPersonaLocalCondicionesDto.class);
    condiciones.add(persona);

    this.primaryTemporaryTableRepositoryCustom.insertTempComisDesplazamiento(condiciones);
    verify(this.jdbcTemplate).batchUpdate(eq(SQL_INSERT_TEMP_COMIS_DESPLAZAMIENTOS),
        any(BatchPreparedStatementSetter.class));

  }

  @Test
  void validateTempComisDesplazamientoTest() {

    final TareaDto tarea = mock(TareaDto.class);
    final LocalDate fechaInicio = LocalDate.of(2020, 01, 01);
    final long idTarea = 1234L;
    when(tarea.getId()).thenReturn(idTarea);

    this.primaryTemporaryTableRepositoryCustom.validateTempComisDesplazamiento(tarea);
    verify(this.namedParameterJdbcTemplate).query(eq(SQL_VALIDATE_TEMP_COMIS_DESPLAZAMIENTOS),
        this.paramsCaptor.capture(),
        any(RowMapper.class));

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(1, params.getValues().size());
    assertTrue(params.hasValue(ID_TAREA_PARAM));
    assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));

  }

  @Test
  void deleteTempComisDesplazamientoTest() {
    this.primaryTemporaryTableRepositoryCustom.deleteTempComisDesplazamiento();
    verify(this.jdbcTemplate).update(SQL_DELETE_TEMP_COMIS_DESPLAZAMIENTOS);
  }

  // Fin tests desplazamientos

  // Inicio tests historico

  @Test
  void createTempComisHistoricoTest() {
    this.primaryTemporaryTableRepositoryCustom.createTempComisHistorico();
    verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_COMIS_HISTORICO);
  }

  @Test
  void insertTempComisHistoricoTest() {

    final List<IdPersonaLocalCondicionesDto> condiciones = new ArrayList<>();
    final IdPersonaLocalCondicionesDto persona = mock(IdPersonaLocalCondicionesDto.class);
    condiciones.add(persona);

    this.primaryTemporaryTableRepositoryCustom.insertTempComisHistorico(condiciones);
    verify(this.jdbcTemplate).batchUpdate(eq(SQL_INSERT_TEMP_COMIS_HISTORICO),
        any(BatchPreparedStatementSetter.class));

  }

  @Test
  void validateTempComisHistoricoTest() {

    final TareaDto tarea = mock(TareaDto.class);
    final long idTarea = 1234L;
    when(tarea.getId()).thenReturn(idTarea);

    this.primaryTemporaryTableRepositoryCustom.validateTempComisHistorico(tarea);
    verify(this.namedParameterJdbcTemplate).query(eq(SQL_VALIDATE_TEMP_COMIS_HISTORICO),
        this.paramsCaptor.capture(),
        any(RowMapper.class));

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(1, params.getValues().size());
    assertTrue(params.hasValue(ID_TAREA_PARAM));
    assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));

  }

  @Test
  void deleteTempComisHistoricoTest() {
    this.primaryTemporaryTableRepositoryCustom.deleteTempComisHistorico();
    verify(this.jdbcTemplate).update(SQL_DELETE_TEMP_COMIS_HISTORICO);
  }

  // Fin tests historico

  // Inicio tests resalta

  @Test
  void createTempComisResaltaTest() {
    this.primaryTemporaryTableRepositoryCustom.createTempComisResalta();
    verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_COMIS_RESALTA);
  }

  @Test
  void insertTempComisResaltaTest() {

    final List<IdPersonaLocalCondicionesDto> condiciones = new ArrayList<>();
    final IdPersonaLocalCondicionesDto persona = mock(IdPersonaLocalCondicionesDto.class);
    condiciones.add(persona);

    this.primaryTemporaryTableRepositoryCustom.insertTempComisResalta(condiciones);
    verify(this.jdbcTemplate).batchUpdate(eq(SQL_INSERT_TEMP_COMIS_RESALTA),
        any(BatchPreparedStatementSetter.class));

  }

  @Test
  void validateTempComisResaltaTest() {

    final TareaDto tarea = mock(TareaDto.class);
    final long idTarea = 1234L;
    when(tarea.getId()).thenReturn(idTarea);

    this.primaryTemporaryTableRepositoryCustom.validateTempComisResalta(tarea);
    verify(this.namedParameterJdbcTemplate).query(eq(SQL_VALIDATE_TEMP_COMIS_RESALTA),
        this.paramsCaptor.capture(),
        any(RowMapper.class));

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(1, params.getValues().size());
    assertTrue(params.hasValue(ID_TAREA_PARAM));
    assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));

  }

  @Test
  void deleteTempComisResaltaTest() {
    this.primaryTemporaryTableRepositoryCustom.deleteTempComisResalta();
    verify(this.jdbcTemplate).update(SQL_DELETE_TEMP_COMIS_RESALTA);
  }

  // Fin tests resalta

  // Inicio tests prima

  @Test
  void createTempComisPrimasTest() {
    this.primaryTemporaryTableRepositoryCustom.createTempComisPrimas();
    verify(this.jdbcTemplate).update(SQL_CREATE_TEMP_COMIS_PRIMAS);
  }

  @Test
  void insertTempComisPrimasTest() {

    final List<IdPersonaLocalCondicionesDto> condiciones = new ArrayList<>();
    final IdPersonaLocalCondicionesDto persona = mock(IdPersonaLocalCondicionesDto.class);
    condiciones.add(persona);

    this.primaryTemporaryTableRepositoryCustom.insertTempComisPrimas(condiciones);
    verify(this.jdbcTemplate).batchUpdate(eq(SQL_INSERT_TEMP_COMIS_PRIMAS),
        any(BatchPreparedStatementSetter.class));

  }

  @Test
  void deleteTempComisPrimasTest() {
    this.primaryTemporaryTableRepositoryCustom.deleteTempComisPrimas();
    verify(this.jdbcTemplate).update(SQL_DELETE_TEMP_COMIS_PRIMAS);
  }

  @Test
  void mergeDateRangesSeccionNotEqualsTempComisPrimasTest() {
    final TareaDto tarea = new TareaDto();
    final long idTarea = 1919L;
    tarea.setId(idTarea);
    final LocalDate fechaFinPeriodo = LocalDate.of(2020, 8, 31);
    tarea.setFechaFinPeriodo(fechaFinPeriodo);
    this.primaryTemporaryTableRepositoryCustom.mergeDateRangesSeccionNotEqualsTempComisPrimas(tarea);
    verify(this.namedParameterJdbcTemplate).update(eq(SQL_MERGE_DATE_RANGES_SECCION_NOT_EQUALS_TEMP_COMIS_PRIMAS),
        this.paramsCaptor.capture());
    // parametros: id tarea, fechaHasta
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(2, params.getValues().size());
    // id tarea
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue(SqlComisConstants.SQL_PARAM_ID_TAREA));
    // fecha hasta
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
    assertEquals(TimeUtils.toDate(fechaFinPeriodo), params.getValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
  }

  @Test
  void mergeDateRangesTempComisPrimasTest() {
    final TareaDto tarea = new TareaDto();
    final long idTarea = 1919L;
    tarea.setId(idTarea);
    final LocalDate fechaFinPeriodo = LocalDate.of(2020, 8, 31);
    tarea.setFechaFinPeriodo(fechaFinPeriodo);
    this.primaryTemporaryTableRepositoryCustom.mergeDateRangesTempComisPrimas(tarea);
    verify(this.namedParameterJdbcTemplate).update(eq(SQL_MERGE_DATE_RANGES_TEMP_COMIS_PRIMAS),
        this.paramsCaptor.capture());
    // parametros: id tarea, fechaHasta
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(2, params.getValues().size());
    // id tarea
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue(SqlComisConstants.SQL_PARAM_ID_TAREA));
    // fecha hasta
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
    assertEquals(TimeUtils.toDate(fechaFinPeriodo), params.getValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
  }

  @Test
  void validateTempComisPrimasTest() {

    final TareaDto tarea = mock(TareaDto.class);
    final long idTarea = 1234L;
    when(tarea.getId()).thenReturn(idTarea);

    this.primaryTemporaryTableRepositoryCustom.validateTempComisPrimas(tarea);
    verify(this.namedParameterJdbcTemplate).query(eq(SQL_VALIDATE_TEMP_COMIS_PRIMAS),
        this.paramsCaptor.capture(),
        any(RowMapper.class));

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(1, params.getValues().size());
    assertTrue(params.hasValue(ID_TAREA_PARAM));
    assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));

  }

  // Fin tests prima

  // Tests totalizacion tarea calculo

  @Test
  void createTempCalculoPorComisionTest() {
    final int result = 10;
    when(this.jdbcTemplate.update(any(String.class))).thenReturn(result);
    assertEquals(result, this.primaryTemporaryTableRepositoryCustom.createTempCalculoPorComision());
    verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_CALCULO_POR_COMISION);
  }

  @Test
  void mergeCalculoTempCalculoPorComisionNumParamsTest() {
    final long idTarea = 12L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoPorComision(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_CALCULO_TEMP_CALCULO_POR_COMISION),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(3, params.getValues().size());

  }

  @Test
  void mergeCalculoTempCalculoPorComisionIdTareaParamTest() {
    final long idTarea = 12L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoPorComision(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_CALCULO_TEMP_CALCULO_POR_COMISION),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(ID_TAREA_PARAM));
    assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));

  }

  @Test
  void mergeCalculoTempCalculoPorComisionInactivoParamTest() {
    final long idTarea = 12L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoPorComision(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_CALCULO_TEMP_CALCULO_POR_COMISION),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(INACTIVO_PARAM));
    assertEquals(SQL_ZERO_VALUE, params.getValue(INACTIVO_PARAM));

  }

  @Test
  void mergeCalculoTempCalculoPorComisionImporteParamTest() {
    final long idTarea = 12L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoPorComision(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_CALCULO_TEMP_CALCULO_POR_COMISION),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(IMPORTE_PARAM));
    assertEquals(SQL_ZERO_VALUE, params.getValue(IMPORTE_PARAM));

  }

  @Test
  void mergeCalculoTempCalculoSinComisionNumParamsTest() {
    final long idTarea = 12L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoSinComision(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_CALCULO_TEMP_CALCULO_SIN_COMISION),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(3, params.getValues().size());
  }

  @Test
  void mergeCalculoTempCalculoSinComisionIdTareaParamTest() {
    final long idTarea = 12L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoSinComision(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_CALCULO_TEMP_CALCULO_SIN_COMISION),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(ID_TAREA_PARAM));
    assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));

  }

  @Test
  void mergeCalculoTempCalculoSinComisionInactivoParamTest() {
    final long idTarea = 12L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoSinComision(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_CALCULO_TEMP_CALCULO_SIN_COMISION),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(INACTIVO_PARAM));
    assertEquals(SQL_ZERO_VALUE, params.getValue(INACTIVO_PARAM));

  }

  @Test
  void mergeCalculoTempCalculoSinComisionImporteParamTest() {
    final long idTarea = 12L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoSinComision(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_CALCULO_TEMP_CALCULO_SIN_COMISION),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(IMPORTE_PARAM));
    assertEquals(SQL_ZERO_VALUE, params.getValue(IMPORTE_PARAM));

  }

  @Test
  void deleteTempCalculoPorComisionTest() {
    final int result = 90;
    when(this.jdbcTemplate.update(any(String.class))).thenReturn(result);
    assertEquals(result, this.primaryTemporaryTableRepositoryCustom.deleteTempCalculoPorComision());
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_CALCULO_POR_COMISION);
  }

  // Fin tests totalizacion tarea calculo

  // Tests totalizacion tarea calculo ajuste

  @Test
  void createTempCalculoAjusteTotalizadoTest() {
    final int result = 10;
    when(this.jdbcTemplate.update(any(String.class))).thenReturn(result);
    assertEquals(result, this.primaryTemporaryTableRepositoryCustom.createTempCalculoAjusteTotalizado());
    verify(this.jdbcTemplate, times(1)).update(SQL_CREATE_TEMP_CALCULO_AJUSTE_TOTALIZADO);
  }

  @Test
  void deleteTempCalculoAjusteTotalizadoTest() {
    final int result = 90;
    when(this.jdbcTemplate.update(any(String.class))).thenReturn(result);
    assertEquals(result, this.primaryTemporaryTableRepositoryCustom.deleteTempCalculoAjusteTotalizado());
    verify(this.jdbcTemplate, times(1)).update(SQL_DELETE_TEMP_CALCULO_AJUSTE_TOTALIZADO);
  }

  @Test
  void mergeCalculoTempCalculoAjusteTotalizadoNumParamsTest() {
    final long idTarea = 12L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoAjusteTotalizado(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_CALCULO_TEMP_CALCULO_AJUSTE_TOTALIZADO),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(2, params.getValues().size());

  }

  @Test
  void mergeCalculoTempCalculoAjusteTotalizadoIdTareaParamTest() {
    final long idTarea = 12L;
    final TareaDto tarea = new TareaDto();
    tarea.setId(idTarea);

    this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoAjusteTotalizado(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_CALCULO_TEMP_CALCULO_AJUSTE_TOTALIZADO),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(ID_TAREA_PARAM));
    assertEquals(idTarea, params.getValue(ID_TAREA_PARAM));

  }

  @Test
  void mergeCalculoTempCalculoAjusteTotalizadoImporteParamTest() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(8989L);

    this.primaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoAjusteTotalizado(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_MERGE_CALCULO_TEMP_CALCULO_AJUSTE_TOTALIZADO),
        this.paramsCaptor.capture());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue(IMPORTE_PARAM));
    assertEquals(SQL_ZERO_VALUE, params.getValue(IMPORTE_PARAM));

  }

  // Fin tests totalizacion tarea calculo ajuste

}
