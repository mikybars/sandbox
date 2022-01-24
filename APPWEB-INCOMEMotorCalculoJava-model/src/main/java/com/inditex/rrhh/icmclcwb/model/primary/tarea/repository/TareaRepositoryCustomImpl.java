package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoLimpiezaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoLimpiezaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.dto.IdTareaDTO;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TareaRepositoryCustomImpl implements TareaRepositoryCustom {

  @Autowired
  @Qualifier("primaryNamedParameterJdbcTemplate")
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Value("${app.envars.limpieza.days-number:-7}")
  private int daysNumber;

  @Value("${app.envars.limpieza.days-number-creation:-3}")
  private int daysNumberFechaCreacion;

  @Value("${app.envars.limpieza.max:100}")
  private int limitLimpieza;

  @Value("#{primaryQuery['TareaRepositoryCustom.updateFechaFin']}")
  private String sqlUpdateFechaFin;

  @Value("#{primaryQuery['TareaRepositoryCustom.updateFechaInicioAndEstado']}")
  private String sqlUpdateFechaInicioAndEstado;

  @Value("#{primaryQuery['TareaRepositoryCustom.updateEstado']}")
  private String sqlUpdateEstado;

  @Value("#{primaryQuery['TareaRepositoryCustom.updateEstadoFinal']}")
  private String sqlUpdateEstadoFinal;

  @Value("#{primaryQuery['TareaRepositoryCustom.selectLimit']} #{primaryQuery['TareaRepositoryCustom.findLimpieza']} "
      + "#{primaryQuery['TareaRepositoryCustom.findLimpieza.limit']}")
  private String sqlFindLimpieza;

  @Value("#{primaryQuery['TareaRepositoryCustom.selectTotal']} #{primaryQuery['TareaRepositoryCustom.findLimpieza']}")
  private String sqlTotalLimpieza;

  @Value("#{primaryQuery['TareaRepositoryCustom.selectTarea']} #{primaryQuery['TareaRepositoryCustom.findLimpieza']} "
      + "#{primaryQuery['TareaRepositoryCustom.findLimpieza.byIdTarea']}")
  private String sqlFindLimpiezaByIdTarea;

  // Comienzo de normalización de tareas consolidadas (para borrar)

  @Value("#{primaryQuery['TareaRepositoryCustom.findTareasConsolidadesSinAjusteComision.selectTarea']} "
      + "#{primaryQuery['TareaRepositoryCustom.findTareasConsolidadesSinAjusteComision']} "
      + "#{primaryQuery['TareaRepositoryCustom.findTareasConsolidadesSinAjusteComision.limit']}")
  private String sqlFindTareasConsolidadasSinAjusteComision;

  @Value("#{primaryQuery['TareaRepositoryCustom.findTareasConsolidadesSinAjusteComision.selectTotal']} "
      + "#{primaryQuery['TareaRepositoryCustom.findTareasConsolidadesSinAjusteComision']}")
  private String sqlTotalTareasConsolidadasSinAjusteComision;

  // Fin de normalización de tareas consolidadas (para borrar)

  @Override
  public void updateFechaFin(@NotNull final TareaDto tarea) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA, TimeUtils.nowDate());
    this.namedParameterJdbcTemplate.update(this.sqlUpdateFechaFin, params);
  }

  @Override
  public void updateFechaInicioAndEstado(@NotNull final TareaDto tarea, @NotNull final EstadoTareaDto estado) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO, estado.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA, TimeUtils.nowDate());
    this.namedParameterJdbcTemplate.update(this.sqlUpdateFechaInicioAndEstado, params);
  }

  @Override
  public void updateEstado(@NotNull final TareaDto tarea, @NotNull final EstadoTareaDto estado) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO, estado.getId());
    this.namedParameterJdbcTemplate.update(this.sqlUpdateEstado, params);
  }

  @Override
  public void updateEstadoFinal(@NotNull final TareaDto tarea) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO, EstadoTareaEnum.EN_CURSO.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ESTADO_SIN_ERRORES,
        EstadoTareaEnum.FINALIZADO_SIN_ERRORES.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ESTADO_CON_ERRORES,
        EstadoTareaEnum.FINALIZADO_CON_ERRORES.getId());
    this.namedParameterJdbcTemplate.update(this.sqlUpdateEstadoFinal, params);
  }

  @Override
  public List<IdTareaDTO> findLimpieza() {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO,
        Arrays.asList(EstadoTareaEnum.PENDIENTE.getId(), EstadoTareaEnum.EN_CURSO.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA,
        DateUtils.addDays(TimeUtils.nowDate(), this.daysNumber));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_HORA_CREACION,
        DateUtils.addDays(TimeUtils.nowDate(), this.daysNumberFechaCreacion));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_LIMPIEZA,
        Arrays.asList(EstadoLimpiezaEnum.PENDIENTE.getId(), EstadoLimpiezaEnum.KO.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_LIMPIEZA, TipoLimpiezaEnum.COMPLETA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_LIMIT, this.limitLimpieza);
    return this.namedParameterJdbcTemplate.query(this.sqlFindLimpieza, parameters, (rs, rowNum) -> {
      final IdTareaDTO dto = new IdTareaDTO();
      dto.setId(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA));
      return dto;
    });
  }

  @Override
  public Integer totalLimpieza() {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO,
        Arrays.asList(EstadoTareaEnum.PENDIENTE.getId(), EstadoTareaEnum.EN_CURSO.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA,
        DateUtils.addDays(TimeUtils.nowDate(), this.daysNumber));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_HORA_CREACION,
        DateUtils.addDays(TimeUtils.nowDate(), this.daysNumberFechaCreacion));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_LIMPIEZA,
        Arrays.asList(EstadoLimpiezaEnum.PENDIENTE.getId(), EstadoLimpiezaEnum.KO.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_LIMPIEZA, TipoLimpiezaEnum.COMPLETA.getId());
    return this.namedParameterJdbcTemplate.queryForObject(this.sqlTotalLimpieza, parameters,
        (rs, rowNum) -> rs.getInt(SqlPrimaryConstants.SQL_RESULT_TOTAL));
  }

  @Override
  public List<IdTareaDTO> findLimpiezaByIdTarea(@NotNull final Long idTarea) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA,
        DateUtils.addDays(TimeUtils.nowDate(), this.daysNumber));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_HORA_CREACION,
        DateUtils.addDays(TimeUtils.nowDate(), this.daysNumberFechaCreacion));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO,
        Arrays.asList(EstadoTareaEnum.PENDIENTE.getId(), EstadoTareaEnum.EN_CURSO.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_LIMPIEZA,
        Arrays.asList(EstadoLimpiezaEnum.PENDIENTE.getId(), EstadoLimpiezaEnum.KO.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_LIMPIEZA, TipoLimpiezaEnum.COMPLETA.getId());
    return this.namedParameterJdbcTemplate.query(this.sqlFindLimpiezaByIdTarea, parameters, (rs, rowNum) -> {
      final IdTareaDTO dto = new IdTareaDTO();
      dto.setId(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA));
      return dto;
    });
  }

  // Comienzo de normalización de tareas consolidadas (para borrar)

  @Override
  public Integer totalTareasConsolidadesSinAjusteComision() {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    return this.namedParameterJdbcTemplate.queryForObject(this.sqlTotalTareasConsolidadasSinAjusteComision,
        parameters, (rs, rowNum) -> rs.getInt(SqlPrimaryConstants.SQL_RESULT_TOTAL));
  }

  @Override
  public List<IdTareaDTO> findTareasConsolidadesSinAjusteComision(
      @NotNull final Integer limit) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO, EstadoTareaEnum.FINALIZADO_SIN_ERRORES.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_LIMIT, limit);
    return this.namedParameterJdbcTemplate.query(this.sqlFindTareasConsolidadasSinAjusteComision, parameters,
        (rs, rowNum) -> {
          final IdTareaDTO dto = new IdTareaDTO();
          dto.setId(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA));
          return dto;
        });
  }

  // Fin de normalización de tareas consolidadas (para borrar)

}
