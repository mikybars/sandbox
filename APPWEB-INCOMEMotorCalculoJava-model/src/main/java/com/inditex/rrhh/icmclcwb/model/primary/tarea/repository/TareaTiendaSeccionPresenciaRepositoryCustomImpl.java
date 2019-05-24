package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaSeccionPresencia;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TareaTiendaSeccionPresenciaRepositoryCustomImpl extends
    JdbcBatchPrimaryRepositoryAbstract<TareaTiendaSeccionPresencia> implements TareaTiendaSeccionPresenciaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-tienda-seccion-presencia:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaTiendaSeccionPresenciaRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaTiendaSeccionPresencia> save(List<TareaTiendaSeccionPresencia> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaTiendaSeccionPresencia entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdTienda());
        pstmt.setString(3, entity.getIdSeccion());
        pstmt.setDouble(4, entity.getMinutos());
        pstmt.setDouble(5, entity.getTipoDato().getId());
        pstmt.setBoolean(6, entity.getActivo());
        pstmt.setLong(7, entity.getTarea().getId());
    }
}
