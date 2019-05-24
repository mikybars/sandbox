package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaSeccionVenta;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TareaTiendaSeccionVentaRepositoryCustomImpl extends
    JdbcBatchPrimaryRepositoryAbstract<TareaTiendaSeccionVenta> implements TareaTiendaSeccionVentaRepositoryCustom{

    @Value("${app.envars.repository.batch-size.tarea-tienda-seccion-venta:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaTiendaSeccionVentaRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaTiendaSeccionVenta> save(List<TareaTiendaSeccionVenta> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaTiendaSeccionVenta entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdTienda());
        pstmt.setString(3, entity.getIdSeccion());
        pstmt.setDouble(4, entity.getImporte());
        pstmt.setDouble(5, entity.getImporteConImpuestos());
        pstmt.setDouble(6, entity.getTipoDato().getId());
        pstmt.setLong(7, entity.getTarea().getId());
    }

}
