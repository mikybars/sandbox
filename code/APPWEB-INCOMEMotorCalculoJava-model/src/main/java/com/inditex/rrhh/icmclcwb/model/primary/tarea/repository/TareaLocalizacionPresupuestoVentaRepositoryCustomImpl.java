package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuestoVenta;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaLocalizacionPresupuestoVentaRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionPresupuestoVenta>
    implements TareaLocalizacionPresupuestoVentaRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-localizacion-presupuesto-venta:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaLocalizacionPresupuestoVentaRepositoryCustom.save']}")
  private String sqlSave;

  @Value("#{primaryQuery['TareaLocalizacionPresupuestoVentaRepositoryCustom.updateActivoVacioCongelada']}")
  private String sqlUpdateActivoCongelada;

  @Value("#{primaryQuery['TareaLocalizacionPresupuestoVentaRepositoryCustom.updateActivoVacioCongeladaSeccion']}")
  private String sqlUpdateActivoCongeladaSeccion;

  @Value("#{primaryQuery['TareaLocalizacionPresupuestoVentaRepositoryCustom.updateActivoVacioExcepcionada']}")
  private String sqlUpdateActivoExcepcionada;

  @Value("#{primaryQuery['TareaLocalizacionPresupuestoVentaRepositoryCustom.totalizar']}")
  private String sqlTotalizar;

  @Override
  public void updateActivoExcepcionada(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);

    this.update(this.sqlUpdateActivoExcepcionada, parameters);
  }

  @Override
  public void updateActivoCongelada(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_CONGELADA,
        Arrays.asList(TipoDatoEnum.VENTA_RANGO_CONGELADA_LOCALIZACION.getId(),
            TipoDatoEnum.VENTA_RANGO_CONGELADA_LOCALIZACION_SECCION.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_REAL,
        Arrays.asList(TipoDatoEnum.VENTA_RANGO_LOCALIZACION.getId(),
            TipoDatoEnum.VENTA_RANGO_LOCALIZACION_SECCION.getId()));

    this.update(this.sqlUpdateActivoCongelada, parameters);
  }

  @Override
  public void updateActivoCongeladaSeccion(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA_CONGELADA,
        TipoGrupoDatoEnum.VENTA_RANGO_CONGELADA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA_REAL,
        TipoGrupoDatoEnum.VENTA_RANGO.getId());

    this.update(this.sqlUpdateActivoCongeladaSeccion, parameters);
  }

  @Override
  public void totalizar(@NonNull final RunTareaDto runTareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA_CONGELADA,
        TipoGrupoDatoEnum.VENTA_RANGO_CONGELADA.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO_VENTA_REAL,
        TipoGrupoDatoEnum.VENTA_RANGO.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_RANGO_CONGELADA_LOCALIZACION,
        TipoDatoEnum.VENTA_RANGO_CONGELADA_LOCALIZACION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_RANGO_CONGELADA_LOCALIZACION_SECCION,
        TipoDatoEnum.VENTA_RANGO_CONGELADA_LOCALIZACION_SECCION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_RANGO_LOCALIZACION,
        TipoDatoEnum.VENTA_RANGO_LOCALIZACION.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_RANGO_LOCALIZACION_SECCION,
        TipoDatoEnum.VENTA_RANGO_LOCALIZACION_SECCION.getId());

    this.update(this.sqlTotalizar, parameters);
  }

  @Override
  public List<TareaLocalizacionPresupuestoVenta> save(final List<TareaLocalizacionPresupuestoVenta> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

}
