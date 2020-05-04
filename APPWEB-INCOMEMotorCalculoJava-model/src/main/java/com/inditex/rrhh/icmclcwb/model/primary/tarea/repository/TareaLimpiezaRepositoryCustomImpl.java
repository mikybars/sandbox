package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.aqsw.framework.service.aaa.classic.serviciossso.UserSSO;
import com.inditex.aqsw.framework.service.aaa.classic.util.SsoUtils;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

@Repository
public class TareaLimpiezaRepositoryCustomImpl implements TareaLimpiezaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{primaryQuery['TareaLimpiezaRepositoryCustom.mergeLimpieza']}")
    private String sqlMergeLimpieza;

    @Override
    public void mergeLimpieza(@NotNull TareaDto tareaDto, @NotNull TrabajoDto trabajoDto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        params.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        params.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_HORA_LIMPIEZA, TimeUtils.nowDate());

        UserSSO userSSO = SsoUtils.getUserSSO();
        if (userSSO != null && StringUtils.isNotBlank(userSSO.getUser())) {
            params.addValue(SqlPrimaryConstants.SQL_PARAM_NOMBRE_USUARIO, userSSO.getUser());
        } else {
            params.addValue(SqlPrimaryConstants.SQL_PARAM_NOMBRE_USUARIO, trabajoDto.getNombreUsuario());
        }

        namedParameterJdbcTemplate.update(sqlMergeLimpieza, params);
    }

}
