package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.util.Collections;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.MailEntornoDto;
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

  private static final String ENTORNO = "PRE";

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

    final MailEntornoDto mailEntorno = new MailEntornoDto();
    mailEntorno.setActivo(Boolean.TRUE);
    mailEntorno.setEntorno(ENTORNO);
    when(this.namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
        ArgumentMatchers.<RowMapper<IdPersonaLocalLocalizacionDto>>any())).then((invocation) -> {
          final RowMapper<MailEntornoDto> rowMapper = invocation.getArgument(2);
          final ResultSet rs = mock(ResultSet.class);
          when(rs.getString(SqlPrimaryConstants.SQL_RESULT_ENTORNO)).thenReturn(mailEntorno.getEntorno());
          when(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_ACTIVO)).thenReturn(mailEntorno.getActivo());

          return Collections.singletonList(rowMapper.mapRow(rs, 0));
        });

    this.mailEntornoRepositoryCustom.findMailEntornoDtoByEntorno(ENTORNO);

    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<MailAmbito>>any());

    assertEquals(SQL_FIND_MAIL_ENTORNO_BY_ENTORNO, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(1, params.getValues().size());
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ENTORNO));
    assertEquals(ENTORNO, params.getValue(SqlPrimaryConstants.SQL_PARAM_ENTORNO));

  }
}
