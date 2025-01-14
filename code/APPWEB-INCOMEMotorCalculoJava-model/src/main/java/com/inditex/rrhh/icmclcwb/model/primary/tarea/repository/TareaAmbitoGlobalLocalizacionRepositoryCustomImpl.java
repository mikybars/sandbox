package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacion;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaAmbitoGlobalLocalizacionRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaAmbitoGlobalLocalizacion>
    implements TareaAmbitoGlobalLocalizacionRepositoryCustom {

  @Value("#{primaryQuery['TareaAmbitoGlobalLocalizacionRepositoryCustom.mergeLocalizacion']}")
  private String sqlMergeLocalizacion;

  @Override
  public void mergeLocalizacion(@NonNull final RunTareaDto tareaDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getTarea().getId());
    this.update(this.sqlMergeLocalizacion, params);
  }

}
