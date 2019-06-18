package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.TipoConceptoVenta;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TareaAgrupacionCadena;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TareaAgrupacionCadenaRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaAgrupacionCadena> implements TareaAgrupacionCadenaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-agrupacion-cadena:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Value("#{primaryQuery['TareaAgrupacionCadenaRepositoryCustom.save']}")
    private String sqlSave;
    
    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<TareaAgrupacionCadena> save(@NotNull List<TareaAgrupacionCadena> agrupaciones) {
        return saveJdbcBatchList(agrupaciones, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaAgrupacionCadena entity) throws SQLException {
        pstmt.setLong(1, entity.getTarea().getId());
        pstmt.setLong(2, entity.getIdAgrupacion());
        pstmt.setString(3, entity.getIdCadena());
        pstmt.setBoolean(4, entity.getMultiple());
    }
}
