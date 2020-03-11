package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuestoVenta;


@Repository
public class TareaLocalizacionPresupuestoVentaRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionPresupuestoVenta>
        implements TareaLocalizacionPresupuestoVentaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-localizacion-presupuesto-venta:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaLocalizacionPresupuestoVentaRepositoryCustom.save']}")
    private String sqlSave;
    
    @Override
    public List<TareaLocalizacionPresupuestoVenta> save(List<TareaLocalizacionPresupuestoVenta> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }
    
    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionPresupuestoVenta entity) throws SQLException {
        pstmt.setLong(1, entity.getTarea().getId());
        pstmt.setString(2, entity.getStdIdWorkLocat());
        pstmt.setString(3, entity.getCclIdCodOrigen());
        pstmt.setString(4, entity.getCclIdSeccion());
        pstmt.setInt(5, entity.getOrdinal());
        pstmt.setDouble(6, entity.getImporteSinImpuestos());
        pstmt.setDouble(7, entity.getImporteConImpuestos());
        pstmt.setLong(8, entity.getTipoPresupuesto().getId());
        pstmt.setString(9, entity.getIcmIdConceptoVenta());
        pstmt.setString(10, entity.getCclIdOrigen());
        pstmt.setBoolean(11, entity.getActivo());

    }

}
