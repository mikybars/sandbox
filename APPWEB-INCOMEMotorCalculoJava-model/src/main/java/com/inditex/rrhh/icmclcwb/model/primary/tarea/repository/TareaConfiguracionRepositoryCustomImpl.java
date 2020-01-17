package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TareaConfiguracionRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaConfiguracion>
    implements TareaConfiguracionRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-configuracion-venta-online:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaConfiguracionRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaConfiguracion> save(List<TareaConfiguracion> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaConfiguracion entity) throws SQLException {
        pstmt.setLong(1, entity.getTarea().getId());
        pstmt.setString(2, entity.getCclIdOrigen());
        pstmt.setInt(3, entity.getIcmIdConfig());
        pstmt.setObject(4, entity.getFechaInicio());
        pstmt.setObject(5, entity.getFechaFin());
        pstmt.setString(6, entity.getIcmIdTpHora());
        pstmt.setBoolean(7, entity.getIcmCkVentaImpuestos());
    }
}
