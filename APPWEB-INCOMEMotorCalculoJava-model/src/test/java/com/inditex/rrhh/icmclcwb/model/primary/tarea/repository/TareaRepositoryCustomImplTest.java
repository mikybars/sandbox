package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoLimpiezaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoLimpiezaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.dto.IdTareaDTO;

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
class TareaRepositoryCustomImplTest {

  private final static String SQL_UPDATE_FECHA_FIN = "SQL UPDATE FECHA FIN";

  private final static String SQL_UPDATE_FECHA_INICIO_AND_ESTADO = "SQL UPDATE FECHA INICIO AND ESTADO";

  private final static String SQL_UPDATE_ESTADO = "SQL UPDATE ESTADO";

  private final static String SQL_UPDATE_ESTADO_FINAL = "SQL UPDATE ESTADO FINAL";

  private final static String SQL_FIND_LIMPIEZA = "SQL FIND LIMPIEZA";

  private final static String SQL_TOTAL_LIMPIEZA = "SQL TOTAL LIMPIEZA";

  private final static String SQL_FIND_LIMPIEZA_BY_ID_TAREA = "SQL FIND LIMPIEZA BY ID TAREA";

  private final static Integer LIMIT = 10;

  private final static String SQL_FIND_TOTAL_TAREAS_CONSOLIDADAS_SIN_AJUSTE_COMISION =
      "SQL FIND TOTAL TAREAS CONSOLIDADAS SIN AJUSTE COMISION";

  private final static String SQL_FIND_TAREAS_CONSOLIDADAS_SIN_AJUSTE_COMISION = "SQL FIND TAREAS CONSOLIDADAS SIN AJUSTE COMISION";

  @Mock
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @InjectMocks
  private TareaRepositoryCustomImpl tareaRepositoryCustom;

  @Captor
  private ArgumentCaptor<String> sqlCaptor;

  @Captor
  private ArgumentCaptor<MapSqlParameterSource> paramsCaptor;

  @BeforeEach
  public void setup() throws IllegalAccessException {
    FieldUtils.writeField(this.tareaRepositoryCustom,
        "sqlUpdateFechaFin", SQL_UPDATE_FECHA_FIN, true);
    FieldUtils.writeField(this.tareaRepositoryCustom,
        "sqlUpdateFechaInicioAndEstado", SQL_UPDATE_FECHA_INICIO_AND_ESTADO, true);
    FieldUtils.writeField(this.tareaRepositoryCustom,
        "sqlUpdateEstado", SQL_UPDATE_ESTADO, true);
    FieldUtils.writeField(this.tareaRepositoryCustom,
        "sqlUpdateEstadoFinal", SQL_UPDATE_ESTADO_FINAL, true);
    FieldUtils.writeField(this.tareaRepositoryCustom,
        "sqlFindLimpieza", SQL_FIND_LIMPIEZA, true);
    FieldUtils.writeField(this.tareaRepositoryCustom,
        "sqlFindLimpiezaByIdTarea", SQL_FIND_LIMPIEZA_BY_ID_TAREA, true);
    FieldUtils.writeField(this.tareaRepositoryCustom,
        "sqlTotalLimpieza", SQL_TOTAL_LIMPIEZA, true);
    FieldUtils.writeField(this.tareaRepositoryCustom, "limitLimpieza", LIMIT, true);
    FieldUtils.writeField(this.tareaRepositoryCustom,
        "sqlFindTareasConsolidadasSinAjusteComision", SQL_FIND_TAREAS_CONSOLIDADAS_SIN_AJUSTE_COMISION, true);
    FieldUtils.writeField(this.tareaRepositoryCustom,
        "sqlTotalTareasConsolidadasSinAjusteComision", SQL_FIND_TOTAL_TAREAS_CONSOLIDADAS_SIN_AJUSTE_COMISION,
        true);
  }

  @Test
  void updateFechaFinTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(9090L);
    this.tareaRepositoryCustom.updateFechaFin(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_FECHA_FIN, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: nuevaFecha, idTarea
    assertEquals(2, params.getValues().size());
    // nuevaFecha
    assertTrue(params.hasValue("nuevaFecha"));
    // idTarea
    assertTrue(params.hasValue("idTarea"));
    assertEquals(tarea.getId(), params.getValue("idTarea"));

  }

