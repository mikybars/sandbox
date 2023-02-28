package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.periodo.dto.EstadoPeriodoCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.entity.PeriodoCalculoPersona;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;

import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PeriodoCalculoPersonaRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<PeriodoCalculoPersona>
    implements PeriodoCalculoPersonaRepositoryCustom {

  @Autowired
  @Qualifier("primaryNamedParameterJdbcTemplate")
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Value("#{primaryQuery['PeriodoCalculoPersonaRepositoryCustom.mergePeriodoCalculoPersona']}")
  private String sqlMergePeriodoCalculoPersona;

  @Value("#{primaryQuery['PeriodoCalculoPersonaRepositoryCustom.limpiezaPeriodoCalculoPersona']}")
  private String sqlLimpiezaPeriodoCalculoPersona;

  @Value("#{primaryQuery['PeriodoCalculoPersonaRepositoryCustom.findEmpleadosValidarRecuperar']}")
  private String sqlFindEmpleadosValidarRecuperar;

  @Override
  public void mergePeriodoCalculoPersona(@NotNull final RunTareaDto tareaDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getTarea().getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_PERIODO_PERSONA,
        EstadoPeriodoCalculoPersonaEnum.CALCULADO.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_PERIODO_PERSONA_CALCULADO_ERROR,
        EstadoPeriodoCalculoPersonaEnum.CALCULADO_ERROR.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_TAREA_PERSONA,
        EstadoTareaCalculoPersonaEnum.OK.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_TAREA_PERSONA_KO,
        EstadoTareaCalculoPersonaEnum.KO.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA, TimeUtils.nowDate());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_BLOQUEADO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_DESBLOQUEADO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    this.namedParameterJdbcTemplate.update(this.sqlMergePeriodoCalculoPersona, params);
  }

  @Override
  public void limpiezaPeriodoCalculoPersona(@NotNull final RunTareaDto tareaDto,
      @NotNull final TareaAmbitoDto tareaAmbitoDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getTarea().getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_DESBLOQUEADO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN,
        tareaAmbitoDto.getCclIdOrigen());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT,
        tareaDto.getTarea().getStdIdLegEnt());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ICM_ID_PERIODO,
        tareaDto.getTrabajo().getIcmIdPeriodo());
    this.namedParameterJdbcTemplate.update(this.sqlLimpiezaPeriodoCalculoPersona, params);
  }

  @Override
  public List<IdPersonaLocalDto> findEmpleadosValidarRecuperar(final RunTareaDto runTareaDto, final TareaAmbitoDto tareaAmbito,
      final List<String> personas) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, tareaAmbito.getCclIdOrigen());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT, runTareaDto.getTarea().getStdIdLegEnt());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ICM_ID_PERIODO, runTareaDto.getTrabajo().getIcmIdPeriodo());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, personas);

    return this.query(this.sqlFindEmpleadosValidarRecuperar, map,
        (rs, rowNum) -> {
          final IdPersonaLocalDto idPersonaLocalCondicionesDto = new IdPersonaLocalDto();
          idPersonaLocalCondicionesDto
              .setIdPersonaLocal((rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_LOCAL)));
          idPersonaLocalCondicionesDto
              .setStdOrHrPeriod((rs.getString(SqlPrimaryConstants.SQL_RESULT_OR_PERSONA)));
          return idPersonaLocalCondicionesDto;
        });
  }

}
