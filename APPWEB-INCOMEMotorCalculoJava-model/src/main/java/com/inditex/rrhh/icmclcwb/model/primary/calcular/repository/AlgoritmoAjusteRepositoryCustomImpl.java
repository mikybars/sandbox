package com.inditex.rrhh.icmclcwb.model.primary.calcular.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

@Repository
public class AlgoritmoAjusteRepositoryCustomImpl implements AlgoritmoAjusteRepositoryCustom {
    
    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{primaryQuery['RunTareaAjustarService.customFindAjusteIdsByTarea']}")
    private String sqlCustomFindAjusteIdsByTarea;

    @Override
    public List<Integer> customFindAjusteIdsByTarea(@NotNull @Positive final Long idTarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        return namedParameterJdbcTemplate.query(sqlCustomFindAjusteIdsByTarea, parameters,
                new RowMapper<Integer>() {
                    @Override
                    public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_ALGORITMO_AJUSTE);
                    }
                });
    }

    
}
