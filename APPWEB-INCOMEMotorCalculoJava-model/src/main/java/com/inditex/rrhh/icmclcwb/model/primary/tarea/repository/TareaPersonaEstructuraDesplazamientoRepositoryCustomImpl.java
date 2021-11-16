package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraDesplazamiento;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaPersonaEstructuraDesplazamientoRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaPersonaEstructuraDesplazamiento>
    implements TareaPersonaEstructuraDesplazamientoRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-persona-estructura-desplazamiento:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaPersonaEstructuraDesplazamientoRepositoryCustom.save']}")
  private String sqlSave;

  @Override
  public List<TareaPersonaEstructuraDesplazamiento> save(final List<TareaPersonaEstructuraDesplazamiento> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

}
