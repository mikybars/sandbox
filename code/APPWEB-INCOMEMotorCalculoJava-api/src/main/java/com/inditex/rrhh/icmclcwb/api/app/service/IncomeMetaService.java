package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoExternoDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.ExternosRequestDTO;

import org.jspecify.annotations.NonNull;

public interface IncomeMetaService {

  List<EmpleadoExternoDTO> getEmpleadosExternosExcluidosDenominador(@NonNull ExternosRequestDTO request);

}
