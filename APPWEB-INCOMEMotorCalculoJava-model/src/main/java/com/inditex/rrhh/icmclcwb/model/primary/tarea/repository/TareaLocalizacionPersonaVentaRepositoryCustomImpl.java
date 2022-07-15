package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoGrupoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaVenta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaLocalizacionPersonaVentaRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionPersonaVenta>
    implements TareaLocalizacionPersonaVentaRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-localizacion-persona-venta:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaLocalizacionPersonaVentaRepositoryCustom.save']}")
  private String sqlSave;

  @Value("#{primaryQuery['TareaLocalizacionPersonaVentaRepositoryCustom.totalizarVentaPersonaLocalizacion']}")
  private String sqlTotalizarVentaPersonaLocalizacion;

  @Value("#{primaryQuery['TareaLocalizacionPersonaVentaRepositoryCustom.devolucionImporte0']}")
  private String sqlDevolucionImporte0;

  @Autowired
  private TipoDatoService tipoDatoService;

  @Override
  public List<TareaLocalizacionPersonaVenta> save(final List<TareaLocalizacionPersonaVenta> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

  private void totalizarVentaPersonaLocalizacion(final TareaDto tarea, final TipoDatoEnum nuevoTipoDato,
      final List<Integer> tiposDato) {

    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    // Parámetros filtro
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO, tiposDato);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    // Parámetros que establecen valores
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO, nuevoTipoDato.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);

    this.update(this.sqlTotalizarVentaPersonaLocalizacion, parameters);

  }

  private void totalizarVentaPersonaLocalizacion(final TareaDto tarea, final List<IdTipoDatoDto> tiposDato,
      final TipoDatoEnum nuevoTipoDato) {

    this.totalizarVentaPersonaLocalizacion(tarea, nuevoTipoDato,
        tiposDato.stream().map(IdTipoDatoDto::getId).collect(Collectors.toList()));

  }

  @Override
  public void totalizarVentaSinDevolucionPersonaLocalizacion(final TareaDto tarea) {

    final List<IdTipoDatoDto> tiposDato = this.tipoDatoService.findTipoDatoByTipoGrupoDato(
        TipoGrupoDatoEnum.VENTA_SIN_DEVOLUCION_LOCALIZACION_SECCION_TOTALIZADA.getId());
    this.totalizarVentaPersonaLocalizacion(tarea, tiposDato,
        TipoDatoEnum.VENTA_SIN_DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION);

  }

  @Override
  public void totalizarDevolucionPersonaLocalizacion(final TareaDto tarea) {

    final List<IdTipoDatoDto> tiposDato = this.tipoDatoService
        .findTipoDatoByTipoGrupoDato(TipoGrupoDatoEnum.DEVOLUCION_LOCALIZACION_TOTALIZADA.getId());
    this.totalizarVentaPersonaLocalizacion(tarea, tiposDato, TipoDatoEnum.DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION);

  }

  @Override
  public void devolucionImporte0(final TareaDto tarea) {

    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_DEVOLUCION_LOCALIZACION_SECCION,
        TipoDatoEnum.DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ABIERTO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_IMPORTE, SqlPrimaryConstants.SQL_VALUE_IMPORTE_CERO);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO, TipoDatoEnum.DEVOLUCION_INDIVIDUAL_LOCALIZACION_SECCION.getId());

    this.update(this.sqlDevolucionImporte0, params);

  }
}
