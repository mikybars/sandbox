package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracion;

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
        pstmt.setObject(3, entity.getFechaInicio());
        pstmt.setObject(4, entity.getFechaFin());
        if(entity.getCodTipoHora() != null) {
            pstmt.setInt(5, entity.getCodTipoHora());    
        }else {
            pstmt.setNull(5, Types.INTEGER);
        }
        pstmt.setBoolean(6, entity.getIcmCkVentaImpuestos());
    }
}
