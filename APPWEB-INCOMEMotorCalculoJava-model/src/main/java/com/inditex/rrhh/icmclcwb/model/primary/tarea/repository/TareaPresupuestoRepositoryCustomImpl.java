package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPresupuesto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TareaPresupuestoRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaPresupuesto>
    implements TareaPresupuestoRepositoryCustom {

    @Value("#{primaryQuery['TareaPresupuestoRepositoryCustom.save']}")
    private String sqlSave;

    @Value("${app.envars.repository.batch-size.tarea-persona-historico:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Override
    public List<TareaPresupuesto> save(List<TareaPresupuesto> src) {
        //TODO [JAVIEREV] Activar guardado cuando tengamos la tabla 100% definida
//        return saveJdbcBatchList(src, sqlSave, batchSize);
        return src;
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaPresupuesto src) throws SQLException {
        pstmt.setLong(1, src.getTarea().getId());
        pstmt.setString(2, src.getCclIdOrigen());
        pstmt.setString(3, src.getStdIdLegEnt());
        pstmt.setString(4, src.getCclIdCodOrigen());
        pstmt.setString(5, src.getStdIdWorkLocat());
        pstmt.setString(6, src.getCclIdSeccion());
        pstmt.setObject(7, src.getFechaInicio());
        pstmt.setObject(8, src.getFechaFin());
        pstmt.setDouble(9, src.getImporteSinImpuestos());
        pstmt.setDouble(10, src.getImporteConImpuestos());
        pstmt.setInt(11, src.getBanda());
        pstmt.setInt(12, src.getOrdinal());
        pstmt.setBoolean(13, src.getExcepcion());
        pstmt.setString(14, src.getIdTpPresupuesto());
        pstmt.setBoolean(15, src.getActivo());
    }
}
