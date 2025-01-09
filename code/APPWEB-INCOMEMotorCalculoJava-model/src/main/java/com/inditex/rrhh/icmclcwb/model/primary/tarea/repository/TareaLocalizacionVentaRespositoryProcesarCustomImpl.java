package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TareaLocalizacionVentaRespositoryProcesarCustomImpl
    implements TareaLocalizacionVentaRespositoryProcesarCustom {

  @Value("#{primaryQuery['TareaLocalizacionVentaSeccionRepositoryCustom.proceasrRepartoVentaEntregaDomicilio']}")
  private String sqlProcesarEntregaDomicilio;

  @Autowired
  @Qualifier("primaryNamedParameterJdbcTemplate")
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Override
  public void procesarRepartoEntregaDomicilio(@NonNull final TareaDto tareaDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    // Filtros de la consulta
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA_ENTREGA_DOMICILIO_LOCALIZACION,
        TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_FISICA_LOCALIZACION_SECCION,
        TipoDatoEnum.VENTA_FISICA_LOCALIZACION_SECCION.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_DATO_VENTA_FISICA_LOCALIZACION,
        TipoDatoEnum.VENTA_FISICA_LOCALIZACION.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_IMPORTE, SqlPrimaryConstants.SQL_VALUE_IMPORTE_CERO);
    // Establecimiento de parametros
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_LOCALIZACION_SECCION.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    this.namedParameterJdbcTemplate.update(this.sqlProcesarEntregaDomicilio, params);
  }

}
