package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionConfiguracion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TareaAgrupacionConfiguracionRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaAgrupacionConfiguracion>
    implements TareaAgrupacionConfiguracionRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-configuracion-venta-online:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaAgrupacionConfiguracionRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaAgrupacionConfiguracion> save(List<TareaAgrupacionConfiguracion> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaAgrupacionConfiguracion entity) throws SQLException {
        pstmt.setLong(1, entity.getTarea().getId());
        pstmt.setString(2, entity.getIdOrigen());
        pstmt.setLong(3, entity.getIdAgrupacion());
        pstmt.setObject(4, entity.getFechaInicio());
        pstmt.setObject(5, entity.getFechaFin());
        pstmt.setBigDecimal(6, entity.getPorcentajeInclusion());
        pstmt.setLong(7, entity.getTipoVentaConcepto().getId());
    }
}
