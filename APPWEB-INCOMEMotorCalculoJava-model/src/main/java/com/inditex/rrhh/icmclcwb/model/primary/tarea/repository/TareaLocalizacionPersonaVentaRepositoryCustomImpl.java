package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaVenta;

@Repository
public class TareaLocalizacionPersonaVentaRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionPersonaVenta>
        implements TareaLocalizacionPersonaVentaRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-localizacion-persona-venta:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaLocalizacionPersonaVentaRepositoryCustom.save']}")
    private String sqlSave;

    @Value("#{primaryQuery['TareaLocalizacionPersonaVentaRepositoryCustom.totalizarVentaPersonaSeccionPorVenta']}")
    private String sqlTotalizarVentaPersonaSeccion;

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<TareaLocalizacionPersonaVenta> save(List<TareaLocalizacionPersonaVenta> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionPersonaVenta entity) throws SQLException {
        pstmt.setObject(1, entity.getFecha());
        pstmt.setString(2, entity.getCclIdCodOrigen());
        pstmt.setString(3, entity.getCclIdPerson());
        pstmt.setBigDecimal(4, entity.getImporteSinImpuestos());
        pstmt.setBigDecimal(5, entity.getImporteConImpuestos());
        pstmt.setDouble(6, entity.getTipoDato().getId());
        pstmt.setLong(7, entity.getTarea().getId());
        pstmt.setObject(8, entity.getPk().getFechaInicioPeriodo());
        pstmt.setString(9, entity.getCclIdSeccion());
        pstmt.setString(10, entity.getCclIdCadena());
        pstmt.setBoolean(11, entity.getActivo());
    }

    @Override
    public void totalizarVentaPersonaSeccion(TareaDto tarea) {

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        // Parámetros filtro
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.VENTA_INDIVIDUAL_LOCALIZACION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        // Parámetros que establecen valores
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.VENTA_INDIVIDUAL_LOCALIZACION_SECCION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

        namedParameterJdbcTemplate.update(sqlTotalizarVentaPersonaSeccion, parameters);

    }

    @Override
    public void totalizarVentaSinDevolucionPersonaSeccion(TareaDto tarea) {

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        // Parámetros filtro
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION_TOTALIZADA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        // Parámetros que establecen valores
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.VENTA_SIN_DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

        namedParameterJdbcTemplate.update(sqlTotalizarVentaPersonaSeccion, parameters);

    }

    @Override
    public void totalizarDevolucionPersonaSeccion(TareaDto tarea) {

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        // Parámetros filtro
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.DEVOLUCION_LOCALIZACION_TOTALIZADA.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        // Parámetros que establecen valores
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

        namedParameterJdbcTemplate.update(sqlTotalizarVentaPersonaSeccion, parameters);

    }
}
