package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracionChallengeDiasMinimos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaConfiguracionChallengeDiasMinimosRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaConfiguracionChallengeDiasMinimos>
    implements TareaConfiguracionChallengeDiasMinimosRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-configuracion-challenge-dias-minimos:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaConfiguracionChallengeDiasMinimosRepositoryCustom.save']}")
  private String sqlSave;

  @Override
  public List<TareaConfiguracionChallengeDiasMinimos> save(final List<TareaConfiguracionChallengeDiasMinimos> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

}
