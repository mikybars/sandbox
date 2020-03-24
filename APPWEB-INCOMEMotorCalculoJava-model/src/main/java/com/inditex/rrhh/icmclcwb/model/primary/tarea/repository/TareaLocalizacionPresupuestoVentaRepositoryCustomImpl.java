package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuestoVenta;


@Repository
public class TareaLocalizacionPresupuestoVentaRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionPresupuestoVenta>
        implements TareaLocalizacionPresupuestoVentaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Value("${app.envars.repository.batch-size.tarea-localizacion-presupuesto-venta:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaLocalizacionPresupuestoVentaRepositoryCustom.save']}")
    private String sqlSave;
    
    @Value("#{primaryQuery['TareaLocalizacionPresupuestoVentaRepositoryCustom.updateActivoVacio']}")
    private String sqlUpdateActivo;
    
    @Override
    public void updateActivo(@NotNull RunTareaDto runTareaDto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
        namedParameterJdbcTemplate.update(sqlUpdateActivo, parameters);
    }
    
    @Override
    public List<TareaLocalizacionPresupuestoVenta> save(List<TareaLocalizacionPresupuestoVenta> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }
    
    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionPresupuestoVenta entity) throws SQLException {
        pstmt.setLong(1, entity.getTarea().getId());
        pstmt.setString(2, entity.getStdIdWorkLocat());
        pstmt.setString(3, entity.getCclIdCodOrigen());
        pstmt.setString(4, entity.getCclIdSeccion());
        if (entity.getOrdinal() != null) {
            pstmt.setInt(5, entity.getOrdinal());
        }else{
            pstmt.setNull(5, Types.INTEGER);
        }
        pstmt.setDouble(6, entity.getImporteSinImpuestos());
        pstmt.setDouble(7, entity.getImporteConImpuestos());
        pstmt.setLong(8, entity.getTipoPresupuesto().getId());
        pstmt.setLong(9, entity.getTipoVentaConceptoChallenge().getId());
        pstmt.setString(10, entity.getCclIdOrigen());
        pstmt.setBoolean(11, entity.getActivo());
        pstmt.setInt(12, entity.getTipoDato().getId());
        pstmt.setObject(13, entity.getFechaFin());
        pstmt.setObject(14, entity.getFechaInicio());

    }

}
