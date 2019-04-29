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
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersona;

@Repository
public class TareaLocalizacionPersonaRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionPersona>
        implements TareaLocalizacionPersonaRepositoryCustom {

    private static final String ID_TAREA = "idTarea";

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Value("${app.envars.repository.batch-size.tarea-localizacion-persona:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Value("#{primaryQuery['TareaLocalizacionPersonaRepositoryCustom.save']}")
    private String sqlSave;
    
    @Value("#{primaryQuery['TareaLocalizacionAbiertaRepositoryCustom.mergePersonaLocalizacion']}")
    private String sqlMergePersonaLocalizacion;
    
    @Override
    public void mergePersonaLocalizacion(@NotNull final RunTareaDto tareaDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(ID_TAREA, tareaDto.getTarea().getId());
        
        namedParameterJdbcTemplate.update(sqlMergePersonaLocalizacion, parameters);
    }
    
    @Override
    public List<TareaLocalizacionPersona> save(List<TareaLocalizacionPersona> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionPersona entity) throws SQLException {
        pstmt.setString(1, entity.getIdLocalizacion());
        pstmt.setString(2, entity.getIdOrigen());
        pstmt.setString(3, entity.getIdPersona());
        pstmt.setLong(4, entity.getTarea().getId());
    }

}
