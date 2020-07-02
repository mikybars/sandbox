package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoComisionEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructura;

@Repository
public class TareaPersonaEstructuraRepositoryCustomImpl extends
        JdbcBatchPrimaryRepositoryAbstract<TareaPersonaEstructura> implements TareaPersonaEstructuraRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-persona-estructura:0}")
    private int batchSize;

    @Value("#{primaryQuery['TareaPersonaEstructuraRepositoryCustom.save']}")
    private String sqlSave;

    @Value("#{primaryQuery['TareaPersonaEstructuraRepositoryCustom.updateActivoTopes']}")
    private String sqlUpdateActivoTopes;

    @Value("#{primaryQuery['TareaPersonaEstructura.findPersonasChallenge']}")
    private String sqlFindPersonasChallenge;

    @Value("#{primaryQuery['TareaPersonaEstructuraRepositoryCustom.desactivarChallengeOpcionOrigen']}")
    private String sqlDesactivarChallengeOpcionOrigen;

    @Value("#{primaryQuery['TareaPersonaEstructuraRepositoryCustom.crearChallengeOpcionOrigen']}")
    private String sqlCrearChallengeOpcionOrigen;

    @Override
    public List<TareaPersonaEstructura> save(final List<TareaPersonaEstructura> src) {
        return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
    }

    @Override
    public void updateActivoTopes(final TareaDto tarea) {

        final MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO,
                TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ICM_ORD_TOPE, AppConstants.TOPE_DEFAULT);
        this.update(this.sqlUpdateActivoTopes, map);

    }

    @Override
    public List<IdPersonaLocalDto> findPersonasChallenge(final TareaDto tarea) {

        final MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO,
                TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
        map.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO, Arrays.asList(
                TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId(),
                TipoCalculoEnum.CHALLENGE_PRECIO_HORA_SECCION.getId(),
                TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_IMPORTE_SECCION.getId()));

        return this.query(this.sqlFindPersonasChallenge, map,
                (rs, rowNum) -> IdPersonaLocalDto
                    .builder()
                    .idPersonaLocal(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_LOCAL))
                    .stdOrHrPeriod(rs.getString(SqlPrimaryConstants.SQL_RESULT_OR_PERSONA))
                    .build());
    }

    @Override
    public void desactivarChallengeOpcionOrigen(final TareaDto tarea) {

        final MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO,
                TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        map.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        map.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO, Arrays.asList(
                TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId(),
                TipoCalculoEnum.CHALLENGE_PRECIO_HORA_SECCION.getId(),
                TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_IMPORTE_SECCION.getId()));
        map.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION, Arrays
            .asList(TipoComisionEnum.CHALLENGE_PRINCIPAL.getId(), TipoComisionEnum.CHALLENGE_SECUNDARIO.getId()));
        this.update(this.sqlDesactivarChallengeOpcionOrigen, map);

    }

    @Override
    public void crearChallengeOpcionOrigen(final TareaDto tarea) {

        final MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO,
                TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        map.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        map.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO, Arrays.asList(
                TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId(),
                TipoCalculoEnum.CHALLENGE_PRECIO_HORA_SECCION.getId(),
                TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_IMPORTE_SECCION.getId()));
        map.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION, Arrays
            .asList(TipoComisionEnum.CHALLENGE_PRINCIPAL.getId(), TipoComisionEnum.CHALLENGE_SECUNDARIO.getId()));
        this.update(this.sqlCrearChallengeOpcionOrigen, map);

    }

}
