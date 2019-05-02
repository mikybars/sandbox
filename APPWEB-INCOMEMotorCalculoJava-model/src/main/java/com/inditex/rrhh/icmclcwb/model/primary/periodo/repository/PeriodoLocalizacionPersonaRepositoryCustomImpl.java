package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.periodo.entity.PeriodoLocalizacionPersona;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;

@Repository
public class PeriodoLocalizacionPersonaRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<PeriodoLocalizacionPersona>
        implements PeriodoLocalizacionPersonaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.periodo-localizacion-persona:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Value("#{primaryQuery['PeriodoLocalizacionPersonaRepositoryCustom.save']}")
    private String sqlSave;
    
    @Override
    public List<PeriodoLocalizacionPersona> save(List<PeriodoLocalizacionPersona> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }
    
    @Override
    public void setParameters(PreparedStatement pstmt, PeriodoLocalizacionPersona entity) throws SQLException {
        pstmt.setString(1, entity.getPk().getIdPeriodo());
        pstmt.setString(2, entity.getPk().getIdOrigen());
        pstmt.setString(3, entity.getPk().getIdEmpresa());
        pstmt.setString(4, entity.getPk().getIdLocalizacion());
        pstmt.setString(5, entity.getPk().getIdPersona());
    }

}
