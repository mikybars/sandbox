package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccion;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaFaseAccionRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaFaseAccion>
    implements TareaFaseAccionRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-fase-accion:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaFaseAccionRepositoryCustom.save']}")
  private String sqlSave;

  @Value("#{primaryQuery['TareaFaseAccionRepositoryCustom.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion']}")
  private String sqlFindTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion;

  @Value("#{primaryQuery['TareaFaseAccionRepositoryCustom.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucion']}")
  private String sqlFindTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucion;

  @Value("#{primaryQuery['TareaFaseAccionRepositoryCustom.findValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion']}")
  private String sqlFindValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion;

  @Value("#{primaryQuery['TareaFaseAccionRepositoryCustom.updateFechaInicio']}")
  private String sqlUpdateFechaInicio;

  @Value("#{primaryQuery['TareaFaseAccionRepositoryCustom.updateFechaFinAndEstado']}")
  private String sqlUpdateFechaFinAndEstado;

  @Value("#{primaryQuery['TareaFaseAccionRepositoryCustom.updateFechaInicioAndFechaFinAndEstadoAndActivoByIdTareaAndEstadoActual']}")
  private String sqlUpdateFechaInicioAndFechaFinAndEstadoAndActivoByIdTareaAndEstadoActual;

  @Value("#{primaryQuery['TareaFaseAccionRepositoryCustom.countReintentosByIdTareaAndIdAccionAndIdEstado']}")
  private String sqlCountReintentosByIdTareaAndIdAccionAndIdEstado;

  @Value("#{primaryQuery['TareaFaseAccionRepositoryCustom.findByIdTareaFaseAccion']}")
  private String sqlFindByIdTareaFaseAccion;

  @Override
  public List<TareaFaseAccion> save(final List<TareaFaseAccion> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

  @Override
  public List<TareaFaseAccionDto> findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(
      @NotNull @Positive final Long idTarea, @NotNull final Integer idFase,
      @NotNull final Integer idPuntoEjecucion) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_FASE, idFase);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_PUNTO_EJECUCION, idPuntoEjecucion);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    return this.query(
        this.sqlFindTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion,
        parameters, new RowMapper<TareaFaseAccionDto>() {
          @Override
          public TareaFaseAccionDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final TareaFaseAccionDto dto = new TareaFaseAccionDto();
            dto.setId(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA_FASE_ACCION));
            dto.setIdTareaFase(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA_FASE));
            dto.setIdAccion(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_ACCION));
            dto.setIdPuntoEjecucion(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_PUNTO_EJECUCION));
            dto.setIdEstadoTareaFaseAccion(
                rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_ESTADO_TAREA_FASE_ACCION));
            dto.setActivo(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_ACTIVO));
            // dto.setFechaHoraInicio(TimeUtils
            // .toLocalDateTime(
            // rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_HORA_INICIO).toLocalDate()));
            dto.setFechaHoraCreacion(TimeUtils
                .toLocalDateTime(
                    rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_HORA_CREACION).toLocalDate()));
            dto.setPeso(rs.getInt(SqlPrimaryConstants.SQL_RESULT_PESO));
            dto.setReaccionPeso(rs.getInt(SqlPrimaryConstants.SQL_RESULT_REACCION_PESO));
            return dto;
          }
        });
  }

  @Override
  public List<TareaFaseAccionDto> findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucion(
      @NotNull @Positive final Long idTarea, @NotNull final Integer idFase, @NotNull final Integer idAccion,
      @NotNull final Integer idPuntoEjecucion) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_FASE, idFase);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ACCION, idAccion);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_PUNTO_EJECUCION, idPuntoEjecucion);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    return this.query(
        this.sqlFindTareaFaseAccionDtoByIdTareaAndIdFaseAndIdAccionAndIdPuntoEjecucion,
        parameters, new RowMapper<TareaFaseAccionDto>() {
          @Override
          public TareaFaseAccionDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final TareaFaseAccionDto dto = new TareaFaseAccionDto();
            dto.setId(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA_FASE_ACCION));
            dto.setIdTareaFase(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA_FASE));
            dto.setIdAccion(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_ACCION));
            dto.setIdPuntoEjecucion(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_PUNTO_EJECUCION));
            dto.setIdEstadoTareaFaseAccion(
                rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_ESTADO_TAREA_FASE_ACCION));
            dto.setActivo(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_ACTIVO));
            // dto.setFechaHoraInicio(TimeUtils
            // .toLocalDateTime(
            // rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_HORA_INICIO).toLocalDate()));
            dto.setFechaHoraCreacion(TimeUtils
                .toLocalDateTime(
                    rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_HORA_CREACION).toLocalDate()));
            dto.setPeso(rs.getInt(SqlPrimaryConstants.SQL_RESULT_PESO));
            dto.setReaccionPeso(rs.getInt(SqlPrimaryConstants.SQL_RESULT_REACCION_PESO));
            return dto;
          }
        });
  }

  @Override
  public List<Long> findValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion(
      @NotNull @Positive final Long idTarea, @NotNull final Integer idFase,
      @NotNull final Integer idPuntoEjecucion) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_FASE, idFase);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_PUNTO_EJECUCION, idPuntoEjecucion);

    return this.query(
        this.sqlFindValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion,
        parameters, new RowMapper<Long>() {
          @Override
          public Long mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            return (rs.getLong(SqlPrimaryConstants.SQL_RESULT_PESO));
          }
        });
  }

  @Override
  public void updateFechaInicio(@NotNull final TareaFaseAccionDto tareaFaseAccionDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE_ACCION, tareaFaseAccionDto.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO, EstadoTareaFaseAccionEnum.PENDIENTE.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA, TimeUtils.nowDate());
    this.update(this.sqlUpdateFechaInicio, params);
  }

  @Override
  public void updateFechaFinAndEstado(@NotNull final TareaFaseAccionDto tareaFaseAccionDto,
      @NotNull final EstadoTareaFaseAccionDto estadoTareaFaseAccionDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE_ACCION, tareaFaseAccionDto.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO, estadoTareaFaseAccionDto.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA, TimeUtils.nowDate());
    this.update(this.sqlUpdateFechaFinAndEstado, params);
  }

  @Override
  public void updateFechaInicioFechaFinAndEstadoAndActivoByIdTareaAndEstadoActual(
      @NotNull final TareaFaseDto tareaFaseDto,
      @NotNull final EstadoTareaFaseAccionDto estadoTareaFaseAccionActualDto,
      @NotNull final EstadoTareaFaseAccionDto estadoTareaFaseAccionDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaFaseDto.getIdTarea());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO, estadoTareaFaseAccionDto.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO, estadoTareaFaseAccionActualDto.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA, TimeUtils.nowDate());
    this.update(this.sqlUpdateFechaInicioAndFechaFinAndEstadoAndActivoByIdTareaAndEstadoActual, params);
  }

  @Override
  public Integer countReintentosByIdTareaAndIdAccionAndIdEstado(
      @NotNull final TareaFaseAccionDto tareaFaseAccionDto,
      @NotNull final TareaFaseDto tareaFaseDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaFaseDto.getIdTarea());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO, EstadoTareaFaseAccionEnum.KO.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ACCION, tareaFaseAccionDto.getIdAccion());
    return this.queryForObject(this.sqlCountReintentosByIdTareaAndIdAccionAndIdEstado, params, Integer.class);
  }

  @Override
  public TareaFaseAccionDto findById(
      @NotNull @Positive final Long idTareaFaseAccion) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE_ACCION, idTareaFaseAccion);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    return this.queryForObject(
        this.sqlFindByIdTareaFaseAccion,
        parameters, new RowMapper<TareaFaseAccionDto>() {
          @Override
          public TareaFaseAccionDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final TareaFaseAccionDto dto = new TareaFaseAccionDto();
            dto.setId(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA_FASE_ACCION));
            dto.setIdTareaFase(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA_FASE));
            dto.setIdAccion(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_ACCION));
            dto.setIdPuntoEjecucion(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_PUNTO_EJECUCION));
            dto.setIdEstadoTareaFaseAccion(
                rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_ESTADO_TAREA_FASE_ACCION));
            dto.setActivo(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_ACTIVO));
            // dto.setFechaHoraInicio(TimeUtils
            // .toLocalDateTime(
            // rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_HORA_INICIO).toLocalDate()));
            dto.setFechaHoraCreacion(TimeUtils
                .toLocalDateTime(
                    rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_HORA_CREACION).toLocalDate()));
            return dto;
          }
        });
  }

}
