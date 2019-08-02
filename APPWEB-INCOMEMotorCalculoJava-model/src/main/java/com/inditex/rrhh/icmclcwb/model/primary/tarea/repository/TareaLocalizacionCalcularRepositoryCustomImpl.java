package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionCalcular;

@Repository
public class TareaLocalizacionCalcularRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionCalcular>
        implements TareaLocalizacionCalcularRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-localizacion-calcular:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Value("#{primaryQuery['TareaLocalizacionCalcularRepositoryCustom.save']}")
    private String sqlSave;
    
    @Override
    public List<TareaLocalizacionCalcular> save(final List<TareaLocalizacionCalcular> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionCalcular entity) throws SQLException {
        pstmt.setLong(1, entity.getTarea().getId());
        pstmt.setString(2, entity.getStdIdWorkLocat());
        pstmt.setString(3, entity.getCclIdCodOrigen());
        pstmt.setObject(4, entity.getCalcula());
        pstmt.setObject(5, entity.getFechaInicio());
        pstmt.setObject(6, entity.getFechaFin());
    }

}
