package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaLocalizacionVenta;

@Repository
public class TareaPersonaLocalizacionVentaRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaPersonaLocalizacionVenta>
        implements TareaPersonaLocalizacionVentaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-persona-localizacion-venta:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Value("#{primaryQuery['TareaPersonaLocalizacionVentaRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaPersonaLocalizacionVenta> save(List<TareaPersonaLocalizacionVenta> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaPersonaLocalizacionVenta entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdLocalizacion());
        pstmt.setString(3, entity.getIdPersona());
        pstmt.setDouble(4, entity.getImporte());
        pstmt.setDouble(5, entity.getTipoImporteVenta().getId());
        pstmt.setLong(6, entity.getTarea().getId());
    }
    
}
