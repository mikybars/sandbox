package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersonaDesplazamiento;

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
public class TareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustomImplTest {

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @InjectMocks
  private TareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustomImpl tareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustom;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustom, "sqlSave", "",
        true);
    FieldUtils.writeField(this.tareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustom, "batchSize", 100,
        true);
  }

  @Test
  public void saveTest() {

    final List<TareaAmbitoGlobalLocalizacionPersonaDesplazamiento> items = new ArrayList<>();
    items.add(mock(TareaAmbitoGlobalLocalizacionPersonaDesplazamiento.class));

    this.tareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustom.save(items);
    verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));

  }

}
