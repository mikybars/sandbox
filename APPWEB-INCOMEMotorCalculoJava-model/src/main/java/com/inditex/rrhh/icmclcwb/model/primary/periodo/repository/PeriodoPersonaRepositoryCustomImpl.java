package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.entity.PeriodoPersona;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;

import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PeriodoPersonaRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<PeriodoPersona>
    implements PeriodoPersonaRepositoryCustom {

  @Autowired
  @Qualifier("primaryNamedParameterJdbcTemplate")
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Value("#{primaryQuery['PeriodoPersonaRepositoryCustom.mergePeriodoPersona']}")
  private String sqlMergePeriodoPersona;

  @Value("#{primaryQuery['PeriodoPersonaRepositoryCustom.limpiezaPeriodoPersona']}")
  private String sqlLimpiezaPeriodoPersona;

  @Override
  public void mergePeriodoPersona(@NotNull final RunTareaDto tareaDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getTarea().getId());
    this.namedParameterJdbcTemplate.update(this.sqlMergePeriodoPersona, params);
  }

  @Override
  public void limpiezaPeriodoPersona(@NotNull final RunTareaDto tareaDto,
      @NotNull final TareaAmbitoDto tareaAmbitoDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getTarea().getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN,
        tareaAmbitoDto.getCclIdOrigen());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT,
        tareaDto.getTarea().getStdIdLegEnt());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ICM_ID_PERIODO,
        tareaDto.getTrabajo().getIcmIdPeriodo());
    this.namedParameterJdbcTemplate.update(this.sqlLimpiezaPeriodoPersona, params);
  }

}
