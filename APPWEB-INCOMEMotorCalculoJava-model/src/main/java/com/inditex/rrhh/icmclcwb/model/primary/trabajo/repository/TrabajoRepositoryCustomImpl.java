package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.EstadoTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public class TrabajoRepositoryCustomImpl implements TrabajoRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{primaryQuery['TrabajoRepositoryCustom.updateFechaInicioAndEstado']}")
    private String sqlUpdateFechaInicioAndEstado;

    @Value("#{primaryQuery['TrabajoRepositoryCustom.updateFechaFin']}")
    private String sqlUpdateFechaFin;


    @Override
    public void updateEstado(@NotNull TrabajoDto trabajo, @NotNull EstadoTrabajoDto estado) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TRABAJO, trabajo.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO, estado.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA, TimeUtils.nowDate());
        namedParameterJdbcTemplate.update(sqlUpdateFechaInicioAndEstado, parameters);
    }

    @Override
    public void updateFechaFin(@NotNull TrabajoDto trabajo) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TRABAJO, trabajo.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA, TimeUtils.nowDate());
        namedParameterJdbcTemplate.update(sqlUpdateFechaFin, parameters);
    }

}
