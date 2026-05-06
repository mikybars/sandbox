package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.EstadoPeriodoCalculoDTO;
import com.inditex.rrhh.icmclcwb.dto.EstadoPeriodoCalculoSearchRequestDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EstadoCalculoPeriodoRepository {

  private static final String PARAM_IDS_LUGAR_TRABAJO = "idsLugarTrabajo";

  private static final String PARAM_ID_PERIODO = "idPeriodo";

  private static final String PARAM_ID_SOCIEDAD = "idSociedad";

  @Qualifier("primaryNamedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Value("#{primaryQuery['EstadoCalculoPeriodoRepository.getEstadoPeriodo']}")
  private String sqlGetEstadoPeriodo;

  public List<EstadoPeriodoCalculoDTO> getEstadoPeriodo(EstadoPeriodoCalculoSearchRequestDTO request) {
    return namedParameterJdbcTemplate.query(sqlGetEstadoPeriodo,
        new MapSqlParameterSource()
            .addValue(PARAM_IDS_LUGAR_TRABAJO, request.getIdsLugarTrabajo())
            .addValue(PARAM_ID_PERIODO, Long.valueOf(request.getIdPeriodo()))
            .addValue(PARAM_ID_SOCIEDAD, request.getIdSociedad()),
        (rs, rowNum) -> new EstadoPeriodoCalculoDTO()
            .idPeriodo(rs.getString("ICM_ID_PERIODO"))
            .idOrigen(rs.getString("CCL_ID_ORIGEN"))
            .idEmpresa(rs.getString("STD_ID_LEG_ENT"))
            .fechaInicioPeriodo(rs.getDate("ICM_DT_START") != null ? rs.getDate("ICM_DT_START").toLocalDate() : null)
            .fechaFinPeriodo(rs.getDate("ICM_DT_END") != null ? rs.getDate("ICM_DT_END").toLocalDate() : null)
            .idLugarTrabajo(rs.getString("STD_ID_WORK_LOCAT"))
            .idEstado(rs.getString("ICM_ID_ESTADO"))
            .nombreEstado(rs.getString("NOMBRE")));
  }
}
