package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

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
public class PeriodoPersonaRepositoryCustomImplTest {

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private PeriodoPersonaRepositoryCustomImpl periodoPersonaRepositoryCustom;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> params;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.periodoPersonaRepositoryCustom, "sqlMergePeriodoPersona", "", true);
    FieldUtils.writeField(this.periodoPersonaRepositoryCustom, "sqlLimpiezaPeriodoPersona", "", true);
  }

  @Test
  public void mergePeriodoLocalizacionPersonaTest() {

    final Long idTarea = 12345L;
    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(idTarea);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.periodoPersonaRepositoryCustom.mergePeriodoPersona(runTarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.params.capture());
    // parametros de la consulta: idTarea
    assertEquals(1, this.params.getValue().getValues().size());
    assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, this.params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));

  }

  @Test
  public void limpiezaPeriodoPersonaTest() {
    final Long idTarea = 12345L;
    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    final TrabajoDTO trabajo = mock(TrabajoDTO.class);

    when(tarea.getId()).thenReturn(idTarea);
    when(trabajo.getIcmIdPeriodo()).thenReturn(1L);
    when(tarea.getStdIdLegEnt()).thenReturn("1");

    when(runTarea.getTarea()).thenReturn(tarea);
    when(runTarea.getTrabajo()).thenReturn(trabajo);

    final TareaAmbitoDto tareaAmbitoDto = mock(TareaAmbitoDto.class);
    when(tareaAmbitoDto.getCclIdOrigen()).thenReturn("1");

    this.periodoPersonaRepositoryCustom.limpiezaPeriodoPersona(runTarea, tareaAmbitoDto);

    verify(this.namedParameterJdbcTemplate, times(1)).update(any(String.class), this.params.capture());
    // parametros de la consulta: idTarea
    assertEquals(4, this.params.getValue().getValues().size());
    assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, this.params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // origen
    assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN));
    assertEquals("1",
        this.params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN));
    // empresa
    assertTrue(this.params.getValue().hasValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT));
    assertEquals("1",
        this.params.getValue().getValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT));
    // periodo
    assertTrue(this.params.getValue()
        .hasValue(SqlPrimaryConstants.SQL_PARAM_ICM_ID_PERIODO));

  }

}
