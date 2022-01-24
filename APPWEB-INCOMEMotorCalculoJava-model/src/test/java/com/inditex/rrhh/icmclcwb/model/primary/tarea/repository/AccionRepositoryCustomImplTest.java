
package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

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
public class AccionRepositoryCustomImplTest {

  private final static String SQL_FIND_BY_ID_ACCION_AND_ID_ORIGEN_AND_STD_ID_LEG_ENT =
      "SQL FIND BY ID ACCION AND ID ORIGEN AND STD ID LEG ENT";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private AccionRepositoryCustomImpl accionRepositoryCustom;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.accionRepositoryCustom,
        "sqlFindByIdAccionAndIdOrigenAndStdIdLegEnt",
        SQL_FIND_BY_ID_ACCION_AND_ID_ORIGEN_AND_STD_ID_LEG_ENT, true);
    FieldUtils.writeField(this.accionRepositoryCustom,
        "batchSize", 100, true);
  }

  @Test
  public void findByIdAccionAndIdOrigenAndStdIdLegEnt() {
    final Integer idAccion = 10;
    final String cclIdOrigen = "1";
    final String stdIdLegEnt = "1";

    this.accionRepositoryCustom.findByIdAccionAndIdOrigenAndStdIdLegEnt(idAccion,
        cclIdOrigen,
        stdIdLegEnt);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<AccionDto>>any());
    assertEquals(SQL_FIND_BY_ID_ACCION_AND_ID_ORIGEN_AND_STD_ID_LEG_ENT,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idAccion, cclIdOrigen, stdIdLegEnt
    assertEquals(3, params.getValues().size());
    // idAccion
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_ACCION));
    assertEquals(idAccion, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_ACCION));
    // cclIdOrigen
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN));
    assertEquals(cclIdOrigen, params.getValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN));
    // stdIdLegEnt
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT));
    assertEquals(stdIdLegEnt, params.getValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT));
  }

}
