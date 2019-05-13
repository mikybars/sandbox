package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaSeccionPresencia;

@Repository
public class TareaLocalizacionPersonaSeccionPresenciaRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionPersonaSeccionPresencia>
        implements TareaLocalizacionPersonaSeccionPresenciaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Value("${app.envars.repository.batch-size.tarea-localizacion-persona-seccion-presencia:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Value("#{primaryQuery['TareaLocalizacionPersonaSeccionPresenciaRepositoryCustom.save']}")
    private String sqlSave;
    
    @Value("#{primaryQuery['TareaLocalizacionPersonaSeccionPresenciaRepositoryCustom.updateActivo']}")
    private String sqlUpdateActivo;
    
    @Override
    public void updateActivo(@NotNull RunTareaDto runTareaDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        
        namedParameterJdbcTemplate.update(sqlUpdateActivo, parameters);
    }
    
    @Override
    public List<TareaLocalizacionPersonaSeccionPresencia> save(final List<TareaLocalizacionPersonaSeccionPresencia> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionPersonaSeccionPresencia entity)
            throws SQLException {
        pstmt.setString(1, entity.getIdLocalizacion());
        pstmt.setString(2, entity.getIdOrigen());
        pstmt.setString(3, entity.getIdPersona());
        pstmt.setString(4, entity.getOrPersona());
        pstmt.setString(5, entity.getIdEmpresa());
        pstmt.setString(6, entity.getIdSeccion());
        pstmt.setObject(7, entity.getFecha());
        pstmt.setLong(8, entity.getMinutos());
        pstmt.setString(9, entity.getIdTipoHora());
        pstmt.setBoolean(10, entity.getActivo());
        pstmt.setLong(11, entity.getTarea().getId());
    }

}
