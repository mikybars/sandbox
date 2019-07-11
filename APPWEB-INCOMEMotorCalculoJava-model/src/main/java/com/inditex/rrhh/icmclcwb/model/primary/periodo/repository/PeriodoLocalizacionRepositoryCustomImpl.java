package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.entity.PeriodoLocalizacion;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;

@Repository
public class PeriodoLocalizacionRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<PeriodoLocalizacion>
        implements PeriodoLocalizacionRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Value("${app.envars.repository.batch-size.periodo-localizacion:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Value("#{primaryQuery['PeriodoLocalizacionRepositoryCustom.save']}")
    private String sqlSave;
    
    @Value("#{primaryQuery['PeriodoLocalizacionRepositoryCustom.mergePeriodoLocalizacion']}")
    private String sqlMergePeriodoLocalizacion;
    
    @Override
    public List<PeriodoLocalizacion> save(List<PeriodoLocalizacion> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }
    
    @Override
    public void mergePeriodoLocalizacion(@NotNull RunTareaDto tareaDto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getTarea().getId());
        namedParameterJdbcTemplate.update(sqlMergePeriodoLocalizacion, params);
    }
    
    @Override
    public void setParameters(PreparedStatement pstmt, PeriodoLocalizacion entity) throws SQLException {
        pstmt.setLong(1, entity.getPk().getIdPeriodo());
        pstmt.setString(2, entity.getPk().getIdOrigen());
        pstmt.setString(3, entity.getPk().getIdEmpresa());
        pstmt.setString(4, entity.getPk().getIdLocalizacion());
    }

}
