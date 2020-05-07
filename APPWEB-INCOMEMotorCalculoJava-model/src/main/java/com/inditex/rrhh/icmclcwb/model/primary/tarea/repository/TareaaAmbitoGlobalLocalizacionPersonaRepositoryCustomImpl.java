package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

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
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersona;

@Repository
public class TareaaAmbitoGlobalLocalizacionPersonaRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaAmbitoGlobalLocalizacionPersona>
        implements TareaAmbitoGlobalLocalizacionPersonaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{primaryQuery['TareaAmbitoGlobalLocalizacionPersonaRepositoryCustom.mergePersonaLocalizacion']}")
    private String sqlMergePersonaLocalizacion;

    @Override
    public void mergePersonaLocalizacion(@NotNull final RunTareaDto tareaDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getTarea().getId());
        namedParameterJdbcTemplate.update(sqlMergePersonaLocalizacion, parameters);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaAmbitoGlobalLocalizacionPersona entity)
            throws SQLException {
        pstmt.setString(1, entity.getStdIdWorkLocat());
        pstmt.setString(2, entity.getCclIdOrigen());
        pstmt.setString(3, entity.getCclIdPerson());
        pstmt.setString(4, entity.getStdIdLegEnt());
        pstmt.setLong(5, entity.getTarea().getId());
    }

}
