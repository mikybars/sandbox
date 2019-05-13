package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaCoeficiente;

@Repository
public class TareaPersonaCoeficienteRepositoryCustomImpl extends
        JdbcBatchPrimaryRepositoryAbstract<TareaPersonaCoeficiente> implements TareaPersonaCoeficienteRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-persona-coeficiente:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Value("#{primaryQuery['TareaPersonaCoeficienteRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaPersonaCoeficiente> save(List<TareaPersonaCoeficiente> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }
    
    @Override
    public void setParameters(PreparedStatement pstmt, TareaPersonaCoeficiente entity) throws SQLException {
        pstmt.setObject(1, entity.getCoeficiente());
        pstmt.setString(2, entity.getIdPersona());
        pstmt.setString(3, entity.getIdPersonaLocal());
        pstmt.setString(4, entity.getOrPersona());
        pstmt.setObject(5, entity.getFechaInicio());
        pstmt.setObject(6, entity.getFechaFin());
        pstmt.setLong(7, entity.getTarea().getId());        
    }

}
