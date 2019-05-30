package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionSeccionVenta;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TareaLocalizacionSeccionVentaRepositoryCustomImpl extends
    JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionSeccionVenta> implements TareaLocalizacionSeccionVentaRepositoryCustom{

    @Value("${app.envars.repository.batch-size.tarea-localizacion-seccion-venta:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaLocalizacionSeccionVentaRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaLocalizacionSeccionVenta> save(List<TareaLocalizacionSeccionVenta> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionSeccionVenta entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdLocalizacion());
        pstmt.setString(3, entity.getIdSeccion());
        pstmt.setDouble(4, entity.getImporte());
        pstmt.setDouble(5, entity.getImporteConImpuestos());
        pstmt.setDouble(6, entity.getTipoDato().getId());
        pstmt.setLong(7, entity.getTarea().getId());
    }

}
