package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.EstadoPeriodoCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.entity.PeriodoCalculoPersona;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;

@Repository
public class PeriodoCalculoPersonaRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<PeriodoCalculoPersona>
        implements PeriodoCalculoPersonaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{primaryQuery['PeriodoCalculoPersonaRepositoryCustom.mergePeriodoCalculoPersona']}")
    private String sqlMergePeriodoCalculoPersona;

    @Override
    public void mergePeriodoCalculoPersona(@NotNull RunTareaDto tareaDto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getTarea().getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_PERIODO_PERSONA,
                EstadoPeriodoCalculoPersonaEnum.CALCULADO.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_PERIODO_PERSONA_CALCULADO_ERROR,
                EstadoPeriodoCalculoPersonaEnum.CALCULADO_ERROR.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_PERIODO_PERSONA_NO_CALCULADO,
                Arrays.asList(EstadoPeriodoCalculoPersonaEnum.SIN_CALCULAR.getId(), 
                    EstadoPeriodoCalculoPersonaEnum.CALCULADO_ERROR.getId(), EstadoPeriodoCalculoPersonaEnum.CONFIRMADO.getId(),
                    EstadoPeriodoCalculoPersonaEnum.EXPORTADO.getId(), EstadoPeriodoCalculoPersonaEnum.PAGADO.getId(),
                    EstadoPeriodoCalculoPersonaEnum.RECUPERADO.getId()));
        params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA, TimeUtils.nowDate());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_BLOQUEADO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        params.addValue(SqlPrimaryConstants.SQL_PARAM_DESBLOQUEADO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        namedParameterJdbcTemplate.update(sqlMergePeriodoCalculoPersona, params);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, PeriodoCalculoPersona entity) throws SQLException {
        pstmt.setLong(1, entity.getPk().getIcmIdPeriodo());
        pstmt.setString(2, entity.getPk().getCclIdOrigen());
        pstmt.setString(3, entity.getPk().getStdIdLegEnt());
        pstmt.setString(4, entity.getPk().getCclIdPerson());
        pstmt.setString(5, entity.getPk().getStdOrHrPeriod());
        pstmt.setLong(6, entity.getTareaActual().getId());
        pstmt.setLong(7, entity.getTareaUltima().getId());
        pstmt.setLong(8, entity.getEstado().getId());
        pstmt.setObject(9, entity.getFechaHoraCreacion());
        pstmt.setObject(10, entity.getFechaHoraActualizacion());
    }

}
