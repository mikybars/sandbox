package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionFestivo;

@Repository
public class TareaLocalizacionFestivoRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionFestivo>
implements TareaLocalizacionFestivoRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-localizacion-festivo:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Value("#{primaryQuery['TareaLocalizacionFestivoRepositoryCustom.save']}")
    private String sqlSave;
    
    @Override
    public List<TareaLocalizacionFestivo> save(final List<TareaLocalizacionFestivo> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }
    
    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionFestivo entity) throws SQLException {
        pstmt.setLong(1, entity.getTarea().getId());
        pstmt.setString(2, entity.getStdIdWorkLocat());
        pstmt.setObject(3, entity.getFecha());
    }
}
