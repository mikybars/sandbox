package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracionChallengeDiasMinimos;

@Repository
public class TareaConfiguracionChallengeDiasMinimosRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaConfiguracionChallengeDiasMinimos>
        implements TareaConfiguracionChallengeDiasMinimosRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-configuracion-challenge-dias-minimos:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaConfiguracionChallengeDiasMinimosRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaConfiguracionChallengeDiasMinimos> save(List<TareaConfiguracionChallengeDiasMinimos> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaConfiguracionChallengeDiasMinimos entity)
            throws SQLException {
        pstmt.setLong(1, entity.getTarea().getId());
        pstmt.setString(2, entity.getIcmIdTpCalculo());
        pstmt.setInt(3, entity.getIcmMinNumDays());
        pstmt.setObject(4, entity.getFechaInicio());
        pstmt.setObject(5, entity.getFechaFin());
        pstmt.setString(6, entity.getCclIdOrigen());
    }

}
