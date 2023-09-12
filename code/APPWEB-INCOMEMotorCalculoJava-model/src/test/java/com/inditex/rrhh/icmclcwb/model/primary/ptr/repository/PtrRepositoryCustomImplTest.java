
package com.inditex.rrhh.icmclcwb.model.primary.ptr.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import com.inditex.rrhh.icmclcwb.api.app.dto.PresenciaOrigenDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.ptr.repository.PtrRepositoryCustomImpl;

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

@ExtendWith(SpringExtension.class)
public class PtrRepositoryCustomImplTest {

  private final static String SQL_FIND_PRESENCIAS_ORIGEN_AND_FECHA = "SQL FIND PRESENCIAS ORIGEN AND FECHA";

  private final static String SQL_FIND_PRESENCIAS_ORIGEN_AND_FECHA_ES = "SQL FIND PRESENCIAS ORIGEN AND FECHA ES";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private PtrRepositoryCustomImpl ptrRepositoryCustom;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.ptrRepositoryCustom,
        "sqlfindPresenciasOrigenAndFechaQuery",
        SQL_FIND_PRESENCIAS_ORIGEN_AND_FECHA, true);
    FieldUtils.writeField(this.ptrRepositoryCustom,
        "sqlfindPresenciasOrigenAndFechaEsQuery",
        SQL_FIND_PRESENCIAS_ORIGEN_AND_FECHA_ES, true);
  }

  @Test
  public void findPresenciasOrigenAndFecha() {
    final TareaDto tarea = new TareaDto();
    final TareaAmbitoDto ambito = new TareaAmbitoDto();
    tarea.setFechaInicioPeriodo(LocalDate.now());
    tarea.setFechaFinPeriodo(LocalDate.now());
    this.ptrRepositoryCustom.findPresenciasOrigenAndFecha(tarea, ambito);
    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(this.sqlCaptor.capture(),
        this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<PresenciaOrigenDto>>any());
    assertEquals(SQL_FIND_PRESENCIAS_ORIGEN_AND_FECHA,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: fechainicio, fechafin
    assertEquals(3, params.getValues().size());
    // fechainicio
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO));
    // fechafin
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_FECHA_FIN));
  }

  @Test
  public void findPresenciasOrigenAndFechaEs() {
    final TareaDto tarea = new TareaDto();
    final TareaAmbitoDto ambito = new TareaAmbitoDto();
    tarea.setFechaInicioPeriodo(LocalDate.now());
    tarea.setFechaFinPeriodo(LocalDate.now());
    final Integer idCatalogo = 1;
    this.ptrRepositoryCustom.findPresenciasOrigenAndFechaEs(tarea, ambito, idCatalogo);
    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(this.sqlCaptor.capture(),
        this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<PresenciaOrigenDto>>any());
    assertEquals(SQL_FIND_PRESENCIAS_ORIGEN_AND_FECHA_ES,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: fechainicio, fechafin
    assertEquals(4, params.getValues().size());
    // fechainicio
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO));
    // fechafin
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_FECHA_FIN));
  }

}
