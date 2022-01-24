package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaExterna;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaPersonaExternaRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaPersonaExterna>
    implements TareaPersonaExternaRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-persona-externa:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaPersonaExternaRepositoryCustom.save']}")
  private String sqlSave;

  @Override
  public List<TareaPersonaExterna> save(final List<TareaPersonaExterna> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

}
