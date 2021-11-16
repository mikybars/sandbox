package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersonaDesplazamiento;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustomImpl extends
    JdbcBatchPrimaryRepositoryAbstract<TareaAmbitoGlobalLocalizacionPersonaDesplazamiento>
    implements TareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-ambito-global-localizacion-persona-desplazamiento:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustom.save']}")
  private String sqlSave;

  @Override
  public List<TareaAmbitoGlobalLocalizacionPersonaDesplazamiento> save(
      final List<TareaAmbitoGlobalLocalizacionPersonaDesplazamiento> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

}
