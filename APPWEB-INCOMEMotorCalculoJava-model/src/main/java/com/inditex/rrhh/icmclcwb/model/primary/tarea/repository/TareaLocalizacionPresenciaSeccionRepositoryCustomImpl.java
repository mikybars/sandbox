package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresenciaSeccion;

@Repository
public class TareaLocalizacionPresenciaSeccionRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionPresenciaSeccion>
        implements TareaLocalizacionPresenciaSeccionRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Value("${app.envars.repository.batch-size.tarea-localizacion-presencia-seccion:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("primaryQuery")
    private Properties query;

    @Override
    public List<TareaLocalizacionPresenciaSeccion> save(final List<TareaLocalizacionPresenciaSeccion> src) {
        return saveJdbcBatchList(src, query.getProperty("TareaLocalizacionPresenciaSeccionRepositoryCustom.save"), batchSize);
    }
    
    @Override
    public void compensar(@NotNull final RunTareaDto runTarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTarea.getTarea().getId());
        namedParameterJdbcTemplate.update(query.getProperty("TareaLocalizacionPresenciaSeccionRepositoryCustom.compensar"), parameters);
    }
    
    @Override
    public void updateActivo(@NotNull final RunTareaDto runTarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTarea.getTarea().getId());
        namedParameterJdbcTemplate.update(query.getProperty("TareaLocalizacionPresenciaSeccionRepositoryCustom.updateActivo"), parameters);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionPresenciaSeccion entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getIdLocalizacion());
        pstmt.setDouble(3, entity.getMinutos1() != null ? entity.getMinutos1() : 0);
        pstmt.setDouble(4, entity.getMinutos2() != null ? entity.getMinutos2() : 0);
        pstmt.setDouble(5, entity.getMinutos3() != null ? entity.getMinutos3() : 0);
        pstmt.setDouble(6, entity.getTipoDato().getId());
        pstmt.setObject(7, entity.getActivo());
        pstmt.setLong(8, entity.getTarea().getId());
    }

}
