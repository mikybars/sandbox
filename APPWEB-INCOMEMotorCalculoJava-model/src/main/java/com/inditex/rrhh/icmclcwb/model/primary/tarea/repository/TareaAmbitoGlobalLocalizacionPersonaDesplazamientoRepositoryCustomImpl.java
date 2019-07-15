package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersonaDesplazamiento;

@Repository
public class TareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustomImpl extends
        JdbcBatchPrimaryRepositoryAbstract<TareaAmbitoGlobalLocalizacionPersonaDesplazamiento>
        implements TareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-ambito-global-localizacion-persona-desplazamiento:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustom.save']}")
    private String sqlSave;
    
    @Override
    public List<TareaAmbitoGlobalLocalizacionPersonaDesplazamiento> save(final List<TareaAmbitoGlobalLocalizacionPersonaDesplazamiento> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }
    
    @Override
    public void setParameters(PreparedStatement pstmt, TareaAmbitoGlobalLocalizacionPersonaDesplazamiento entity)
            throws SQLException {
        pstmt.setString(1, entity.getIdLocalizacion());
        pstmt.setString(2, entity.getIdOrigen());
        pstmt.setString(3, entity.getIdPersona());
        pstmt.setString(4, entity.getIdEmpresa());
        pstmt.setLong(5, entity.getTarea().getId());        
    }

}
