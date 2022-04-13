package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccionFallidas;

import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaFaseAccionFallidasRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaFaseAccionFallidas>
    implements TareaFaseAccionFallidasRepositoryCustom {

  @Value("#{primaryQuery['TareaFaseAccionFallidasRepositoryCustom.save']}")
  private String sqlSave;

  /**
   * Guarda en TAREA_FASE_ACCION_FALLIDAS.
   */
  @Override
  public void save(@NotNull TareaFaseAccionFallidas src) {

    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("idTareaFaseAccion", src.getPk().getTareaFaseAccion().getId());
    parameters.addValue("idTipoFallidas", src.getTipoFallidas().getId());
    parameters.addValue("fallidas", src.getFallidas());
    this.update(this.sqlSave, parameters);

  }
}