  @Test
  void updateFechaInicioAndEstadoTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(9090L);
    final EstadoTareaDto estado = mock(EstadoTareaDto.class);
    when(estado.getId()).thenReturn(909);
    this.tareaRepositoryCustom.updateFechaInicioAndEstado(tarea, estado);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_FECHA_INICIO_AND_ESTADO, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: nuevaFecha, nuevoIdEstado, idTarea
    assertEquals(3, params.getValues().size());
    // nuevaFecha
    assertTrue(params.hasValue("nuevaFecha"));
    // nuevoIdEstado
    assertTrue(params.hasValue("nuevoIdEstado"));
    assertEquals(estado.getId(), params.getValue("nuevoIdEstado"));
    // idTarea
    assertTrue(params.hasValue("idTarea"));
    assertEquals(tarea.getId(), params.getValue("idTarea"));

  }

  @Test
  void updateEstadoTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(9090L);
    final EstadoTareaDto estado = mock(EstadoTareaDto.class);
    when(estado.getId()).thenReturn(909);
    this.tareaRepositoryCustom.updateEstado(tarea, estado);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_ESTADO, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: nuevoIdEstado, idTarea
    assertEquals(2, params.getValues().size());
    // nuevoIdEstado
    assertTrue(params.hasValue("nuevoIdEstado"));
    assertEquals(estado.getId(), params.getValue("nuevoIdEstado"));
    // idTarea
    assertTrue(params.hasValue("idTarea"));
    assertEquals(tarea.getId(), params.getValue("idTarea"));

  }

  @Test
  void updateEstadoFinalTest() {

    final TareaDto tarea = mock(TareaDto.class);
    when(tarea.getId()).thenReturn(9090L);
    this.tareaRepositoryCustom.updateEstadoFinal(tarea);

    verify(this.namedParameterJdbcTemplate, times(1)).update(this.sqlCaptor.capture(), this.paramsCaptor.capture());
    assertEquals(SQL_UPDATE_ESTADO_FINAL, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    // Parámetros de la consulta: idEstado, idTarea, idEstadoSinErrores, idEstadoConErrores
    assertEquals(4, params.getValues().size());
    // idEstado
    assertTrue(params.hasValue("idEstado"));
    assertEquals(EstadoTareaEnum.EN_CURSO.getId(), params.getValue("idEstado"));
    // idTarea
    assertTrue(params.hasValue("idTarea"));
    assertEquals(tarea.getId(), params.getValue("idTarea"));
    // idEstadoSinErrores
    assertTrue(params.hasValue("idEstadoSinErrores"));
    assertEquals(EstadoTareaEnum.FINALIZADO_SIN_ERRORES.getId(), params.getValue("idEstadoSinErrores"));
    // idEstadoConErrores
    assertTrue(params.hasValue("idEstadoConErrores"));
    assertEquals(EstadoTareaEnum.FINALIZADO_CON_ERRORES.getId(), params.getValue("idEstadoConErrores"));

  }

  @Test
  void findLimpiezaTest() {

    final List<IdTareaDto> idTareas = Arrays.asList(new IdTareaDto(22L), new IdTareaDto(789L),
        new IdTareaDto(377L));
    when(this.namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
        ArgumentMatchers.<RowMapper<IdTareaDto>>any())).thenReturn(idTareas);
    final List<IdTareaDTO> result = this.tareaRepositoryCustom.findLimpieza();
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdTareaDto>>any());

    assertEquals(idTareas, result);
    assertEquals(SQL_FIND_LIMPIEZA, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();

    // Parámetros de la consulta: idEstado, fecha
    assertEquals(6, params.getValues().size());
    assertTrue(params.hasValue("idEstado"));
    assertTrue(params.hasValue("fecha"));
    assertTrue(params.hasValue("idEstadoLimpieza"));
    assertTrue(params.hasValue("fechaHoraCreacion"));
    assertTrue(params.hasValue("idTipoLimpieza"));
    assertTrue(params.hasValue("limit"));
    assertEquals(
        Arrays.asList(EstadoTareaEnum.PENDIENTE.getId(), EstadoTareaEnum.EN_CURSO.getId()),
        params.getValue("idEstado"));
    assertEquals(
        Arrays.asList(EstadoLimpiezaEnum.PENDIENTE.getId(), EstadoLimpiezaEnum.KO
            .getId()),
        params.getValue("idEstadoLimpieza"));
    assertEquals(TipoLimpiezaEnum.COMPLETA.getId(), params.getValue("idTipoLimpieza"));
    assertEquals(LIMIT, params.getValue("limit"));
  }

  @Test
  void totalLimpiezaTest() {

    final Integer total = 1234;
    when(this.namedParameterJdbcTemplate.queryForObject(any(String.class), any(MapSqlParameterSource.class),
        ArgumentMatchers.<RowMapper<Integer>>any())).thenReturn(total);
    final Integer result = this.tareaRepositoryCustom.totalLimpieza();
    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(this.sqlCaptor.capture(),
        this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdTareaDto>>any());

    assertEquals(total, result);
    assertEquals(SQL_TOTAL_LIMPIEZA, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();

    // Parámetros de la consulta: idEstado, fecha
    assertEquals(5, params.getValues().size());
    assertTrue(params.hasValue("idEstado"));
    assertTrue(params.hasValue("fecha"));
    assertTrue(params.hasValue("idEstadoLimpieza"));
    assertTrue(params.hasValue("fechaHoraCreacion"));
    assertTrue(params.hasValue("idTipoLimpieza"));
    assertEquals(
        Arrays.asList(EstadoTareaEnum.PENDIENTE.getId(), EstadoTareaEnum.EN_CURSO.getId()),
        params.getValue("idEstado"));
    assertEquals(
        Arrays.asList(EstadoLimpiezaEnum.PENDIENTE.getId(), EstadoLimpiezaEnum.KO
            .getId()),
        params.getValue("idEstadoLimpieza"));
    assertEquals(TipoLimpiezaEnum.COMPLETA.getId(), params.getValue("idTipoLimpieza"));
  }

  @Test
  void findLimpiezaByIdTareaTest() {

    final Long idTarea = 22L;
    final List<IdTareaDto> idTareas = Collections.singletonList(new IdTareaDto(idTarea));
    when(this.namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
        ArgumentMatchers.<RowMapper<IdTareaDto>>any())).thenReturn(idTareas);
    final List<IdTareaDTO> result = this.tareaRepositoryCustom.findLimpiezaByIdTarea(idTarea);
    verify(this.namedParameterJdbcTemplate, times(1)).query(this.sqlCaptor.capture(), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdTareaDto>>any());

    assertEquals(idTareas, result);
    assertEquals(SQL_FIND_LIMPIEZA_BY_ID_TAREA, this.sqlCaptor.getValue());
    final MapSqlParameterSource params = this.paramsCaptor.getValue();

    // Parámetros de la consulta: idEstado, fecha
    assertEquals(6, params.getValues().size());
    assertTrue(params.hasValue("idEstado"));
    assertTrue(params.hasValue("fecha"));
    assertTrue(params.hasValue("idEstadoLimpieza"));
    assertTrue(params.hasValue("fechaHoraCreacion"));
    assertTrue(params.hasValue("idTipoLimpieza"));
    assertTrue(params.hasValue("idTarea"));
    assertEquals(
        Arrays.asList(EstadoTareaEnum.PENDIENTE.getId(), EstadoTareaEnum.EN_CURSO.getId()),
        params.getValue("idEstado"));
    assertEquals(
        Arrays.asList(EstadoLimpiezaEnum.PENDIENTE.getId(), EstadoLimpiezaEnum.KO
            .getId()),
        params.getValue("idEstadoLimpieza"));
    assertEquals(TipoLimpiezaEnum.COMPLETA.getId(), params.getValue("idTipoLimpieza"));
    assertEquals(idTarea, params.getValue("idTarea"));
  }

  // Comienzo de tests de normalización de tareas consolidadas (para borrar)

  @Test
  void totalTareasConsolidadasSinAjusteComisionTest() {

    final Integer total = 145;
    when(this.namedParameterJdbcTemplate.queryForObject(any(String.class), any(MapSqlParameterSource.class),
        ArgumentMatchers.<RowMapper<Integer>>any())).thenReturn(total);
    final Integer result = this.tareaRepositoryCustom.totalTareasConsolidadesSinAjusteComision();

    verify(this.namedParameterJdbcTemplate, times(1)).queryForObject(
        eq(SQL_FIND_TOTAL_TAREAS_CONSOLIDADAS_SIN_AJUSTE_COMISION), this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdTareaDto>>any());
    assertEquals(total, result);

  }

  @Test
  void totalTareasConsolidadasRowMapperTest() {

    final Integer total = 234;
    when(this.namedParameterJdbcTemplate.queryForObject(any(String.class), any(MapSqlParameterSource.class),
        ArgumentMatchers.<RowMapper<Integer>>any())).thenAnswer((invocation) -> {

          final RowMapper<Integer> rowMapper = invocation.getArgument(2);
          final ResultSet rs = mock(ResultSet.class);

          when(rs.getInt(SqlPrimaryConstants.SQL_RESULT_TOTAL)).thenReturn(total);

          return rowMapper.mapRow(rs, 0);

        });

    final Integer result = this.tareaRepositoryCustom.totalTareasConsolidadesSinAjusteComision();

    assertEquals(total, result);

  }

  @Test
  void findTareasConsolidadasSinAjusteComisionNumParamsTest() {

    final Long idTarea = 22L;
    final IdTareaDTO dto = new IdTareaDTO();
    dto.setId(idTarea);
    final List<IdTareaDTO> idTareas = Collections.singletonList(dto);
    when(this.namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
        ArgumentMatchers.<RowMapper<IdTareaDTO>>any())).thenReturn(idTareas);

    final int max = 199;
    final List<IdTareaDTO> result = this.tareaRepositoryCustom
        .findTareasConsolidadesSinAjusteComision(max);

    verify(this.namedParameterJdbcTemplate, times(1)).query(eq(SQL_FIND_TAREAS_CONSOLIDADAS_SIN_AJUSTE_COMISION),
        this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdTareaDTO>>any());
    // Parámetros de la consulta: limit, idEstado
    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertEquals(2, params.getValues().size());
  }

  @Test
  void findTareasConsolidadasSinAjusteComisionLimitParamTest() {

    final Long idTarea = 22L;
    final IdTareaDTO dto = new IdTareaDTO();
    dto.setId(idTarea);
    final List<IdTareaDTO> idTareas = Collections.singletonList(dto);
    when(this.namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
        ArgumentMatchers.<RowMapper<IdTareaDTO>>any())).thenReturn(idTareas);

    final int max = 199;
    final List<IdTareaDTO> result = this.tareaRepositoryCustom
        .findTareasConsolidadesSinAjusteComision(max);

    verify(this.namedParameterJdbcTemplate, times(1)).query(eq(SQL_FIND_TAREAS_CONSOLIDADAS_SIN_AJUSTE_COMISION),
        this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdTareaDTO>>any());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue("limit"));
    assertEquals(max, params.getValue("limit"));

    assertEquals(idTareas, result);

  }

  @Test
  void findTareasConsolidadasSinAjusteComisionIdEstadoParamTest() {

    final Long idTarea = 22L;
    final IdTareaDTO dto = new IdTareaDTO();
    dto.setId(idTarea);
    final List<IdTareaDTO> idTareas = Collections.singletonList(dto);
    when(this.namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
        ArgumentMatchers.<RowMapper<IdTareaDTO>>any())).thenReturn(idTareas);

    final int max = 199;
    final List<IdTareaDTO> result = this.tareaRepositoryCustom
        .findTareasConsolidadesSinAjusteComision(max);

    verify(this.namedParameterJdbcTemplate, times(1)).query(eq(SQL_FIND_TAREAS_CONSOLIDADAS_SIN_AJUSTE_COMISION),
        this.paramsCaptor.capture(),
        ArgumentMatchers.<RowMapper<IdTareaDTO>>any());

    final MapSqlParameterSource params = this.paramsCaptor.getValue();
    assertTrue(params.hasValue("idEstado"));
    assertEquals(EstadoTareaEnum.FINALIZADO_SIN_ERRORES.getId(), params.getValue("idEstado"));

    assertEquals(idTareas, result);

  }

  @Test
  void findTareasConsolidadasSinAjusteComisionRowMapperTest() {

    final long idTarea1 = 190L;
    final long idTarea2 = 899L;

    when(this.namedParameterJdbcTemplate.query(any(String.class), any(MapSqlParameterSource.class),
        ArgumentMatchers.<RowMapper<IdTareaDTO>>any())).thenAnswer((invocation) -> {

          final RowMapper<IdTareaDTO> rowMapper = invocation.getArgument(2);
          final ResultSet rs = mock(ResultSet.class);

          when(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA)).thenReturn(idTarea1, idTarea2);

          return Arrays.asList(rowMapper.mapRow(rs, 0), rowMapper.mapRow(rs, 1));

        });

    final List<IdTareaDTO> result = this.tareaRepositoryCustom
        .findTareasConsolidadesSinAjusteComision(100);

    assertEquals(2, result.size());
    assertEquals(idTarea1, result.get(0).getId());
    assertEquals(idTarea2, result.get(1).getId());

  }

  // Fin de tests de normalización de tareas consolidadas (para borrar)

}
