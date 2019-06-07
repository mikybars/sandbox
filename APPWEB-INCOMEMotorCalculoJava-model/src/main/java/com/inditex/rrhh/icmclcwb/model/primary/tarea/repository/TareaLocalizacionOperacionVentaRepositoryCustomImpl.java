package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionOperacionVenta;

@Repository
public class TareaLocalizacionOperacionVentaRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionOperacionVenta>
        implements TareaLocalizacionOperacionVentaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-localizacion-operacion-venta:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Value("#{primaryQuery['TareaLocalizacionOperacionVentaRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaLocalizacionOperacionVenta> save(List<TareaLocalizacionOperacionVenta> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionOperacionVenta entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdLocalizacion());
        pstmt.setString(3, entity.getIdSeccion());
        pstmt.setString(4, entity.getIdOperacion());
        pstmt.setDouble(5, entity.getImporte());
        pstmt.setDouble(6, entity.getImporteConImpuestos());
        pstmt.setDouble(7, entity.getTipoDato().getId());
        pstmt.setLong(8, entity.getTarea().getId());
    }

}
