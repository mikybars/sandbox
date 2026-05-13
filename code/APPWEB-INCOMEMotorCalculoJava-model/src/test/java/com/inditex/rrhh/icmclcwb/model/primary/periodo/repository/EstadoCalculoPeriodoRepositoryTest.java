package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.EstadoPeriodoCalculoDTO;
import com.inditex.rrhh.icmclcwb.dto.EstadoPeriodoCalculoSearchRequestDTO;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
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
class EstadoCalculoPeriodoRepositoryTest {

  private static final String SQL_GET_ESTADO_PERIODO = "SELECT PARTITION.ICM_ID_PERIODO ...";

  @Mock
  NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  EstadoCalculoPeriodoRepository estadoCalculoPeriodoRepository;

  @BeforeEach
  void setup() throws IllegalAccessException {
    estadoCalculoPeriodoRepository = new EstadoCalculoPeriodoRepository(namedParameterJdbcTemplate);
    FieldUtils.writeField(estadoCalculoPeriodoRepository, "sqlGetEstadoPeriodo", SQL_GET_ESTADO_PERIODO, true);
  }

  @Nested
  class GetEstadoPeriodo {

    @Test
    void whenValidRequestExpectCorrectParameters(@Captor ArgumentCaptor<MapSqlParameterSource> paramsCaptor) {
      var request = new EstadoPeriodoCalculoSearchRequestDTO(List.of("STORE1", "STORE2"), "1", "ORG1");

      estadoCalculoPeriodoRepository.getEstadoPeriodo(request);

      verify(namedParameterJdbcTemplate).query(eq(SQL_GET_ESTADO_PERIODO), paramsCaptor.capture(),
          ArgumentMatchers.<RowMapper<EstadoPeriodoCalculoDTO>>any());
      var params = paramsCaptor.getValue();
      assertThat(params.getValue("idsLugarTrabajo")).isEqualTo(List.of("STORE1", "STORE2"));
      assertThat(params.getValue("idPeriodo")).isEqualTo(1L);
      assertThat(params.getValue("idSociedad")).isEqualTo("ORG1");
    }

    @Test
    void whenResultSetHasDataExpectCorrectMapping() {
      var request = new EstadoPeriodoCalculoSearchRequestDTO(List.of("STORE1"), "1", "ORG1");
      var startDate = LocalDate.of(2026, 1, 1);
      var endDate = LocalDate.of(2026, 1, 31);
      stubQueryWithDates(Date.valueOf(startDate), Date.valueOf(endDate));

      var result = estadoCalculoPeriodoRepository.getEstadoPeriodo(request);

      assertThat(result).singleElement().satisfies(dto -> {
        assertThat(dto.getIdPeriodo()).isEqualTo("1");
        assertThat(dto.getIdOrigen()).isEqualTo("ORIGEN1");
        assertThat(dto.getIdEmpresa()).isEqualTo("LEG1");
        assertThat(dto.getFechaInicioPeriodo()).isEqualTo(startDate);
        assertThat(dto.getFechaFinPeriodo()).isEqualTo(endDate);
        assertThat(dto.getIdLugarTrabajo()).isEqualTo("STORE1");
        assertThat(dto.getIdEstado()).isEqualTo("3");
        assertThat(dto.getNombreEstado()).isEqualTo("Calculado");
      });
    }

    @Test
    void whenNullDatesExpectNullFields() {
      var request = new EstadoPeriodoCalculoSearchRequestDTO(List.of("STORE1"), "1", "ORG1");
      stubQueryWithDates(null, null);

      var result = estadoCalculoPeriodoRepository.getEstadoPeriodo(request);

      assertThat(result).singleElement().satisfies(dto -> {
        assertThat(dto.getFechaInicioPeriodo()).isNull();
        assertThat(dto.getFechaFinPeriodo()).isNull();
      });
    }

    @Test
    void whenNoResultsExpectEmptyList() {
      var request = new EstadoPeriodoCalculoSearchRequestDTO(List.of("STORE1"), "1", "ORG1");
      when(namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
          ArgumentMatchers.<RowMapper<EstadoPeriodoCalculoDTO>>any())).thenReturn(emptyList());

      var result = estadoCalculoPeriodoRepository.getEstadoPeriodo(request);

      assertThat(result).isEmpty();
    }

    @Test
    void whenNonNumericIdPeriodoExpectNumberFormatException() {
      var request = new EstadoPeriodoCalculoSearchRequestDTO(List.of("STORE1"), "invalid", "ORG1");

      ThrowingCallable result = () -> estadoCalculoPeriodoRepository.getEstadoPeriodo(request);

      assertThatThrownBy(result).isInstanceOf(NumberFormatException.class);
    }

    void stubQueryWithDates(Date startDate, Date endDate) {
      when(namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
          ArgumentMatchers.<RowMapper<EstadoPeriodoCalculoDTO>>any())).thenAnswer(invocation -> {
            RowMapper<EstadoPeriodoCalculoDTO> rowMapper = invocation.getArgument(2);
            var rs = mock(ResultSet.class);
            when(rs.getString("ICM_ID_PERIODO")).thenReturn("1");
            when(rs.getString("CCL_ID_ORIGEN")).thenReturn("ORIGEN1");
            when(rs.getString("STD_ID_LEG_ENT")).thenReturn("LEG1");
            when(rs.getDate("ICM_DT_START")).thenReturn(startDate);
            when(rs.getDate("ICM_DT_END")).thenReturn(endDate);
            when(rs.getString("STD_ID_WORK_LOCAT")).thenReturn("STORE1");
            when(rs.getString("ICM_ID_ESTADO")).thenReturn("3");
            when(rs.getString("NOMBRE")).thenReturn("Calculado");
            return singletonList(rowMapper.mapRow(rs, 0));
          });
    }
  }
}
