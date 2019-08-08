package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersonaPresencia;

@Repository
public class TareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaAmbitoGlobalLocalizacionPersonaPresencia>
        implements TareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-ambito-global-localizacion-persona-presencia:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Value("#{primaryQuery['TareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustom.save']}")
    private String sqlSave;
    
    @Override
    public List<TareaAmbitoGlobalLocalizacionPersonaPresencia> save(final List<TareaAmbitoGlobalLocalizacionPersonaPresencia> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }
    
    @Override
    public void setParameters(PreparedStatement pstmt, TareaAmbitoGlobalLocalizacionPersonaPresencia entity) throws SQLException {
        pstmt.setString(1, entity.getCclIdCodOrigen());
        pstmt.setString(2, entity.getCclIdOrigen());
        pstmt.setString(3, entity.getCclIdPerson());
        pstmt.setString(4, entity.getStdIdLegEnt());
        pstmt.setLong(5, entity.getTarea().getId());
    }

}
