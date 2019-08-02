package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersonaPresenciaManual;

@Repository
public class TareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaAmbitoGlobalLocalizacionPersonaPresenciaManual>
        implements TareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-ambito-global-localizacion-persona-presencia-manual:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaAmbitoGlobalLocalizacionPersonaPresenciaManual> save(final List<TareaAmbitoGlobalLocalizacionPersonaPresenciaManual> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaAmbitoGlobalLocalizacionPersonaPresenciaManual entity)
            throws SQLException {
        pstmt.setString(1, entity.getStdIdWorkLocat());
        pstmt.setString(2, entity.getCclIdOrigen());
        pstmt.setString(3, entity.getCclIdPerson());
        pstmt.setString(4, entity.getStdIdLegEnt());
        pstmt.setLong(5, entity.getTarea().getId());
    }

}
