package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraDesplazamientoReal;

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
public class TareaPersonaEstructuraDesplazamientoRealRepositoryCustomImplTest {

  private static final String SQL_SAVE = "SQL SAVE";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @InjectMocks
  private TareaPersonaEstructuraDesplazamientoRealRepositoryCustomImpl tareaPersonaEstructuraDesplazamientoRealRepositoryCustom;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaPersonaEstructuraDesplazamientoRealRepositoryCustom,
        "sqlSave", SQL_SAVE, true);
    FieldUtils.writeField(this.tareaPersonaEstructuraDesplazamientoRealRepositoryCustom,
        "batchSize", 100, true);
  }

  @Test
  public void saveTest() {
    final List<TareaPersonaEstructuraDesplazamientoReal> items = Arrays
        .asList(mock(TareaPersonaEstructuraDesplazamientoReal.class));
    this.tareaPersonaEstructuraDesplazamientoRealRepositoryCustom.save(items);
    verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));
    assertEquals(SQL_SAVE, this.sqlCaptor.getValue());
  }

}
