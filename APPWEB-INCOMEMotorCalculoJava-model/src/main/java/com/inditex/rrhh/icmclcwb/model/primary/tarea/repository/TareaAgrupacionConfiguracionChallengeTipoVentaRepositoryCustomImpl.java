package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionConfiguracionChallengeTipoVenta;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaAgrupacionConfiguracionChallengeTipoVenta>
    implements TareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-agrupacion-configuracion-challenge-tipo-venta:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustom.save']}")
  private String sqlSave;

  @Override
  public List<TareaAgrupacionConfiguracionChallengeTipoVenta> save(
      final List<TareaAgrupacionConfiguracionChallengeTipoVenta> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

}
