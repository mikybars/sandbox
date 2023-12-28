package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.EmpleadoExternoDTO;
import com.inditex.rrhh.icmclcwb.dto.ExternosRequestDTO;

import javax.validation.constraints.NotNull;

public interface IncomeMetaService {

  List<EmpleadoExternoDTO> getEmpleadosExternosExcluidosDenominador(@NotNull ExternosRequestDTO request);

}
