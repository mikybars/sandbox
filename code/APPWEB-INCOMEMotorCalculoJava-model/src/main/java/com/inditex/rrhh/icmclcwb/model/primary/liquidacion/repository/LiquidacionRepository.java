package com.inditex.rrhh.icmclcwb.model.primary.liquidacion.repository;

import java.time.LocalDate;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LiquidacionRepository {

  @Qualifier("primaryNamedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Value("#{primaryQuery['LiquidacionRepository.findImportes']}")
  private String sqlFindImportes;

  @Value("#{primaryQuery['LiquidacionRepository.findImportesDiario']}")
  private String sqlFindImportesDiario;

  @Value("#{primaryQuery['LiquidacionRepository.updateEstado']}")
  private String sqlUpdateEstado;

  public List<ImporteRow> findImportes(MapSqlParameterSource params, boolean isDiario) {
    String sql = isDiario ? sqlFindImportesDiario : sqlFindImportes;
    return namedParameterJdbcTemplate.query(sql, params, importeRowMapper(isDiario));
  }

  public int updateEstado(MapSqlParameterSource params) {
    return namedParameterJdbcTemplate.update(sqlUpdateEstado, params);
  }

  private RowMapper<ImporteRow> importeRowMapper(boolean isDiario) {
    return (rs, rowNum) -> new ImporteRow(
        rs.getString("CCL_ID_ORIGEN"),
        rs.getString("STD_ID_LEG_ENT"),
        rs.getString("CCL_ID_PERSON"),
        rs.getString("STD_OR_HR_PERIOD"),
        rs.getInt("ID_ESTADO"),
        rs.getString("ID_TIPO_COMISION"),
        rs.getDouble("IMPORTE"),
        isDiario && rs.getObject("FECHA") != null ? rs.getDate("FECHA").toLocalDate() : null);
  }

  public record ImporteRow(
      String idOrigen,
      String idEmpresa,
      String idEmpleado,
      String ordinal,
      int idEstado,
      String idTipoComision,
      double importe,
      LocalDate fecha) {
  }
}
