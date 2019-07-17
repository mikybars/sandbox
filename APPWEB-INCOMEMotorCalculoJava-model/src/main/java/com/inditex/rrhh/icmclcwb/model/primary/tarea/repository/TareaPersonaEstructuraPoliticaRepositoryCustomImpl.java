package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraPolitica;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TareaPersonaEstructuraPoliticaRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaPersonaEstructuraPolitica>
    implements TareaPersonaEstructuraPoliticaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-persona-estructura-politica:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaPersonaEstructuraPoliticaRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaPersonaEstructuraPolitica> save(List<TareaPersonaEstructuraPolitica> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaPersonaEstructuraPolitica entity) throws SQLException {
        pstmt.setObject(1, entity.getFechaFin());
        pstmt.setObject(2, entity.getFechaInicio());
        pstmt.setString(3, entity.getIdPersona());
        pstmt.setString(4, entity.getIdPersonaLocal());
        pstmt.setString(5, entity.getIdEstructuraPolitica());
        pstmt.setLong(6, entity.getTipoPolitica().getId());
        pstmt.setString(7, entity.getOrPersona());
        pstmt.setLong(8, entity.getTarea().getId());
        pstmt.setString(9, entity.getIdOrigen());
        pstmt.setBoolean(10, entity.getExcluidoDenominador());
    }

}
