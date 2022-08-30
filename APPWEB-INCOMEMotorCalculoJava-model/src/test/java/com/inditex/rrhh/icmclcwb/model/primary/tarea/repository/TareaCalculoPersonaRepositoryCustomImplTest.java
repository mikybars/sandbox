package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_ESTADO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_ACTUAL;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_NUEVO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_TAREA_PERSONA;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_TAREA_PERSONA_KO;
import static com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants.SQL_PARAM_ID_TAREA;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCalculoPersona;

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
public class TareaCalculoPersonaRepositoryCustomImplTest {

  private final static String SQL_FIND_BY_ALGORITMO = "FIND BY ALGORITMO TEST";

  private final static String SQL_UPDATE_WITH_ESTADO_AND_ID_PERSONA = "UPDATE WITH ESTADO AND ID PERSONA TEST";

  private final static String SQL_UPDATE_WITH_ESTADO = "UPDATE WITH ESTADO TEST";

  private final static String SQL_MERGE_BY_AMBITO = "MERGE BY AMBITO TEST";

  private final static String SQL_MERGE_BY_AMBITO_LOCALIZACION = "MERGE BY AMBITO LOCALIZACION TEST";

  private final static String SQL_MERGE_BY_AMBITO_PERSONA = "MERGE BY AMGITO PERSONA TEST";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private TareaCalculoPersonaRepositoryCustomImpl tareaCalculoPersonaRepositoryCustom;

