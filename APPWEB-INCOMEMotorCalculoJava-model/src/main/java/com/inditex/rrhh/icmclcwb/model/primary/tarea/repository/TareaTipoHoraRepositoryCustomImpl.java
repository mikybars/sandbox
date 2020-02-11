package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTipoHora;

@Repository
public class TareaTipoHoraRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaTipoHora>
        implements TareaTipoHoraRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-tipo-hora:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaTipoHoraRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaTipoHora> save(List<TareaTipoHora> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaTipoHora entity) throws SQLException {
        pstmt.setObject(1, entity.getExcluidoCalculo());
        pstmt.setObject(2, entity.getExcluidoDenominador());
        pstmt.setObject(3, entity.getIncluidoVenta());
        pstmt.setObject(4, entity.getIncluidoChallenge());
        pstmt.setObject(5, entity.getIncluidoEcommerce());
        pstmt.setInt(6, entity.getIdTipoHora());
        pstmt.setLong(7, entity.getTarea().getId());
    }

}
