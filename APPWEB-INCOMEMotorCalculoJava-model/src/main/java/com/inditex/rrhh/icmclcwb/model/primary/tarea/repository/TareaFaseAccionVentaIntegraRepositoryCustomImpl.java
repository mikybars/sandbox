package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccionVentaIntegra;

import org.springframework.beans.factory.annotation.Value;

public class TareaFaseAccionVentaIntegraRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaFaseAccionVentaIntegra>
    implements TareaFaseAccionVentaIntegraRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-fase-accion-dato:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaFaseAccionVentaIntegraRepositoryCustom.save']}")
  private String sqlSave;

  @Override
  public void save(final List<TareaFaseAccionVentaIntegra> src) {
    this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }
}
