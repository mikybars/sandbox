package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaVentaSeccion;

@Repository
public class TareaTiendaVentaSeccionRepositoryCustomImpl extends
        JdbcBatchPrimaryRepositoryAbstract<TareaTiendaVentaSeccion> implements TareaTiendaVentaSeccionRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-tienda-venta-seccion:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaTiendaVentaSeccionRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaTiendaVentaSeccion> save(List<TareaTiendaVentaSeccion> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaTiendaVentaSeccion entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdTienda());
        pstmt.setDouble(3, entity.getImporte1() != null ? entity.getImporte1() : 0);
        pstmt.setDouble(4, entity.getImporte2() != null ? entity.getImporte2() : 0);
        pstmt.setDouble(5, entity.getImporte3() != null ? entity.getImporte3() : 0);
        pstmt.setDouble(6, entity.getImporteConImpuestos1() != null ? entity.getImporteConImpuestos1() : 0);
        pstmt.setDouble(7, entity.getImporteConImpuestos2() != null ? entity.getImporteConImpuestos2() : 0);
        pstmt.setDouble(8, entity.getImporteConImpuestos3() != null ? entity.getImporteConImpuestos3() : 0);
        pstmt.setDouble(9, entity.getTipoImporteVenta().getId());
        pstmt.setLong(10, entity.getTarea().getId());
    }

}
