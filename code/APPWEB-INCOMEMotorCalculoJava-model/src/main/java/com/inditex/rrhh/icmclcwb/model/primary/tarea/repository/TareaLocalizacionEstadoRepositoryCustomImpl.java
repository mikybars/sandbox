package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionEstado;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaLocalizacionEstadoRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionEstado>
    implements TareaLocalizacionEstadoRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-localizacion-estado: 0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaLocalizacionEstadoRepositoryCustom.save']}")
  private String sqlSave;

  @Override
  public List<TareaLocalizacionEstado> save(final List<TareaLocalizacionEstado> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }
}
