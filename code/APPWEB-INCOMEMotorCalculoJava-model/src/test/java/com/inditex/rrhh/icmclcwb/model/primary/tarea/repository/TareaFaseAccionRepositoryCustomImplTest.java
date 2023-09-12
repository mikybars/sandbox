
package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccion;

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
public class TareaFaseAccionRepositoryCustomImplTest {

  private final static String SQL_SAVE = "SQL SAVE";

  private final static String SQL_FIND_TAREA_FASE_ACCION_DTO_BY_ID_TAREA_AND_ID_FASE_AND_ID_PUNTO_EJECUCION =
      "SQL FIND TAREA FASE ACCION DTO BY ID TAREA AND ID FASE AND ID PUNTO EJECUCION";

  private final static String SQL_FIND_TAREA_FASE_ACCION_DTO_BY_ID_TAREA_AND_ID_FASE_AND_ID_ACCION_AND_ID_PUNTO_EJECUCION =
      "SQL FIND TAREA FASE ACCION DTO BY ID TAREA AND ID FASE AND ID ACCION AND ID PUNTO EJECUCION";

  private final static String SQL_FIND_VALIDACION_PESO_BY_ID_TAREA_AND_ID_FASE_AND_ID_PUNTO_EJECUCION =
      "SQL FIND VALIDACION PESO BY ID TAREA AND ID FASE AND ID PUNTO EJECUCION";

  private final static String SQL_UPDATE_FECHA_INICIO = "SQL UPDATE FECHA INICIO";

  private final static String SQL_UPDATE_FECHA_FIN_AND_ESTADO = "SQL UPDATE FECHA FIN AND ESTADO";

  private final static String SQL_UPDATE_FECHA_INICIO_FECHA_FIN_AND_ESTADO_AND_ACTIVO_BY_ID_TAREA_AND_ESTADO_ACTUAL =
      "SQL UPDATE FECHA INICIO FECHA FIN AND ESTADO AND ACTIVO BY ID TAREA AND ESTADO ACTUAL";

  private final static String SQL_COUNT_REINTENTOS_BY_ID_TAREA_AND_ID_ACCION_AND_ID_ESTADO =
      "SQL COUNT REINTENTOS BY ID TAREA AND ID ACCION AND ID ESTADO";

