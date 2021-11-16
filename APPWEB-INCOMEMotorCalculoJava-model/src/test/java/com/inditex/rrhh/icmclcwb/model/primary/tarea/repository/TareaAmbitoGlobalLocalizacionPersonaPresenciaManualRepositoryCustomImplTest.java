package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersonaPresenciaManual;

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
public class TareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustomImplTest {

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @InjectMocks
  private TareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustomImpl tareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustom;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustom, "sqlSave", "",
        true);
    FieldUtils.writeField(this.tareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustom, "batchSize",
        100,
        true);
  }

  @Test
  public void saveTest() {

    final List<TareaAmbitoGlobalLocalizacionPersonaPresenciaManual> items = new ArrayList<>();
    items.add(mock(TareaAmbitoGlobalLocalizacionPersonaPresenciaManual.class));

    this.tareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustom.save(items);
    verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));
  }

}
