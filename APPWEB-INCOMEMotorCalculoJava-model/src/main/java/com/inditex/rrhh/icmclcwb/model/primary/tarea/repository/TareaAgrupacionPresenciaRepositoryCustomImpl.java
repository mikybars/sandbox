package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionPresencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Repository
public class TareaAgrupacionPresenciaRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaAgrupacionPresencia>
    implements TareaAgrupacionPresenciaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-agrupacion-presencia:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{primaryQuery['TareaAgrupacionPresenciaRepository.save']}")
    private String sqlSave;

    @Value("#{primaryQuery['TareaAgrupacionPresenciaRepositoryCustom.updateActivo']}")
    private String sqlUpdateActivo;

    @Override
    public List<TareaAgrupacionPresencia> save(@Valid List<TareaAgrupacionPresencia> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaAgrupacionPresencia entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setLong(2, entity.getIdAgrupacion());
        pstmt.setString(3, entity.getIdSeccion());
        pstmt.setString(4, entity.getIdOrigen());
        pstmt.setLong(5, entity.getMinutos());
        pstmt.setLong(6, entity.getTarea().getId());
        pstmt.setLong(7, entity.getTipoDato().getId());
    }

    @Override
    public void updateActivo(TareaDto tarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_MINUTOS, TipoDatoEnum.MINUTOS_TOTALES.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO, Arrays.asList(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId()));
        namedParameterJdbcTemplate.update(sqlUpdateActivo, parameters);
    }
}
