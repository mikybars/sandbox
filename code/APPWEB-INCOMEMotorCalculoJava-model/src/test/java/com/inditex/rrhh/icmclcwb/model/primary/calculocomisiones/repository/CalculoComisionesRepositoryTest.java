package com.inditex.rrhh.icmclcwb.model.primary.calculocomisiones.repository;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.AmbitoFilter;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.CalculoComisionesFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.ComisionLineDto;
import com.inditex.rrhh.icmclcwb.model.primary.calculocomisiones.repository.dto.EmpleadoAProcesarDto;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@ExtendWith(MockitoExtension.class)
class CalculoComisionesRepositoryTest {

  private static final String SQL_FIND_EMPLEADOS_BASE = "SELECT * FROM empleados WHERE periodo = :idPeriodo";

  private static final String SQL_FILTER_BY_EMPRESAS = " AND empresa IN (:empresas)";

  private static final String SQL_FILTER_BY_TIENDAS = " AND tienda IN (:tiendas)";

  private static final String SQL_FILTER_BY_EMPLEADOS = " AND id IN (:empleados)";

  private static final String SQL_FIND_COMISIONES = "SELECT * FROM comisiones WHERE empleado = :idEmpleado";

  @Mock
  NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  CalculoComisionesRepository repository;

  @BeforeEach
  void beforeEach() throws IllegalAccessException {
    repository = new CalculoComisionesRepository(namedParameterJdbcTemplate);
    FieldUtils.writeField(repository, "sqlFindEmpleadosBase", SQL_FIND_EMPLEADOS_BASE, true);
    FieldUtils.writeField(repository, "sqlFilterByEmpresas", SQL_FILTER_BY_EMPRESAS, true);
    FieldUtils.writeField(repository, "sqlFilterByTiendas", SQL_FILTER_BY_TIENDAS, true);
    FieldUtils.writeField(repository, "sqlFilterByEmpleados", SQL_FILTER_BY_EMPLEADOS, true);
    FieldUtils.writeField(repository, "sqlFindComisionesPorEmpleado", SQL_FIND_COMISIONES, true);
  }

  @Nested
  class FindEmpleadosAProcesar {

    @Captor
    ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    @Test
    void whenAmbitoEmpresasExpectCorrectSqlAndParameters() {
      CalculoComisionesFilterDto filter = CalculoComisionesFilterDto.builder()
          .idPeriodo(100L)
          .idOrigen(200L)
          .ambito(AmbitoFilter.EMPRESAS)
          .empresas(List.of("EMP1", "EMP2"))
          .build();
      when(namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
          ArgumentMatchers.<RowMapper<EmpleadoAProcesarDto>>any())).thenReturn(emptyList());

      repository.findEmpleadosAProcesar(filter);

      verify(namedParameterJdbcTemplate).query(eq(SQL_FIND_EMPLEADOS_BASE + SQL_FILTER_BY_EMPRESAS), paramsCaptor.capture(),
          ArgumentMatchers.<RowMapper<EmpleadoAProcesarDto>>any());
      MapSqlParameterSource params = paramsCaptor.getValue();
      assertThat(params.getValue("idPeriodo")).isEqualTo(100L);
      assertThat(params.getValue("idOrigen")).isEqualTo(200L);
      assertThat(params.getValue("empresas")).isEqualTo(List.of("EMP1", "EMP2"));
    }

    @Test
    void whenAmbitoTiendasExpectCorrectSqlAndParameters() {
      CalculoComisionesFilterDto filter = CalculoComisionesFilterDto.builder()
          .idPeriodo(100L)
          .idOrigen(200L)
          .ambito(AmbitoFilter.TIENDAS)
          .tiendas(List.of("T001", "T002", "T003"))
          .build();
      when(namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
          ArgumentMatchers.<RowMapper<EmpleadoAProcesarDto>>any())).thenReturn(emptyList());

      repository.findEmpleadosAProcesar(filter);

