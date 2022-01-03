package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionPresencia;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaAgrupacionPresenciaRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaAgrupacionPresencia>
    implements TareaAgrupacionPresenciaRepositoryCustom {

  @Value("#{primaryQuery['TareaAgrupacionPresenciaRepositoryCustom.totalizar']}")
  private String sqlTotalizar;

  @Override
  public void calcularPresenciasTotalesAgrupacion(final TareaDto tarea) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();

    // FILTROS
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_SECCION, AppConstants.SECCION_4);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO,
        Arrays.asList(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_MINUTOS,
        TipoDatoEnum.PRESENCIA_LOCALIZACION_INCLUIDOECOMMERCE.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION,
        SqlPrimaryConstants.SQL_VALUE_PORCENTAJE_CERO);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ABIERTO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_FIN, TimeUtils.toDate(tarea.getFechaFinPeriodo()));

    // VALORES ESTABLECIDOS
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_TIPO_DATO,
        TipoDatoEnum.PRESENCIA_AGRUPACIONONLINE_INCLUIDOECOMMERCE.getId());

    this.update(this.sqlTotalizar, parameters);
  }

}
