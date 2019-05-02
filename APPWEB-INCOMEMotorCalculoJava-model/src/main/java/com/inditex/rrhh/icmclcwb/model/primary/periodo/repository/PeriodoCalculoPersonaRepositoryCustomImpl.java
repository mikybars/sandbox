package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.periodo.entity.PeriodoCalculoPersona;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;

@Repository
public class PeriodoCalculoPersonaRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<PeriodoCalculoPersona>
        implements PeriodoCalculoPersonaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.periodo-calculo-persona:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Value("#{primaryQuery['PeriodoCalculoPersonaRepositoryCustom.save']}")
    private String sqlSave;
    
    @Override
    public List<PeriodoCalculoPersona> save(List<PeriodoCalculoPersona> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }
    
    @Override
    public void setParameters(PreparedStatement pstmt, PeriodoCalculoPersona entity) throws SQLException {
        pstmt.setString(1, entity.getPk().getIdPeriodo());
        pstmt.setString(2, entity.getPk().getIdOrigen());
        pstmt.setString(3, entity.getPk().getIdEmpresa());
        pstmt.setString(4, entity.getPk().getIdPersona());
        pstmt.setString(5, entity.getPk().getOrPersona());
        pstmt.setLong(6, entity.getTareaActual().getId());
        pstmt.setLong(7, entity.getTareaUltima().getId());
        pstmt.setString(8, entity.getIdEstado());
        pstmt.setObject(9, entity.getFechaCreacion());
        pstmt.setObject(10, entity.getFechaActualizacion());

    }

}
