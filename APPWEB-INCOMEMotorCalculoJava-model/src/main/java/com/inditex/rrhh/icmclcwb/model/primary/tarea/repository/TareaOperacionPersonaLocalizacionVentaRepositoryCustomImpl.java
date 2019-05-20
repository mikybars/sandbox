package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaOperacionPersonaLocalizacionVenta;

@Repository
public class TareaOperacionPersonaLocalizacionVentaRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaOperacionPersonaLocalizacionVenta>
        implements TareaOperacionPersonaLocalizacionVentaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-operacion-persona-localizacion-venta:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Value("#{primaryQuery['TareaOperacionPersonaLocalizacionVentaRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaOperacionPersonaLocalizacionVenta> save(List<TareaOperacionPersonaLocalizacionVenta> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaOperacionPersonaLocalizacionVenta entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdLocalizacion());
        pstmt.setString(3, entity.getIdOperacion());
        pstmt.setString(4, entity.getIdPersona());
        pstmt.setDouble(5, entity.getImporte());
        pstmt.setDouble(6, entity.getImporteConImpuestos());
        pstmt.setDouble(7, entity.getTipoDato().getId());
        pstmt.setLong(8, entity.getTarea().getId());
    }

}
