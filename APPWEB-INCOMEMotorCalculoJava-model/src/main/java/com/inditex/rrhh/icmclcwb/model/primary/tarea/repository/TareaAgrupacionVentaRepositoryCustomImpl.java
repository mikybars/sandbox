package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.TipoConceptoVenta;
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
public class TareaAgrupacionVentaRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaAgrupacionVenta>
    implements TareaAgrupacionVentaRepositoryCustom{

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
        pstmt.setDouble(6, entity.getImporte());
        pstmt.setDouble(7, entity.getImporteConImpuestos());
    }

    @Override
    public List<TareaAgrupacionVenta> save(List<TareaAgrupacionVenta> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void updateActivo(TareaDto tarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA, TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_AGRUPACION_CADENA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO, TipoConceptoVenta.ENTREGA_DOMICILIO_POR_VENTA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        namedParameterJdbcTemplate.update(sqlUpdateActivo, parameters);
    }
}
