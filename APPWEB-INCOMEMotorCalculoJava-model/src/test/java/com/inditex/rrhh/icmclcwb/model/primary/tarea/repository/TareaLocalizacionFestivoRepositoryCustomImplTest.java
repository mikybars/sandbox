package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionFestivo;

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
public class TareaLocalizacionFestivoRepositoryCustomImplTest {

  private static final String SQL_SAVE = "SAVE TEST";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @InjectMocks
  private TareaLocalizacionFestivoRepositoryCustomImpl tareaLocalizacionFestivoRepositoryCustom;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaLocalizacionFestivoRepositoryCustom, "sqlSave", SQL_SAVE, true);
    FieldUtils.writeField(this.tareaLocalizacionFestivoRepositoryCustom, "batchSize", 100, true);
  }

  @Test
  public void saveTest() {

    final List<TareaLocalizacionFestivo> entities = Arrays.asList(mock(TareaLocalizacionFestivo.class));
    this.tareaLocalizacionFestivoRepositoryCustom.save(entities);
    verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));
    assertEquals(SQL_SAVE, this.sqlCaptor.getValue());

  }

}
