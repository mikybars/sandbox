package com.inditex.rrhh.icmclcwb.api.app.periodo.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.EstadoPeriodoCalculoDTO;
import com.inditex.rrhh.icmclcwb.dto.EstadoPeriodoCalculoSearchRequestDTO;

public interface EstadoCalculoPeriodoService {

  List<EstadoPeriodoCalculoDTO> buscarEstadosPeriodoCalculo(EstadoPeriodoCalculoSearchRequestDTO request);
}
