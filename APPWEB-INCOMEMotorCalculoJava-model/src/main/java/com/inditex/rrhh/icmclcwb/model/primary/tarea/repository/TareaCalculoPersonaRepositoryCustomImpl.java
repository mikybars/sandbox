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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCalculoPersona;

@Repository
public class TareaCalculoPersonaRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaCalculoPersona>
        implements TareaCalculoPersonaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("${app.envars.repository.batch-size.tarea-calculo-persona:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaCalculoPersonaRepositoryCustom.save']}")
    private String sqlSave;

    @Value("#{primaryQuery['TareaCalculoPersonaRepositoryCustom.mergePersonaCalculo']}")
    private String sqlMergePersonaCalculo;

    @Override
    public List<TareaCalculoPersona> save(final List<TareaCalculoPersona> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void mergePersonaCalculo(@NotNull RunTareaDto tareaDto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getTarea().getId());
        // TODO Origen
        namedParameterJdbcTemplate.update(sqlMergePersonaCalculo, params);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaCalculoPersona entity) throws SQLException {
        pstmt.setLong(1, entity.getTarea().getId());
        pstmt.setString(2, entity.getIdOrigen());
        pstmt.setString(3, entity.getIdPersona());
        pstmt.setString(4, entity.getOrPersona());
        pstmt.setLong(5, entity.getEstado().getId());
    }

}
