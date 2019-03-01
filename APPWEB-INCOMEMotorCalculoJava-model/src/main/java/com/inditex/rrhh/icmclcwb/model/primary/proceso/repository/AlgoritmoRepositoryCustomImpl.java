package com.inditex.rrhh.icmclcwb.model.primary.proceso.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

@Repository
public class AlgoritmoRepositoryCustomImpl implements AlgoritmoRepositoryCustom {
    
    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Value("#{primaryQuery['RunProcesoCalcularService.customFindAlgoritmosIdsByProceso']}")
    private String sqlCustomFindAlgoritmosIdsByProceso;
    
    @Value("#{primaryQuery['RunProcesoCalcularService.checkDuplicatedActives']}")
    private String sqlCheckDuplicatedActives;
    
    @Override
    public List<Long> customFindAlgoritmosIdsByProceso(@NotNull @Positive final Long idProceso) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_PROCESO, idProceso);
        return namedParameterJdbcTemplate.query(sqlCustomFindAlgoritmosIdsByProceso, parameters, new RowMapper<Long>() {
            @Override
            public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_ALGORITMO);
            }
        });
    }
    
    @Override
    public Boolean checkDuplicatedActives() {
        List<Integer> value = namedParameterJdbcTemplate.query(sqlCheckDuplicatedActives, new RowMapper<Integer>() {
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                  return rs.getInt(1);
            }
        });

        if(value != null && !value.isEmpty()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
