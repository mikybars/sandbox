package com.inditex.rrhh.icmclcwb.model.primary.liquidacion.repository;

import static java.util.Collections.singletonList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.stream.Stream;

import com.inditex.rrhh.icmclcwb.model.primary.liquidacion.repository.LiquidacionRepository.ImporteRow;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@ExtendWith(MockitoExtension.class)
class LiquidacionRepositoryTest {

  private static final String SQL_FIND_IMPORTES = "SELECT * FROM importes";

  private static final String SQL_FIND_IMPORTES_DIARIO = "SELECT * FROM importes_diario";

  private static final String SQL_UPDATE_ESTADO = "UPDATE estado SET ...";

  LiquidacionRepository liquidacionRepository;

  @Mock
  NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @BeforeEach
  void setUp() throws IllegalAccessException {
    liquidacionRepository = new LiquidacionRepository(namedParameterJdbcTemplate);
    FieldUtils.writeField(liquidacionRepository, "sqlFindImportes", SQL_FIND_IMPORTES, true);
    FieldUtils.writeField(liquidacionRepository, "sqlFindImportesDiario", SQL_FIND_IMPORTES_DIARIO, true);
    FieldUtils.writeField(liquidacionRepository, "sqlUpdateEstado", SQL_UPDATE_ESTADO, true);
  }

  @Nested
  class FindImportes {

    static Stream<Arguments> isDiarioToSqlProvider() {
      return Stream.of(
          Arguments.of(false, SQL_FIND_IMPORTES),
          Arguments.of(true, SQL_FIND_IMPORTES_DIARIO));
    }

    @ParameterizedTest
    @MethodSource("isDiarioToSqlProvider")
    void whenIsDiarioFlagExpectCorrectSqlUsed(boolean isDiario, String expectedSql) {
      var params = new MapSqlParameterSource();
      when(namedParameterJdbcTemplate.query(eq(expectedSql), any(MapSqlParameterSource.class),
          ArgumentMatchers.<RowMapper<ImporteRow>>any())).thenReturn(singletonList(
              new ImporteRow("1", "EMP1", "100", "1", 3, "COM1", 150.0, null)));

      var result = liquidacionRepository.findImportes(params, isDiario);

      assertThat(result).hasSize(1);
      verify(namedParameterJdbcTemplate, times(1)).query(eq(expectedSql), any(MapSqlParameterSource.class),
          ArgumentMatchers.<RowMapper<ImporteRow>>any());
    }

    @Test
    void whenResultSetHasDataWithIsDiarioTrueExpectCorrectMapping() throws Exception {
      var params = new MapSqlParameterSource();
      var fecha = LocalDate.of(2026, 1, 15);
      when(namedParameterJdbcTemplate.query(eq(SQL_FIND_IMPORTES_DIARIO), any(MapSqlParameterSource.class),
          ArgumentMatchers.<RowMapper<ImporteRow>>any())).thenAnswer(invocation -> {
            RowMapper<ImporteRow> rowMapper = invocation.getArgument(2);
            var rs = mock(ResultSet.class);
            when(rs.getString("CCL_ID_ORIGEN")).thenReturn("2");
            when(rs.getString("STD_ID_LEG_ENT")).thenReturn("EMP1");
            when(rs.getString("CCL_ID_PERSON")).thenReturn("100");
            when(rs.getString("STD_OR_HR_PERIOD")).thenReturn("1");
            when(rs.getInt("ID_ESTADO")).thenReturn(3);
            when(rs.getString("ID_TIPO_COMISION")).thenReturn("COM1");
            when(rs.getDouble("IMPORTE")).thenReturn(150.0);
            when(rs.getObject("FECHA")).thenReturn(Date.valueOf(fecha));
            when(rs.getDate("FECHA")).thenReturn(Date.valueOf(fecha));
            return singletonList(rowMapper.mapRow(rs, 0));
          });

      var result = liquidacionRepository.findImportes(params, true);

      assertThat(result).singleElement().satisfies(row -> {
        assertThat(row.idOrigen()).isEqualTo("2");
        assertThat(row.idEmpresa()).isEqualTo("EMP1");
        assertThat(row.idEmpleado()).isEqualTo("100");
        assertThat(row.ordinal()).isEqualTo("1");
        assertThat(row.idEstado()).isEqualTo(3);
        assertThat(row.idTipoComision()).isEqualTo("COM1");
        assertThat(row.importe()).isEqualTo(150.0);
        assertThat(row.fecha()).isEqualTo(fecha);
      });
    }

