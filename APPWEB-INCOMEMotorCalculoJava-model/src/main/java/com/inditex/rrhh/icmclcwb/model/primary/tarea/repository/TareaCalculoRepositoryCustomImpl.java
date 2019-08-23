package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

@Repository
public class TareaCalculoRepositoryCustomImpl implements TareaCalculoRepositoryCustom{

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{primaryQuery['TareaCalculoRepositoryCustom.regularizarMejorOpcion']}")
    private String sqlRegularizarMejorOpcion;
    
    @Override
    public void regularizarMejorOpcion(@NotNull TareaDto tareaDto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        namedParameterJdbcTemplate.update(sqlRegularizarMejorOpcion, params);
    }
}
