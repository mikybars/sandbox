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
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getCclIdCodOrigen());
        pstmt.setString(3, entity.getCclIdPerson());
        pstmt.setBigDecimal(4, entity.getImporteSinImpuestos());
        pstmt.setBigDecimal(5, entity.getImporteConImpuestos());
        pstmt.setDouble(6, entity.getTipoDato().getId());
        pstmt.setLong(7, entity.getTarea().getId());
        pstmt.setObject(8, entity.getPk().getFechaInicioPeriodo());
        pstmt.setString(9, entity.getCclIdSeccion());
        pstmt.setString(10, entity.getCclIdCadena());
        pstmt.setBoolean(11, entity.getActivo());
    }

}
