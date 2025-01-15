package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoGlobalLocalizacionPersona;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaAmbitoGlobalLocalizacionPersonaRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaAmbitoGlobalLocalizacionPersona>
    implements TareaAmbitoGlobalLocalizacionPersonaRepositoryCustom {

  @Value("#{primaryQuery['TareaAmbitoGlobalLocalizacionPersonaRepositoryCustom.mergePersonaLocalizacion']}")
  private String sqlMergePersonaLocalizacion;

  @Override
  public void mergePersonaLocalizacion(@NotNull final RunTareaDto tareaDto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getTarea().getId());
    this.update(this.sqlMergePersonaLocalizacion, parameters);
  }

}
