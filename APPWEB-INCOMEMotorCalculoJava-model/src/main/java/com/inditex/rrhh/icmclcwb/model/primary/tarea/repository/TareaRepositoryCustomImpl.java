package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

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
        params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA, TimeUtils.nowDate());
        namedParameterJdbcTemplate.update(sqlUpdateFechaFin, params);
    }

    @Override
    public void updateFechaInicioAndEstado(@NotNull final TareaDto tarea, @NotNull final EstadoTareaDto estado) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO, estado.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA, TimeUtils.nowDate());
        namedParameterJdbcTemplate.update(sqlUpdateFechaInicioAndEstado, params);
    }

    @Override
    public void updateEstado(@NotNull final TareaDto tarea, @NotNull final EstadoTareaDto estado) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO, estado.getId());
        namedParameterJdbcTemplate.update(sqlUpdateEstado, params);
    }

    @Override
    public void updateEstadoFinal(@NotNull final TareaDto tarea) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO, EstadoTareaEnum.EN_CURSO.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ESTADO_SIN_ERRORES, EstadoTareaEnum.FINALIZADO_SIN_ERRORES.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ESTADO_CON_ERRORES, EstadoTareaEnum.FINALIZADO_CON_ERRORES.getId());
        namedParameterJdbcTemplate.update(sqlUpdateEstadoFinal, params);
    }

}
