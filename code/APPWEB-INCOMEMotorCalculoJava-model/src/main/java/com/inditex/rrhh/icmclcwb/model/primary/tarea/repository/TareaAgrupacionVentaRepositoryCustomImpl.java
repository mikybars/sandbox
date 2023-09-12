package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionVenta;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaAgrupacionVentaRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaAgrupacionVenta>
    implements TareaAgrupacionVentaRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-agrupacion-venta:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaAgrupacionVentaRepository.save']}")
  private String sqlSave;

  @Value("#{primaryQuery['TareaAgrupacionVentRepositoryCustom.updateActivo']}")
  private String sqlUpdateActivo;

  @Override
  public List<TareaAgrupacionVenta> save(final List<TareaAgrupacionVenta> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

  @Override
  public void updateActivo(final TareaDto tarea) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_IMPORTE_VENTA,
        TipoDatoEnum.VENTA_ONLINE_ENTREGADOMICILIO_AGRUPACIONONLINE.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION,
        SqlPrimaryConstants.SQL_VALUE_PORCENTAJE_CERO);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CONCEPTO_VENTA,
        Arrays.asList(TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_VENTA.getId(),
            TipoVentaConceptoEnum.ENTREGA_DOMICILIO_POR_PRESENCIAS.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    this.update(this.sqlUpdateActivo, parameters);
  }

}
