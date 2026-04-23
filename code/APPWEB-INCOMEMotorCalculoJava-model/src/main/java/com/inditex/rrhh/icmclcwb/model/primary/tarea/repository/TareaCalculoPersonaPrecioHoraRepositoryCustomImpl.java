package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCalculoPersonaPrecioHora;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaCalculoPersonaPrecioHoraRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaCalculoPersonaPrecioHora>
    implements TareaCalculoPersonaPrecioHoraRepositoryCustom {

  @Value("#{primaryQuery['TareaCalculoPersonaPrecioHoraRepositoryCustom.insertPrecioHora']}")
  private String sqlInsertPrecioHora;

  @Value("#{primaryQuery['TareaCalculoPersonaPrecioHoraRepositoryCustom.getIds']}")
  private String sqlIds;

  @Override
  public List<IdPersonaLocalDto> ids(@Valid @NotNull final Long idTarea,
      @Valid @NotNull final String cclIdOrigen) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);

    return this.query(this.sqlIds, parameters, (rs, rowNum) -> {
      final IdPersonaLocalDto dto = new IdPersonaLocalDto();
      dto.setIdPersonaLocal(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_LOCAL));
      dto.setStdOrHrPeriod(rs.getString(SqlPrimaryConstants.SQL_RESULT_OR_PERSONA));
      return dto;
    });
  }

  @Override
  public CompletableFuture<Void> insertPrecioHora(@Valid @NotNull final Long idTarea, @Valid @NotNull final Long icmIdPeriodo,
      @Valid @NotNull final String cclIdOrigen, @Valid @NotNull final String stdIdLegEnt,
      @Valid @NotNull final List<String> cclIdPersonList) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();

    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ICM_ID_PERIODO, icmIdPeriodo);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT, stdIdLegEnt);

    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_PERSON, cclIdPersonList);

    this.query(this.sqlInsertPrecioHora, parameters, null);

    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
