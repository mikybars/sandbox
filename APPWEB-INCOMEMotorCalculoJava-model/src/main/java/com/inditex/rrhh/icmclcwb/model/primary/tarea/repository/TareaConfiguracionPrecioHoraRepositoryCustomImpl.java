package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracionPrecioHora;

@Repository
public class TareaConfiguracionPrecioHoraRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaConfiguracionPrecioHora>
        implements TareaConfiguracionPrecioHoraRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-configuracion-precio-hora:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Value("#{primaryQuery['TareaConfiguracionPrecioHoraRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaConfiguracionPrecioHora> save(List<TareaConfiguracionPrecioHora> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }
    @Override
    public void setParameters(PreparedStatement pstmt, TareaConfiguracionPrecioHora entity) throws SQLException {
        pstmt.setLong(1, entity.getTarea().getId());
        pstmt.setBoolean(2, entity.getIcmCkTpHoraComis());
        pstmt.setBoolean(3, entity.getIcmCkTpHoraIncPtpo());
        pstmt.setObject(4, entity.getFechaInicio());
        pstmt.setObject(5, entity.getFechaFin());
        pstmt.setString(6, entity.getCclIdOrigen());        
    }

}
