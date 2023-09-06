package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaAusenciaHistorico;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaPersonaAusenciaHistoricoRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaPersonaAusenciaHistorico>
    implements TareaPersonaAusenciaHistoricoRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-persona-ausencia-historico:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaPersonaAusenciaHistoricoRepositoryCustom.save']}")
  private String sqlSave;

  @Override
  public List<TareaPersonaAusenciaHistorico> save(final List<TareaPersonaAusenciaHistorico> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

}
