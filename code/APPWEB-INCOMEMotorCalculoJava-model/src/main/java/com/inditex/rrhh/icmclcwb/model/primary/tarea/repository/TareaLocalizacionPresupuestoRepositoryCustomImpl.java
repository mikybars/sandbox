package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuesto;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

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

  @Value("#{primaryQuery['TareaLocalizacionPresupuestoRepositoryCustom.findLocalizacionOrdinalTarea']}")
  private String sqlFindLocalizacionOrdinalTarea;

  @Value("${app.envars.repository.batch-size.tarea-persona-historico:0}")
  private int batchSize;

  @Override
  public List<TareaLocalizacionPresupuesto> save(final List<TareaLocalizacionPresupuesto> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

  @Override
  public List<TareaLocalizacionPresupuestoDto> findPresupuestos(final TareaDto tarea) {

    final MapSqlParameterSource maps = new MapSqlParameterSource();
    maps.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    return this.query(this.sqlFindPresupuestos, maps,
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
  public PeriodoDto findPeriodoPresupuestoYTrabajo(final Long idTarea) {

    final MapSqlParameterSource maps = new MapSqlParameterSource();
    maps.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    return this.queryForObject(this.sqlFindPeriodoPresupuestoYTrabajo, maps,
        (rs, rowNum) -> PeriodoDto
            .builder()
            .fechaFinPeriodo(rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_FIN).toLocalDate())
            .fechaInicioPeriodo(rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_INICIO).toLocalDate())
            .build());
  }

  @Override
  public void updateActivoBandaExcepcion(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ICM_CK_EXCEPCION, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    this.update(this.sqlUpdateActivoBandaExcepcion, map);
  }

  @Override
  public void updateActivoBandasSinExcepcion(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO,
        TipoGrupoDatoEnum.VENTA_RANGO_REAL_Y_CONGELADA.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ICM_CK_EXCEPCION, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    map.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    this.update(this.sqlUpdateActivoBandasSinExcepcion, map);
  }

  @Override
  public List<String> findLocalizacionOrdinalTarea(
      @NotNull final Long idTarea, @NotNull final Integer cclIdCodOrigen, @NotNull final Integer cclIdSeccion,
      @NotNull final LocalDate fechaInicio, @NotNull final LocalDate fechaFin,
      @NotNull final Integer idTipoPresupuesto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_COD_ORIGEN, cclIdCodOrigen);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, cclIdSeccion);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO, TimeUtils.toDate(fechaInicio));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_FIN, TimeUtils.toDate(fechaFin));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_PRESUPUESTO, idTipoPresupuesto);

    return this.query(
        this.sqlFindLocalizacionOrdinalTarea,
        parameters, new RowMapper<String>() {
          @Override
          public String mapRow(final ResultSet rs, final int rowNum)
              throws SQLException {
            return rs.getString(SqlPrimaryConstants.SQL_RESULT_ICM_ORDINAL);
          }
        });
  }

}
