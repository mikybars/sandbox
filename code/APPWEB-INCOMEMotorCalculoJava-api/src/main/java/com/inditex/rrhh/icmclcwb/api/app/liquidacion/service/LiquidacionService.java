package com.inditex.rrhh.icmclcwb.api.app.liquidacion.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.CalculoConsultaRequestDTO;
import com.inditex.rrhh.icmclcwb.dto.CalculoConsultaResultadoItemDTO;
import com.inditex.rrhh.icmclcwb.dto.CalculoEstadoRequestDTO;
import com.inditex.rrhh.icmclcwb.dto.CalculoEstadoResponseDTO;

public interface LiquidacionService {

  List<CalculoConsultaResultadoItemDTO> consultarCalculoBulk(CalculoConsultaRequestDTO request);

  CalculoEstadoResponseDTO actualizarEstadoCalculoBulk(CalculoEstadoRequestDTO request);
}
