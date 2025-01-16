package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoExternoDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.ExternosRequestDTO;

import jakarta.validation.constraints.NotNull;

public interface IncomeMetaService {

  List<EmpleadoExternoDTO> getEmpleadosExternosExcluidosDenominador(@NotNull ExternosRequestDTO request);

}
