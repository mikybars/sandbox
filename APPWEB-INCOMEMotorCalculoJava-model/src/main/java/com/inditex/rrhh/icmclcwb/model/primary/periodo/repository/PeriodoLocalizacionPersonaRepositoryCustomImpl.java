package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.entity.PeriodoLocalizacionPersona;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;

@Repository
public class PeriodoLocalizacionPersonaRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<PeriodoLocalizacionPersona>
        implements PeriodoLocalizacionPersonaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{primaryQuery['PeriodoLocalizacionPersonaRepositoryCustom.mergePeriodoLocalizacionPersona']}")
    private String sqlMergePeriodoLocalizacionPersona;

    @Override
    public void mergePeriodoLocalizacionPersona(@NotNull RunTareaDto tareaDto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getTarea().getId());
        namedParameterJdbcTemplate.update(sqlMergePeriodoLocalizacionPersona, params);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, PeriodoLocalizacionPersona entity) throws SQLException {
        pstmt.setLong(1, entity.getPk().getIcmIdPeriodo());
        pstmt.setString(2, entity.getPk().getCclIdOrigen());
        pstmt.setString(3, entity.getPk().getStdIdLegEnt());
        pstmt.setString(4, entity.getPk().getStdIdWorkLocat());
        pstmt.setString(5, entity.getPk().getCclIdPerson());
    }

}
