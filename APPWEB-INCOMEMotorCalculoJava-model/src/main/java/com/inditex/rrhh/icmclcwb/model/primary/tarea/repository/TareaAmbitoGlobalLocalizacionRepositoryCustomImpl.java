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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacion;

@Repository
public class TareaAmbitoGlobalLocalizacionRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaAmbitoGlobalLocalizacion>
        implements TareaAmbitoGlobalLocalizacionRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{primaryQuery['TareaAmbitoGlobalLocalizacionRepositoryCustom.mergeLocalizacion']}")
    private String sqlMergeLocalizacion;

    @Override
    public void mergeLocalizacion(@NotNull RunTareaDto tareaDto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getTarea().getId());
        namedParameterJdbcTemplate.update(sqlMergeLocalizacion, params);
    }
    
    @Override
    public void setParameters(PreparedStatement pstmt, TareaAmbitoGlobalLocalizacion entity) throws SQLException {
        pstmt.setLong(1, entity.getTarea().getId());        
        pstmt.setString(2, entity.getIdOrigen());
        pstmt.setString(3, entity.getIdLocalizacion());
        pstmt.setString(4, entity.getIdEmpresa());
    }

}
