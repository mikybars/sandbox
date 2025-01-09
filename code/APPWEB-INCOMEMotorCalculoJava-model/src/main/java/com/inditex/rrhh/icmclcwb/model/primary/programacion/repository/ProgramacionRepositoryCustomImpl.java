package com.inditex.rrhh.icmclcwb.model.primary.programacion.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProgramacionRepositoryCustomImpl implements ProgramacionRepositoryCustom {

  @Autowired
  @Qualifier("primaryNamedParameterJdbcTemplate")
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Value("#{primaryQuery['ProgramacionRepositoryCustom.reset']}")
  private String sqlCustomReset;

  @Value("#{primaryQuery['ProgramacionRepositoryCustom.activa']}")
  private String sqlCheckActiva;

  @Value("#{primaryQuery['ProgramacionRepositoryCustom.activaById']}")
  private String sqlCheckActivaById;

  @Value("#{primaryQuery['ProgramacionRepositoryCustom.updateSiguienteEjecucion']}")
  private String sqlUpdateSiguienteEjecucion;

  @Override
  public void reset() {
    final MapSqlParameterSource arg = new MapSqlParameterSource();
    arg.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_SIGUIENTE_EJECUCION, TimeUtils
        .toDate(TimeUtils.toInstant(LocalDateTime.of(LocalDate.of(1800, Month.JANUARY, 1), LocalTime.MIN))));
    arg.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    this.namedParameterJdbcTemplate.update(this.sqlCustomReset, arg);
  }

  @Override
  public void activa() {
    final MapSqlParameterSource arg = new MapSqlParameterSource();
    arg.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    this.namedParameterJdbcTemplate.update(this.sqlCheckActiva, arg);
  }

  @Override
  public void activa(@Positive @NonNull final Long id) {
    final MapSqlParameterSource arg = new MapSqlParameterSource();
    arg.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_PROGRAMACION, id);
    this.namedParameterJdbcTemplate.update(this.sqlCheckActivaById, arg);
  }

  @Override
  public void desactiva() {
    final MapSqlParameterSource arg = new MapSqlParameterSource();
    arg.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    this.namedParameterJdbcTemplate.update(this.sqlCheckActiva, arg);
  }

  @Override
  public void desactiva(@Positive @NonNull final Long id) {
    final MapSqlParameterSource arg = new MapSqlParameterSource();
    arg.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_PROGRAMACION, id);
    this.namedParameterJdbcTemplate.update(this.sqlCheckActivaById, arg);
  }

  @Override
  public void updateFechaSiguienteEjecucion(
      @NonNull @NotEmpty final List<IdProgramacionDto> idProgramacion,
      final LocalDateTime fechaSiguienteEjecucion) {
    final MapSqlParameterSource arg = new MapSqlParameterSource();
    arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_PROGRAMACION,
        idProgramacion.stream()
            .map(IdProgramacionDto::getId)
            .collect(
                Collectors.toList()));
    arg.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_SIGUIENTE_EJECUCION,
        TimeUtils.toDate(fechaSiguienteEjecucion));
    this.namedParameterJdbcTemplate.update(this.sqlUpdateSiguienteEjecucion, arg);
  }

}
