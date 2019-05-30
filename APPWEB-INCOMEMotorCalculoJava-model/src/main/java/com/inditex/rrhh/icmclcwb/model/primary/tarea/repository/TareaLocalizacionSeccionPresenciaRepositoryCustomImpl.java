package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionSeccionPresencia;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TareaLocalizacionSeccionPresenciaRepositoryCustomImpl extends
    JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionSeccionPresencia> implements TareaLocalizacionSeccionPresenciaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-localizacion-seccion-presencia:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaLocalizacionSeccionPresenciaRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaLocalizacionSeccionPresencia> save(List<TareaLocalizacionSeccionPresencia> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionSeccionPresencia entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdLocalizacion());
        pstmt.setString(3, entity.getIdSeccion());
        pstmt.setDouble(4, entity.getMinutos());
        pstmt.setDouble(5, entity.getTipoDato().getId());
        pstmt.setBoolean(6, entity.getActivo());
        pstmt.setLong(7, entity.getTarea().getId());
    }
}
