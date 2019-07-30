package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TareaAgrupacionVentaRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaAgrupacionVenta>
        implements TareaAgrupacionVentaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("${app.envars.repository.batch-size.tarea-agrupacion-venta:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaAgrupacionVentaRepository.save']}")
    private String sqlSave;

    @Value("#{primaryQuery['TareaAgrupacionVentRepositoryCustom.updateActivo']}")
    private String sqlUpdateActivo;

    @Override
    public void setParameters(PreparedStatement pstmt, TareaAgrupacionVenta entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setLong(2, entity.getIdAgrupacion());
        pstmt.setLong(3, entity.getTarea().getId());
        pstmt.setLong(4, entity.getTipoDato().getId());
        pstmt.setString(5, entity.getIdSeccion());
        pstmt.setString(6, entity.getIdOrigen());
        pstmt.setBigDecimal(7, entity.getImporteSinImpuestos());
        pstmt.setBigDecimal(8, entity.getImporteConImpuestos());
        pstmt.setBoolean(9, entity.getActivo());
    }

    @Override
    public List<TareaAgrupacionVenta> save(List<TareaAgrupacionVenta> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void updateActivo(TareaDto tarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA,
                TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_AGRUPACIONONLINE.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION,
                SqlPrimaryConstants.SQL_VALUE_PORCENTAJE_CERO);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        namedParameterJdbcTemplate.update(sqlUpdateActivo, parameters);
    }

}
