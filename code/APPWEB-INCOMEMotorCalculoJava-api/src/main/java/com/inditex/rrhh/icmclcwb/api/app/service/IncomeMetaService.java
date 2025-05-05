package com.inditex.rrhh.icmclcwb.api.app.service;

import java.time.LocalDate;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.searchempleados.dto.SearchEmpleadosRequestDto;
import com.inditex.rrhh.icmclcwb.rest.client.dto.AgrupacionesOnlineResponseDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoExternoDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.ExternosRequestDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.PeriodoResponseDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.PresupuestoResponseDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.TiendaResponseDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.TiposVentaChallengeResponseDTO;

import jakarta.validation.constraints.NotNull;

public interface IncomeMetaService {

  List<EmpleadoExternoDTO> getEmpleadosExternosExcluidosDenominador(@NotNull ExternosRequestDTO request);

  List<EmpleadoDTO> searchEmpleados(@NotNull SearchEmpleadosRequestDto reqeust);

  List<TiposVentaChallengeResponseDTO> getTiposVentaChallenge(@NotNull String origen, @NotNull Integer empresa,
      @NotNull LocalDate fechaInicio,
      @NotNull LocalDate fechaFin, @NotNull String organizacion);

  List<TiendaResponseDTO> getTiendas(@NotNull String idOrigen, @NotNull List<String> idsEmpresaOrCadena,
      @NotNull Boolean esEmpresa, @NotNull LocalDate fechaInicio, @NotNull LocalDate fechaFin,
      @NotNull String idOrganizacion);

  List<PresupuestoResponseDTO> getPresupuestos(@NotNull List<Integer> idEmpresa, @NotNull LocalDate fechaInicio,
      @NotNull LocalDate fechaFin,
      @NotNull String idOrganizacion);

  PeriodoResponseDTO getPeriodos(@NotNull String idOrganization, @NotNull Integer idPeriodo, @NotNull Boolean abierto,
      @NotNull Boolean vigente);

  List<AgrupacionesOnlineResponseDTO> getAgrupOnline(@NotNull String idOrigen);
}
