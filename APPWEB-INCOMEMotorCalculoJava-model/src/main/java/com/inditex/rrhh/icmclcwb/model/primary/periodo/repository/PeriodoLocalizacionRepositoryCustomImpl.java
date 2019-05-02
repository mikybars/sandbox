package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.periodo.entity.PeriodoLocalizacion;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;

@Repository
public class PeriodoLocalizacionRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<PeriodoLocalizacion>
        implements PeriodoLocalizacionRepositoryCustom {

    @Value("${app.envars.repository.batch-size.periodo-localizacion:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Value("#{primaryQuery['PeriodoLocalizacionRepositoryCustom.save']}")
    private String sqlSave;
    
    @Override
    public List<PeriodoLocalizacion> save(List<PeriodoLocalizacion> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }
    
    @Override
    public void setParameters(PreparedStatement pstmt, PeriodoLocalizacion entity) throws SQLException {
        pstmt.setString(1, entity.getPk().getIdPeriodo());
        pstmt.setString(2, entity.getPk().getIdOrigen());
        pstmt.setString(3, entity.getPk().getIdEmpresa());
        pstmt.setString(4, entity.getPk().getIdLocalizacion());
    }

}
