package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.MailEntornoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.MailEntorno;

import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class MailEntornoRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<MailEntorno>
    implements MailEntornoRepositoryCustom {

  @Value("${app.envars.repository.batch-size.mail-entorno:0}")
  private int batchSize;

  @Value("#{primaryQuery['MailEntornoRepositoryCustom.findMailEntornoByEntorno']}")
  private String sqlFindMailEntornoByEntorno;

  @Override
  public MailEntornoDto findMailEntornoDtoByEntorno(
      @NotBlank final String entorno) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ENTORNO, entorno);

    final List<MailEntornoDto> mailEntornoDto = this.query(this.sqlFindMailEntornoByEntorno,
        parameters,
        new RowMapper<MailEntornoDto>() {
          @Override
          public MailEntornoDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final MailEntornoDto dto = new MailEntornoDto();
            dto.setEntorno(rs.getString(SqlPrimaryConstants.SQL_RESULT_ENTORNO));
            dto.setActivo(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_ACTIVO));
            return dto;
          }
        });

    return mailEntornoDto.size() == 1 ? mailEntornoDto.get(0) : null;
  }

}
