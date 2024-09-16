package com.inditex.rrhh.icmclcwb.model.primary.calcular.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

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
class AlgoritmoAjusteRepositoryCustomImplTest {

  private static final String SQL_CUSTOM_FIND_AJUSTE_PESOS_BY_TAREA =
      "SQL CUSTOM FIND AJUSTE PESOS BY TAREA";

  private static final String SQL_CUSTOM_FIND_AJUSTE_IDS_BY_TAREA_AND_PESO =
      "SQL CUSTOM FIND AJUSTE IDS BY TAREA AND PESO";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private AlgoritmoAjusteRepositoryCustomImpl algoritmoAjusteRepositoryCustomImpl;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.algoritmoAjusteRepositoryCustomImpl,
        "sqlCustomFindAjustePesosByTarea",
        SQL_CUSTOM_FIND_AJUSTE_PESOS_BY_TAREA, true);

    FieldUtils.writeField(this.algoritmoAjusteRepositoryCustomImpl,
        "sqlCustomFindAjusteIdsByTareaAndPeso",
        SQL_CUSTOM_FIND_AJUSTE_IDS_BY_TAREA_AND_PESO, true);

  }

  @Test
  void customFindAjustePesosByTareaTest() {

    final Long idTarea = 1L;

    this.algoritmoAjusteRepositoryCustomImpl.customFindAjustePesosByTarea(idTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<AccionDto>>any());

    assertEquals(SQL_CUSTOM_FIND_AJUSTE_PESOS_BY_TAREA,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // parametros consulta SQL: idTarea
    assertEquals(2, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
  }

  @Test
  void customFindAjusteIdsByTareaAndPesoTest() {
    final Long Peso = 1L;
    final Long idTarea = 1L;

    this.algoritmoAjusteRepositoryCustomImpl.customFindAjusteIdsByTareaAndPeso(Peso, idTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<AccionDto>>any());

    assertEquals(SQL_CUSTOM_FIND_AJUSTE_IDS_BY_TAREA_AND_PESO, this.sqlCaptor.getValue());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // parametros consulta SQL: idTarea, Peso
    assertEquals(3, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // Peso
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_PESO));
    assertEquals(Peso, params.getValue(SqlPrimaryConstants.SQL_PARAM_PESO));

  }
}
