package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresencia;

@Repository
public class TareaLocalizacionPersonaPresenciaRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionPersonaPresencia>
        implements TareaLocalizacionPersonaPresenciaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Autowired
    @Qualifier("primaryQuery")
    private Properties query;
    
    @Value("${app.envars.repository.batch-size.tarea-localizacion-persona-presencia:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Override
    public List<TareaLocalizacionPersonaPresencia> save(final List<TareaLocalizacionPersonaPresencia> src) {
        return saveJdbcBatchList(src, query.getProperty("TareaLocalizacionPersonaPresenciaRepositoryCustom.save"), batchSize);
    }
    
    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionPersonaPresencia entity) throws SQLException {
        pstmt.setObject(1, entity.getIdOrigen());
        pstmt.setString(2, entity.getIdPersona());
        pstmt.setString(3, entity.getIdLocalizacion());
        pstmt.setString(4, entity.getIdEmpresa());
        pstmt.setObject(5, entity.getFecha());
        pstmt.setDouble(6, entity.getMinutos() != null ? entity.getMinutos() : 0);
        pstmt.setDouble(7, entity.getTipoDato().getId());
        pstmt.setObject(8, entity.getActivo());
        pstmt.setString(9, entity.getIdTipoHora());
        pstmt.setLong(10, entity.getTarea().getId());  
    }

}
