package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.TipoConceptoVenta;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCadenaPresencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TareaCadenaPresenciaRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaCadenaPresencia>
        implements TareaCadenaPresenciaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-agrupacion-presencia:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaCadenaPresenciaRepositoryCustom.save']}")
    private String sqlSave;

    @Value("#{primaryQuery['TareaCadenaPresenciaRepositoryCustom.updateActivo']}")
    private String sqlUpdateActivo;

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<TareaCadenaPresencia> save(@NotNull List<TareaCadenaPresencia> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaCadenaPresencia entity) throws SQLException {
        pstmt.setLong(1, entity.getTarea().getId());
        pstmt.setObject(2, entity.getFecha());
        pstmt.setString(3, entity.getIdCadena());
        pstmt.setString(4, entity.getIdSeccion());
        pstmt.setLong(5, entity.getMinutos());
        pstmt.setBoolean(6, entity.getActivo());
        pstmt.setLong(7, entity.getTipoDato().getId());
    }

    @Override
    public void updateActivo(@NotNull TareaDto tarea) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO,
                TipoConceptoVenta.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_MINUTOS, TipoDatoEnum.MINUTOS_TOTALES.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        namedParameterJdbcTemplate.update(sqlUpdateActivo, params);
    }

}
