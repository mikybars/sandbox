package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaOperacionLocalizacionVenta;

@Repository
public class TareaOperacionLocalizacionVentaRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaOperacionLocalizacionVenta>
        implements TareaOperacionLocalizacionVentaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-operacion-localizacion-venta:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Value("#{primaryQuery['TareaOperacionLocalizacionVentaRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaOperacionLocalizacionVenta> save(List<TareaOperacionLocalizacionVenta> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaOperacionLocalizacionVenta entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdLocalizacion());
        pstmt.setString(3, entity.getIdOperacion());
        pstmt.setDouble(4, entity.getImporte());
        pstmt.setDouble(5, entity.getTipoImporteVenta().getId());
        pstmt.setLong(6, entity.getTarea().getId());
    }

}
