package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.entity.PeriodoLocalizacionPersona;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PeriodoLocalizacionPersonaRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<PeriodoLocalizacionPersona>
    implements PeriodoLocalizacionPersonaRepositoryCustom {

  @Autowired
  @Qualifier("primaryNamedParameterJdbcTemplate")
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Value("#{primaryQuery['PeriodoLocalizacionPersonaRepositoryCustom.mergePeriodoLocalizacionPersona']}")
  private String sqlMergePeriodoLocalizacionPersona;

  @Value("#{primaryQuery['PeriodoLocalizacionPersonaRepositoryCustom.limpiezaPeriodoLocalizacionPersona']}")
  private String sqlLimpiezaPeriodoLocalizacionPersona;

  @Override
  public void mergePeriodoLocalizacionPersona(@NotNull final RunTareaDto tareaDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getTarea().getId());
    this.namedParameterJdbcTemplate.update(this.sqlMergePeriodoLocalizacionPersona, params);
  }

  @Override
  public void limpiezaPeriodoLocalizacionPersona(@NotNull final RunTareaDto tareaDto,
      @NotNull final TareaAmbitoDto tareaAmbitoDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getTarea().getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN,
        tareaAmbitoDto.getCclIdOrigen());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT,
        tareaDto.getTarea().getStdIdLegEnt());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ICM_ID_PERIODO,
        tareaDto.getTrabajo().getIcmIdPeriodo());
    this.namedParameterJdbcTemplate.update(this.sqlLimpiezaPeriodoLocalizacionPersona, params);
  }

}
