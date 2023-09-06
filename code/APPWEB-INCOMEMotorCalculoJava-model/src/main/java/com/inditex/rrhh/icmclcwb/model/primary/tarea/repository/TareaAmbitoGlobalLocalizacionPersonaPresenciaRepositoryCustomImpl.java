package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersonaPresencia;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaAmbitoGlobalLocalizacionPersonaPresencia>
    implements TareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-ambito-global-localizacion-persona-presencia:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustom.save']}")
  private String sqlSave;

  @Override
  public List<TareaAmbitoGlobalLocalizacionPersonaPresencia> save(
      final List<TareaAmbitoGlobalLocalizacionPersonaPresencia> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

}
