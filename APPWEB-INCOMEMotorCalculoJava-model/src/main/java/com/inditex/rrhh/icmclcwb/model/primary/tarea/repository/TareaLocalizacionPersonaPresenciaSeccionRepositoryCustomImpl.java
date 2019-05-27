package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaPresenciaSeccion;

@Repository
public class TareaLocalizacionPersonaPresenciaSeccionRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionPersonaPresenciaSeccion>
        implements TareaLocalizacionPersonaPresenciaSeccionRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Value("${app.envars.repository.batch-size.tarea-localizacion-persona-presencia-seccion:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Value("#{primaryQuery['TareaLocalizacionPersonaPresenciaSeccionRepositoryCustom.save']}")
    private String sqlSave;
    
    @Override
    public List<TareaLocalizacionPersonaPresenciaSeccion> save(final List<TareaLocalizacionPersonaPresenciaSeccion> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionPersonaPresenciaSeccion entity)
            throws SQLException {
        pstmt.setString(1, entity.getIdLocalizacion());
        pstmt.setString(2, entity.getIdOrigen());
        pstmt.setString(3, entity.getIdPersona());
        pstmt.setString(4, entity.getIdEmpresa());
        pstmt.setObject(5, entity.getFecha());
        pstmt.setLong(6, entity.getMinutos1());
        pstmt.setLong(7, entity.getMinutos2());
        pstmt.setLong(8, entity.getMinutos3());
        pstmt.setString(9, entity.getIdTipoHora());
        pstmt.setBoolean(10, entity.getActivo());
        pstmt.setLong(11, entity.getTipoDato().getId());
        pstmt.setLong(12, entity.getTarea().getId());
    }
    

}