    @Test
    void whenIsDiarioFalseExpectFechaAlwaysNull() throws Exception {
      var params = new MapSqlParameterSource();
      when(namedParameterJdbcTemplate.query(eq(SQL_FIND_IMPORTES), any(MapSqlParameterSource.class),
          ArgumentMatchers.<RowMapper<ImporteRow>>any())).thenAnswer(invocation -> {
            RowMapper<ImporteRow> rowMapper = invocation.getArgument(2);
            var rs = mock(ResultSet.class);
            when(rs.getString("CCL_ID_ORIGEN")).thenReturn("2");
            when(rs.getString("STD_ID_LEG_ENT")).thenReturn("EMP1");
            when(rs.getString("CCL_ID_PERSON")).thenReturn("100");
            when(rs.getString("STD_OR_HR_PERIOD")).thenReturn("1");
            when(rs.getInt("ID_ESTADO")).thenReturn(3);
            when(rs.getString("ID_TIPO_COMISION")).thenReturn("COM1");
            when(rs.getDouble("IMPORTE")).thenReturn(150.0);
            return singletonList(rowMapper.mapRow(rs, 0));
          });

      var result = liquidacionRepository.findImportes(params, false);

      assertThat(result).singleElement().satisfies(row -> assertThat(row.fecha()).isNull());
    }

    @Test
    void whenIsDiarioTrueAndFechaIsNullExpectFechaIsNull() throws Exception {
      var params = new MapSqlParameterSource();
      when(namedParameterJdbcTemplate.query(eq(SQL_FIND_IMPORTES_DIARIO), any(MapSqlParameterSource.class),
          ArgumentMatchers.<RowMapper<ImporteRow>>any())).thenAnswer(invocation -> {
            RowMapper<ImporteRow> rowMapper = invocation.getArgument(2);
            var rs = mock(ResultSet.class);
            when(rs.getString("CCL_ID_ORIGEN")).thenReturn("2");
            when(rs.getString("STD_ID_LEG_ENT")).thenReturn("EMP1");
            when(rs.getString("CCL_ID_PERSON")).thenReturn("100");
            when(rs.getString("STD_OR_HR_PERIOD")).thenReturn("1");
            when(rs.getInt("ID_ESTADO")).thenReturn(3);
            when(rs.getString("ID_TIPO_COMISION")).thenReturn("COM1");
            when(rs.getDouble("IMPORTE")).thenReturn(150.0);
            when(rs.getObject("FECHA")).thenReturn(null);
            return singletonList(rowMapper.mapRow(rs, 0));
          });

      var result = liquidacionRepository.findImportes(params, true);

      assertThat(result).singleElement().satisfies(row -> assertThat(row.fecha()).isNull());
    }
  }

  @Nested
  class UpdateEstado {

    @Test
    void whenCalledExpectDelegatesToJdbcTemplate() {
      var params = new MapSqlParameterSource();
      when(namedParameterJdbcTemplate.update(eq(SQL_UPDATE_ESTADO), any(MapSqlParameterSource.class)))
          .thenReturn(1);

      var result = liquidacionRepository.updateEstado(params);

      assertThat(result).isOne();
      verify(namedParameterJdbcTemplate, times(1)).update(eq(SQL_UPDATE_ESTADO), any(MapSqlParameterSource.class));
    }
  }
}
