package com.inditex.rrhh.icmclcwb.api.app.service;

import java.time.LocalDate;
import java.util.List;

import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoExternoDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.ExternosRequestDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.TiposVentaChallengeResponseDTO;

import jakarta.validation.constraints.NotNull;

public interface IncomeMetaService {

  List<EmpleadoExternoDTO> getEmpleadosExternosExcluidosDenominador(@NotNull ExternosRequestDTO request);

  List<TiposVentaChallengeResponseDTO> getTiposVentaChallenge(@NotNull String origen, @NotNull Integer empresa,
      @NotNull LocalDate fechaInicio,
      @NotNull LocalDate fechaFin, @NotNull String organizacion);
}
