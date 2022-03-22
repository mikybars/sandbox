
package com.inditex.rrhh.icmclcwb.model.primary.comis.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.ComisClaseEmpleadoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalComisionManualDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalFechaIncidenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlComisConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.comis.repository.ComisRepositoryCustomImpl;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class ComisRepositoryCustomImplTest {

  private final static String SQL_FIND_PRESENCIAS_ORIGEN_AND_FECHA = "SQL FIND PRESENCIAS ORIGEN AND FECHA";

  private final static String SQL_FIND_MOTIVOS_DESPLAZAMIENTO = "SQL FIND MOTIVOS DESPLAZAMIENTO";

  private final static String SQL_FIND_FECHAS_INCIDENCIAS = "SQL FIND FECHAS INCIDENCIAS";

  private final static String SQL_FIND_FECHAS_DESPLAZAMIENTO = "SQL FIND FECHAS DESPLAZAMIENTO";

  private final static String SQL_FIND_CONDICIONES_HISTORICO = "SQL FIND CONDICIONES HISTORICO";

  private final static String SQL_FIND_CONDICIONES_HISTORICO_ES = "SQL FIND CONDICIONES HISTORICO ES";

  private final static String SQL_FIND_CONDICIONES_HISTORICO_CHALLENGE = "SQL FIND CONDICIONES HISTORICO CHALLENGE";

  private final static String SQL_FIND_CONDICIONES_DESPLAZAMIENTO = "SQL FIND CONDICIONES DESPLAZAMIENTO";

  private final static String SQL_FIND_CONDICIONES_DESPLAZAMIENTO_ES = "SQL FIND CONDICIONES DESPLAZAMIENTO ES";

  private final static String SQL_FIND_CONDICIONES_DESPLAZAMIENTO_CHALLENGE = "SQL FIND CONDICIONES DESPLAZAMIENTO CHALLENGE";

  private final static String SQL_FIND_CONDICIONES_RESALTA = "SQL FIND CONDICIONES RESALTA";

  private final static String SQL_FIND_CONDICIONES_RESALTA_SIN_PRIMAS = "SQL FIND CONDICIONES RESALTA SIN PRIMA";

  private final static String SQL_FIND_CONDICIONES_RESALTA_ES = "SQL FIND CONDICIONES RESALTA ES";

  private final static String SQL_FIND_CONDICIONES_RESALTA_CHALLENGE = "SQL FIND CONDICIONES RESALTA CHALLENGE";

  private final static String SQL_FIND_CONDICIONES_PRIMAS = "SQL FIND CONDICIONES PRIMA";

  private final static String SQL_FIND_BAJAS_IT = "SQL FIND BAJAS IT";

  private final static String SQL_FIND_CARENCIA = "SQL FIND CARENCIA";

  private final static String SQL_FIND_EXTERNOS_BY_CLASE = "SQL FIND EXERTNOS BY CLASE";

  private final static String SQL_FIND_EXTERNOS_BY_MIN_ID_PERSONA = "SQL FIND EXTERNOS BY MIN ID PERSONA";

  private final static String SQL_FIND_BAJAS_IT_ES = "SQL FIND BAJAS IT ES";

  private final static String SQL_FIND_COMISION_MANUAL = "SQL FIND COMISION MANUAL";

  private final static String SQL_FIND_PERSONAS = "SQL FIND PERSONAS";

  private final static String SQL_FIND_PERSONAS_SIL_SIN_ESTADO = "SQL FIND PERSONAS SIN ESTADO";

  private final static String SQL_FIND_PERSONAS_SIL_CON_ESTADO = "SQL FIND PERSONAS CON ESTADO";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private ComisRepositoryCustomImpl comisRepositoryCustom;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @Mock
  private PrevalidarPropertiesDto fechaProperties;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindPresenciasOrigenAndFechaQuery",
        SQL_FIND_PRESENCIAS_ORIGEN_AND_FECHA, true);
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindMotivosDesplazamiento",
        SQL_FIND_MOTIVOS_DESPLAZAMIENTO, true);
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindFechasIncidencias",
        SQL_FIND_FECHAS_INCIDENCIAS,
        true);
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindFechasDesplazamiento",
        SQL_FIND_FECHAS_DESPLAZAMIENTO,
        true);
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindCondicionesHistorico", SQL_FIND_CONDICIONES_HISTORICO,
        true);
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindCondicionesHistoricoEs", SQL_FIND_CONDICIONES_HISTORICO_ES,
        true);
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindCondicionesDesplazamiento",
        SQL_FIND_CONDICIONES_DESPLAZAMIENTO,
        true);
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindCondicionesDesplazamientoEs",
        SQL_FIND_CONDICIONES_DESPLAZAMIENTO_ES,
        true);
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindCondicionesResalta",
        SQL_FIND_CONDICIONES_RESALTA,
        true);
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindCondicionesResaltaSinPrimas",
        SQL_FIND_CONDICIONES_RESALTA_SIN_PRIMAS,
        true);
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindCondicionesResaltaEs",
        SQL_FIND_CONDICIONES_RESALTA_ES,
        true);
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindCondicionesPrimas",
        SQL_FIND_CONDICIONES_PRIMAS,
        true);
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindBajasIt",
        SQL_FIND_BAJAS_IT,
        true);
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindCarencia",
        SQL_FIND_CARENCIA,
        true);
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindExternosByClase",
        SQL_FIND_EXTERNOS_BY_CLASE,
        true);
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindExternosByMinIdPersona",
        SQL_FIND_EXTERNOS_BY_MIN_ID_PERSONA,
        true);
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindBajasItEs",
        SQL_FIND_BAJAS_IT_ES,
        true);
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindCondicionesResaltaSinChallenge",
        SQL_FIND_CONDICIONES_RESALTA_CHALLENGE,
        true);
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindCondicionesDesplazamientoSinChallenge",
        SQL_FIND_CONDICIONES_DESPLAZAMIENTO_CHALLENGE,
        true);
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindCondicionesHistoricoSinChallenge",
        SQL_FIND_CONDICIONES_HISTORICO_CHALLENGE,
        true);
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindComisionManual",
        SQL_FIND_COMISION_MANUAL,
        true);
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindPersonas",
        SQL_FIND_PERSONAS,
        true);
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindPersonasSilConEstado",
        SQL_FIND_PERSONAS_SIL_CON_ESTADO,
        true);
    FieldUtils.writeField(this.comisRepositoryCustom,
        "sqlFindPersonasSilSinEstado",
        SQL_FIND_PERSONAS_SIL_SIN_ESTADO,
        true);
  }

  @Test
  void findPresenciasOrigenAndFecha() {
    final TareaDto tarea = new TareaDto();
    tarea.setFechaInicioPeriodo(LocalDate.now());
    tarea.setFechaFinPeriodo(LocalDate.now());
    this.comisRepositoryCustom.findPresenciasOrigenAndFecha(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(this.sqlCaptor.capture(),
        this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<PresenciaOrigenDto>>any());
    assertEquals(SQL_FIND_PRESENCIAS_ORIGEN_AND_FECHA,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: fechainicio, fechafin
    assertEquals(2, params.getValues().size());
    // fechainicio
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO));
    // fechafin
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_FECHA_FIN));
  }

  @Test
  void findMotivoDesplazamiento() {
    final TareaDto tarea = new TareaDto();
    tarea.setIdOrganization("1");
    tarea.setFechaInicioPeriodo(LocalDate.now());
    tarea.setFechaFinPeriodo(LocalDate.now());
    this.comisRepositoryCustom.findMotivoDesplazamiento(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(),
        this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<Object>>any());
    assertEquals(SQL_FIND_MOTIVOS_DESPLAZAMIENTO,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idOrganization
    assertEquals(1, params.getValues().size());
    // idOrganization
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_ID_ORGANIZATION));
    assertEquals(tarea.getIdOrganization(), params.getValue(SqlComisConstants.SQL_PARAM_ID_ORGANIZATION));
  }

  @Test
  void findFechasIncidencias() {
    final TareaDto tarea = new TareaDto();
    tarea.setFechaInicioPeriodo(LocalDate.now());
    when(this.fechaProperties.getMeses())
        .thenReturn(1);

    this.comisRepositoryCustom.findFechasIncidencias(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalFechaIncidenciaDto>>any());
    assertEquals(SQL_FIND_FECHAS_INCIDENCIAS,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: fecha inicio
    assertEquals(1, params.getValues().size());
    // fecha inicio
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_INICIO));
  }

  @Test
  void findFechasDesplazamientos() {
    final TareaDto tarea = new TareaDto();
    tarea.setFechaInicioPeriodo(LocalDate.now());
    when(this.fechaProperties.getMeses())
        .thenReturn(1);

    this.comisRepositoryCustom.findFechasDesplazamientos(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalFechaIncidenciaDto>>any());
    assertEquals(SQL_FIND_FECHAS_DESPLAZAMIENTO,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: fecha inicio
    assertEquals(1, params.getValues().size());
    // fecha inicio
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_INICIO));
  }

  @Test
  void findCondicionesHistorico() {
    final TareaDto tarea = new TareaDto();
    tarea.setIdOrganization("1");
    tarea.setFechaInicioPeriodo(LocalDate.now());
    tarea.setFechaFinPeriodo(LocalDate.now());
    final PeriodoDto periodo = new PeriodoDto();
    periodo.setFechaInicioPeriodo(LocalDate.now());
    this.comisRepositoryCustom.findCondicionesHistorico(tarea, periodo);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalCondicionesDto>>any());
    assertEquals(SQL_FIND_CONDICIONES_HISTORICO,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: fecha desde, fecha hasta
    assertEquals(3, params.getValues().size());
    // fecha desde
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE));
    // fecha hasta
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
    // fecha desde ampliado
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE_AMPLIADO));
  }

  @Test
  void findCondicionesHistoricoEs() {
    final TareaDto tarea = new TareaDto();
    tarea.setIdOrganization("1");
    tarea.setFechaInicioPeriodo(LocalDate.now());
    tarea.setFechaFinPeriodo(LocalDate.now());
    this.comisRepositoryCustom.findCondicionesHistoricoEs(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalCondicionesDto>>any());
    assertEquals(SQL_FIND_CONDICIONES_HISTORICO_ES,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: fecha desde, fecha hasta
    assertEquals(2, params.getValues().size());
    // fecha desde
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE));
    // fecha hasta
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
  }

  @Test
  void findCondicionesDesplazamiento() {
    final TareaDto tarea = new TareaDto();
    tarea.setIdOrganization("1");
    tarea.setFechaInicioPeriodo(LocalDate.now());
    tarea.setFechaFinPeriodo(LocalDate.now());
    final PeriodoDto periodo = new PeriodoDto();
    periodo.setFechaInicioPeriodo(LocalDate.now());
    this.comisRepositoryCustom.findCondicionesDesplazamiento(tarea, periodo);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalCondicionesDto>>any());
    assertEquals(SQL_FIND_CONDICIONES_DESPLAZAMIENTO,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: fecha desde, fecha hasta
    assertEquals(3, params.getValues().size());
    // fecha desde
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE));
    // fecha hasta
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
    // fecha desde ampliado
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE_AMPLIADO));
  }

  @Test
  void findCondicionesDesplazamientoEs() {
    final TareaDto tarea = new TareaDto();
    tarea.setIdOrganization("1");
    tarea.setFechaInicioPeriodo(LocalDate.now());
    tarea.setFechaFinPeriodo(LocalDate.now());
    this.comisRepositoryCustom.findCondicionesDesplazamientoEs(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalCondicionesDto>>any());
    assertEquals(SQL_FIND_CONDICIONES_DESPLAZAMIENTO_ES,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: fecha desde, fecha hasta
    assertEquals(2, params.getValues().size());
    // fecha desde
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE));
    // fecha hasta
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
  }

  @Test
  void findCondicionesResalta() {
    final TareaDto tarea = new TareaDto();
    tarea.setIdOrganization("1");
    tarea.setFechaInicioPeriodo(LocalDate.now());
    tarea.setFechaFinPeriodo(LocalDate.now());
    this.comisRepositoryCustom.findCondicionesResalta(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalCondicionesDto>>any());
    assertEquals(SQL_FIND_CONDICIONES_RESALTA,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: fecha desde, fecha hasta
    assertEquals(2, params.getValues().size());
    // fecha desde
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE));
    // fecha hasta
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
  }

  @Test
  void findCondicionesResaltaSinPrimas() {
    final TareaDto tarea = new TareaDto();
    tarea.setIdOrganization("1");
    tarea.setFechaInicioPeriodo(LocalDate.now());
    tarea.setFechaFinPeriodo(LocalDate.now());
    this.comisRepositoryCustom.findCondicionesResaltaSinPrimas(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalCondicionesDto>>any());
    assertEquals(SQL_FIND_CONDICIONES_RESALTA_SIN_PRIMAS,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: fecha desde, fecha hasta
    assertEquals(2, params.getValues().size());
    // fecha desde
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE));
    // fecha hasta
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
  }

  @Test
  void findCondicionesResaltaEs() {
    final TareaDto tarea = new TareaDto();
    tarea.setIdOrganization("1");
    tarea.setFechaInicioPeriodo(LocalDate.now());
    tarea.setFechaFinPeriodo(LocalDate.now());
    this.comisRepositoryCustom.findCondicionesResaltaEs(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalCondicionesDto>>any());
    assertEquals(SQL_FIND_CONDICIONES_RESALTA_ES,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: fecha desde, fecha hasta
    assertEquals(2, params.getValues().size());
    // fecha desde
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE));
    // fecha hasta
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
  }

  @Test
  void findCondicionesPrimas() {
    final TareaDto tarea = new TareaDto();
    tarea.setIdOrganization("1");
    tarea.setFechaInicioPeriodo(LocalDate.now());
    tarea.setFechaFinPeriodo(LocalDate.now());
    this.comisRepositoryCustom.findCondicionesPrimas(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalCondicionesDto>>any());
    assertEquals(SQL_FIND_CONDICIONES_PRIMAS,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: fecha desde, fecha hasta
    assertEquals(2, params.getValues().size());
    // fecha desde
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE));
    // fecha hasta
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
  }

  @Test
  void findBajasIt() {
    final TareaDto tarea = new TareaDto();
    tarea.setIdOrganization("1");
    tarea.setFechaInicioPeriodo(LocalDate.now());
    tarea.setFechaFinPeriodo(LocalDate.now());
    final PeriodoDto periodo = new PeriodoDto();
    periodo.setFechaInicioPeriodo(LocalDate.now());

    this.comisRepositoryCustom.findBajasIt(tarea, periodo);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalCondicionesDto>>any());
    assertEquals(SQL_FIND_BAJAS_IT,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: fecha desde, fecha hasta, fecha desde ampliado
    assertEquals(3, params.getValues().size());
    // fecha desde
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE));
    // fecha hasta
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
    // fecha desde ampliado
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE_AMPLIADO));
  }

  @Test
  void findCarencia() {
    final TareaDto tarea = new TareaDto();
    tarea.setIdOrganization("1");
    this.comisRepositoryCustom.findCarencia(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalCarenciaDto>>any());
    assertEquals(SQL_FIND_CARENCIA,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: fecha desde, fecha hasta
    assertEquals(2, params.getValues().size());
    // fecha desde
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE));
    // fecha hasta
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
  }

  @Test
  void findExternosByClaseQueryTest() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    tarea.setFechaInicioPeriodo(LocalDate.now());
    tarea.setFechaFinPeriodo(LocalDate.now());
    this.comisRepositoryCustom.findExternosByClase(tarea, ComisClaseEmpleadoEnum.EMPLEADO_EXTERNO_BRASIL);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(),
        any(MapSqlParameterSource.class), ArgumentMatchers.<RowMapper<IdPersonaLocalCarenciaDto>>any());
    assertEquals(SQL_FIND_EXTERNOS_BY_CLASE, this.sqlCaptor.getValue());
  }

  @Test
  void findExternosByClaseNumeroParametrosTest() {
    final TareaDto tarea = new TareaDto();
    tarea.setFechaInicioPeriodo(LocalDate.now());
    tarea.setFechaFinPeriodo(LocalDate.now());
    this.comisRepositoryCustom.findExternosByClase(tarea, ComisClaseEmpleadoEnum.EMPLEADO_EXTERNO_BRASIL);
    verify(this.namedParameterJdbcTemplate, times(1)).query(any(String.class), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalCarenciaDto>>any());

    // Parámetros de la consulta: clase, fechaDesde, fechaHasta
    assertEquals(3, this.paramsCaptor.getValue().getValues().size());
  }

  @Test
  void findExternosByClaseParametroFechaDesdeTest() {
    final TareaDto tarea = new TareaDto();
    final LocalDate fechaDesde = LocalDate.of(2020, 1, 1);
    tarea.setFechaInicioPeriodo(fechaDesde);
    tarea.setFechaFinPeriodo(LocalDate.now());
    this.comisRepositoryCustom.findExternosByClase(tarea, ComisClaseEmpleadoEnum.EMPLEADO_EXTERNO_BRASIL);
    verify(this.namedParameterJdbcTemplate, times(1)).query(any(String.class), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalCarenciaDto>>any());

    final MapSqlParameterSource parameters = this.paramsCaptor.getValue();
    assertTrue(parameters.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE));
    assertEquals(TimeUtils.toDate(fechaDesde), parameters.getValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE));
  }

  @Test
  void findExternosByClaseParametroFechaHastaTest() {
    final TareaDto tarea = new TareaDto();
    final LocalDate fechaHasta = LocalDate.of(2020, 1, 31);
    tarea.setFechaFinPeriodo(fechaHasta);
    tarea.setFechaInicioPeriodo(LocalDate.now());
    this.comisRepositoryCustom.findExternosByClase(tarea, ComisClaseEmpleadoEnum.EMPLEADO_EXTERNO_BRASIL);
    verify(this.namedParameterJdbcTemplate, times(1)).query(any(String.class), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalCarenciaDto>>any());

    final MapSqlParameterSource parameters = this.paramsCaptor.getValue();
    assertTrue(parameters.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
    assertEquals(TimeUtils.toDate(fechaHasta), parameters.getValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
  }

  @Test
  void findExternosByClaseParametroClaseTest() {
    final TareaDto tarea = new TareaDto();
    tarea.setFechaFinPeriodo(LocalDate.now());
    tarea.setFechaInicioPeriodo(LocalDate.now());
    this.comisRepositoryCustom.findExternosByClase(tarea, ComisClaseEmpleadoEnum.EMPLEADO_EXTERNO_BRASIL);

    verify(this.namedParameterJdbcTemplate, times(1)).query(any(String.class), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalCarenciaDto>>any());

    final MapSqlParameterSource parameters = this.paramsCaptor.getValue();
    assertTrue(parameters.hasValue(SqlComisConstants.SQL_PARAM_CLASE));
    assertEquals(ComisClaseEmpleadoEnum.EMPLEADO_EXTERNO_BRASIL.getId(),
        parameters.getValue(SqlComisConstants.SQL_PARAM_CLASE));

  }

  @Test
  void findExternosByMinIdPersonaQueryTest() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    tarea.setFechaInicioPeriodo(LocalDate.now());
    tarea.setFechaFinPeriodo(LocalDate.now());
    this.comisRepositoryCustom.findExternosByMinIdPersona(tarea, 1234L);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(),
        any(MapSqlParameterSource.class), ArgumentMatchers.<RowMapper<IdPersonaLocalCarenciaDto>>any());
    assertEquals(SQL_FIND_EXTERNOS_BY_MIN_ID_PERSONA, this.sqlCaptor.getValue());
  }

  @Test
  void findExternosByMinIdPersonaNumeroParametrosTest() {
    final TareaDto tarea = new TareaDto();
    tarea.setFechaInicioPeriodo(LocalDate.now());
    tarea.setFechaFinPeriodo(LocalDate.now());
    this.comisRepositoryCustom.findExternosByMinIdPersona(tarea, 1234L);
    verify(this.namedParameterJdbcTemplate, times(1)).query(any(String.class), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalCarenciaDto>>any());

    // Parámetros de la consulta: minPersona, fechaDesde, fechaHasta
    assertEquals(3, this.paramsCaptor.getValue().getValues().size());
  }

  @Test
  void findExternosByMinIdPersonaParametroFechaDesdeTest() {
    final TareaDto tarea = new TareaDto();
    final LocalDate fechaDesde = LocalDate.of(2020, 1, 1);
    tarea.setFechaInicioPeriodo(fechaDesde);
    tarea.setFechaFinPeriodo(LocalDate.now());
    this.comisRepositoryCustom.findExternosByMinIdPersona(tarea, 1234L);
    verify(this.namedParameterJdbcTemplate, times(1)).query(any(String.class), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalCarenciaDto>>any());

    final MapSqlParameterSource parameters = this.paramsCaptor.getValue();
    assertTrue(parameters.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE));
    assertEquals(TimeUtils.toDate(fechaDesde), parameters.getValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE));
  }

  @Test
  void findExternosByMinIdPersonaParametroFechaHastaTest() {
    final TareaDto tarea = new TareaDto();
    final LocalDate fechaHasta = LocalDate.of(2020, 1, 31);
    tarea.setFechaFinPeriodo(fechaHasta);
    tarea.setFechaInicioPeriodo(LocalDate.now());
    this.comisRepositoryCustom.findExternosByMinIdPersona(tarea, 1234L);
    verify(this.namedParameterJdbcTemplate, times(1)).query(any(String.class), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalCarenciaDto>>any());

    final MapSqlParameterSource parameters = this.paramsCaptor.getValue();
    assertTrue(parameters.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
    assertEquals(TimeUtils.toDate(fechaHasta), parameters.getValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
  }

  @Test
  void findExternosByMinIdPersonaParametroMinPersonaTest() {
    final TareaDto tarea = new TareaDto();
    tarea.setFechaFinPeriodo(LocalDate.now());
    tarea.setFechaInicioPeriodo(LocalDate.now());
    final Long idPersona = 12456L;
    this.comisRepositoryCustom.findExternosByMinIdPersona(tarea, idPersona);

    verify(this.namedParameterJdbcTemplate, times(1)).query(any(String.class), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalCarenciaDto>>any());

    final MapSqlParameterSource parameters = this.paramsCaptor.getValue();
    assertTrue(parameters.hasValue(SqlComisConstants.SQL_PARAM_MIN_ID_PERSONA));
    assertEquals(idPersona, parameters.getValue(SqlComisConstants.SQL_PARAM_MIN_ID_PERSONA));

  }

  @Test
  void findBajasItEs() {
    final TareaDto tarea = new TareaDto();
    tarea.setIdOrganization("1");
    tarea.setFechaInicioPeriodo(LocalDate.now());
    tarea.setFechaFinPeriodo(LocalDate.now());
    this.comisRepositoryCustom.findBajasItEs(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalCondicionesDto>>any());
    assertEquals(SQL_FIND_BAJAS_IT_ES,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: fecha desde, fecha hasta
    assertEquals(2, params.getValues().size());
    // fecha desde
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE));
    // fecha hasta
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
  }

  @Test
  void findCondicionesHistoricoSinChallenge() {
    final TareaDto tarea = new TareaDto();
    tarea.setIdOrganization("1");
    tarea.setFechaInicioPeriodo(LocalDate.now());
    tarea.setFechaFinPeriodo(LocalDate.now());
    final PeriodoDto periodo = new PeriodoDto();
    periodo.setFechaInicioPeriodo(LocalDate.now());
    this.comisRepositoryCustom.findCondicionesHistoricoSinChallenge(tarea, periodo);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalCondicionesDto>>any());
    assertEquals(SQL_FIND_CONDICIONES_HISTORICO_CHALLENGE,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: fecha desde, fecha hasta
    assertEquals(3, params.getValues().size());
    // fecha desde
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE));
    // fecha hasta
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
    // fecha desde ampliado
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE_AMPLIADO));
  }

  @Test
  void findCondicionesDesplazamientoSinChallenge() {
    final TareaDto tarea = new TareaDto();
    tarea.setIdOrganization("1");
    tarea.setFechaInicioPeriodo(LocalDate.now());
    tarea.setFechaFinPeriodo(LocalDate.now());
    final PeriodoDto periodo = new PeriodoDto();
    periodo.setFechaInicioPeriodo(LocalDate.now());
    this.comisRepositoryCustom.findCondicionesDesplazamientoSinChallenge(tarea, periodo);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalCondicionesDto>>any());
    assertEquals(SQL_FIND_CONDICIONES_DESPLAZAMIENTO_CHALLENGE,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: fecha desde, fecha hasta
    assertEquals(3, params.getValues().size());
    // fecha desde
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE));
    // fecha hasta
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
    // fecha desde ampliado
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE_AMPLIADO));
  }

  @Test
  void findCondicionesResaltaSinChallenge() {
    final TareaDto tarea = new TareaDto();
    tarea.setIdOrganization("1");
    tarea.setFechaInicioPeriodo(LocalDate.now());
    tarea.setFechaFinPeriodo(LocalDate.now());
    this.comisRepositoryCustom.findCondicionesResaltaSinChallenge(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalCondicionesDto>>any());
    assertEquals(SQL_FIND_CONDICIONES_RESALTA_CHALLENGE,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: fecha desde, fecha hasta
    assertEquals(2, params.getValues().size());
    // fecha desde
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE));
    // fecha hasta
    assertTrue(params.hasValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA));
  }

  @Test
  void findComisionManual(@Random final TareaDto tarea, @Random final IdPersonaLocalComisionManualDto result) {

    when(this.namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
        ArgumentMatchers.<RowMapper<IdPersonaLocalComisionManualDto>>any())).thenAnswer((invocation) -> {

          final RowMapper<IdPersonaLocalComisionManualDto> rowMapper = invocation.getArgument(2);
          final ResultSet rs = mock(ResultSet.class);
          when(rs.getString(SqlComisConstants.SQL_RESULT_IMPORTE)).thenReturn(result.getImporte());
          when(rs.getString(SqlComisConstants.SQL_RESULT_ID_GRUPO_MANUAL)).thenReturn(result.getGrupoManual());
          when(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON)).thenReturn(result.getIdPersonaLocal());
          when(rs.getString(SqlComisConstants.SQL_RESULT_ID_TIPO_COMISION)).thenReturn(result.getTipoComision());

          return Collections.singletonList(rowMapper.mapRow(rs, 0));
        });

    final List<IdPersonaLocalComisionManualDto> comisiones = this.comisRepositoryCustom.findComisionManual(tarea);

    final Map<String, Object> params = new HashMap<>();
    params.put(SqlComisConstants.SQL_PARAM_FECHA_HASTA, TimeUtils.toDate(tarea.getFechaFinPeriodo()));

    verify(this.namedParameterJdbcTemplate, times(1)).query(eq(SQL_FIND_COMISION_MANUAL), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalComisionManualDto>>any());

    assertEquals(params, this.paramsCaptor.getValue().getValues());
    assertEquals(1, comisiones.size());
    assertEquals(result, comisiones.get(0));
  }

  @Test
  void findPersonasTest(@Random final TareaDto tarea, @Random final IdPersonaLocalLocalizacionDto result,
      @Random final Long maxIdEmpleado) {

    when(this.namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
        ArgumentMatchers.<RowMapper<IdPersonaLocalLocalizacionDto>>any())).then((invocation) -> {
          final RowMapper<IdPersonaLocalLocalizacionDto> rowMapper = invocation.getArgument(2);
          final ResultSet rs = mock(ResultSet.class);
          when(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON)).thenReturn(result.getIdPersonaLocal());
          when(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_COD_ORIGEN)).thenReturn(result.getCclIdCodOrigen());

          return Collections.singletonList(rowMapper.mapRow(rs, 0));
        });

    final List<IdPersonaLocalLocalizacionDto> personas = this.comisRepositoryCustom.findPersonas(tarea, maxIdEmpleado);

    final Map<String, Object> expectedParams = new HashMap<>();
    expectedParams.put(SqlComisConstants.SQL_PARAM_FECHA_HASTA, TimeUtils.toDate(tarea.getFechaFinPeriodo()));
    expectedParams.put(SqlComisConstants.SQL_PARAM_FECHA_DESDE, TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    expectedParams.put(SqlComisConstants.SQL_PARAM_MAX_ID_PERSONA, maxIdEmpleado);

    verify(this.namedParameterJdbcTemplate, times(1)).query(eq(SQL_FIND_PERSONAS), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalLocalizacionDto>>any());

    assertEquals(expectedParams, this.paramsCaptor.getValue().getValues());
    assertEquals(1, personas.size());
    assertEquals(result, personas.get(0));

  }

  @Test
  void findPersonasSilSinEstadoTest(@Random final TareaDto tarea, @Random final IdPersonaLocalLocalizacionDto result,
      @Random final Long maxIdEmpleado, @Random final ClaseResultItemDto clase) {
    when(this.namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
        ArgumentMatchers.<RowMapper<IdPersonaLocalLocalizacionDto>>any())).then((invocation) -> {
          final RowMapper<IdPersonaLocalLocalizacionDto> rowMapper = invocation.getArgument(2);
          final ResultSet rs = mock(ResultSet.class);
          when(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON)).thenReturn(result.getIdPersonaLocal());
          when(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_COD_ORIGEN)).thenReturn(result.getCclIdCodOrigen());

          return Collections.singletonList(rowMapper.mapRow(rs, 0));
        });

    final List<IdPersonaLocalLocalizacionDto> personas = this.comisRepositoryCustom.findPersonasSilSinEstado(tarea, maxIdEmpleado, clase);

    final Map<String, Object> expectedParams = new HashMap<>();
    expectedParams.put(SqlComisConstants.SQL_PARAM_FECHA_HASTA, TimeUtils.toDate(tarea.getFechaFinPeriodo()));
    expectedParams.put(SqlComisConstants.SQL_PARAM_FECHA_DESDE, TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    expectedParams.put(SqlComisConstants.SQL_PARAM_MAX_ID_PERSONA, maxIdEmpleado);
    expectedParams.put(SqlComisConstants.SQL_PARAM_CLASE, clase.getIdClase());

    verify(this.namedParameterJdbcTemplate, times(1)).query(eq(SQL_FIND_PERSONAS_SIL_SIN_ESTADO), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalLocalizacionDto>>any());

    assertEquals(expectedParams, this.paramsCaptor.getValue().getValues());
    assertEquals(1, personas.size());
    assertEquals(result, personas.get(0));
  }

  @Test
  void findPersonasSilConEstadoTest(@Random final TareaDto tarea, @Random final IdPersonaLocalLocalizacionDto result,
      @Random final Long maxIdEmpleado, @Random final ClaseResultItemDto clase) {
    when(this.namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
        ArgumentMatchers.<RowMapper<IdPersonaLocalLocalizacionDto>>any())).then((invocation) -> {
          final RowMapper<IdPersonaLocalLocalizacionDto> rowMapper = invocation.getArgument(2);
          final ResultSet rs = mock(ResultSet.class);
          when(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON)).thenReturn(result.getIdPersonaLocal());
          when(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_COD_ORIGEN)).thenReturn(result.getCclIdCodOrigen());

          return Collections.singletonList(rowMapper.mapRow(rs, 0));
        });

    final List<IdPersonaLocalLocalizacionDto> personas = this.comisRepositoryCustom.findPersonasSilConEstado(tarea, maxIdEmpleado, clase);

    final Map<String, Object> expectedParams = new HashMap<>();
    expectedParams.put(SqlComisConstants.SQL_PARAM_FECHA_HASTA, TimeUtils.toDate(tarea.getFechaFinPeriodo()));
    expectedParams.put(SqlComisConstants.SQL_PARAM_FECHA_DESDE, TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    expectedParams.put(SqlComisConstants.SQL_PARAM_MAX_ID_PERSONA, maxIdEmpleado);
    expectedParams.put(SqlComisConstants.SQL_PARAM_CLASE, clase.getIdClase());
    expectedParams.put(SqlComisConstants.SQL_PARAM_ESTADO_SIL, clase.getIdsEstadoSil());

    verify(this.namedParameterJdbcTemplate, times(1)).query(eq(SQL_FIND_PERSONAS_SIL_CON_ESTADO), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdPersonaLocalLocalizacionDto>>any());

    assertEquals(expectedParams, this.paramsCaptor.getValue().getValues());
    assertEquals(1, personas.size());
    assertEquals(result, personas.get(0));
  }

}
