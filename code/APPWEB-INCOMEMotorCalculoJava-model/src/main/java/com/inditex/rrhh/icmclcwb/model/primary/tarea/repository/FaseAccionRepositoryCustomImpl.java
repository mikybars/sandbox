package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.FaseAccion;

import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class FaseAccionRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<FaseAccion>
    implements FaseAccionRepositoryCustom {

  @Value("${app.envars.repository.batch-size.fase-accion:0}")
  private int batchSize;

  @Value("#{primaryQuery['FaseAccionRepositoryCustom.findByIdFase']}")
  private String sqlFindByIdFase;

  @Override
  public List<FaseAccionDto> findByIdFase(@NonNull @Positive final Integer idFase) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_FASE, idFase);
    return this.query(this.sqlFindByIdFase, parameters,
        new RowMapper<FaseAccionDto>() {
          @Override
          public FaseAccionDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final FaseAccionDto dto = new FaseAccionDto();
            dto.setIdFase(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_FASE));
            dto.setIdAccion(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_ACCION));
            dto.setIdPuntoEjecucion(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_PUNTO_EJECUCION));
            dto.setPeso(rs.getInt(SqlPrimaryConstants.SQL_RESULT_PESO));
            return dto;
          }
        });
  }

}
