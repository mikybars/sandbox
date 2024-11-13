package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4Dto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.ReglaEmpleadoExternoMeta4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class ReglaEmpleadoExternoMeta4RepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<ReglaEmpleadoExternoMeta4>
    implements ReglaEmpleadoExternoMeta4RepositoryCustom {

  @Value("#{primaryQuery['ReglaEmpleadoExternoMeta4RepositoryCustom.findReglasEmpleadoExternoMeta4ActivasByCclIdOrigen']}")
  private String sqlFindReglasEmpleadoExternoMeta4ActivasByCclIdOrigen;

  @Override
  public List<ReglaEmpleadoExternoMeta4Dto> findReglasEmpleadoExternoMeta4ActivasByCclIdOrigen(final String cclIdOrigen,
      final String stdIdLegEnt) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT, stdIdLegEnt);

    return this.query(this.sqlFindReglasEmpleadoExternoMeta4ActivasByCclIdOrigen, parameters,
        (rs, rowNum) -> ReglaEmpleadoExternoMeta4Dto.builder().cclIdOrigen(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_ORIGEN))
            .stdIdLegEnt(rs.getString(SqlPrimaryConstants.SQL_RESULT_EMPRESA))
            .idOrganization(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_ORGANIZATION))
            .puesto(rs.getInt(SqlPrimaryConstants.SQL_RESULT_PUESTO))
            .esActivo(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_ACTIVO))
            .stdIdHrType(rs.getString(SqlPrimaryConstants.SQL_RESULT_STD_ID_HR_TYPE)).build());
  }
}
