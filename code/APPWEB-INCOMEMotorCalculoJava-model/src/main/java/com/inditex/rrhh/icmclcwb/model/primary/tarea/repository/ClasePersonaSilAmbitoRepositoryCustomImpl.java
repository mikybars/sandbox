package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ClasePersonaSilAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.ClasePersonaSilAmbito;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class ClasePersonaSilAmbitoRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<ClasePersonaSilAmbito>
    implements ClasePersonaSilAmbitoRepositoryCustom {

  @Value("#{primaryQuery['ClasePersonaSilAmbitoRepositoryCustom.findClaseEstadoByCclIdOrigenAndStdIdLegEnt']}")
  private String sqlFindClaseEstadoByCclIdOrigenAndStdIdLegEnt;

  @Override
  public List<ClasePersonaSilAmbitoDto> findClaseEstadoByCclIdOrigenAndStdIdLegEnt(@NotNull final String cclIdOrigen,
      @NotNull final String stdIdLegEnt) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT, stdIdLegEnt);

    return this.query(this.sqlFindClaseEstadoByCclIdOrigenAndStdIdLegEnt, parameters,
        (rs, rowNum) -> ClasePersonaSilAmbitoDto.builder().cclIdOrigen(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_ORIGEN))
            .clase(rs.getInt(SqlPrimaryConstants.SQL_RESULT_CLASE))
            .estado((Integer) rs.getObject(SqlPrimaryConstants.SQL_RESULT_ESTADO)).build());
  }
}
