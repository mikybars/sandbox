package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalPersona;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaAmbitoGlobalPersonaRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaAmbitoGlobalPersona>
    implements TareaAmbitoGlobalPersonaRepositoryCustom {

  @Value("#{primaryQuery['TareaAmbitoGlobalPersonaRepositoryCustom.mergePersona']}")
  private String sqlMergePersona;

  @Override
  public void mergePersona(@NonNull final RunTareaDto tareaDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getTarea().getId());
    this.update(this.sqlMergePersona, params);
  }

}
