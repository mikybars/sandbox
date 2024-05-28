package com.inditex.rrhh.icmclcwb.model.primary.calcular.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AlgoritmoAjusteRepositoryCustomImpl implements AlgoritmoAjusteRepositoryCustom {

  @Autowired
  @Qualifier("primaryNamedParameterJdbcTemplate")
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Value("#{primaryQuery['RunTareaAjustarService.customFindAjustePesosByTarea']}")
  private String sqlCustomFindAjustePesosByTarea;

  @Value("#{primaryQuery['RunTareaAjustarService.customFindAjusteIdsByTareaAndPeso']}")
  private String sqlCustomFindAjusteIdsByTareaAndPeso;

  @Override
  public List<Long> customFindAjustePesosByTarea(@NotNull @Positive final Long idTarea) {
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    return namedParameterJdbcTemplate.query(sqlCustomFindAjustePesosByTarea, parameters,
        new RowMapper<Long>() {
          @Override
          public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getLong(SqlPrimaryConstants.SQL_RESULT_PESO);
          }
        });
  }

  @Override
  public List<Integer> customFindAjusteIdsByTareaAndPeso(@NotNull @Positive final Long idTarea,
      @NotNull @Positive final Long peso) {
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_PESO, peso);
    return namedParameterJdbcTemplate.query(sqlCustomFindAjusteIdsByTareaAndPeso, parameters,
        new RowMapper<Integer>() {
          @Override
          public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_ALGORITMO_AJUSTE);
          }
        });
  }

}
