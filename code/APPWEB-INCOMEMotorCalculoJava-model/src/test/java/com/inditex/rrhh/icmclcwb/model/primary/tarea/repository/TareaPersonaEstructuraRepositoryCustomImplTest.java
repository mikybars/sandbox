package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoComisionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructura;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class TareaPersonaEstructuraRepositoryCustomImplTest {

  private static final String SQL_UPDATE_ACTIVO_TOPES = "SQL UPDATE ACTIVO TOPES";

  private static final String SQL_FIND_PERSONAS_CHALLENGE = "SQL FIND PERSONAS CHALLENGE";

  private static final String SQL_DESACTIVAR_CHALLENGE_OPCION_ORIGEN = "SQL DESACTIVAR CHALLENGE OPCION ORIGEN";

  private static final String SQL_CALCULAR_FESTIVOS = "SQL CALCULAR FESTIVOS";

  private static final String SQL_SAVE = "SQL_SAVE";

  private static final String SQL_CREAR_ESTRUCTURAS_ORIGEN_IGUALAR_BANDAS = "SQL CREAR ESTRUCTURAS ORIGEN IGUALAR BANDAS";

  private static final String SQL_ESTABLECER_BANDA_OPCION_ORIGEN = "SQL ESTABLECER BANDA OPCION ORIGEN";

  private static final String SQL_CREAR_CHALLENGE_OPCION_ORIGEN = "SQL CREAR CHALLENGE OPCION ORIGEN";

  private static final String SQL_DESACTIVAR_GLOBAL_SECCION_OPCION_ORIGEN = "SQL DESACTIVAR GLOBAL SECCION OPCION ORIGEN";

  private static final String SQL_CREAR_GLOBAL_SECCION_OPCION_ORIGEN = "SQL CREAR GLOBAL SECCION OPCION ORIGEN";

  @Mock
  private JdbcTemplate jdbcTemplate;

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private TareaPersonaEstructuraRepositoryCustomImpl tareaPersonaEstructuraRepositoryCustom;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaPersonaEstructuraRepositoryCustom, "sqlUpdateActivoTopes",
        SQL_UPDATE_ACTIVO_TOPES,
        true);
    FieldUtils.writeField(this.tareaPersonaEstructuraRepositoryCustom, "sqlFindPersonasChallenge",
        SQL_FIND_PERSONAS_CHALLENGE, true);
    FieldUtils.writeField(this.tareaPersonaEstructuraRepositoryCustom, "sqlDesactivarChallengeOpcionOrigen",
        SQL_DESACTIVAR_CHALLENGE_OPCION_ORIGEN, true);
    FieldUtils.writeField(this.tareaPersonaEstructuraRepositoryCustom, "sqlCalcularFestivos", SQL_CALCULAR_FESTIVOS,
        true);
    FieldUtils.writeField(this.tareaPersonaEstructuraRepositoryCustom, "sqlSave", SQL_SAVE, true);
    FieldUtils.writeField(this.tareaPersonaEstructuraRepositoryCustom, "sqlCrearEstructurasOrigenIgualarBandas",
        SQL_CREAR_ESTRUCTURAS_ORIGEN_IGUALAR_BANDAS, true);
    FieldUtils.writeField(this.tareaPersonaEstructuraRepositoryCustom, "sqlEstablecerBandaOpcionOrigen",
        SQL_ESTABLECER_BANDA_OPCION_ORIGEN, true);
    FieldUtils.writeField(this.tareaPersonaEstructuraRepositoryCustom, "sqlCrearChallengeOpcionOrigen", SQL_CREAR_CHALLENGE_OPCION_ORIGEN,
        true);
    FieldUtils.writeField(this.tareaPersonaEstructuraRepositoryCustom, "sqlCrearGlobalSeccionOpcionOrigen",
        SQL_CREAR_GLOBAL_SECCION_OPCION_ORIGEN,
        true);
    FieldUtils.writeField(this.tareaPersonaEstructuraRepositoryCustom, "sqlDesactivarGlobalSeccionOpcionOrigen",
        SQL_DESACTIVAR_GLOBAL_SECCION_OPCION_ORIGEN,
        true);

    FieldUtils.writeField(this.tareaPersonaEstructuraRepositoryCustom, "batchSize", 100, true);
  }

  @Test
  void updateActivoTopesTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(890L);
    when(tarea.getFechaInicioPeriodo()).thenReturn(LocalDate.of(2019, 1, 1));

    this.tareaPersonaEstructuraRepositoryCustom.updateActivoTopes(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_ACTIVO_TOPES, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: activo, fechaInicioPeriodo, idTarea, icmOrdTope
    assertEquals(4, params.getValues().size());
    // activo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    // fechaInicioPeriodo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO));
    assertEquals(TimeUtils.toDate(tarea.getFechaInicioPeriodo()),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO));
    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // icmOrdTope
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ICM_ORD_TOPE));
    assertEquals(AppConstants.TOPE_DEFAULT, params.getValue(SqlPrimaryConstants.SQL_PARAM_ICM_ORD_TOPE));
  }

  @Test
  void findPersonasChallengeTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(8209L);
    when(tarea.getFechaInicioPeriodo()).thenReturn(LocalDate.of(2019, 12, 1));

    this.tareaPersonaEstructuraRepositoryCustom.findPersonasChallenge(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<TareaPersonaEstructura>>any());
    assertEquals(SQL_FIND_PERSONAS_CHALLENGE, this.sqlCaptor.getValue());
    final MapSqlParameterSource map = this.paramsCaptor.getValue();
    // Parámetros de la consulta: fechaInicioPeriodo, idTarea, tiposCalculo
    assertEquals(3, map.getValues().size());
    // fechaInicio
    assertTrue(map.hasValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO));
    assertEquals(TimeUtils.toDate(tarea.getFechaInicioPeriodo()),
        map.getValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO));
    // idTarea
    assertTrue(map.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), map.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // fechaInicio
    assertTrue(map.hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
    assertEquals(Arrays.asList(TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId(),
        TipoCalculoEnum.CHALLENGE_PRECIO_HORA_SECCION.getId(),
        TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_IMPORTE_SECCION.getId(),
        TipoCalculoEnum.CHALLENGE_PORCENTAJE.getId(), TipoCalculoEnum.CHALLENGE_JORNADA.getId()),
        map.getValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));

  }

  @Test
  void saveTest() {
    final List<TareaPersonaEstructura> items = Collections.singletonList(mock(TareaPersonaEstructura.class));
    this.tareaPersonaEstructuraRepositoryCustom.save(items);
    verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(),
        any(SqlParameterSource[].class));
    assertEquals(SQL_SAVE, this.sqlCaptor.getValue());
  }

  @Test
  void desactivarChallengeOpcionOrigenTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(8209L);
    final LocalDate fechaInicioPeriodo = LocalDate.of(2019, 12, 1);
    when(tarea.getFechaInicioPeriodo()).thenReturn(fechaInicioPeriodo);

    this.tareaPersonaEstructuraRepositoryCustom.desactivarChallengeOpcionOrigen(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_DESACTIVAR_CHALLENGE_OPCION_ORIGEN, this.sqlCaptor.getValue());
    final MapSqlParameterSource map = this.paramsCaptor.getValue();
    // Parámetros de la consulta: inactivo, fechaInicioPeriodo, activo, idTarea, tiposComision,
    // tiposCalculo
    assertEquals(6, map.getValues().size());
    // inactivo
    assertTrue(map.hasValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE, map.getValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
    // fechaInicioPeriodo
    assertTrue(map.hasValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO));
    assertEquals(TimeUtils.toDate(fechaInicioPeriodo),
        map.getValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO));
    // activo
    assertTrue(map.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, map.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    // idTarea
    assertTrue(map.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(8209L, map.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // tiposComision
    assertTrue(map.hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION));
    assertEquals(Arrays
        .asList(TipoComisionEnum.CHALLENGE_PRINCIPAL.getId(), TipoComisionEnum.CHALLENGE_SECUNDARIO.getId()),
        map.getValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION));
    // tiposCalculo
    assertTrue(map.hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
    assertEquals(Arrays.asList(
        TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId(),
        TipoCalculoEnum.CHALLENGE_PRECIO_HORA_SECCION.getId(),
        TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_IMPORTE_SECCION.getId()),
        map.getValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));

  }

  @Test
  void calcularFestivosTest() {

    final Long idTarea = 12L;
    final TareaDto tareaMock = mock(TareaDto.class);
    when(tareaMock.getId()).thenReturn(idTarea);

    this.tareaPersonaEstructuraRepositoryCustom.calcularFestivos(tareaMock);
    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(this.sqlCaptor.capture(),
        this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<Boolean>>any());
    assertEquals(SQL_CALCULAR_FESTIVOS, this.sqlCaptor.getValue());
    final MapSqlParameterSource map = this.paramsCaptor.getValue();

    // Parametros de la peticion: idTarea, festivo
    assertEquals(2, map.getValues().size());
    // idTarea
    assertTrue(map.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, map.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // festivo
    assertTrue(map.hasValue(SqlPrimaryConstants.SQL_PARAM_FESTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, map.getValue(SqlPrimaryConstants.SQL_PARAM_FESTIVO));

  }

  @Test
  void crearEstructurasOrigenIgualarBandasTest() {

    this.tareaPersonaEstructuraRepositoryCustom.crearEstructurasOrigenIgualarBandas();

    final ArgumentCaptor<MapSqlParameterSource> paramsCaptor = ArgumentCaptor.forClass(MapSqlParameterSource.class);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_CREAR_ESTRUCTURAS_ORIGEN_IGUALAR_BANDAS), paramsCaptor.capture());

    final Map<String, Object> expected = new HashMap<>() {
      private static final long serialVersionUID = 3840086857103797076L;

      {
        this.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        this.put(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
      }
    };

    assertEquals(expected, paramsCaptor.getValue().getValues());

  }

  @Test
  void establecerBandaOpcionOrigen() {

    final ArgumentCaptor<MapSqlParameterSource> paramsCaptor = ArgumentCaptor.forClass(MapSqlParameterSource.class);
    this.tareaPersonaEstructuraRepositoryCustom.establecerBandaOpcionOrigen();
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_ESTABLECER_BANDA_OPCION_ORIGEN), paramsCaptor.capture());
    final Map<String, Object> expected = new HashMap<>();
    assertEquals(expected, paramsCaptor.getValue().getValues());

  }

  @ParameterizedTest
  @InstancioSource
  void crearChallengeOpcionOrigenTest(final TareaDto tarea) {
    final ArgumentCaptor<MapSqlParameterSource> paramsCaptor = ArgumentCaptor.forClass(MapSqlParameterSource.class);
    this.tareaPersonaEstructuraRepositoryCustom.crearChallengeOpcionOrigen(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_CREAR_CHALLENGE_OPCION_ORIGEN), paramsCaptor.capture());
    final Map<String, Object> expected = new HashMap<>();
    expected.put(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO, Arrays.asList(
        TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId(),
        TipoCalculoEnum.CHALLENGE_PRECIO_HORA_SECCION.getId(),
        TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_IMPORTE_SECCION.getId()));
    expected.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    expected.put(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO,
        TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    expected.put(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION, Arrays
        .asList(TipoComisionEnum.CHALLENGE_PRINCIPAL.getId(), TipoComisionEnum.CHALLENGE_SECUNDARIO.getId()));
    expected.put(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO_CHALLENGE_LOCALIZACION,
        Arrays.asList(TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId(),
            TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId()));

    assertEquals(expected, paramsCaptor.getValue().getValues());
  }

  @Test
  void desactivarGlobalSeccionOpcionOrigenTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(8209L);
    final LocalDate fechaInicioPeriodo = LocalDate.of(2019, 12, 1);
    when(tarea.getFechaInicioPeriodo()).thenReturn(fechaInicioPeriodo);

    this.tareaPersonaEstructuraRepositoryCustom.desactivarGlobalSeccionOpcionOrigen(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_DESACTIVAR_GLOBAL_SECCION_OPCION_ORIGEN, this.sqlCaptor.getValue());
    final MapSqlParameterSource map = this.paramsCaptor.getValue();
    // Parámetros de la consulta: inactivo, fechaInicioPeriodo, activo, idTarea, tiposComision,
    // tiposCalculo
    assertEquals(5, map.getValues().size());
    // inactivo
    assertTrue(map.hasValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE, map.getValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO));
    // fechaInicioPeriodo
    assertTrue(map.hasValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO));
    assertEquals(TimeUtils.toDate(fechaInicioPeriodo),
        map.getValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO));
    // activo
    assertTrue(map.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, map.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    // idTarea
    assertTrue(map.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(8209L, map.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // tiposCalculo
    assertTrue(map.hasValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));
    assertEquals(Collections.singletonList(
        TipoCalculoEnum.GLOBAL_SECCION.getId()),
        map.getValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO));

  }

  @ParameterizedTest
  @InstancioSource
  void crearGlobalSeccionOpcionOrigenTest(final TareaDto tarea) {
    final ArgumentCaptor<MapSqlParameterSource> paramsCaptor = ArgumentCaptor.forClass(MapSqlParameterSource.class);
    this.tareaPersonaEstructuraRepositoryCustom.crearGlobalSeccionOpcionOrigen(tarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(eq(SQL_CREAR_GLOBAL_SECCION_OPCION_ORIGEN), paramsCaptor.capture());
    final Map<String, Object> expected = new HashMap<>();
    expected.put(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO, Collections.singletonList(
        TipoCalculoEnum.GLOBAL_SECCION.getId()));
    expected.put(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    expected.put(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    expected.put(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO,
        TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    expected.put(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    assertEquals(expected, paramsCaptor.getValue().getValues());
  }
}
