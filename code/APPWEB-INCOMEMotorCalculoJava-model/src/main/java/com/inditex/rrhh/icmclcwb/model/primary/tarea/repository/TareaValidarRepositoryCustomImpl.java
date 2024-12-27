package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TareaValidarRepositoryCustomImpl implements TareaValidarRepositoryCustom {

  @Autowired
  @Qualifier("primaryNamedParameterJdbcTemplate")
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Value("#{primaryQuery['RunTareaValidarService.checkDuplicatedTiendasHistorico']}")
  private String sqlCheckDuplicatedTiendasHistorico;

  @Value("#{primaryQuery['RunTareaValidarService.checkDuplicatedTiposHora']}")
  private String sqlCheckDuplicatedTiposHora;

  @Value("#{primaryQuery['RunTareaValidarService.countEmpleadosHistorico']}")
  private String sqlCountEmpleadosHistorico;

  @Value("#{primaryQuery['RunTareaValidarService.countTiendasHistorico']}")
  private String sqlCountTiendasHistorico;

  @Value("#{primaryQuery['RunTareaValidarService.countEstructuras']}")
  private String sqlCountEstructuras;

  @Value("#{primaryQuery['RunTareaValidarService.countTiendaPresenciaSeccion']}")
  private String sqlCountTiendaPresenciaSeccion;

  @Value("#{primaryQuery['RunTareaValidarService.countTiendaEmpleadoPresenciaSeccion']}")
  private String sqlCountTiendaEmpleadoPresenciaSeccion;

  @Value("#{primaryQuery['RunTareaValidarService.countTiendaVentaSeccion']}")
  private String sqlCountTiendaVentaSeccion;

  @Value("#{primaryQuery['RunTareaValidarService.EmpleadoHistoricoEmptyFields']}")
  private String sqlEmpleadoHistoricoEmptyFields;

  // ---
  @Value("#{primaryQuery['RunTareaValidarService.AmbitoLocalizacion']}")
  private String sqlValidacionAmbitoLocalizacion;

  @Value("#{primaryQuery['RunTareaValidarService.AmbitoPersona']}")
  private String sqlValidacionAmbitoPersona;

  @Value("#{primaryQuery['RunTareaValidarService.AmbitoEmpresa']}")
  private String sqlValidacionAmbitoEmpresa;

  @Override
  public List<String> validateAmbitoEmpresa(@NonNull @Positive final Long idTarea) {
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    return namedParameterJdbcTemplate.query(sqlValidacionAmbitoEmpresa, parameters, new RowMapper<String>() {
      public String mapRow(ResultSet rs, int rowNum) throws SQLException {
        return rs.getString(1);
      }
    });
  }

  @Override
  public List<String> validateAmbitoPersona(@NonNull @Positive final Long idTarea) {
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    return namedParameterJdbcTemplate.query(sqlValidacionAmbitoPersona, parameters, new RowMapper<String>() {
      public String mapRow(ResultSet rs, int rowNum) throws SQLException {
        return rs.getString(1);
      }
    });
  }

  @Override
  public List<String> validateAmbitoLocalizacion(@NonNull @Positive final Long idTarea) {
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    return namedParameterJdbcTemplate.query(sqlValidacionAmbitoLocalizacion, parameters, new RowMapper<String>() {
      public String mapRow(ResultSet rs, int rowNum) throws SQLException {
        return rs.getString(1);
      }
    });
  }

  @Override
  public List<String> checkDuplicatedTiendasHistorico(@NonNull @Positive final Long idTarea) {
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    return namedParameterJdbcTemplate.query(sqlCheckDuplicatedTiendasHistorico, parameters,
        new RowMapper<String>() {
          public String mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getString(1);
          }
        });
  }

  @Override
  public List<String> checkDuplicatedTiposHora(@NonNull @Positive final Long idTarea) {
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    return namedParameterJdbcTemplate.query(sqlCheckDuplicatedTiposHora, parameters, new RowMapper<String>() {
      public String mapRow(ResultSet rs, int rowNum) throws SQLException {
        return rs.getString(1);
      }
    });
  }

  @Override
  public List<TareaPersonaHistoricoDto> empleadoHistoricoEmptyFields(@NonNull @Positive final Long idTarea) {
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    return namedParameterJdbcTemplate.query(sqlEmpleadoHistoricoEmptyFields, parameters,
        new RowMapper<TareaPersonaHistoricoDto>() {
          public TareaPersonaHistoricoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
            TareaPersonaHistoricoDto dto = new TareaPersonaHistoricoDto();
            dto.setId(rs.getString("ID_TAREA_PERSONA_HISTORICO"));
            dto.setStdIdHr(rs.getString("STD_ID_HR"));
            dto.setCclIdPerson(rs.getString("CCL_ID_PERSON"));
            dto.setStdOrHrPeriod(rs.getString("STD_OR_HR_PERIOD"));
            dto.setIdTarea(rs.getLong("ID_TAREA"));
            dto.setCclIdCodOrigen(rs.getString("CCL_ID_COD_ORIGEN"));
            dto.setStdIdWorkLocat(rs.getString("STD_ID_WORK_LOCAT"));
            dto.setFechaFin(rs.getDate("FECHA_FIN"));
            dto.setFechaInicio(rs.getDate("FECHA_INICIO"));
            return dto;
          }
        });
  }

  @Override
  public Integer countEmpleadosHistorico(@NonNull @Positive Long idTarea) {
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    return namedParameterJdbcTemplate.queryForObject(sqlCountEmpleadosHistorico, parameters, Integer.class);
  }

  @Override
  public Integer countTiendasHistorico(@NonNull @Positive final Long idTarea) {
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    return namedParameterJdbcTemplate.queryForObject(sqlCountTiendasHistorico, parameters, Integer.class);
  }

  @Override
  public Integer countEstructuras(@NonNull @Positive final Long idTarea) {
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    return namedParameterJdbcTemplate.queryForObject(sqlCountEstructuras, parameters, Integer.class);
  }

  @Override
  public Integer countTiendaPresenciaSeccion(@NonNull @Positive final Long idTarea) {
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
    return namedParameterJdbcTemplate.queryForObject(sqlCountTiendaPresenciaSeccion, parameters, Integer.class);
  }

  @Override
  public Integer countTiendaEmpleadoPresenciaSeccion(@NonNull @Positive final Long idTarea) {
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
    return namedParameterJdbcTemplate.queryForObject(sqlCountTiendaEmpleadoPresenciaSeccion, parameters,
        Integer.class);
  }

  @Override
  public Integer countTiendaVentaSeccion(@NonNull @Positive final Long idTarea) {
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
    return namedParameterJdbcTemplate.queryForObject(sqlCountTiendaVentaSeccion, parameters, Integer.class);
  }

}
