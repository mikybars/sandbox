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
public class MailEntornoRepositoryCustomImplTest {

  private final static String SQL_FIND_MAIL_ENTORNO_BY_ENTORNO = "SQL FIND MAIL ENTORNO BY ENTORNO";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private MailEntornoRepositoryCustomImpl mailEntornoRepositoryCustom;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.mailEntornoRepositoryCustom, "sqlFindMailEntornoByEntorno", SQL_FIND_MAIL_ENTORNO_BY_ENTORNO, true);
  }

  @Test
  void findMailEntornoDtoByEntornoTest() {

    final String entorno = "PRE";

    this.mailEntornoRepositoryCustom.findMailEntornoDtoByEntorno(entorno);

    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<MailAmbito>>any());

    assertEquals(SQL_FIND_MAIL_ENTORNO_BY_ENTORNO, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(1, params.getValues().size());
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ENTORNO));
    assertEquals(entorno, params.getValue(SqlPrimaryConstants.SQL_PARAM_ENTORNO));

  }
}
