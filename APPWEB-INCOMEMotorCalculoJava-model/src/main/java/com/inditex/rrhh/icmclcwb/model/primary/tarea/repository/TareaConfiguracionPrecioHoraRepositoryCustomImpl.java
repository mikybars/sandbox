package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracionPrecioHora;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaConfiguracionPrecioHoraRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaConfiguracionPrecioHora>
    implements TareaConfiguracionPrecioHoraRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-configuracion-precio-hora:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaConfiguracionPrecioHoraRepositoryCustom.save']}")
  private String sqlSave;

  @Override
  public List<TareaConfiguracionPrecioHora> save(final List<TareaConfiguracionPrecioHora> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

}
