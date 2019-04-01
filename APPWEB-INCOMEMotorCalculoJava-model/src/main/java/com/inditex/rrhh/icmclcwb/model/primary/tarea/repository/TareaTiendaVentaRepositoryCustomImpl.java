package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaVenta;

@Repository
public class TareaTiendaVentaRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaTiendaVenta> implements TareaTiendaVentaRepositoryCustom {
 
    @Value("#{primaryQuery['TareaTiendaVentaRepositoryCustom.save']}")
    private String sqlSave;
    
    @Value("${app.envars.repository.batch-size.tarea-tienda-venta:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Override
    public List<TareaTiendaVenta> save(List<TareaTiendaVenta> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaTiendaVenta entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdTienda());
        pstmt.setDouble(3, entity.getImporte());
        pstmt.setDouble(4, entity.getTipoImporteVenta().getId());
        pstmt.setLong(5, entity.getTarea().getId());
    }

}