  @Captor
  private ArgumentCaptor<String> sql;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> params;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaCalculoPersonaRepositoryCustom, "sqlMergePersonaCalculoByAmbito",
        SQL_MERGE_BY_AMBITO, true);
    FieldUtils.writeField(this.tareaCalculoPersonaRepositoryCustom, "sqlMergePersonaCalculoByAmbitoLocalizacion",
        SQL_MERGE_BY_AMBITO_LOCALIZACION, true);
    FieldUtils.writeField(this.tareaCalculoPersonaRepositoryCustom, "sqlMergePersonaCalculoByAmbitoPersona",
        SQL_MERGE_BY_AMBITO_PERSONA, true);
    FieldUtils.writeField(this.tareaCalculoPersonaRepositoryCustom, "sqlUpdateWithEstado",
        SQL_UPDATE_WITH_ESTADO_AND_ID_PERSONA, true);
    FieldUtils.writeField(this.tareaCalculoPersonaRepositoryCustom, "sqlFindByAlgoritmo", SQL_FIND_BY_ALGORITMO,
        true);
    FieldUtils.writeField(this.tareaCalculoPersonaRepositoryCustom, "sqlUpdateEstadoActualWithEstadoNuevo",
        SQL_UPDATE_WITH_ESTADO, true);
  }

  @Test
  public void findByAlgoritmoTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(12L);
    final AlgoritmoDTO algoritmo = mock(AlgoritmoDTO.class);
    when(algoritmo.getId()).thenReturn(90);

    this.tareaCalculoPersonaRepositoryCustom.findByAlgoritmo(tarea, algoritmo);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sql.capture(), this.params.capture(),
        ArgumentMatchers.<RowMapper<TareaCalculoPersona>>any());
    assertEquals(SQL_FIND_BY_ALGORITMO, this.sql.getValue());
    // parametros de la consulta SQL: idAlgoritmo, idTarea
    assertEquals(4, this.params.getValue().getValues().size());
    // idAlgoritmo
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_ALGORITMO));
    assertEquals(algoritmo.getId(), this.params.getValue().getValue(SQL_PARAM_ID_ALGORITMO));
    // idTarea
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), this.params.getValue().getValue(SQL_PARAM_ID_TAREA));
  }

  @Test
  public void updateWithEstadoAndIdPersonaTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(123L);
    when(runTarea.getTarea()).thenReturn(tarea);
    final List<String> idPerson = Arrays.asList("SK22321", "AT2733", "CZ92090");
    final EstadoTareaPersonaDto estado = mock(EstadoTareaPersonaDto.class);
    when(estado.getId()).thenReturn(1);

    this.tareaCalculoPersonaRepositoryCustom.updateWithEstadoAndidPersona(idPerson, runTarea, estado);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sql.capture(), this.params.capture());
    assertEquals(SQL_UPDATE_WITH_ESTADO_AND_ID_PERSONA, this.sql.getValue());
    // parametros de la consulta: idEstado, cclIdPerson, idTarea
    assertEquals(3, this.params.getValue().getValues().size());
    // idEstado
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_ESTADO));
    assertEquals(estado.getId(), this.params.getValue().getValue(SQL_PARAM_ID_ESTADO));
    // cclIdPerson
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_CCL_ID_PERSON));
    assertEquals(idPerson, this.params.getValue().getValue(SQL_PARAM_CCL_ID_PERSON));
    // idTarea
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), this.params.getValue().getValue(SQL_PARAM_ID_TAREA));
  }

  @Test
  public void updateWithEstadoTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(123L);
    when(runTarea.getTarea()).thenReturn(tarea);
    final EstadoTareaPersonaDto estadoActual = mock(EstadoTareaPersonaDto.class);
    when(estadoActual.getId()).thenReturn(1);
    final EstadoTareaPersonaDto estadoNuevo = mock(EstadoTareaPersonaDto.class);
    when(estadoNuevo.getId()).thenReturn(2);

    this.tareaCalculoPersonaRepositoryCustom.updateWithEstado(runTarea, estadoActual, estadoNuevo);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sql.capture(), this.params.capture());
    assertEquals(SQL_UPDATE_WITH_ESTADO, this.sql.getValue());
    // parametros de la consulta: idEstadoNuevo, idTarea, idEstadoActual
    assertEquals(3, this.params.getValue().getValues().size());
    // idEstadoNuevo
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_ESTADO_NUEVO));
    assertEquals(estadoNuevo.getId(), this.params.getValue().getValue(SQL_PARAM_ID_ESTADO_NUEVO));
    // idTarea
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), this.params.getValue().getValue(SQL_PARAM_ID_TAREA));
    // idEstadoActual
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_ESTADO_ACTUAL));
    assertEquals(estadoActual.getId(), this.params.getValue().getValue(SQL_PARAM_ID_ESTADO_ACTUAL));
  }

  @Test
  public void mergePersonaCalculoByAmbitoTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(123L);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaCalculoPersonaRepositoryCustom.mergePersonaCalculoByAmbito(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sql.capture(), this.params.capture());
    assertEquals(SQL_MERGE_BY_AMBITO, this.sql.getValue());
    // parametros de la consulta: idEstadoTareaPersona, idTarea
    assertEquals(4, this.params.getValue().getValues().size());
    // idEstadoTareaPersona
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_ESTADO_TAREA_PERSONA));
    assertEquals(EstadoTareaCalculoPersonaEnum.PENDIENTE.getId(),
        this.params.getValue().getValue(SQL_PARAM_ID_ESTADO_TAREA_PERSONA));
    // idEstadoTareaPersonaKo
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_ESTADO_TAREA_PERSONA_KO));
    assertEquals(EstadoTareaCalculoPersonaEnum.KO.getId(),
        this.params.getValue().getValue(SQL_PARAM_ID_ESTADO_TAREA_PERSONA_KO));
    // idTarea
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), this.params.getValue().getValue(SQL_PARAM_ID_TAREA));
  }

  @Test
  public void mergePersonaCalculoByAmbitoLocalizacionTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(123L);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaCalculoPersonaRepositoryCustom.mergePersonaCalculoByAmbitoLocalizacion(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sql.capture(), this.params.capture());
    assertEquals(SQL_MERGE_BY_AMBITO_LOCALIZACION, this.sql.getValue());
    // parametros de la consulta: idEstadoTareaPersona, idTarea
    assertEquals(4, this.params.getValue().getValues().size());
    // idEstadoTareaPersona
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_ESTADO_TAREA_PERSONA));
    assertEquals(EstadoTareaCalculoPersonaEnum.PENDIENTE.getId(),
        this.params.getValue().getValue(SQL_PARAM_ID_ESTADO_TAREA_PERSONA));
    // idEstadoTareaPersonaKo
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_ESTADO_TAREA_PERSONA_KO));
    assertEquals(EstadoTareaCalculoPersonaEnum.KO.getId(),
        this.params.getValue().getValue(SQL_PARAM_ID_ESTADO_TAREA_PERSONA_KO));
    // idTarea
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), this.params.getValue().getValue(SQL_PARAM_ID_TAREA));

  }

  @Test
  public void mergePersonaCalculoByAmbitoPersonaTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(123L);
    when(runTarea.getTarea()).thenReturn(tarea);

    this.tareaCalculoPersonaRepositoryCustom.mergePersonaCalculoByAmbitoPersona(runTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sql.capture(), this.params.capture());
    assertEquals(SQL_MERGE_BY_AMBITO_PERSONA, this.sql.getValue());
    // parametros de la consulta: idEstadoTareaPersona, idTarea
    assertEquals(4, this.params.getValue().getValues().size());
    // idEstadoTareaPersona
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_ESTADO_TAREA_PERSONA));
    assertEquals(EstadoTareaCalculoPersonaEnum.PENDIENTE.getId(),
        this.params.getValue().getValue(SQL_PARAM_ID_ESTADO_TAREA_PERSONA));
    // idEstadoTareaPersonaKo
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_ESTADO_TAREA_PERSONA_KO));
    assertEquals(EstadoTareaCalculoPersonaEnum.KO.getId(),
        this.params.getValue().getValue(SQL_PARAM_ID_ESTADO_TAREA_PERSONA_KO));
    // idTarea
    assertTrue(this.params.getValue().hasValue(SQL_PARAM_ID_TAREA));
    assertEquals(tarea.getId(), this.params.getValue().getValue(SQL_PARAM_ID_TAREA));

  }

}
