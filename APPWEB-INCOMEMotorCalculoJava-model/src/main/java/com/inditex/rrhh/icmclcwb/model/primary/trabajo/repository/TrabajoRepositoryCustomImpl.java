package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.dto.EstadoTrabajoDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

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
    public void updateEstado(@NotNull final TrabajoDTO trabajo, @NotNull final EstadoTrabajoDTO estado) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TRABAJO, trabajo.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO, estado.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA, TimeUtils.nowDate());
        this.namedParameterJdbcTemplate.update(this.sqlUpdateFechaInicioAndEstado, parameters);
    }

    @Override
    public void updateFechaFin(@NotNull final TrabajoDTO trabajo) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TRABAJO, trabajo.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA, TimeUtils.nowDate());
        this.namedParameterJdbcTemplate.update(this.sqlUpdateFechaFin, parameters);
    }

}
