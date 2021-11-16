package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionComisionHistorico;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaLocalizacionComisionHistoricoRepositoryCustomImpl extends
    JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionComisionHistorico>
    implements TareaLocalizacionComisionHistoricoRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-localizacion-comision-historico:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaLocalizacionComisionHistoricoRepositoryCustom.save']}")
  private String sqlSave;

  @Override
  public List<TareaLocalizacionComisionHistorico> save(final List<TareaLocalizacionComisionHistorico> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

}
