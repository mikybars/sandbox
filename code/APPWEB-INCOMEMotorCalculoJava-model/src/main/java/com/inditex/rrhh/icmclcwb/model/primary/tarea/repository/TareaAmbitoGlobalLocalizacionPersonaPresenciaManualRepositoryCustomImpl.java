package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersonaPresenciaManual;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaAmbitoGlobalLocalizacionPersonaPresenciaManual>
    implements TareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-ambito-global-localizacion-persona-presencia-manual:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustom.save']}")
  private String sqlSave;

  @Override
  public List<TareaAmbitoGlobalLocalizacionPersonaPresenciaManual> save(
      final List<TareaAmbitoGlobalLocalizacionPersonaPresenciaManual> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

}
