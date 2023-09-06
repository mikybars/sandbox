package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaCoeficiente;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaPersonaCoeficienteRepositoryCustomImpl extends
    JdbcBatchPrimaryRepositoryAbstract<TareaPersonaCoeficiente> implements TareaPersonaCoeficienteRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-persona-coeficiente:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaPersonaCoeficienteRepositoryCustom.save']}")
  private String sqlSave;

  @Override
  public List<TareaPersonaCoeficiente> save(final List<TareaPersonaCoeficiente> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

}
