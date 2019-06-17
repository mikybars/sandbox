package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.TipoConceptoVenta;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCadenaVenta;
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
public class TareaCadenaVentaRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaCadenaVenta>
    implements TareaCadenaVentaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-cadena-venta:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaCadenaVentaRepositoryCustom.save']}")
    private String sqlSave;

    @Value("#{primaryQuery['TareaCadenaVentaRepositoryCustom.updateActivo']}")
    private String sqlUpdateActivo;

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void save(List<TareaCadenaVenta> src) {
        saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaCadenaVenta entity) throws SQLException {
        pstmt.setLong(1, entity.getTarea().getId());
        pstmt.setObject(2, entity.getFecha());
        pstmt.setString(3, entity.getIdCadena());
        pstmt.setString(4, entity.getIdSeccion());
        pstmt.setDouble(5, entity.getImporte());
        pstmt.setDouble(6, entity.getImporteConImpuestos());
        pstmt.setBoolean(7, entity.getActivo());
        pstmt.setLong(8, entity.getTipoDato().getId());
    }

    @Override
    public void updateActivoVentaOnlineEntregaDomicilio(TareaDto tarea) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA,
            TipoDatoEnum.IMPORTE_VENTA_ONLINE_ENTREGA_DOMICILIO_CADENA.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO,
            TipoConceptoVenta.ENTREGA_DOMICILIO_POR_VENTA.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA,
            tarea.getId());
        namedParameterJdbcTemplate.update(sqlUpdateActivo, params);
    }
}
