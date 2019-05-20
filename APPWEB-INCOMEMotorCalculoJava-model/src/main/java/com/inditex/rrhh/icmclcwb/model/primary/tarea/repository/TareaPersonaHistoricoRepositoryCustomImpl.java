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
        pstmt.setObject(3, entity.getFechaFinSeccion());
        pstmt.setObject(4, entity.getFechaInicioSeccion());
        pstmt.setString(5, entity.getIdEmpleado());
        pstmt.setString(6, entity.getIdEmpleadoLocal());
        pstmt.setString(7, entity.getIdTienda());
        pstmt.setString(8, entity.getIdTiendaMeta4());
        pstmt.setString(9, entity.getOrEmpleado());
        pstmt.setString(10, entity.getIdEmpresa());
        pstmt.setString(11, entity.getIdOrigen());
        pstmt.setString(12, entity.getIdSeccion());
        pstmt.setLong(13, entity.getTarea().getId());        
    }

}
