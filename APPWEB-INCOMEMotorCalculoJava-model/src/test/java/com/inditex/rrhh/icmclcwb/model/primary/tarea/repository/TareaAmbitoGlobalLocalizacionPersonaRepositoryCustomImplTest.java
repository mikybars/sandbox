package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

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
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaAmbitoGlobalLocalizacionPersonaRepositoryCustomImplTest {

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private TareaAmbitoGlobalLocalizacionPersonaRepositoryCustomImpl tareaaAmbitoGlobalLocalizacionPersonaRepositoryCustom;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> params;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(tareaaAmbitoGlobalLocalizacionPersonaRepositoryCustom, "sqlMergePersonaLocalizacion", "",
        true);
  }

  @Test
  public void mergePersonaLocalizacionTest() {

    Long idTarea = 123456L;
    RunTareaDto runTarea = mock(RunTareaDto.class);
    TareaDto tarea = mock(TareaDto.class);
    when(runTarea.getTarea()).thenReturn(tarea);
    when(tarea.getId()).thenReturn(idTarea);

    tareaaAmbitoGlobalLocalizacionPersonaRepositoryCustom.mergePersonaLocalizacion(runTarea);

    verify(namedParameterJdbcTemplate, times(1)).update(any(String.class), params.capture());
    // argumentos de la consulta SQL: idTarea
    assertEquals(1, params.getValue().getValues().size());
    assertTrue(params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

  }

}
