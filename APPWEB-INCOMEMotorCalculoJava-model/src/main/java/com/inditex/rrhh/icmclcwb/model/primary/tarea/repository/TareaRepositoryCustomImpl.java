package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoLimpiezaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEnum;
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

    @Value("${app.envars.limpieza.days-number-creation:-3}")
    private int daysNumberFechaCreacion;

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
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA, TimeUtils.nowDate());
        this.namedParameterJdbcTemplate.update(this.sqlUpdateFechaFin, params);
    }

    @Override
    public void updateFechaInicioAndEstado(@NotNull final TareaDto tarea, @NotNull final EstadoTareaDto estado) {
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO, estado.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA, TimeUtils.nowDate());
        this.namedParameterJdbcTemplate.update(this.sqlUpdateFechaInicioAndEstado, params);
    }

    @Override
    public void updateEstado(@NotNull final TareaDto tarea, @NotNull final EstadoTareaDto estado) {
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO, estado.getId());
        this.namedParameterJdbcTemplate.update(this.sqlUpdateEstado, params);
    }

    @Override
    public void updateEstadoFinal(@NotNull final TareaDto tarea) {
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO, EstadoTareaEnum.EN_CURSO.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ESTADO_SIN_ERRORES,
                EstadoTareaEnum.FINALIZADO_SIN_ERRORES.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ESTADO_CON_ERRORES,
                EstadoTareaEnum.FINALIZADO_CON_ERRORES.getId());
        this.namedParameterJdbcTemplate.update(this.sqlUpdateEstadoFinal, params);
    }

    @Override
    public List<IdTareaDto> findLimpieza() {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO,
                Arrays.asList(EstadoTareaEnum.PENDIENTE.getId(), EstadoTareaEnum.EN_CURSO.getId()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA,
                DateUtils.addDays(TimeUtils.nowDate(), this.daysNumber));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_HORA_CREACION,
                DateUtils.addDays(TimeUtils.nowDate(), this.daysNumberFechaCreacion));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_LIMPIEZA,
                Arrays.asList(EstadoLimpiezaEnum.PENDIENTE.getId(), EstadoLimpiezaEnum.KO.getId()));
        return this.namedParameterJdbcTemplate.query(this.sqlFindLimpieza, parameters, new RowMapper<IdTareaDto>() {
            @Override
            public IdTareaDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
                final IdTareaDto dto = new IdTareaDto();
                dto.setId(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA));
                return dto;
            }
        });
    }

    @Override
    public List<IdTareaDto> findLimpiezaByIdTarea(@NotNull final Long idTarea) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA,
                DateUtils.addDays(TimeUtils.nowDate(), this.daysNumber));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_HORA_CREACION,
                DateUtils.addDays(TimeUtils.nowDate(), this.daysNumberFechaCreacion));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO,
                Arrays.asList(EstadoTareaEnum.PENDIENTE.getId(), EstadoTareaEnum.EN_CURSO.getId()));
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_LIMPIEZA,
                Arrays.asList(EstadoLimpiezaEnum.OK.getId()));
        return this.namedParameterJdbcTemplate.query(this.sqlFindLimpiezaByIdTarea, parameters, (rs, rowNum) -> {
            final IdTareaDto dto = new IdTareaDto();
            dto.setId(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA));
            return dto;
        });
    }

}
