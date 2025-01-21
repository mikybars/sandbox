package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaHistoricoDto;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaValidarRepositoryCustomImplTest {

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Mock
  private RowMapper<String> stringRowMapper;

  @Mock
  private RowMapper<TareaPersonaHistoricoDto> tareaPersonaHistoricoDtoRowMapper;

  @Mock
  private MapSqlParameterSource mapSqlParameterSource;

  @InjectMocks
  private TareaValidarRepositoryCustomImpl tareaValidarRepositoryCustomImpl;

  private final static String SQL_VALIDACION_AMBITO_EMPRESA = "VALIDACION AMBITO EMPRESA";

  private final static String SQL_VALIDACION_AMBITO_PERSONA = "VALIDACION AMBITO PERSONA";

  private final static String SQL_VALIDACION_AMBITO_LOCALIZACION = "VALIDACION AMBITO LOCALIZACION";

  private final static String SQL_CHECK_DUPLICATED_TIENDAS_HISTORICO = "CHECK_DUPLICATED_TIENDAS_HISTORICO";

  private final static String SQL_CHECK_DUPLICATED_TIPOS_HORA = "CHECK_DUPLICATED_TIPOS_HORA";

  private final static String SQL_EMPLEADO_HISTORICO_EMPTY_FIELDS = "EMPLEADO_HISTORICO_EMPTY_FIELDS";

  private final static String SQL_COUNT_EMPLEADOS_HISTORICO = "COUNT_EMPLEADOS_HISTORICO";

  private final static String SQL_COUNT_TIENDAS_HISTORICO = "COUNT_TIENDAS_HISTORICO";

  private final static String SQL_COUNT_ESTRUCTURAS = "COUNT_ESTRUCTURAS";

  private final static String SQL_COUNT_TIENDA_PRESENCIA_SECCION = "COUNT_TIENDA_PRESENCIA_SECCION";

  private final static String SQL_COUNT_TIENDA_EMPLEADO_PRESENCIA_SECCION = "COUNT_TIENDA_EMPLEADO_PRESENCIA_SECCION";

  private final static String SQL_COUNT_TIENDA_VENTA_SECCION = "COUNT_TIENDA_VENTA_SECCION";

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaValidarRepositoryCustomImpl, "sqlValidacionAmbitoEmpresa", SQL_VALIDACION_AMBITO_EMPRESA, true);
    FieldUtils.writeField(this.tareaValidarRepositoryCustomImpl, "sqlValidacionAmbitoPersona", SQL_VALIDACION_AMBITO_PERSONA, true);
    FieldUtils.writeField(this.tareaValidarRepositoryCustomImpl, "sqlValidacionAmbitoLocalizacion", SQL_VALIDACION_AMBITO_LOCALIZACION,
        true);
    FieldUtils.writeField(this.tareaValidarRepositoryCustomImpl, "sqlCheckDuplicatedTiendasHistorico",
        SQL_CHECK_DUPLICATED_TIENDAS_HISTORICO, true);
    FieldUtils.writeField(this.tareaValidarRepositoryCustomImpl, "sqlCheckDuplicatedTiposHora", SQL_CHECK_DUPLICATED_TIPOS_HORA, true);
    FieldUtils.writeField(this.tareaValidarRepositoryCustomImpl, "sqlEmpleadoHistoricoEmptyFields", SQL_EMPLEADO_HISTORICO_EMPTY_FIELDS,
        true);
    FieldUtils.writeField(this.tareaValidarRepositoryCustomImpl, "sqlCountEmpleadosHistorico", SQL_COUNT_EMPLEADOS_HISTORICO, true);
    FieldUtils.writeField(this.tareaValidarRepositoryCustomImpl, "sqlCountTiendasHistorico", SQL_COUNT_TIENDAS_HISTORICO, true);
    FieldUtils.writeField(this.tareaValidarRepositoryCustomImpl, "sqlCountEstructuras", SQL_COUNT_ESTRUCTURAS, true);
    FieldUtils.writeField(this.tareaValidarRepositoryCustomImpl, "sqlCountTiendaPresenciaSeccion", SQL_COUNT_TIENDA_PRESENCIA_SECCION,
        true);
    FieldUtils.writeField(this.tareaValidarRepositoryCustomImpl, "sqlCountTiendaEmpleadoPresenciaSeccion",
        SQL_COUNT_TIENDA_EMPLEADO_PRESENCIA_SECCION, true);
    FieldUtils.writeField(this.tareaValidarRepositoryCustomImpl, "sqlCountTiendaVentaSeccion", SQL_COUNT_TIENDA_VENTA_SECCION, true);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void validateAmbitoEmpresaValidIdTareaReturnsList(final Long idTarea) {
    doReturn(List.of("Empresa1", "Empresa2")).when(this.namedParameterJdbcTemplate).query(
        eq(SQL_VALIDACION_AMBITO_EMPRESA), any(MapSqlParameterSource.class), any(RowMapper.class));

    final List<String> result = this.tareaValidarRepositoryCustomImpl.validateAmbitoEmpresa(idTarea);

    assertNotNull(result);
    assertEquals(2, result.size());
    verify(this.namedParameterJdbcTemplate, times(1)).query(eq(SQL_VALIDACION_AMBITO_EMPRESA), any(MapSqlParameterSource.class),
        any(RowMapper.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void validateAmbitoPersonaValidIdTareaReturnsList(final Long idTarea) {
    doReturn(List.of("Persona1", "Persona2")).when(this.namedParameterJdbcTemplate).query(
        eq(SQL_VALIDACION_AMBITO_PERSONA), any(MapSqlParameterSource.class), any(RowMapper.class));

    final List<String> result = this.tareaValidarRepositoryCustomImpl.validateAmbitoPersona(idTarea);

    assertNotNull(result);
    assertEquals(2, result.size());
    verify(this.namedParameterJdbcTemplate, times(1)).query(eq(SQL_VALIDACION_AMBITO_PERSONA), any(MapSqlParameterSource.class),
        any(RowMapper.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void validateAmbitoLocalizacionValidIdTareaReturnsList(final Long idTarea) {
    doReturn(List.of("Localizacion1", "Localizacion2")).when(this.namedParameterJdbcTemplate).query(
        eq(SQL_VALIDACION_AMBITO_LOCALIZACION), any(MapSqlParameterSource.class), any(RowMapper.class));

    final List<String> result = this.tareaValidarRepositoryCustomImpl.validateAmbitoLocalizacion(idTarea);

    assertNotNull(result);
    assertEquals(2, result.size());
    verify(this.namedParameterJdbcTemplate, times(1)).query(eq(SQL_VALIDACION_AMBITO_LOCALIZACION), any(MapSqlParameterSource.class),
        any(RowMapper.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void checkDuplicatedTiendasHistoricoValidIdTareaReturnsList(final Long idTarea) {
    doReturn(List.of("Tienda1", "Tienda2")).when(this.namedParameterJdbcTemplate).query(
        eq(SQL_CHECK_DUPLICATED_TIENDAS_HISTORICO), any(MapSqlParameterSource.class), any(RowMapper.class));

    final List<String> result = this.tareaValidarRepositoryCustomImpl.checkDuplicatedTiendasHistorico(idTarea);

    assertNotNull(result);
    assertEquals(2, result.size());
    verify(this.namedParameterJdbcTemplate, times(1)).query(eq(SQL_CHECK_DUPLICATED_TIENDAS_HISTORICO), any(MapSqlParameterSource.class),
        any(RowMapper.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void checkDuplicatedTiposHoraValidIdTareaReturnsList(final Long idTarea) {
    doReturn(List.of("TipoHora1", "TipoHora2")).when(this.namedParameterJdbcTemplate).query(
        eq(SQL_CHECK_DUPLICATED_TIPOS_HORA), any(MapSqlParameterSource.class), any(RowMapper.class));

    final List<String> result = this.tareaValidarRepositoryCustomImpl.checkDuplicatedTiposHora(idTarea);

    assertNotNull(result);
    assertEquals(2, result.size());
    verify(this.namedParameterJdbcTemplate, times(1)).query(eq(SQL_CHECK_DUPLICATED_TIPOS_HORA), any(MapSqlParameterSource.class),
        any(RowMapper.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void empleadoHistoricoEmptyFieldsValidIdTareaReturnsList(final Long idTarea) {
    doReturn(List.of(new TareaPersonaHistoricoDto(), new TareaPersonaHistoricoDto())).when(this.namedParameterJdbcTemplate).query(
        eq(SQL_EMPLEADO_HISTORICO_EMPTY_FIELDS), any(MapSqlParameterSource.class), any(RowMapper.class));

    final List<TareaPersonaHistoricoDto> result = this.tareaValidarRepositoryCustomImpl.empleadoHistoricoEmptyFields(idTarea);

    assertNotNull(result);
    assertEquals(2, result.size());
    verify(this.namedParameterJdbcTemplate, times(1)).query(eq(SQL_EMPLEADO_HISTORICO_EMPTY_FIELDS), any(MapSqlParameterSource.class),
        any(RowMapper.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void countEmpleadosHistoricoValidIdTareaReturnsInteger(final Long idTarea) {
    doReturn(5).when(this.namedParameterJdbcTemplate).queryForObject(
        eq(SQL_COUNT_EMPLEADOS_HISTORICO), any(MapSqlParameterSource.class), eq(Integer.class));

    final Integer result = this.tareaValidarRepositoryCustomImpl.countEmpleadosHistorico(idTarea);

    assertNotNull(result);
    assertEquals(5, result);
    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(eq(SQL_COUNT_EMPLEADOS_HISTORICO), any(MapSqlParameterSource.class),
        eq(Integer.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void countTiendasHistoricoValidIdTareaReturnsInteger(final Long idTarea) {
    doReturn(3).when(this.namedParameterJdbcTemplate).queryForObject(
        eq(SQL_COUNT_TIENDAS_HISTORICO), any(MapSqlParameterSource.class), eq(Integer.class));

    final Integer result = this.tareaValidarRepositoryCustomImpl.countTiendasHistorico(idTarea);

    assertNotNull(result);
    assertEquals(3, result);
    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(eq(SQL_COUNT_TIENDAS_HISTORICO), any(MapSqlParameterSource.class),
        eq(Integer.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void countEstructurasValidIdTareaReturnsInteger(final Long idTarea) {
    doReturn(7).when(this.namedParameterJdbcTemplate).queryForObject(
        eq(SQL_COUNT_ESTRUCTURAS), any(MapSqlParameterSource.class), eq(Integer.class));

    final Integer result = this.tareaValidarRepositoryCustomImpl.countEstructuras(idTarea);

    assertNotNull(result);
    assertEquals(7, result);
    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(eq(SQL_COUNT_ESTRUCTURAS), any(MapSqlParameterSource.class),
        eq(Integer.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void countTiendaPresenciaSeccionValidIdTareaReturnsInteger(final Long idTarea) {
    doReturn(4).when(this.namedParameterJdbcTemplate).queryForObject(
        eq(SQL_COUNT_TIENDA_PRESENCIA_SECCION), any(MapSqlParameterSource.class), eq(Integer.class));

    final Integer result = this.tareaValidarRepositoryCustomImpl.countTiendaPresenciaSeccion(idTarea);

    assertNotNull(result);
    assertEquals(4, result);
    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(eq(SQL_COUNT_TIENDA_PRESENCIA_SECCION),
        any(MapSqlParameterSource.class),
        eq(Integer.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void countTiendaEmpleadoPresenciaSeccionValidIdTareaReturnsInteger(final Long idTarea) {
    doReturn(6).when(this.namedParameterJdbcTemplate).queryForObject(
        eq(SQL_COUNT_TIENDA_EMPLEADO_PRESENCIA_SECCION), any(MapSqlParameterSource.class), eq(Integer.class));

    final Integer result = this.tareaValidarRepositoryCustomImpl.countTiendaEmpleadoPresenciaSeccion(idTarea);

    assertNotNull(result);
    assertEquals(6, result);
    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(eq(SQL_COUNT_TIENDA_EMPLEADO_PRESENCIA_SECCION),
        any(MapSqlParameterSource.class), eq(Integer.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void countTiendaVentaSeccionValidIdTareaReturnsInteger(final Long idTarea) {
    doReturn(8).when(this.namedParameterJdbcTemplate).queryForObject(
        eq(SQL_COUNT_TIENDA_VENTA_SECCION), any(MapSqlParameterSource.class), eq(Integer.class));

    final Integer result = this.tareaValidarRepositoryCustomImpl.countTiendaVentaSeccion(idTarea);

    assertNotNull(result);
    assertEquals(8, result);
    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(eq(SQL_COUNT_TIENDA_VENTA_SECCION), any(MapSqlParameterSource.class),
        eq(Integer.class));
  }
}
