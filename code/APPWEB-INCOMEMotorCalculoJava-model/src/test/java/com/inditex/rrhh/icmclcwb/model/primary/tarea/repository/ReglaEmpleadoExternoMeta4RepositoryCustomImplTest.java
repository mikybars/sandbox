package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.MailAmbito;

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
public class ReglaEmpleadoExternoMeta4RepositoryCustomImplTest {

  private final static String SQL_FIND_REGLAS = "sql";

  @InjectMocks
  private ReglaEmpleadoExternoMeta4RepositoryCustomImpl reglaEmpleadoExternoMeta4RepositoryCustom;

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.reglaEmpleadoExternoMeta4RepositoryCustom, "sqlFindReglasEmpleadoExternoMeta4ActivasByCclIdOrigen",
        SQL_FIND_REGLAS, true);
  }

  @Test
  void findReglasEmpleadoExternoMeta4ActivasByCclIdOrigen() {

    final String cclIdOrigen = "1";
    final String stdIdLegEnt = "8";

    this.reglaEmpleadoExternoMeta4RepositoryCustom.findReglasEmpleadoExternoMeta4ActivasByCclIdOrigen(cclIdOrigen, stdIdLegEnt);

    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<MailAmbito>>any());

    assertEquals(SQL_FIND_REGLAS, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(2, params.getValues().size());
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN));
    assertEquals(cclIdOrigen, params.getValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN));
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT));
    assertEquals(stdIdLegEnt, params.getValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT));
  }

}
