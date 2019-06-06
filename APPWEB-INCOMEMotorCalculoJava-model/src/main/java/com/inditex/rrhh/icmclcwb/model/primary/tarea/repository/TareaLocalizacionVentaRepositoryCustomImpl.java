package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TareaLocalizacionVentaRepositoryCustomImpl extends
    JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionVenta> implements TareaLocalizacionVentaRepositoryCustom{

    @Value("${app.envars.repository.batch-size.tarea-localizacion-venta:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaLocalizacionVenta> save(List<TareaLocalizacionVenta> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }
    
    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionVenta entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdCadena());
        pstmt.setString(3, entity.getIdLocalizacion());
        pstmt.setString(4, entity.getIdSeccion());
        pstmt.setDouble(5, entity.getImporte());
        pstmt.setDouble(6, entity.getImporteConImpuestos());
        pstmt.setDouble(7, entity.getTipoDato().getId());
        pstmt.setObject(8, entity.getActivo());
        pstmt.setLong(9, entity.getTarea().getId());
    }

}
