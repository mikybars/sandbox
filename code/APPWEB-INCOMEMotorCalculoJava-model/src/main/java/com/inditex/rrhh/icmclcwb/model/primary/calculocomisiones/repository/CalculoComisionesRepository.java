package com.inditex.rrhh.icmclcwb.model.primary.calculocomisiones.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.CalculoComisionesFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.ComisionLineDto;
import com.inditex.rrhh.icmclcwb.model.primary.calculocomisiones.repository.dto.EmpleadoAProcesarDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Repository for executing planificacion commission calculation queries against PostgreSQL.
 */
@Slf4j
@Repository
@RequiredArgsConstructor
public class CalculoComisionesRepository {

  private static final String PARAM_ID_PERIODO = "idPeriodo";

  private static final String PARAM_ID_ORIGEN = "idOrigen";

  private static final String PARAM_EMPRESAS = "empresas";

  private static final String PARAM_TIENDAS = "tiendas";

  private static final String PARAM_EMPLEADOS = "empleados";

  private static final String PARAM_ID_EMPLEADO = "idEmpleado";

  @Qualifier("primaryNamedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Value("#{primaryQuery['CalculoComisionesRepository.findEmpleadosAProcesar']}")
  private String sqlFindEmpleadosBase;

  @Value("#{primaryQuery['CalculoComisionesRepository.filterByEmpresas']}")
  private String sqlFilterByEmpresas;

  @Value("#{primaryQuery['CalculoComisionesRepository.filterByTiendas']}")
  private String sqlFilterByTiendas;

  @Value("#{primaryQuery['CalculoComisionesRepository.filterByEmpleados']}")
  private String sqlFilterByEmpleados;

  @Value("#{primaryQuery['CalculoComisionesRepository.findComisionesPorEmpleado']}")
  private String sqlFindComisionesPorEmpleado;

  /**
   * Query 1: Find employees to process based on filter criteria.
   */
  public List<EmpleadoAProcesarDto> findEmpleadosAProcesar(CalculoComisionesFilterDto filter) {
    log.debug("Finding empleados a procesar for periodo={}, origen={}, ambito={}",
        filter.getIdPeriodo(), filter.getIdOrigen(), filter.getAmbito());

    MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue(PARAM_ID_PERIODO, filter.getIdPeriodo())
        .addValue(PARAM_ID_ORIGEN, filter.getIdOrigen());

    String sql = buildEmpleadosQuery(filter, params);

    return namedParameterJdbcTemplate.query(sql, params,
        (rs, rowNum) -> EmpleadoAProcesarDto.builder()
            .idOrigen(rs.getString("CCL_ID_ORIGEN"))
            .idPersona(rs.getString("CCL_ID_PERSON"))
            .stdOrHrPeriod(rs.getString("STD_OR_HR_PERIOD"))
            .idEstado(rs.getString("ID_ESTADO"))
            .idEmpresa(rs.getString("STD_ID_LEG_ENT"))
            .idLugarTrabajo(rs.getString("STD_ID_WORK_LOCAT"))
            .build());
  }

  private String buildEmpleadosQuery(CalculoComisionesFilterDto filter, MapSqlParameterSource params) {
    StringBuilder sql = new StringBuilder(sqlFindEmpleadosBase);

    if (filter.getAmbito() == null) {
      return sql.toString();
    }

    switch (filter.getAmbito()) {
      case EMPRESAS -> appendFilterIfNotEmpty(sql, params, sqlFilterByEmpresas, PARAM_EMPRESAS, filter.getEmpresas());
      case TIENDAS -> appendFilterIfNotEmpty(sql, params, sqlFilterByTiendas, PARAM_TIENDAS, filter.getTiendas());
      case EMPLEADOS -> appendFilterIfNotEmpty(sql, params, sqlFilterByEmpleados, PARAM_EMPLEADOS, filter.getEmpleados());
      default -> {
      }
    }

    return sql.toString();
  }

  private static void appendFilterIfNotEmpty(StringBuilder sql, MapSqlParameterSource params,
      String filterSql, String paramName, List<String> values) {
    if (values != null && !values.isEmpty()) {
      sql.append(filterSql);
      params.addValue(paramName, values);
    }
  }

  /**
   * Query 2: Calculate commissions for a specific employee.
   */
  public List<ComisionLineDto> findComisionesPorEmpleado(Long idPeriodo, Long idOrigen, String idEmpleado) {
    log.debug("Finding comisiones for empleado={}, periodo={}, origen={}", idEmpleado, idPeriodo, idOrigen);

    MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue(PARAM_ID_PERIODO, idPeriodo)
        .addValue(PARAM_ID_ORIGEN, idOrigen)
        .addValue(PARAM_ID_EMPLEADO, idEmpleado);

    return namedParameterJdbcTemplate.query(sqlFindComisionesPorEmpleado, params,
        (rs, rowNum) -> ComisionLineDto.builder()
            .idTipoComision(rs.getString("ID_TIPO_COMISION"))
            .idTipoCalculo(rs.getString("ID_TIPO_CALCULO"))
            .codTipoHora(rs.getString("COD_TIPO_HORA"))
            .importe(rs.getDouble("IMPORTE"))
            .build());
  }
}
