package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCalculo;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaCalculoRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaCalculo>
    implements TareaCalculoRepositoryCustom {

  @Value("#{primaryQuery['TareaCalculoRepositoryCustom.regularizarMejorOpcion']}")
  private String sqlRegularizarMejorOpcion;

  @Value("#{primaryQuery['TareaCalculoRepositoryCustom.regularizarMejorOpcionSinFechas']}")
  private String sqlRegularizarMejorOpcionSinFechas;

  @Value("#{primaryQuery['TareaCalculoRepositoryCustom.regularizarMejorOpcionSinFechasTodoPeriodo']}")
  private String sqlRegularizarMejorOpcionSinFechasTodoPeriodo;

  @Value("#{primaryQuery['TareaCalculoRepositoryCustom.regularizarChallenge']}")
  private String sqlRegularizarChallenge;

  @Value("#{primaryQuery['TareaCalculoRepositoryCustom.findPersonaImporteExcedidoByIdTarea']}")
  private String sqlRecuperarPersonasImporteExcedido;

  @Value("#{primaryQuery['TareaCalculoRepositoryCustom.findPersonaCalculoPendiente']}")
  private String sqlRecuperarPersonasCalculoPendiente;

  @Override
  public void regularizarMejorOpcion(@NotNull final TareaDto tareaDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO,
        TimeUtils.toDate(tareaDto.getFechaInicioPeriodo()));
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    this.update(this.sqlRegularizarMejorOpcion, params);
  }

  @Override
  public void regularizarMejorOpcionSinFechas(@NotNull final TareaDto tareaDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO,
        TimeUtils.toDate(tareaDto.getFechaInicioPeriodo()));
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    this.update(this.sqlRegularizarMejorOpcionSinFechas, params);
  }

  @Override
  public void regularizarMejorOpcionSinFechasTodoPeriodo(@NotNull final TareaDto tareaDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO_PERIODO,
        TimeUtils.toDate(tareaDto.getFechaInicioPeriodo()));
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    this.update(this.sqlRegularizarMejorOpcionSinFechasTodoPeriodo, params);
  }

  @Override
  public void regularizarChallenge(@NotNull final TareaDto tareaDto,
      @NotNull final IdPersonaLocalChallengeDto idPersonaLocalChallengeDto) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, idPersonaLocalChallengeDto.getCclIdPerson());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_STD_OR_HR_PERIOD, idPersonaLocalChallengeDto.getStdOrHrPeriod());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO,
        idPersonaLocalChallengeDto.getIcmIdTpCalculo());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION,
        idPersonaLocalChallengeDto.getIcmIdTpComision());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO,
        idPersonaLocalChallengeDto.getEsDesplazamiento());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ES_DESPLAZAMIENTO_BASE,
        idPersonaLocalChallengeDto.getEsDesplazamientoBase());
    this.update(this.sqlRegularizarChallenge, params);
  }

  @Override
  public List<IdPersonaLocalDto> findPersonaImporteExcedidoByIdTarea(
      @NotNull Long idTarea, @NotNull String cclIdOrigen, @NotNull String stdIdLegEnt) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT, stdIdLegEnt);
    return this.query(
        this.sqlRecuperarPersonasImporteExcedido,
        params, (rs, rowNum) -> {
          final IdPersonaLocalDto dto = new IdPersonaLocalDto();
          dto.setIdPersonaLocal(rs.getString(SqlPrimaryConstants.SQL_RESULT_CCL_ID_PERSON));
          return dto;
        });
  }

  @Override
  public List<IdPersonaLocalDto> findPersonaCalculoPendiente(Long idTarea, String cclIdOrigen, String stdIdLegEnt) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    return this.query(
        this.sqlRecuperarPersonasCalculoPendiente,
        params, (rs, rowNum) -> {
          final IdPersonaLocalDto dto = new IdPersonaLocalDto();
          dto.setIdPersonaLocal(rs.getString(SqlPrimaryConstants.SQL_RESULT_CCL_ID_PERSON));
          return dto;
        });
  }

}
