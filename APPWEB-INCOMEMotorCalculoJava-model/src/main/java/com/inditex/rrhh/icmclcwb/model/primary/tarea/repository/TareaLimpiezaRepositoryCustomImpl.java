package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaLimpiezaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import org.apache.commons.lang3.StringUtils;

import com.inditex.aqsw.framework.service.aaa.userdetails.sso.model.UserSSO;
import com.inditex.aqsw.framework.service.aaa.userdetails.sso.util.SsoUtils;

@Repository
public class TareaLimpiezaRepositoryCustomImpl implements TareaLimpiezaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{primaryQuery['TareaLimpiezaRepositoryCustom.mergeLimpieza']}")
    private String sqlMergeLimpieza;

    @Value("#{primaryQuery['TareaLimpiezaRepositoryCustom.updateFechaEjecucion']}")
    private String sqlUpdateFechaEjecucion;

    @Value("#{primaryQuery['TareaLimpiezaRepositoryCustom.updateEstado']}")
    private String sqlUpdateEstado;

    @Override
    public void mergeLimpieza(@NotNull final TareaDto tareaDto, @NotNull final TrabajoDto trabajoDto) {
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        params.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        params.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_HORA_LIMPIEZA, TimeUtils.nowDate());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_LIMPIEZA, EstadoTareaLimpiezaEnum.OK.getId());

        final UserSSO userSSO = SsoUtils.getUserSSO();
        if ((userSSO != null) && StringUtils.isNotBlank(userSSO.getUser())) {
            params.addValue(SqlPrimaryConstants.SQL_PARAM_NOMBRE_USUARIO, userSSO.getUser());
        } else {
            params.addValue(SqlPrimaryConstants.SQL_PARAM_NOMBRE_USUARIO, trabajoDto.getNombreUsuario());
        }

        this.namedParameterJdbcTemplate.update(this.sqlMergeLimpieza, params);
    }

    @Override
    public void save(
            @NotNull @Valid final TareaLimpiezaDto limpiezaDto) {
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, limpiezaDto.getIdTarea());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        params.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_LIMPIEZA, limpiezaDto.getEstado().getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_NOMBRE_USUARIO, limpiezaDto.getNombreUsuario());
        this.namedParameterJdbcTemplate.update(this.sqlMergeLimpieza, params);
    }

    @Override
    public void updateFechaEjecucion(
            @NotNull @Positive final Long idTareaLimpieza) {
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_HORA_LIMPIEZA, TimeUtils.nowDate());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_LIMPIEZA, idTareaLimpieza);
        this.namedParameterJdbcTemplate.update(this.sqlUpdateFechaEjecucion, params);
    }

    @Override
    public void updateEstado(
            @NotNull @Positive final Long idTareaLimpieza,
            @NotNull @Valid final EstadoTareaLimpiezaDto estado) {
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_LIMPIEZA, estado.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_LIMPIEZA, idTareaLimpieza);
        this.namedParameterJdbcTemplate.update(this.sqlUpdateEstado, params);
    }

}
