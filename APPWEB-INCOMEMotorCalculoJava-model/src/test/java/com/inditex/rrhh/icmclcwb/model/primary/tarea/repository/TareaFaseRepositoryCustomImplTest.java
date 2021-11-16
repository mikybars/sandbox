
package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFase;

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
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaFaseRepositoryCustomImplTest {

  private final static String SQL_SAVE = "SQL SAVE";

  private final static String SQL_FIND_TAREA_FASE_DTO_BY_ID_TAREA_AND_ID_FASE = "SQL FIND TAREA FASE DTO BY ID TAREA AND ID FASE";

  private final static String SQL_FIND_TAREA_FASE_DTO_BY_ID_TAREA = "SQL FIND TAREA FASE DTO BY ID TAREA";

  private final static String SQL_UPDATE_FECHA_INICIO = "SQL UPDATE FECHA INICIO";

  private final static String SQL_UPDATE_FECHA_INICIO_FECHA_FIN_AND_ESTADO_BY_ID_TAREA_AND_ESTADO_ACTUAL =
      "SQL UPDATE FECHA INICIO FECHA FIN AND ESTADO BY ID TAREA AND ESTADO ACTUAL";

  private final static String SQL_UPDATE_FECHA_FIN_AND_ESTADO_BY_ID_TAREA_FASE = "SQL UPDATE FECHA FIN AND ESTADO BY ID TAREA FASE";

  private final static String SQL_UPDATE_ACTIVO_BY_ID_TAREA = "SQL UPDATE ACTIVO BY ID TAREA";

  private final static String SQL_UPDATE_ACTIVO_BY_ID_TAREA_FASE = "SQL UPDATE ACTIVO BY ID TAREA FASE";

  private final static String SQL_UPDATE_FECHA_INICIO_FECHA_FIN_AND_ESTADO_BY_ID_TAREA_FASE =
      "SQL UPDATE FECHA INICIO FECHA FIN AND ESTADO BY ID TAREA FASE";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private TareaFaseRepositoryCustomImpl tareaFaseRepositoryCustom;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaFaseRepositoryCustom,
        "sqlSave", SQL_SAVE, true);
    FieldUtils.writeField(this.tareaFaseRepositoryCustom,
        "sqlFindTareaFaseDtoByIdTareaAndIdFase",
        SQL_FIND_TAREA_FASE_DTO_BY_ID_TAREA_AND_ID_FASE, true);
    FieldUtils.writeField(this.tareaFaseRepositoryCustom,
        "sqlFindTareaFaseDtoByIdTarea",
        SQL_FIND_TAREA_FASE_DTO_BY_ID_TAREA, true);
    FieldUtils.writeField(this.tareaFaseRepositoryCustom,
        "sqlUpdateFechaInicio",
        SQL_UPDATE_FECHA_INICIO,
        true);
    FieldUtils.writeField(this.tareaFaseRepositoryCustom,
        "sqlUpdateFechaInicioAndFechaFinAndEstadoByIdTareaAndEstadoActual",
        SQL_UPDATE_FECHA_INICIO_FECHA_FIN_AND_ESTADO_BY_ID_TAREA_AND_ESTADO_ACTUAL,
        true);
    FieldUtils.writeField(this.tareaFaseRepositoryCustom,
        "sqlUpdateFechaFinAndEstadoByIdTareaFase", SQL_UPDATE_FECHA_FIN_AND_ESTADO_BY_ID_TAREA_FASE,
        true);
    FieldUtils.writeField(this.tareaFaseRepositoryCustom,
        "sqlUpdateActivoByIdTarea",
        SQL_UPDATE_ACTIVO_BY_ID_TAREA,
        true);
    FieldUtils.writeField(this.tareaFaseRepositoryCustom,
        "sqlUpdateActivoByIdTareaFase",
        SQL_UPDATE_ACTIVO_BY_ID_TAREA_FASE,
        true);
    FieldUtils.writeField(this.tareaFaseRepositoryCustom,
        "sqlUpdateFechaInicioAndFechaFinAndEstadoByIdTareaFase",
        SQL_UPDATE_FECHA_INICIO_FECHA_FIN_AND_ESTADO_BY_ID_TAREA_FASE,
        true);
    FieldUtils.writeField(this.tareaFaseRepositoryCustom,
        "batchSize", 100, true);
  }

  @Test
  public void saveTest() {
    final List<TareaFase> items = Collections.singletonList(mock(TareaFase.class));
    this.tareaFaseRepositoryCustom.save(items);
    verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));
    assertEquals(SQL_SAVE, this.sqlCaptor.getValue());
  }

  @Test
  public void findTareaFaseDtoByIdTareaAndIdFase() {
    final long idTarea = 10L;
    final Integer idFase = 1;
    this.tareaFaseRepositoryCustom.findTareaFaseDtoByIdTareaAndIdFase(
        idTarea,
        idFase);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<TareaFaseDto>>any());
    assertEquals(SQL_FIND_TAREA_FASE_DTO_BY_ID_TAREA_AND_ID_FASE,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, idFase, activo
    assertEquals(3, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // idFase
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_FASE));
    assertEquals(idFase, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_FASE));
    // activo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
  }

  @Test
  public void findTareaFaseDtoByIdTarea() {
    final long idTarea = 10L;
    this.tareaFaseRepositoryCustom.findTareaFaseDtoByIdTarea(
        idTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<TareaFaseDto>>any());
    assertEquals(SQL_FIND_TAREA_FASE_DTO_BY_ID_TAREA,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, activo
    assertEquals(2, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
  }

  @Test
  public void updateFechaInicio() {
    final TareaFaseDto tareaFaseDto = new TareaFaseDto();
    tareaFaseDto.setId(1L);
    this.tareaFaseRepositoryCustom.updateFechaInicio(tareaFaseDto);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_FECHA_INICIO,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTareaFase, fecha
    assertEquals(2, params.getValues().size());
    // idTareaFase
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE));
    assertEquals(tareaFaseDto.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE));
    // fecha
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA));
  }

  @Test
  public void updateFechaInicioAndFechaFinAndEstadoByIdTareaAndEstadoActual() {
    final TareaDto tareaDto = new TareaDto();
    final EstadoTareaFaseDto estadotareaFaseDto = EstadoTareaFaseEnum.OK.getDto();
    final EstadoTareaFaseDto estadotareaFaseActualDto = EstadoTareaFaseEnum.KO.getDto();
    tareaDto.setId(1L);
    this.tareaFaseRepositoryCustom.updateFechaInicioAndFechaFinAndEstadoByIdTareaAndEstadoActual(tareaDto,
        estadotareaFaseDto, estadotareaFaseActualDto);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_FECHA_INICIO_FECHA_FIN_AND_ESTADO_BY_ID_TAREA_AND_ESTADO_ACTUAL,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTareaFase, fecha
    assertEquals(4, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(tareaDto.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // estado
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO));
    assertEquals(EstadoTareaFaseEnum.KO.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO));
    // nuevo estado
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO));
    assertEquals(EstadoTareaFaseEnum.OK.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO));
    // fecha
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA));
  }

  @Test
  public void updateFechaFinAndEstado() {
    final TareaFaseDto tareaFaseDto = new TareaFaseDto();
    final EstadoTareaFaseDto estadotareaFaseDto = EstadoTareaFaseEnum.OK.getDto();
    tareaFaseDto.setId(1L);
    this.tareaFaseRepositoryCustom.updateFechaFinAndEstado(tareaFaseDto,
        estadotareaFaseDto);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_FECHA_FIN_AND_ESTADO_BY_ID_TAREA_FASE,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTareaFase, estado, activo, fecha
    assertEquals(4, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE));
    assertEquals(tareaFaseDto.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE));
    // estado
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO));
    assertEquals(EstadoTareaFaseEnum.OK.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO));
    // fecha
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA));
    // activo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
        params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
  }

  @Test
  public void updateFechaInicioAndFechaFinAndEstado() {
    final TareaFaseDto tareaFaseDto = new TareaFaseDto();
    final EstadoTareaFaseDto estadotareaFaseDto = EstadoTareaFaseEnum.OK.getDto();
    tareaFaseDto.setId(1L);
    this.tareaFaseRepositoryCustom.updateFechaInicioAndFechaFinAndEstado(tareaFaseDto,
        estadotareaFaseDto);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_FECHA_INICIO_FECHA_FIN_AND_ESTADO_BY_ID_TAREA_FASE,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTareaFase, estado, activo, fecha
    assertEquals(4, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE));
    assertEquals(tareaFaseDto.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE));
    // estado
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO));
    assertEquals(EstadoTareaFaseEnum.OK.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO));
    // fecha
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA));
    // activo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
        params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
  }

  @Test
  public void updateActivoByIdTarea() {
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    this.tareaFaseRepositoryCustom.updateActivoByIdTarea(tareaDto);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_ACTIVO_BY_ID_TAREA,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, activo
    assertEquals(2, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(tareaDto.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // activo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
        params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
  }

  @Test
  public void updateActivoByIdTareaFase() {
    final TareaFaseDto tareaFaseDto = new TareaFaseDto();
    tareaFaseDto.setId(1L);
    this.tareaFaseRepositoryCustom.updateActivoByIdTareaFase(tareaFaseDto);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_ACTIVO_BY_ID_TAREA_FASE,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, activo
    assertEquals(2, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE));
    assertEquals(tareaFaseDto.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE));
    // activo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
        params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
  }

}
