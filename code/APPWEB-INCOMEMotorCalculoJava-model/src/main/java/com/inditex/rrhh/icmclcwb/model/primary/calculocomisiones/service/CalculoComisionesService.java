package com.inditex.rrhh.icmclcwb.model.primary.calculocomisiones.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.CalculoComisionesFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.CalculoComisionesResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.calculocomisiones.dto.CalculoComisionesResultItemDto;
import com.inditex.rrhh.icmclcwb.model.primary.calculocomisiones.repository.CalculoComisionesRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Service that orchestrates commission calculation queries. Executes Query 1 to find employees, then Query 2 for each employee to calculate
 * commissions.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CalculoComisionesService {

  private final CalculoComisionesRepository calculoComisionesRepository;

  /**
   * Executes the planificacion commission calculation flow: 1. Query 1: Find employees to process based on filter criteria 2. Query 2: For
   * each employee, calculate commissions
   */
  public CalculoComisionesResponseDto buscarCalculoComisiones(CalculoComisionesFilterDto filter) {
    log.debug("Starting buscarCalculoComisiones for periodo={}, origen={}, ambito={}",
        filter.getIdPeriodo(), filter.getIdOrigen(), filter.getAmbito());

    var empleados = calculoComisionesRepository.findEmpleadosAProcesar(filter);
    log.debug("Found {} empleados to process", empleados.size());

    List<CalculoComisionesResultItemDto> results = empleados.stream()
        .map(empleado -> {
          var comisiones = calculoComisionesRepository.findComisionesPorEmpleado(
              filter.getIdPeriodo(),
              filter.getIdOrigen(),
              empleado.getIdPersona());

          return CalculoComisionesResultItemDto.builder()
              .idEmpleado(empleado.getIdPersona())
              .idEmpresa(empleado.getIdEmpresa())
              .idLugarTrabajo(empleado.getIdLugarTrabajo())
              .comisiones(comisiones)
              .build();
        })
        .toList();

    log.info("Completed buscarCalculoComisiones with {} results", results.size());
    return CalculoComisionesResponseDto.builder()
        .data(results)
        .build();
  }
}
