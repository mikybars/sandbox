package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

/*
 * Copyright (c) 2022. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.MailAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.MailAmbito;

import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class MailAmbitoRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<MailAmbito>
    implements MailAmbitoRepositoryCustom {

  @Value("#{primaryQuery['MailAmbitoRepositoryCustom.findMailByCclIdOrigenAndStdIdLegEnt']}")
  private String sqlFindMailByCclIdOrigenAndStdIdLegEnt;

  /**
   * Recupera el mail asociado a un origen y empresa.
   *
   * @param cclIdOrigen cclIdOrigen
   * @param stdIdLegEnt stdIdLegEnt
   */
  @Override
  public List<MailAmbitoDto> findMailByCclIdOrigenAndStdIdLegEnt(@NotNull final String cclIdOrigen, @NotNull final String stdIdLegEnt) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT, stdIdLegEnt);

    return this.query(this.sqlFindMailByCclIdOrigenAndStdIdLegEnt, parameters,
        (rs, rowNum) -> MailAmbitoDto.builder()
            .cclIdOrigen(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_ORIGEN))
            .stdIdLegEnt(rs.getString(SqlPrimaryConstants.SQL_RESULT_EMPRESA))
            .mail(rs.getString(SqlPrimaryConstants.SQL_RESULT_MAIL))
            .esActivo(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_ACTIVO)).build());
  }
}
