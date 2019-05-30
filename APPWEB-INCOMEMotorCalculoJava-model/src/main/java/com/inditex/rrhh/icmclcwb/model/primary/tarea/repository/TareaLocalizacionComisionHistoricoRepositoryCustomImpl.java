package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionComisionHistorico;

@Repository
public class TareaLocalizacionComisionHistoricoRepositoryCustomImpl extends
        JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionComisionHistorico> implements TareaLocalizacionComisionHistoricoRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-localizacion-comision-historico:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaLocalizacionComisionHistoricoRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaLocalizacionComisionHistorico> save(final List<TareaLocalizacionComisionHistorico> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionComisionHistorico entity) throws SQLException {
        pstmt.setObject(1, entity.getFechaFin());
        pstmt.setObject(2, entity.getFechaInicio());
        pstmt.setBoolean(3, entity.getComisionable());
        pstmt.setString(4, entity.getIdLocalizacion());
        pstmt.setString(5, entity.getIdLocalizacionMeta4());
        pstmt.setLong(6, entity.getTarea().getId());
    }

}
