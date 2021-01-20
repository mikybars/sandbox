package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotNull;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import org.apache.commons.lang3.time.DateUtils;

@Repository
public class TareaRepositoryCustomImpl implements TareaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("${app.envars.limpieza.days-number:-7}")
    private int daysNumber;
    
    @Value("#{primaryQuery['TareaRepositoryCustom.updateFechaFin']}")
    private String sqlUpdateFechaFin;

    @Value("#{primaryQuery['TareaRepositoryCustom.updateFechaInicioAndEstado']}")
    private String sqlUpdateFechaInicioAndEstado;

    @Value("#{primaryQuery['TareaRepositoryCustom.updateEstado']}")
    private String sqlUpdateEstado;

    @Value("#{primaryQuery['TareaRepositoryCustom.updateEstadoFinal']}")
    private String sqlUpdateEstadoFinal;

    @Value("#{primaryQuery['TareaRepositoryCustom.findLimpieza']}")
    private String sqlFindLimpieza;

    @Value("#{primaryQuery['TareaRepositoryCustom.findLimpieza']} #{primaryQuery['TareaRepositoryCustom.findLimpieza.byIdTarea']}")
    private String sqlFindLimpiezaByIdTarea;


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
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ESTADO_SIN_ERRORES,
                EstadoTareaEnum.FINALIZADO_SIN_ERRORES.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ESTADO_CON_ERRORES,
                EstadoTareaEnum.FINALIZADO_CON_ERRORES.getId());
        namedParameterJdbcTemplate.update(sqlUpdateEstadoFinal, params);
    }

    @Override
    public List<IdTareaDto> findLimpieza() {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO,
                Arrays.asList(EstadoTareaEnum.PENDIENTE.getId(), EstadoTareaEnum.EN_CURSO.getId()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA, DateUtils.addDays(TimeUtils.nowDate(), daysNumber));
        return namedParameterJdbcTemplate.query(sqlFindLimpieza, parameters, new RowMapper<IdTareaDto>() {
            public IdTareaDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                IdTareaDto dto = new IdTareaDto();
                dto.setId(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA));
                return dto;
            }
        });
    }

    @Override
    public List<IdTareaDto> findLimpiezaByIdTarea(@NotNull final Long idTarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO,
                Arrays.asList(EstadoTareaEnum.PENDIENTE.getId(), EstadoTareaEnum.EN_CURSO.getId()));
        return namedParameterJdbcTemplate.query(sqlFindLimpiezaByIdTarea, parameters, new RowMapper<IdTareaDto>() {
            public IdTareaDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                IdTareaDto dto = new IdTareaDto();
                dto.setId(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA));
                return dto;
            }
        });
    }

}
