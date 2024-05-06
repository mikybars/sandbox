package com.inditex.rrhh.icmclcwb.model.primary.calcular.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class AlgoritmoRepositoryCustomImplTest {

  private final static String SQL_CUSTOM_FIND_ALGORITMOS_IDS_BY_TAREA =
      "SQL CUSTOM FIND ALGORITMOS IDS BY TAREA";

  private final static String SQL_CHECK_DUPLICATED_ACTIVES =
      "SQL CHECK DUPLICATED ACTIVES";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private AlgoritmoRepositoryCustomImpl algoritmoRepositoryCustomImpl;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.algoritmoRepositoryCustomImpl,
        "sqlCustomFindAlgoritmosIdsByTarea",
        SQL_CUSTOM_FIND_ALGORITMOS_IDS_BY_TAREA, true);

    FieldUtils.writeField(this.algoritmoRepositoryCustomImpl,
        "sqlCheckDuplicatedActives",
        SQL_CHECK_DUPLICATED_ACTIVES, true);

  }

  @Test
  void customFindAlgoritmosIdsByTareaTest() {

    final Long idTarea = 1L;

    this.algoritmoRepositoryCustomImpl.customFindAlgoritmosIdsByTarea(idTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<AccionDto>>any());

    assertEquals(SQL_CUSTOM_FIND_ALGORITMOS_IDS_BY_TAREA, this.sqlCaptor.getValue());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // parametros consulta SQL: idtarea
    assertEquals(2, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

  }

  @Test
  void checkDuplicatedActivesTest() {

    final Boolean result = this.algoritmoRepositoryCustomImpl.checkDuplicatedActives();

    assertFalse(result);

    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<AccionDto>>any());
    assertEquals(SQL_CHECK_DUPLICATED_ACTIVES, this.sqlCaptor.getValue());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // parametros consulta SQL: activo
    assertEquals(1, params.getValues().size());
    // activo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));

  }

  @Test
  void checkDuplicatedActivesNoEmptyTest() {

    final List<Integer> lista = new ArrayList<>();
    lista.add(1);

    when(this.namedParameterJdbcTemplate.query(any(String.class), any(SqlParameterSource.class), any(RowMapper.class)))
        .thenReturn(lista);
    final Boolean result = this.algoritmoRepositoryCustomImpl.checkDuplicatedActives();

    assertTrue(result);

    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<AccionDto>>any());
    assertEquals(SQL_CHECK_DUPLICATED_ACTIVES, this.sqlCaptor.getValue());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // parametros consulta SQL: activo
    assertEquals(1, params.getValues().size());
    // activo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
  }

}
