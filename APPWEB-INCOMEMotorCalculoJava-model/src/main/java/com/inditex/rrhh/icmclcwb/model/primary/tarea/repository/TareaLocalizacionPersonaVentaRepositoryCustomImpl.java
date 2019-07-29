package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaVenta;

@Repository
public class TareaLocalizacionPersonaVentaRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionPersonaVenta>
        implements TareaLocalizacionPersonaVentaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-localizacion-persona-venta:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaLocalizacionPersonaVentaRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaLocalizacionPersonaVenta> save(List<TareaLocalizacionPersonaVenta> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionPersonaVenta entity) throws SQLException {
        pstmt.setObject(1, entity.getPk().getFecha());
        pstmt.setString(2, entity.getIdLocalizacion());
        pstmt.setString(3, entity.getIdPersona());
        pstmt.setDouble(4, entity.getImporteSinImpuestos());
        pstmt.setDouble(5, entity.getImporteConImpuestos());
        pstmt.setDouble(6, entity.getTipoDato().getId());
        pstmt.setLong(7, entity.getTarea().getId());
    }

}
