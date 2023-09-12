package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionFestivo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaLocalizacionFestivoRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionFestivo>
    implements TareaLocalizacionFestivoRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-localizacion-festivo:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaLocalizacionFestivoRepositoryCustom.save']}")
  private String sqlSave;

  @Override
  public List<TareaLocalizacionFestivo> save(final List<TareaLocalizacionFestivo> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

}
