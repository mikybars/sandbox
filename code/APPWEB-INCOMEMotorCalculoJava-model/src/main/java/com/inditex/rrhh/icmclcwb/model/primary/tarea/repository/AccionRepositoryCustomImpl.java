package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Accion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class AccionRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<Accion>
    implements AccionRepositoryCustom {

  @Value("${app.envars.repository.batch-size.accion:0}")
  private int batchSize;

  @Value("#{primaryQuery['AccionRepositoryCustom.findByIdAccionAndIdOrigenAndStdIdLegEnt']}")
  private String sqlFindByIdAccionAndIdOrigenAndStdIdLegEnt;

  @Override
  public Boolean findByIdAccionAndIdOrigenAndStdIdLegEnt(@NotNull @Positive final Integer idAccion,
      @NotBlank final String cclIdOrigen, @NotBlank final String stdIdLegEnt) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ACCION, idAccion);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT, stdIdLegEnt);

    final List<AccionDto> acciones = this.query(this.sqlFindByIdAccionAndIdOrigenAndStdIdLegEnt, parameters,
        new RowMapper<AccionDto>() {
          @Override
          public AccionDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final AccionDto dto = new AccionDto();
            dto.setId(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_ACCION));
            return dto;
          }
        });

    return acciones.size() == 1;
  }

}
