package com.inditex.rrhh.icmclcwb.model.primary.repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PrimaryTemporaryTablePorVentaRepositoryCustomImpl implements PrimaryTemporaryTablePorVentaRepositoryCustom {

  @Autowired
  @Qualifier("primaryJdbcTemplate")
  private JdbcTemplate jdbcTemplate;

  @Autowired
  @Qualifier("primaryNamedParameterJdbcTemplate")
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Value("${app.envars.repository.batch-size.default}")
  private int batchSize;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempVentaFisicaLocalizacionSeccion']}")
  private String sqlCreateTempVentaFisicaLocalizacionSeccion;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempVentaFisicaLocalizacionSeccion']}")
  private String sqlDeleteTempVentaFisicaLocalizacionSeccion;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTempVentaFisicaLocalizacionSeccion']}")
  private String sqlInsertTempVentaFisicaLocalizacionSeccion;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createIndexTempVentaFisicaLocalizacionSeccion']}")
  private String sqlCreateIndexTempVentaFisicaLocalizacionSeccion;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTempVentaFisicaLocalizacion']}")
  private String sqlInsertTempVentaFisicaLocalizacion;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempDatesEstructurasPorVenta']}")
  private String sqlCreateTempDatesEstructurasPorVenta;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.indexTempDatesEstructurasPorVenta']}")
  private String sqlIndexTempDatesEstructurasPorVenta;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempDatesEstructurasPorVenta']}")
  private String sqlDeleteTempDatesEstructurasPorVenta;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTempDatesEstructurasPorVenta']}")
  private String sqlInsertTempDatesEstructurasPorVenta;

  @Override
  public void createTempVentaFisicaLocalizacionSeccion() {
    this.jdbcTemplate.update(this.sqlCreateTempVentaFisicaLocalizacionSeccion);
  }

  @Override
  public void createIndexTempVentaFisicaLocalizacionSeccion() {
    this.jdbcTemplate.update(this.sqlCreateIndexTempVentaFisicaLocalizacionSeccion);
  }

  @Override
  public void insertTempVentaFisicaLocalizacionSeccion(final TareaDto tarea) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.VENTA_FISICA_IPOD_LOCALIZACION_SECCION.getId());
    this.namedParameterJdbcTemplate.update(this.sqlInsertTempVentaFisicaLocalizacionSeccion, params);
  }

  @Override
  public void deleteTempVentaFisicaLocalizacionSeccion() {
    this.jdbcTemplate.update(this.sqlDeleteTempVentaFisicaLocalizacionSeccion);
  }

  @Override
  public void insertTempVentaFisicaLocalizacion(final TareaDto tarea) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_GRUPO_DATO, TipoGrupoDatoEnum.VENTA_FISICA_IPOD_LOCALIZACION_SECCION.getId());
    this.namedParameterJdbcTemplate.update(this.sqlInsertTempVentaFisicaLocalizacion, params);
  }

  @Override
  public int deleteTempDatesEstructurasPorVenta() {
    return this.jdbcTemplate.update(this.sqlDeleteTempDatesEstructurasPorVenta);
  }

  @Override
  public int createTempDatesEstructurasPorVenta() {
    return this.jdbcTemplate.update(this.sqlCreateTempDatesEstructurasPorVenta);
  }

  @Override
  public int indexTempDatesEstructurasPorVenta() {
    return this.jdbcTemplate.update(this.sqlIndexTempDatesEstructurasPorVenta);
  }

  @Override
  public void insertTempDatesEstructurasPorVenta(final TareaDto tarea) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CALCULO, TipoCalculoEnum.POR_VENTA.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    this.namedParameterJdbcTemplate.update(this.sqlInsertTempDatesEstructurasPorVenta, params);
  }
}
