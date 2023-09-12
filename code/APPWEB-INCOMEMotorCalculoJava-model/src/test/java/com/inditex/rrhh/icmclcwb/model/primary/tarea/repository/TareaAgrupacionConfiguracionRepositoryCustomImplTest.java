package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionConfiguracion;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaAgrupacionConfiguracionRepositoryCustomImplTest {

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @InjectMocks
  private TareaAgrupacionConfiguracionRepositoryCustomImpl tareaAgrupacionConfiguracionRepositoryCustom;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaAgrupacionConfiguracionRepositoryCustom, "sqlSave", "", true);
    FieldUtils.writeField(this.tareaAgrupacionConfiguracionRepositoryCustom, "batchSize", 100, true);
  }

  @Test
  public void mergePersonaLocalizacionTest() {

    final List<TareaAgrupacionConfiguracion> items = new ArrayList<>();
    items.add(mock(TareaAgrupacionConfiguracion.class));

    this.tareaAgrupacionConfiguracionRepositoryCustom.save(items);
    verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));

  }

}
