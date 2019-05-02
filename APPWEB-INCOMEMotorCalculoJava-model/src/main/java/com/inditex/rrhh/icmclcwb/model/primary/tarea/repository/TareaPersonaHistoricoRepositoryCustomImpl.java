package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaHistorico;

@Repository
public class TareaPersonaHistoricoRepositoryCustomImpl 
    extends JdbcBatchPrimaryRepositoryAbstract<TareaPersonaHistorico> implements TareaPersonaHistoricoRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-persona-historico:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Value("#{primaryQuery['TareaPersonaHistoricoRepositoryCustom.save']}")
    private String sqlSave;
    
    @Override
    public List<TareaPersonaHistorico> save(final List<TareaPersonaHistorico> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaPersonaHistorico entity) throws SQLException {
        pstmt.setObject(1, entity.getFechaFin());
        pstmt.setObject(2, entity.getFechaInicio());
        pstmt.setString(3, entity.getIdEmpleado());
        pstmt.setString(4, entity.getIdEmpleadoLocal());
        pstmt.setString(5, entity.getIdTienda());
        pstmt.setString(6, entity.getIdTiendaMeta4());
        pstmt.setString(7, entity.getOrEmpleado());
        pstmt.setString(8, entity.getIdEmpresa());
        pstmt.setLong(9, entity.getTarea().getId());        
    }

}
