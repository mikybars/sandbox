package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionCalcular;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaLocalizacionCalcularRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionCalcular>
    implements TareaLocalizacionCalcularRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-localizacion-calcular:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaLocalizacionCalcularRepositoryCustom.save']}")
  private String sqlSave;

  @Override
  public List<TareaLocalizacionCalcular> save(final List<TareaLocalizacionCalcular> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

}
