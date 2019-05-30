package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVentaSeccion;

@Repository
public class TareaLocalizacionVentaSeccionRepositoryCustomImpl extends
        JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionVentaSeccion> implements TareaLocalizacionVentaSeccionRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-localizacion-venta-seccion:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaLocalizacionVentaSeccionRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaLocalizacionVentaSeccion> save(List<TareaLocalizacionVentaSeccion> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionVentaSeccion entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdLocalizacion());
        pstmt.setDouble(3, entity.getImporte1() != null ? entity.getImporte1() : 0);
        pstmt.setDouble(4, entity.getImporte2() != null ? entity.getImporte2() : 0);
        pstmt.setDouble(5, entity.getImporte3() != null ? entity.getImporte3() : 0);
        pstmt.setDouble(6, entity.getImporteConImpuestos1() != null ? entity.getImporteConImpuestos1() : 0);
        pstmt.setDouble(7, entity.getImporteConImpuestos2() != null ? entity.getImporteConImpuestos2() : 0);
        pstmt.setDouble(8, entity.getImporteConImpuestos3() != null ? entity.getImporteConImpuestos3() : 0);
        pstmt.setDouble(9, entity.getTipoDato().getId());
        pstmt.setLong(10, entity.getTarea().getId());
    }

}
