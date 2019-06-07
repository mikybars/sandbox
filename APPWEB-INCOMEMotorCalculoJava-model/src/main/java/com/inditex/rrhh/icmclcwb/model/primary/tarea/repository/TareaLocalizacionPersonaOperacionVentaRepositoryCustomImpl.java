package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaOperacionVenta;

@Repository
public class TareaLocalizacionPersonaOperacionVentaRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionPersonaOperacionVenta>
        implements TareaLocalizacionPersonaOperacionVentaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-localizacion-persona-operacion-venta:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Value("#{primaryQuery['TareaLocalizacionPersonaOperacionVentaRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaLocalizacionPersonaOperacionVenta> save(List<TareaLocalizacionPersonaOperacionVenta> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionPersonaOperacionVenta entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdLocalizacion());
        pstmt.setString(3, entity.getIdSeccion());
        pstmt.setString(4, entity.getIdOperacion());
        pstmt.setString(5, entity.getIdPersona());
        pstmt.setDouble(6, entity.getImporte());
        pstmt.setDouble(7, entity.getImporteConImpuestos());
        pstmt.setDouble(8, entity.getTipoDato().getId());
        pstmt.setLong(9, entity.getTarea().getId());
    }

}
