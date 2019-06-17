package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

@Repository
public class TareaRepositoryCustomImpl implements TareaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{primaryQuery['TareaRepositoryCustom.updateFechaFin']}")
    private String sqlUpdateFechaFin;
    
    @Value("#{primaryQuery['TareaRepositoryCustom.updateFechaInicioAndEstado']}")
    private String sqlUpdateFechaInicioAndEstado;

    @Value("#{primaryQuery['TareaRepositoryCustom.updateEstado']}")
    private String sqlUpdateEstado;

    @Value("#{primaryQuery['TareaRepositoryCustom.updateEstadoFinal']}")
    private String sqlUpdateEstadoFinal;

    @Override
    public void updateFechaFin(@NotNull final TareaDto tarea) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_FIN, LocalDateTime.now());
        namedParameterJdbcTemplate.update(sqlUpdateFechaFin, params);
    }
    
    @Override
    public void updateFechaInicioAndEstado(@NotNull final TareaDto tarea, @NotNull final EstadoTareaDto estado) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO, estado.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO, LocalDateTime.now());
        namedParameterJdbcTemplate.update(sqlUpdateFechaInicioAndEstado, params);
    }

    @Override
    public void updateEstado(@NotNull final TareaDto tarea, @NotNull final EstadoTareaDto estado) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO, estado.getId());
        namedParameterJdbcTemplate.update(sqlUpdateEstado, params);
    }

    @Override
    public void updateEstadoFinal(@NotNull final TareaDto tarea) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        namedParameterJdbcTemplate.update(sqlUpdateEstadoFinal, params);
    }

}
