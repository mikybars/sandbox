package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoLocalizacionPersonaPresencia;

@Repository
public class TareaAmbitoLocalizacionPersonaPresenciaRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaAmbitoLocalizacionPersonaPresencia>
        implements TareaAmbitoLocalizacionPersonaPresenciaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-ambitolocalizacion-persona-presencia:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Value("#{primaryQuery['TareaAmbitoLocalizacionPersonaPresenciaRepositoryCustom.save']}")
    private String sqlSave;
    
    @Override
    public List<TareaAmbitoLocalizacionPersonaPresencia> save(final List<TareaAmbitoLocalizacionPersonaPresencia> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }
    
    @Override
    public void setParameters(PreparedStatement pstmt, TareaAmbitoLocalizacionPersonaPresencia entity) throws SQLException {
        pstmt.setString(1, entity.getIdLocalizacion());
        pstmt.setString(2, entity.getIdOrigen());
        pstmt.setString(3, entity.getIdPersona());
        pstmt.setString(4, entity.getIdEmpresa());
        pstmt.setLong(5, entity.getTarea().getId());
    }

}
