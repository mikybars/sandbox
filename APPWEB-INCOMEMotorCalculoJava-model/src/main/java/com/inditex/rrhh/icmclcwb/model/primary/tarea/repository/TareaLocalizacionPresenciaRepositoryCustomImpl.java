package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresencia;

@Repository
public class TareaLocalizacionPresenciaRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionPresencia>
        implements TareaLocalizacionPresenciaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Autowired
    @Qualifier("primaryQuery")
    private Properties query;
    
    @Value("${app.envars.repository.batch-size.tarea-localizacion-presencia:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Override
    public List<TareaLocalizacionPresencia> save(final List<TareaLocalizacionPresencia> src) {
        return saveJdbcBatchList(src, query.getProperty("TareaLocalizacionPresenciaRepositoryCustom.save"), batchSize);
    }
    
    @Override
    public void compensar(@NotNull final RunTareaDto runTarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTarea.getTarea().getId());
        namedParameterJdbcTemplate.update(query.getProperty("TareaLocalizacionPresenciaRepositoryCustom.compensar"), parameters);
    }
    
    @Override
    public void updateActivo(@NotNull final RunTareaDto runTarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTarea.getTarea().getId());
        namedParameterJdbcTemplate.update(query.getProperty("TareaLocalizacionPresenciaRepositoryCustom.updateActivo"), parameters);
    }
    
    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionPresencia entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdLocalizacion());
        pstmt.setDouble(3, entity.getMinutos() != null ? entity.getMinutos() : 0);
        pstmt.setDouble(4, entity.getTipoDato().getId());
        pstmt.setObject(5, entity.getActivo());
        pstmt.setLong(6, entity.getTarea().getId());        
    }

}
