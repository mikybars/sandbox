package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionConfiguracionChallengeTipoVenta;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustomImplTest {

  private final static String SQL_SAVE = "SQL SAVE";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private TareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustomImpl tareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustomImpl;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustomImpl, "batchSize", 100,
        true);
    FieldUtils.writeField(this.tareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustomImpl, "sqlSave",
        SQL_SAVE,
        true);
  }

  @Test
  public void save() {
    final List<TareaAgrupacionConfiguracionChallengeTipoVenta> items = Collections
        .singletonList(mock(TareaAgrupacionConfiguracionChallengeTipoVenta.class));
    this.tareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustomImpl.save(items);
    verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));
    assertEquals(SQL_SAVE, this.sqlCaptor.getValue());
  }

}
