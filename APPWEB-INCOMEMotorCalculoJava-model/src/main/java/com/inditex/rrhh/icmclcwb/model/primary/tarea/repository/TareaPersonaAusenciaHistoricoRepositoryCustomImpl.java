package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaAusenciaHistorico;

@Repository
public class TareaPersonaAusenciaHistoricoRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaPersonaAusenciaHistorico>
        implements TareaPersonaAusenciaHistoricoRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-persona-ausencia-historico:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaPersonaAusenciaHistoricoRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaPersonaAusenciaHistorico> save(final List<TareaPersonaAusenciaHistorico> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaPersonaAusenciaHistorico entity) throws SQLException {
        pstmt.setObject(1, entity.getFechaFin());
        pstmt.setObject(2, entity.getFechaInicio());
        pstmt.setString(3, entity.getCclIdPerson());
        pstmt.setString(4, entity.getStdOrHrPeriod());
        pstmt.setLong(5, entity.getTipoAusencia().getId());
        pstmt.setString(6, entity.getCclIdOrigen());
        pstmt.setLong(7, entity.getTarea().getId());
    }

}
