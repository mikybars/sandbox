package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPeriodo;

@Repository
public class TareaPeriodoRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaPeriodo>
        implements TareaPeriodoRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-periodo:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaPeriodoRepositoryCustom.save']}")
    private String sqlSave;
    
    @Override
    public List<TareaPeriodo> save(final List<TareaPeriodo> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }
    
    @Override
    public void setParameters(PreparedStatement pstmt, TareaPeriodo entity) throws SQLException {
        pstmt.setString(1, entity.getIdOrigen());
        pstmt.setString(2, entity.getIdPeriodo());
        pstmt.setObject(3, entity.getActivo());
        pstmt.setObject(4, entity.getAbierto());
        pstmt.setObject(5, entity.getBorrado());
        pstmt.setObject(6, entity.getModificado());
        pstmt.setObject(7, entity.getNuevo());
        pstmt.setObject(8, entity.getFechaInicio());
        pstmt.setObject(9, entity.getFechaFin());
        pstmt.setLong(10, entity.getTarea().getId());
    }

}
