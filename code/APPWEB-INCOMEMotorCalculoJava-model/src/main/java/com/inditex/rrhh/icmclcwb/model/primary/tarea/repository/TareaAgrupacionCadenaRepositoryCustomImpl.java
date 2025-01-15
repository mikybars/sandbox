package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TareaAgrupacionCadena;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaAgrupacionCadenaRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaAgrupacionCadena>
    implements TareaAgrupacionCadenaRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-agrupacion-cadena:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaAgrupacionCadenaRepositoryCustom.save']}")
  private String sqlSave;

  @Override
  public List<TareaAgrupacionCadena> save(@NotNull final List<TareaAgrupacionCadena> agrupaciones) {
    return this.saveNamedJdbcBatchList(agrupaciones, this.sqlSave, this.batchSize);
  }

}
