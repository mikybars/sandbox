package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;

@Repository
public class TareaLocalizacionVentaRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionVenta> implements TareaLocalizacionVentaRepositoryCustom {
 
    @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.save']}")
    private String sqlSave;
    
    @Value("${app.envars.repository.batch-size.tarea-tienda-venta:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Override
    public List<TareaLocalizacionVenta> save(List<TareaLocalizacionVenta> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionVenta entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdCadena());
        pstmt.setString(3, entity.getIdLocalizacion());
        pstmt.setDouble(4, entity.getImporte());
        pstmt.setDouble(5, entity.getImporteConImpuestos());
        pstmt.setDouble(6, entity.getTipoDato().getId());
        pstmt.setLong(7, entity.getTarea().getId());
    }

}
