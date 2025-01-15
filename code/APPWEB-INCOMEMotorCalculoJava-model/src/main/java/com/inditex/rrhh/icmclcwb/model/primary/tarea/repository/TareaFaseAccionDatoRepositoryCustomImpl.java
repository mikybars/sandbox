package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccionDato;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class TareaFaseAccionDatoRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaFaseAccionDato>
    implements TareaFaseAccionDatoRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-fase-accion-dato:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaFaseAccionDatoRepositoryCustom.save']}")
  private String sqlSave;

  /**
   * Guarda en TAREA_FASE_ACCION_DATO.
   */
  @Override
  public void save(@NotNull List<TareaFaseAccionDato> src) {

    this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);

  }
}
