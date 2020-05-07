package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuesto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TareaLocalizacionPresupuestoRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionPresupuesto>
        implements TareaLocalizacionPresupuestoRepositoryCustom {

    @Value("#{primaryQuery['TareaLocalizacionPresupuestoRepositoryCustom.save']}")
    private String sqlSave;

    @Value("#{primaryQuery['TareaLocalizacionPresupuestoRepositoryCustom.findPresupuestos']}")
    private String sqlFindPresupuestos;

    @Value("#{primaryQuery['TareaLocalizacionPresupuestoRepositoryCustom.findPeriodoPresupuestoYTrabajo']}")
    private String sqlFindPeriodoPresupuestoYTrabajo;

    @Value("#{primaryQuery['TareaLocalizacionPresupuestoRepositoryCustom.updateActivoBandaExcepcion']}")
    private String sqlUpdateActivoBandaExcepcion;

    @Value("#{primaryQuery['TareaLocalizacionPresupuestoRepositoryCustom.updateActivoBandasSinExcepcion']}")
    private String sqlUpdateActivoBandasSinExcepcion;

    @Value("${app.envars.repository.batch-size.tarea-persona-historico:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<TareaLocalizacionPresupuesto> save(List<TareaLocalizacionPresupuesto> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionPresupuesto src) throws SQLException {
        pstmt.setLong(1, src.getTarea().getId());
        pstmt.setString(2, src.getCclIdOrigen());
        pstmt.setString(3, src.getStdIdLegEnt());
        pstmt.setString(4, src.getCclIdCodOrigen());
        pstmt.setString(5, src.getStdIdWorkLocat());
        pstmt.setString(6, src.getCclIdSeccion());
        pstmt.setObject(7, src.getFechaInicio());
        pstmt.setObject(8, src.getFechaFin());
        pstmt.setDouble(9, src.getImporteSinImpuestos());
        pstmt.setDouble(10, src.getImporteConImpuestos());
        pstmt.setInt(11, src.getBanda());
        pstmt.setInt(12, src.getOrdinal());
        pstmt.setBoolean(13, src.getExcepcion());
        pstmt.setInt(14, src.getTipoPresupuesto().getId());
        pstmt.setBoolean(15, src.getActivo());
    }

    @Override
    public List<TareaLocalizacionPresupuestoDto> findPresupuestos(TareaDto tarea) {

        MapSqlParameterSource maps = new MapSqlParameterSource();
        maps.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        return namedParameterJdbcTemplate.query(sqlFindPresupuestos, maps,
                (rs, rowNum) -> TareaLocalizacionPresupuestoDto
                    .builder()
                    .cclIdOrigen(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_ORIGEN))
                    .cclIdCodOrigen(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_LOCAL))
                    .fechaFin(rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_FIN).toLocalDate())
                    .fechaInicio(rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_INICIO).toLocalDate())
                    .stdIdLegEnt(rs.getString(SqlPrimaryConstants.SQL_RESULT_EMPRESA).toLowerCase())
                    .cclIdSeccion(rs.getString(SqlPrimaryConstants.SQL_RESULT_SECCION).toLowerCase())
                    .build());
    }

    @Override
    @Cacheable(value = "itx.icmlcwb.periodo_presupuestos_by_id_tarea_repository", key = "{#idTarea}")
    public PeriodoDto findPeriodoPresupuestoYTrabajo(Long idTarea) {

        MapSqlParameterSource maps = new MapSqlParameterSource();
        maps.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        return namedParameterJdbcTemplate.queryForObject(sqlFindPeriodoPresupuestoYTrabajo, maps,
                (rs, rowNum) -> PeriodoDto
                    .builder()
                    .fechaFinPeriodo(rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_FIN).toLocalDate())
                    .fechaInicioPeriodo(rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_INICIO).toLocalDate())
                    .build());
    }

    @Override
    public void updateActivoBandaExcepcion(TareaDto tarea) {
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ICM_CK_EXCEPCION, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

        namedParameterJdbcTemplate.update(sqlUpdateActivoBandaExcepcion, map);
    }

    @Override
    public void updateActivoBandasSinExcepcion(TareaDto tarea) {
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
                TipoGrupoDatoEnum.VENTA_RANGO_REAL_Y_CONGELADA.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ICM_CK_EXCEPCION, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        map.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        map.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

        namedParameterJdbcTemplate.update(sqlUpdateActivoBandasSinExcepcion, map);
    }

}
