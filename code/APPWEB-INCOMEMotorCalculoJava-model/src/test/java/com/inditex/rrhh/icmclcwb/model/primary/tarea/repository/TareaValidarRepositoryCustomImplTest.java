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

import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
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

  @Value("#{primaryQuery['RunTareaValidarService.checkDuplicatedTiendasHistorico']}")
  private String sqlCheckDuplicatedTiendasHistorico;

  @Value("#{primaryQuery['RunTareaValidarService.checkDuplicatedTiposHora']}")
  private String sqlCheckDuplicatedTiposHora;

  @Value("#{primaryQuery['RunTareaValidarService.countEmpleadosHistorico']}")
  private String sqlCountEmpleadosHistorico;

  @Value("#{primaryQuery['RunTareaValidarService.countTiendasHistorico']}")
  private String sqlCountTiendasHistorico;

  @Value("#{primaryQuery['RunTareaValidarService.countEstructuras']}")
  private String sqlCountEstructuras;

  @Value("#{primaryQuery['RunTareaValidarService.countTiendaPresenciaSeccion']}")
  private String sqlCountTiendaPresenciaSeccion;

  @Value("#{primaryQuery['RunTareaValidarService.countTiendaEmpleadoPresenciaSeccion']}")
  private String sqlCountTiendaEmpleadoPresenciaSeccion;

  @Value("#{primaryQuery['RunTareaValidarService.countTiendaVentaSeccion']}")
  private String sqlCountTiendaVentaSeccion;

  @Value("#{primaryQuery['RunTareaValidarService.EmpleadoHistoricoEmptyFields']}")
  private String sqlEmpleadoHistoricoEmptyFields;

  @Value("#{primaryQuery['RunTareaValidarService.AmbitoLocalizacion']}")
  private String sqlValidacionAmbitoLocalizacion;

  @Value("#{primaryQuery['RunTareaValidarService.AmbitoPersona']}")
  private String sqlValidacionAmbitoPersona;

  @Value("#{primaryQuery['RunTareaValidarService.AmbitoEmpresa']}")
  private String sqlValidacionAmbitoEmpresa;

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void validateAmbitoEmpresaValidIdTareaReturnsList(final Long idTarea) {
    doReturn(List.of("Empresa1", "Empresa2")).when(this.namedParameterJdbcTemplate).query(
        eq(this.sqlValidacionAmbitoEmpresa), any(MapSqlParameterSource.class), any(RowMapper.class));

    final List<String> result = this.tareaValidarRepositoryCustomImpl.validateAmbitoEmpresa(idTarea);

    assertNotNull(result);
    assertEquals(2, result.size());
    verify(this.namedParameterJdbcTemplate, times(1)).query(eq(this.sqlValidacionAmbitoEmpresa), any(MapSqlParameterSource.class),
        any(RowMapper.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void validateAmbitoPersonaValidIdTareaReturnsList(final Long idTarea) {
    doReturn(List.of("Persona1", "Persona2")).when(this.namedParameterJdbcTemplate).query(
        eq(this.sqlValidacionAmbitoPersona), any(MapSqlParameterSource.class), any(RowMapper.class));

    final List<String> result = this.tareaValidarRepositoryCustomImpl.validateAmbitoPersona(idTarea);

    assertNotNull(result);
    assertEquals(2, result.size());
    verify(this.namedParameterJdbcTemplate, times(1)).query(eq(this.sqlValidacionAmbitoPersona), any(MapSqlParameterSource.class),
        any(RowMapper.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void validateAmbitoLocalizacionValidIdTareaReturnsList(final Long idTarea) {
    doReturn(List.of("Localizacion1", "Localizacion2")).when(this.namedParameterJdbcTemplate).query(
        eq(this.sqlValidacionAmbitoLocalizacion), any(MapSqlParameterSource.class), any(RowMapper.class));

    final List<String> result = this.tareaValidarRepositoryCustomImpl.validateAmbitoLocalizacion(idTarea);

    assertNotNull(result);
    assertEquals(2, result.size());
    verify(this.namedParameterJdbcTemplate, times(1)).query(eq(this.sqlValidacionAmbitoLocalizacion), any(MapSqlParameterSource.class),
        any(RowMapper.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void checkDuplicatedTiendasHistoricoValidIdTareaReturnsList(final Long idTarea) {
    doReturn(List.of("Tienda1", "Tienda2")).when(this.namedParameterJdbcTemplate).query(
        eq(this.sqlCheckDuplicatedTiendasHistorico), any(MapSqlParameterSource.class), any(RowMapper.class));

    final List<String> result = this.tareaValidarRepositoryCustomImpl.checkDuplicatedTiendasHistorico(idTarea);

    assertNotNull(result);
    assertEquals(2, result.size());
    verify(this.namedParameterJdbcTemplate, times(1)).query(eq(this.sqlCheckDuplicatedTiendasHistorico), any(MapSqlParameterSource.class),
        any(RowMapper.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void checkDuplicatedTiposHoraValidIdTareaReturnsList(final Long idTarea) {
    doReturn(List.of("TipoHora1", "TipoHora2")).when(this.namedParameterJdbcTemplate).query(
        eq(this.sqlCheckDuplicatedTiposHora), any(MapSqlParameterSource.class), any(RowMapper.class));

    final List<String> result = this.tareaValidarRepositoryCustomImpl.checkDuplicatedTiposHora(idTarea);

    assertNotNull(result);
    assertEquals(2, result.size());
    verify(this.namedParameterJdbcTemplate, times(1)).query(eq(this.sqlCheckDuplicatedTiposHora), any(MapSqlParameterSource.class),
        any(RowMapper.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void empleadoHistoricoEmptyFieldsValidIdTareaReturnsList(final Long idTarea) {
    doReturn(List.of(new TareaPersonaHistoricoDto(), new TareaPersonaHistoricoDto())).when(this.namedParameterJdbcTemplate).query(
        eq(this.sqlEmpleadoHistoricoEmptyFields), any(MapSqlParameterSource.class), any(RowMapper.class));

    final List<TareaPersonaHistoricoDto> result = this.tareaValidarRepositoryCustomImpl.empleadoHistoricoEmptyFields(idTarea);

    assertNotNull(result);
    assertEquals(2, result.size());
    verify(this.namedParameterJdbcTemplate, times(1)).query(eq(this.sqlEmpleadoHistoricoEmptyFields), any(MapSqlParameterSource.class),
        any(RowMapper.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void countEmpleadosHistoricoValidIdTareaReturnsInteger(final Long idTarea) {
    doReturn(5).when(this.namedParameterJdbcTemplate).queryForObject(
        eq(this.sqlCountEmpleadosHistorico), any(MapSqlParameterSource.class), eq(Integer.class));

    final Integer result = this.tareaValidarRepositoryCustomImpl.countEmpleadosHistorico(idTarea);

    assertNotNull(result);
    assertEquals(5, result);
    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(eq(this.sqlCountEmpleadosHistorico), any(MapSqlParameterSource.class),
        eq(Integer.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void countTiendasHistoricoValidIdTareaReturnsInteger(final Long idTarea) {
    doReturn(3).when(this.namedParameterJdbcTemplate).queryForObject(
        eq(this.sqlCountTiendasHistorico), any(MapSqlParameterSource.class), eq(Integer.class));

    final Integer result = this.tareaValidarRepositoryCustomImpl.countTiendasHistorico(idTarea);

    assertNotNull(result);
    assertEquals(3, result);
    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(eq(this.sqlCountTiendasHistorico), any(MapSqlParameterSource.class),
        eq(Integer.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void countEstructurasValidIdTareaReturnsInteger(final Long idTarea) {
    doReturn(7).when(this.namedParameterJdbcTemplate).queryForObject(
        eq(this.sqlCountEstructuras), any(MapSqlParameterSource.class), eq(Integer.class));

    final Integer result = this.tareaValidarRepositoryCustomImpl.countEstructuras(idTarea);

    assertNotNull(result);
    assertEquals(7, result);
    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(eq(this.sqlCountEstructuras), any(MapSqlParameterSource.class),
        eq(Integer.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void countTiendaPresenciaSeccionValidIdTareaReturnsInteger(final Long idTarea) {
    doReturn(4).when(this.namedParameterJdbcTemplate).queryForObject(
        eq(this.sqlCountTiendaPresenciaSeccion), any(MapSqlParameterSource.class), eq(Integer.class));

    final Integer result = this.tareaValidarRepositoryCustomImpl.countTiendaPresenciaSeccion(idTarea);

    assertNotNull(result);
    assertEquals(4, result);
    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(eq(this.sqlCountTiendaPresenciaSeccion),
        any(MapSqlParameterSource.class),
        eq(Integer.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void countTiendaEmpleadoPresenciaSeccionValidIdTareaReturnsInteger(final Long idTarea) {
    doReturn(6).when(this.namedParameterJdbcTemplate).queryForObject(
        eq(this.sqlCountTiendaEmpleadoPresenciaSeccion), any(MapSqlParameterSource.class), eq(Integer.class));

    final Integer result = this.tareaValidarRepositoryCustomImpl.countTiendaEmpleadoPresenciaSeccion(idTarea);

    assertNotNull(result);
    assertEquals(6, result);
    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(eq(this.sqlCountTiendaEmpleadoPresenciaSeccion),
        any(MapSqlParameterSource.class), eq(Integer.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void countTiendaVentaSeccionValidIdTareaReturnsInteger(final Long idTarea) {
    doReturn(8).when(this.namedParameterJdbcTemplate).queryForObject(
        eq(this.sqlCountTiendaVentaSeccion), any(MapSqlParameterSource.class), eq(Integer.class));

    final Integer result = this.tareaValidarRepositoryCustomImpl.countTiendaVentaSeccion(idTarea);

    assertNotNull(result);
    assertEquals(8, result);
    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(eq(this.sqlCountTiendaVentaSeccion), any(MapSqlParameterSource.class),
        eq(Integer.class));
  }
}
