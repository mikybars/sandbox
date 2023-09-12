package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaConfiguracionRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaConfiguracion>
    implements TareaConfiguracionRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-configuracion-venta-online:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaConfiguracionRepositoryCustom.save']}")
  private String sqlSave;

  @Override
  public List<TareaConfiguracion> save(final List<TareaConfiguracion> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

}
