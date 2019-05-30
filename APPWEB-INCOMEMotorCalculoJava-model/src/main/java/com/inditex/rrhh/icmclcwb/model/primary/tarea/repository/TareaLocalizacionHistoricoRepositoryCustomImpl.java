package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionHistorico;

@Repository
public class TareaLocalizacionHistoricoRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionHistorico>
        implements TareaLocalizacionHistoricoRepositoryCustom {
    
    @Value("${app.envars.repository.batch-size.tarea-localizacion-historico:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaLocalizacionHistorico> save(final List<TareaLocalizacionHistorico> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionHistorico entity) throws SQLException {
        pstmt.setObject(1, entity.getFechaFin());
        pstmt.setObject(2, entity.getFechaInicio());
        pstmt.setString(3, entity.getIdCadena());
        pstmt.setString(4, entity.getIdEmpresa());
        pstmt.setString(5, entity.getIdPais());
        pstmt.setString(6, entity.getIdPaisOrigen());
        pstmt.setString(7, entity.getIdLocalizacion());
        pstmt.setString(8, entity.getIdLocalizacionMeta4());
        pstmt.setLong(9, entity.getTarea().getId());
    }

}
