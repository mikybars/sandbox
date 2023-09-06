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
class MailAmbitoRepositoryCustomImplTest {

  private final static String SQL_FIND_MAIL_BY_ORIGEN_EMPRESA = "SQL FIND MAIL BY ORIGEN EMPRESA";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private MailAmbitoRepositoryCustomImpl mailAmbitoRepositoryCustom;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.mailAmbitoRepositoryCustom, "sqlFindMailByCclIdOrigenAndStdIdLegEnt", SQL_FIND_MAIL_BY_ORIGEN_EMPRESA, true);
  }

  @Test
  void findMailByOrigenEmpresaTest() {

    final String cclIdOrigen = "60";
    final String stdIdLegEnt = "179";

    this.mailAmbitoRepositoryCustom.findMailByCclIdOrigenAndStdIdLegEnt(cclIdOrigen, stdIdLegEnt);

    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<MailAmbito>>any());

    assertEquals(SQL_FIND_MAIL_BY_ORIGEN_EMPRESA, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(2, params.getValues().size());
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN));
    assertEquals(cclIdOrigen, params.getValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN));
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT));
    assertEquals(stdIdLegEnt, params.getValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT));
  }

}
