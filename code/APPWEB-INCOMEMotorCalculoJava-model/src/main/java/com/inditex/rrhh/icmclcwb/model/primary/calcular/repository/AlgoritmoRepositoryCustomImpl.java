package com.inditex.rrhh.icmclcwb.model.primary.calcular.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;

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
public class AlgoritmoRepositoryCustomImpl implements AlgoritmoRepositoryCustom {

  @Autowired
  @Qualifier("primaryNamedParameterJdbcTemplate")
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Value("#{primaryQuery['RunTareaCalcularService.customFindAlgoritmosIdsByTarea']}")
  private String sqlCustomFindAlgoritmosIdsByTarea;

  @Value("#{primaryQuery['RunTareaCalcularService.checkDuplicatedActives']}")
  private String sqlCheckDuplicatedActives;

  @Override
  public List<Integer> customFindAlgoritmosIdsByTarea(@NonNull @Positive final Long idTarea) {
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    return namedParameterJdbcTemplate.query(sqlCustomFindAlgoritmosIdsByTarea, parameters,
        new RowMapper<Integer>() {
          @Override
          public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_ALGORITMO);
          }
        });
  }

  @Override
  public Boolean checkDuplicatedActives() {
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    List<Integer> value = namedParameterJdbcTemplate.query(sqlCheckDuplicatedActives, parameters,
        new RowMapper<Integer>() {
          public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getInt(1);
          }
        });
    if (CollectionUtils.isNotEmpty(value)) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }

}
