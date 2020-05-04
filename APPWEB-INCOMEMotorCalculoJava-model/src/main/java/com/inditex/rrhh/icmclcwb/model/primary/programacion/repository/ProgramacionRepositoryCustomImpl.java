package com.inditex.rrhh.icmclcwb.model.primary.programacion.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

@Repository
public class ProgramacionRepositoryCustomImpl implements ProgramacionRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{primaryQuery['ProgramacionRepositoryCustom.reset']}")
    private String sqlCustomReset;

    @Value("#{primaryQuery['ProgramacionRepositoryCustom.activa']}")
    private String sqlCheckActiva;

    @Value("#{primaryQuery['ProgramacionRepositoryCustom.activaById']}")
    private String sqlCheckActivaById;

    @Override
    public void reset() {
        MapSqlParameterSource arg = new MapSqlParameterSource();
        arg.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_SIGUIENTE_EJECUCION, TimeUtils
            .toDate(TimeUtils.toInstant(LocalDateTime.of(LocalDate.of(1800, Month.JANUARY, 1), LocalTime.MIN))));
        arg.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        namedParameterJdbcTemplate.update(sqlCustomReset, arg);
    }

    @Override
    public void activa() {
        MapSqlParameterSource arg = new MapSqlParameterSource();
        arg.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        namedParameterJdbcTemplate.update(sqlCheckActiva, arg);
    }

    @Override
    public void activa(@Positive @NotNull final Long id) {
        MapSqlParameterSource arg = new MapSqlParameterSource();
        arg.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_PROGRAMACION, id);
        namedParameterJdbcTemplate.update(sqlCheckActivaById, arg);
    }

    @Override
    public void desactiva() {
        MapSqlParameterSource arg = new MapSqlParameterSource();
        arg.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        namedParameterJdbcTemplate.update(sqlCheckActiva, arg);
    }

    @Override
    public void desactiva(@Positive @NotNull final Long id) {
        MapSqlParameterSource arg = new MapSqlParameterSource();
        arg.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        arg.addValue(SqlPrimaryConstants.SQL_PARAM_ID_PROGRAMACION, id);
        namedParameterJdbcTemplate.update(sqlCheckActivaById, arg);
    }

}