  private final static String SQL_FIND_BY_ID = "SQL FIND BY ID";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private TareaFaseAccionRepositoryCustomImpl tareaFaseAccionRepositoryCustom;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaFaseAccionRepositoryCustom,
        "sqlSave", SQL_SAVE, true);
    FieldUtils.writeField(this.tareaFaseAccionRepositoryCustom,
        "sqlFindTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion",
        SQL_FIND_TAREA_FASE_ACCION_DTO_BY_ID_TAREA_AND_ID_FASE_AND_ID_PUNTO_EJECUCION, true);
    FieldUtils.writeField(this.tareaFaseAccionRepositoryCustom,
        "sqlFindTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucion",
        SQL_FIND_TAREA_FASE_ACCION_DTO_BY_ID_TAREA_AND_ID_FASE_AND_ID_ACCION_AND_ID_PUNTO_EJECUCION, true);
    FieldUtils.writeField(this.tareaFaseAccionRepositoryCustom,
        "sqlFindValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion",
        SQL_FIND_VALIDACION_PESO_BY_ID_TAREA_AND_ID_FASE_AND_ID_PUNTO_EJECUCION,
        true);
    FieldUtils.writeField(this.tareaFaseAccionRepositoryCustom,
        "sqlUpdateFechaInicio",
        SQL_UPDATE_FECHA_INICIO,
        true);
    FieldUtils.writeField(this.tareaFaseAccionRepositoryCustom,
        "sqlUpdateFechaFinAndEstado", SQL_UPDATE_FECHA_FIN_AND_ESTADO,
        true);
    FieldUtils.writeField(this.tareaFaseAccionRepositoryCustom,
        "sqlUpdateFechaInicioAndFechaFinAndEstadoAndActivoByIdTareaAndEstadoActual",
        SQL_UPDATE_FECHA_INICIO_FECHA_FIN_AND_ESTADO_AND_ACTIVO_BY_ID_TAREA_AND_ESTADO_ACTUAL,
        true);
    FieldUtils.writeField(this.tareaFaseAccionRepositoryCustom,
        "sqlCountReintentosByIdTareaAndIdAccionAndIdEstado",
        SQL_COUNT_REINTENTOS_BY_ID_TAREA_AND_ID_ACCION_AND_ID_ESTADO,
        true);
    FieldUtils.writeField(this.tareaFaseAccionRepositoryCustom,
        "sqlFindByIdTareaFaseAccion",
        SQL_FIND_BY_ID,
        true);
    FieldUtils.writeField(this.tareaFaseAccionRepositoryCustom,
        "batchSize", 100, true);
  }

  @Test
  public void saveTest() {
    final List<TareaFaseAccion> items = Collections.singletonList(mock(TareaFaseAccion.class));
    this.tareaFaseAccionRepositoryCustom.save(items);
    verify(this.namedParameterJdbcTemplate).batchUpdate(this.sqlCaptor.capture(), any(SqlParameterSource[].class));
    assertEquals(SQL_SAVE, this.sqlCaptor.getValue());
  }

  @Test
  public void findIdPersonaLocalByIdTareaAndIdOrigenInPeriodoCalculoPersonaTest() {
    final long idTarea = 10L;
    final Integer idFase = 1;
    final Integer idPuntoEjecucion = 1;
    this.tareaFaseAccionRepositoryCustom.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(
        idTarea,
        idFase,
        idPuntoEjecucion);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<TareaFaseAccionDto>>any());
    assertEquals(SQL_FIND_TAREA_FASE_ACCION_DTO_BY_ID_TAREA_AND_ID_FASE_AND_ID_PUNTO_EJECUCION,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, idFase, idPuntoEjecucion, activo
    assertEquals(4, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // idFase
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_FASE));
    assertEquals(idFase, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_FASE));
    // idPuntoEjecucion
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_PUNTO_EJECUCION));
    assertEquals(idPuntoEjecucion, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_PUNTO_EJECUCION));
    // activo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
  }

  @Test
  public void findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucion() {
    final long idTarea = 10L;
    final Integer idFase = 1;
    final Integer idAccion = 1;
    final Integer idPuntoEjecucion = 1;
    this.tareaFaseAccionRepositoryCustom.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucion(
        idTarea,
        idFase,
        idAccion,
        idPuntoEjecucion);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<TareaFaseAccionDto>>any());
    assertEquals(SQL_FIND_TAREA_FASE_ACCION_DTO_BY_ID_TAREA_AND_ID_FASE_AND_ID_ACCION_AND_ID_PUNTO_EJECUCION,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, idFase, idPuntoEjecucion, idAccion, activo
    assertEquals(5, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // idFase
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_FASE));
    assertEquals(idFase, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_FASE));
    // idAccion
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_ACCION));
    assertEquals(idFase, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_ACCION));
    // idPuntoEjecucion
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_PUNTO_EJECUCION));
    assertEquals(idPuntoEjecucion, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_PUNTO_EJECUCION));
    // activo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE, params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
  }

  @Test
  public void findValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion() {
    final long idTarea = 10L;
    final Integer idFase = 1;
    final Integer idPuntoEjecucion = 1;
    this.tareaFaseAccionRepositoryCustom.findValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion(
        idTarea,
        idFase,
        idPuntoEjecucion);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<Long>>any());
    assertEquals(SQL_FIND_VALIDACION_PESO_BY_ID_TAREA_AND_ID_FASE_AND_ID_PUNTO_EJECUCION,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, idFase, idPuntoEjecucion
    assertEquals(3, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(idTarea, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // idFase
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_FASE));
    assertEquals(idFase, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_FASE));
    // idPuntoEjecucion
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_PUNTO_EJECUCION));
    assertEquals(idPuntoEjecucion, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_PUNTO_EJECUCION));
  }

  @Test
  public void updateFechaInicio() {
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();
    tareaFaseAccionDto.setId(1L);
    this.tareaFaseAccionRepositoryCustom.updateFechaInicio(tareaFaseAccionDto);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_FECHA_INICIO,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTareaFaseAccion, estado, fecha
    assertEquals(3, params.getValues().size());
    // idTareaFaseAccion
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE_ACCION));
    assertEquals(tareaFaseAccionDto.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE_ACCION));
    // estado
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO));
    assertEquals(EstadoTareaFaseAccionEnum.PENDIENTE.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO));
    // fecha
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA));
  }

  @Test
  public void updateFechaFinAndEstado() {
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();
    final EstadoTareaFaseAccionDto estadoTareaFaseAccionDto = EstadoTareaFaseAccionEnum.OK.getDto();
    tareaFaseAccionDto.setId(1L);
    this.tareaFaseAccionRepositoryCustom.updateFechaFinAndEstado(tareaFaseAccionDto, estadoTareaFaseAccionDto);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_FECHA_FIN_AND_ESTADO,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTareaFaseAccion, estado, activo, fecha
    assertEquals(4, params.getValues().size());
    // idTareaFaseAccion
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE_ACCION));
    assertEquals(tareaFaseAccionDto.getId(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE_ACCION));
    // activo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
        params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
    // estado
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO));
    assertEquals(EstadoTareaFaseAccionEnum.OK.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO));
    // fecha
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA));
  }

  @Test
  public void updateFechaInicioFechaFinAndEstadoAndActivoByIdTareaAndEstadoActual() {
    final TareaFaseDto tareaFaseDto = new TareaFaseDto();
    final EstadoTareaFaseAccionDto estadoTareaFaseAccionActualDto = EstadoTareaFaseAccionEnum.OK.getDto();
    final EstadoTareaFaseAccionDto estadoTareaFaseAccionDto = EstadoTareaFaseAccionEnum.KO.getDto();
    tareaFaseDto.setId(1L);
    tareaFaseDto.setIdTarea(1L);
    this.tareaFaseAccionRepositoryCustom.updateFechaInicioFechaFinAndEstadoAndActivoByIdTareaAndEstadoActual(
        tareaFaseDto, estadoTareaFaseAccionActualDto, estadoTareaFaseAccionDto);
    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_FECHA_INICIO_FECHA_FIN_AND_ESTADO_AND_ACTIVO_BY_ID_TAREA_AND_ESTADO_ACTUAL,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, estado, activo, fecha
    assertEquals(5, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(tareaFaseDto.getIdTarea(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // estado
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO));
    assertEquals(EstadoTareaFaseAccionEnum.KO.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO));
    // nuevo estado
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO));
    assertEquals(EstadoTareaFaseAccionEnum.OK.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO));
    // activo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE,
        params.getValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO));
    // fecha
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA));
  }

  @Test
  public void countReintentosByIdTareaAndIdAccionAndIdEstado() {
    final TareaFaseAccionDto tareaFaseaAccionDto = new TareaFaseAccionDto();
    final TareaFaseDto tareaFaseDto = new TareaFaseDto();
    tareaFaseaAccionDto.setIdAccion(1);
    tareaFaseDto.setId(1L);
    tareaFaseDto.setIdTarea(1L);
    this.tareaFaseAccionRepositoryCustom.countReintentosByIdTareaAndIdAccionAndIdEstado(
        tareaFaseaAccionDto, tareaFaseDto);
    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(this.sqlCaptor.capture(),
        this.paramsCaptor.capture(), ArgumentMatchers.<Class<Object>>any());
    assertEquals(SQL_COUNT_REINTENTOS_BY_ID_TAREA_AND_ID_ACCION_AND_ID_ESTADO,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTarea, estado, accion
    assertEquals(3, params.getValues().size());
    // idTarea
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    assertEquals(tareaFaseDto.getIdTarea(), params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA));
    // estado
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO));
    assertEquals(EstadoTareaFaseAccionEnum.KO.getId(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO));
    // accion
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_ACCION));
    assertEquals(tareaFaseaAccionDto.getIdAccion(),
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_ACCION));

  }

  @Test
  public void findById() {
    final Long idTareaFaseaAccionDto = 1L;
    this.tareaFaseAccionRepositoryCustom.findById(
        idTareaFaseaAccionDto);
    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(this.sqlCaptor.capture(),
        this.paramsCaptor.capture(), ArgumentMatchers.<RowMapper<Integer>>any());
    assertEquals(SQL_FIND_BY_ID,
        this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idTareaFaseAccion, activo
    assertEquals(2, params.getValues().size());
    // idTareaFaseAccion
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE_ACCION));
    assertEquals(idTareaFaseaAccionDto, params.getValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE_ACCION));
    // activo
    assertTrue(params.hasValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));
    assertEquals(SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE,
        params.getValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO));

  }

}