      verify(namedParameterJdbcTemplate).query(eq(SQL_FIND_EMPLEADOS_BASE + SQL_FILTER_BY_TIENDAS), paramsCaptor.capture(),
          ArgumentMatchers.<RowMapper<EmpleadoAProcesarDto>>any());
      MapSqlParameterSource params = paramsCaptor.getValue();
      assertThat(params.getValue("tiendas")).isEqualTo(List.of("T001", "T002", "T003"));
    }

    @Test
    void whenAmbitoEmpleadosExpectCorrectSqlAndParameters() {
      CalculoComisionesFilterDto filter = CalculoComisionesFilterDto.builder()
          .idPeriodo(100L)
          .idOrigen(200L)
          .ambito(AmbitoFilter.EMPLEADOS)
          .empleados(List.of("EMP001"))
          .build();
      when(namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
          ArgumentMatchers.<RowMapper<EmpleadoAProcesarDto>>any())).thenReturn(emptyList());

      repository.findEmpleadosAProcesar(filter);

      verify(namedParameterJdbcTemplate).query(eq(SQL_FIND_EMPLEADOS_BASE + SQL_FILTER_BY_EMPLEADOS), paramsCaptor.capture(),
          ArgumentMatchers.<RowMapper<EmpleadoAProcesarDto>>any());
      MapSqlParameterSource params = paramsCaptor.getValue();
      assertThat(params.getValue("empleados")).isEqualTo(List.of("EMP001"));
    }

    @Test
    void whenAmbitoEmpresasWithNullListExpectBaseSql() {
      CalculoComisionesFilterDto filter = CalculoComisionesFilterDto.builder()
          .idPeriodo(100L)
          .idOrigen(200L)
          .ambito(AmbitoFilter.EMPRESAS)
          .empresas(null)
          .build();
      when(namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
          ArgumentMatchers.<RowMapper<EmpleadoAProcesarDto>>any())).thenReturn(emptyList());

      repository.findEmpleadosAProcesar(filter);

      verify(namedParameterJdbcTemplate).query(eq(SQL_FIND_EMPLEADOS_BASE), paramsCaptor.capture(),
          ArgumentMatchers.<RowMapper<EmpleadoAProcesarDto>>any());
    }

    @Test
    void whenAmbitoEmpresasWithEmptyListExpectBaseSql() {
      CalculoComisionesFilterDto filter = CalculoComisionesFilterDto.builder()
          .idPeriodo(100L)
          .idOrigen(200L)
          .ambito(AmbitoFilter.EMPRESAS)
          .empresas(emptyList())
          .build();
      when(namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
          ArgumentMatchers.<RowMapper<EmpleadoAProcesarDto>>any())).thenReturn(emptyList());

      repository.findEmpleadosAProcesar(filter);

      verify(namedParameterJdbcTemplate).query(eq(SQL_FIND_EMPLEADOS_BASE), paramsCaptor.capture(),
          ArgumentMatchers.<RowMapper<EmpleadoAProcesarDto>>any());
    }

    @Test
    void whenNullAmbitoExpectBaseSql() {
      CalculoComisionesFilterDto filter = CalculoComisionesFilterDto.builder()
          .idPeriodo(100L)
          .idOrigen(200L)
          .ambito(null)
          .build();
      when(namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
          ArgumentMatchers.<RowMapper<EmpleadoAProcesarDto>>any())).thenReturn(emptyList());

      repository.findEmpleadosAProcesar(filter);

      verify(namedParameterJdbcTemplate).query(eq(SQL_FIND_EMPLEADOS_BASE), paramsCaptor.capture(),
          ArgumentMatchers.<RowMapper<EmpleadoAProcesarDto>>any());
    }

    @Test
    void whenResultSetHasDataExpectCorrectMapping() {
      CalculoComisionesFilterDto filter = CalculoComisionesFilterDto.builder()
          .idPeriodo(100L)
          .idOrigen(200L)
          .ambito(null)
          .build();
      stubEmpleadosQuery();

      List<EmpleadoAProcesarDto> result = repository.findEmpleadosAProcesar(filter);

      assertThat(result).singleElement().satisfies(dto -> {
        assertThat(dto.getIdOrigen()).isEqualTo("ORIGEN1");
        assertThat(dto.getIdPersona()).isEqualTo("PERSON1");
        assertThat(dto.getStdOrHrPeriod()).isEqualTo("PERIOD1");
        assertThat(dto.getIdEstado()).isEqualTo("ESTADO1");
        assertThat(dto.getIdEmpresa()).isEqualTo("EMPRESA1");
        assertThat(dto.getIdLugarTrabajo()).isEqualTo("TIENDA1");
      });
    }

    @Test
    void whenNoResultsExpectEmptyList() {
      CalculoComisionesFilterDto filter = CalculoComisionesFilterDto.builder()
          .idPeriodo(100L)
          .idOrigen(200L)
          .ambito(AmbitoFilter.EMPRESAS)
          .empresas(List.of("NONEXISTENT"))
          .build();
      when(namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
          ArgumentMatchers.<RowMapper<EmpleadoAProcesarDto>>any())).thenReturn(emptyList());

      List<EmpleadoAProcesarDto> result = repository.findEmpleadosAProcesar(filter);

      assertThat(result).isEmpty();
    }

    void stubEmpleadosQuery() {
      when(namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
          ArgumentMatchers.<RowMapper<EmpleadoAProcesarDto>>any())).thenAnswer(invocation -> {
            RowMapper<EmpleadoAProcesarDto> rowMapper = invocation.getArgument(2);
            ResultSet rs = mock(ResultSet.class);
            when(rs.getString("CCL_ID_ORIGEN")).thenReturn("ORIGEN1");
            when(rs.getString("CCL_ID_PERSON")).thenReturn("PERSON1");
            when(rs.getString("STD_OR_HR_PERIOD")).thenReturn("PERIOD1");
            when(rs.getString("ID_ESTADO")).thenReturn("ESTADO1");
            when(rs.getString("STD_ID_LEG_ENT")).thenReturn("EMPRESA1");
            when(rs.getString("STD_ID_WORK_LOCAT")).thenReturn("TIENDA1");
            return singletonList(rowMapper.mapRow(rs, 0));
          });
    }
  }

  @Nested
  class FindComisionesPorEmpleado {

    @Captor
    ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

    @Test
    void whenValidParametersExpectCorrectSqlParameters() {
      when(namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
          ArgumentMatchers.<RowMapper<ComisionLineDto>>any())).thenReturn(emptyList());

      repository.findComisionesPorEmpleado(100L, 200L, "EMP001");

      verify(namedParameterJdbcTemplate).query(eq(SQL_FIND_COMISIONES), paramsCaptor.capture(),
          ArgumentMatchers.<RowMapper<ComisionLineDto>>any());
      MapSqlParameterSource params = paramsCaptor.getValue();
      assertThat(params.getValue("idPeriodo")).isEqualTo(100L);
      assertThat(params.getValue("idOrigen")).isEqualTo(200L);
      assertThat(params.getValue("idEmpleado")).isEqualTo("EMP001");
    }

    @Test
    void whenNullIdEmpleadoExpectNullInParameters() {
      when(namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
          ArgumentMatchers.<RowMapper<ComisionLineDto>>any())).thenReturn(emptyList());

      repository.findComisionesPorEmpleado(100L, 200L, null);

      verify(namedParameterJdbcTemplate).query(eq(SQL_FIND_COMISIONES), paramsCaptor.capture(),
          ArgumentMatchers.<RowMapper<ComisionLineDto>>any());
      MapSqlParameterSource params = paramsCaptor.getValue();
      assertThat(params.getValue("idEmpleado")).isNull();
    }

    @Test
    void whenNullIdPeriodoExpectNullInParameters() {
      when(namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
          ArgumentMatchers.<RowMapper<ComisionLineDto>>any())).thenReturn(emptyList());

      repository.findComisionesPorEmpleado(null, 200L, "EMP001");

      verify(namedParameterJdbcTemplate).query(eq(SQL_FIND_COMISIONES), paramsCaptor.capture(),
          ArgumentMatchers.<RowMapper<ComisionLineDto>>any());
      MapSqlParameterSource params = paramsCaptor.getValue();
      assertThat(params.getValue("idPeriodo")).isNull();
    }

    @Test
    void whenResultSetHasDataExpectCorrectMapping() {
      stubComisionesQuery();

      List<ComisionLineDto> result = repository.findComisionesPorEmpleado(100L, 200L, "EMP001");

      assertThat(result).singleElement().satisfies(dto -> {
        assertThat(dto.getIdTipoComision()).isEqualTo("TIPO_COM1");
        assertThat(dto.getIdTipoCalculo()).isEqualTo("TIPO_CALC1");
        assertThat(dto.getCodTipoHora()).isEqualTo("HORA1");
        assertThat(dto.getImporte()).isEqualTo(1234.56);
      });
    }

    @Test
    void whenNoResultsExpectEmptyList() {
      when(namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
          ArgumentMatchers.<RowMapper<ComisionLineDto>>any())).thenReturn(emptyList());

      List<ComisionLineDto> result = repository.findComisionesPorEmpleado(100L, 200L, "NONEXISTENT");

      assertThat(result).isEmpty();
    }

    void stubComisionesQuery() {
      when(namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
          ArgumentMatchers.<RowMapper<ComisionLineDto>>any())).thenAnswer(invocation -> {
            RowMapper<ComisionLineDto> rowMapper = invocation.getArgument(2);
            ResultSet rs = mock(ResultSet.class);
            when(rs.getString("ID_TIPO_COMISION")).thenReturn("TIPO_COM1");
            when(rs.getString("ID_TIPO_CALCULO")).thenReturn("TIPO_CALC1");
            when(rs.getString("COD_TIPO_HORA")).thenReturn("HORA1");
            when(rs.getDouble("IMPORTE")).thenReturn(1234.56);
            return singletonList(rowMapper.mapRow(rs, 0));
          });
    }
  }
}
