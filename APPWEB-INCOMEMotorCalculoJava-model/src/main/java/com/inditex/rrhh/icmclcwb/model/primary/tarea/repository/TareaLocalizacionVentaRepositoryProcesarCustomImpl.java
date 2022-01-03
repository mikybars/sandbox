package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TareaLocalizacionVentaRepositoryProcesarCustomImpl
    implements TareaLocalizacionVentaRepositoryProcesarCustom {

  @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.procesarRepartoVentaEntregaDomicilioPorVentasAgrupaciones']}")
  private String sqlProcesarEntregaDomicilioPorVentasAgrupaciones;

  @Value("#{primaryQuery['TareaLocalizacionVentaRepositoryCustom.procesarRepartoVentaEntregaDomicilioPresenciaAgrupaciones']}")
  private String sqlProcesarEntregaDomicilioPresenciaAgrupaciones;

  @Autowired
  @Qualifier("primaryNamedParameterJdbcTemplate")
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Override
  public void procesarRepartoEntregaDomicilioPorVentasAgrupaciones(@NotNull final TareaDto tareaDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_AGRUPACION,
        TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_AGRUPACIONONLINE.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_FISICA_LOCALIZACION,
        TipoDatoEnum.VENTA_FISICA_LOCALIZACION.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_FISICA_AGRUPACION,
        TipoDatoEnum.VENTA_FISICA_AGRUPACIONONLINE.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO,
        TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_VENTA.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION,
        SqlPrimaryConstants.SQL_VALUE_PORCENTAJE_CERO);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ABIERTO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_FIN, TimeUtils.toDate(tareaDto.getFechaFinPeriodo()));
    this.namedParameterJdbcTemplate.update(this.sqlProcesarEntregaDomicilioPorVentasAgrupaciones, params);
  }

  @Override
  public void procesarRepartoEntregaDomicilioPorPresenciaAgrupaciones(@NotNull final TareaDto tareaDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    // Parametros para filtrar
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_AGRUPACION,
        TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_AGRUPACIONONLINE.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_FISICA_LOCALIZACION,
        TipoDatoEnum.VENTA_FISICA_LOCALIZACION.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_PRESENCIA_AGRUPACIONONLINE,
        TipoDatoEnum.PRESENCIA_AGRUPACIONONLINE_INCLUIDOECOMMERCE.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO,
        TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION,
        SqlPrimaryConstants.SQL_VALUE_PORCENTAJE_CERO);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_PRESENCIA_LOCALIZACION,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDOECOMMERCE.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ABIERTO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_FIN, TimeUtils.toDate(tareaDto.getFechaFinPeriodo()));
    // Parametros para establecer valores
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_SECCION, AppConstants.SECCION_4);
    this.namedParameterJdbcTemplate.update(this.sqlProcesarEntregaDomicilioPresenciaAgrupaciones, params);
  }

}
