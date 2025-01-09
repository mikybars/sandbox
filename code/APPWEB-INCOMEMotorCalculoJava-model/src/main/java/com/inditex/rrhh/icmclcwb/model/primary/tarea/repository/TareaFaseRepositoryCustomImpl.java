package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFase;

import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaFaseRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaFase>
    implements TareaFaseRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-fase:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaFaseRepositoryCustom.save']}")
  private String sqlSave;

  @Value("#{primaryQuery['TareaFaseRepositoryCustom.findTareaFaseDtoByIdTareaAndIdFase']}")
  private String sqlFindTareaFaseDtoByIdTareaAndIdFase;

  @Value("#{primaryQuery['TareaFaseRepositoryCustom.findTareaFaseDtoByIdTarea']}")
  private String sqlFindTareaFaseDtoByIdTarea;

  @Value("#{primaryQuery['TareaFaseRepositoryCustom.updateFechaInicio']}")
  private String sqlUpdateFechaInicio;

  @Value("#{primaryQuery['TareaFaseRepositoryCustom.updateFechaInicioAndFechaFinAndEstadoByIdTareaAndEstadoActual']}")
  private String sqlUpdateFechaInicioAndFechaFinAndEstadoByIdTareaAndEstadoActual;

  @Value("#{primaryQuery['TareaFaseRepositoryCustom.updateFechaFinAndEstadoByIdTareaFase']}")
  private String sqlUpdateFechaFinAndEstadoByIdTareaFase;

  @Value("#{primaryQuery['TareaFaseRepositoryCustom.updateActivoByIdTarea']}")
  private String sqlUpdateActivoByIdTarea;

  @Value("#{primaryQuery['TareaFaseRepositoryCustom.updateActivoByIdTareaFase']}")
  private String sqlUpdateActivoByIdTareaFase;

  @Value("#{primaryQuery['TareaFaseRepositoryCustom.updateFechaInicioAndFechaFinAndEstadoByIdTareaFase']}")
  private String sqlUpdateFechaInicioAndFechaFinAndEstadoByIdTareaFase;

  @Override
  public List<TareaFase> save(final List<TareaFase> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

  @Override
  public TareaFaseDto findTareaFaseDtoByIdTareaAndIdFase(
      @NonNull @Positive final Long idTarea,
      @NonNull @Positive final Integer idFase) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_FASE, idFase);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    final List<TareaFaseDto> tareaFaseDto = this.query(this.sqlFindTareaFaseDtoByIdTareaAndIdFase,
        parameters,
        new RowMapper<TareaFaseDto>() {
          @Override
          public TareaFaseDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final TareaFaseDto dto = new TareaFaseDto();
            dto.setId(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA_FASE));
            dto.setIdTarea(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA));
            dto.setActivo(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_ACTIVO));
            return dto;
          }
        });

    return tareaFaseDto.size() == 1 ? tareaFaseDto.get(0) : null;
  }

  @Override
  public List<TareaFaseDto> findTareaFaseDtoByIdTarea(
      @NonNull @Positive final Long idTarea) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    return this.query(this.sqlFindTareaFaseDtoByIdTarea,
        parameters,
        new RowMapper<TareaFaseDto>() {
          @Override
          public TareaFaseDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final TareaFaseDto dto = new TareaFaseDto();
            dto.setId(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA_FASE));
            dto.setIdTarea(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA));
            dto.setActivo(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_ACTIVO));
            dto.setIdFase(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_FASE));
            return dto;
          }
        });
  }

  @Override
  public void updateFechaInicio(@NonNull final TareaFaseDto tareaFaseDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE, tareaFaseDto.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA, TimeUtils.nowDate());
    this.update(this.sqlUpdateFechaInicio, params);
  }

  @Override
  public void updateFechaInicioAndFechaFinAndEstadoByIdTareaAndEstadoActual(@NonNull final TareaDto tareaDto,
      @NonNull final EstadoTareaFaseDto estadoTareaFaseActualDto,
      @NonNull final EstadoTareaFaseDto estadoTareaFaseDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO, estadoTareaFaseActualDto.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO, estadoTareaFaseDto.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA, TimeUtils.nowDate());
    this.update(this.sqlUpdateFechaInicioAndFechaFinAndEstadoByIdTareaAndEstadoActual, params);
  }

  @Override
  public void updateFechaFinAndEstado(@NonNull final TareaFaseDto tareaFaseDto,
      @NonNull final EstadoTareaFaseDto estadoTareaFaseDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE, tareaFaseDto.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO, estadoTareaFaseDto.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA, TimeUtils.nowDate());
    this.update(this.sqlUpdateFechaFinAndEstadoByIdTareaFase, params);
  }

  @Override
  public void updateFechaInicioAndFechaFinAndEstado(@NonNull final TareaFaseDto tareaFaseDto,
      @NonNull final EstadoTareaFaseDto estadoTareaFaseDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE, tareaFaseDto.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO, estadoTareaFaseDto.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA, TimeUtils.nowDate());
    this.update(this.sqlUpdateFechaInicioAndFechaFinAndEstadoByIdTareaFase, params);
  }

  @Override
  public void updateActivoByIdTarea(@NonNull final TareaDto tareaDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    this.update(this.sqlUpdateActivoByIdTarea, params);
  }

  @Override
  public void updateActivoByIdTareaFase(@NonNull final TareaFaseDto tareaFaseDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE, tareaFaseDto.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    this.update(this.sqlUpdateActivoByIdTareaFase, params);
  }

}
