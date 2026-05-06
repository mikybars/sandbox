package com.inditex.rrhh.icmclcwb.model.primary.periodo.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.periodo.service.EstadoCalculoPeriodoService;
import com.inditex.rrhh.icmclcwb.dto.EstadoPeriodoCalculoDTO;
import com.inditex.rrhh.icmclcwb.dto.EstadoPeriodoCalculoSearchRequestDTO;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.EstadoCalculoPeriodoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class EstadoCalculoPeriodoServiceImpl implements EstadoCalculoPeriodoService {

  private final EstadoCalculoPeriodoRepository estadoCalculoPeriodoRepository;

  @Override
  public List<EstadoPeriodoCalculoDTO> buscarEstadosPeriodoCalculo(EstadoPeriodoCalculoSearchRequestDTO request) {
    return estadoCalculoPeriodoRepository.getEstadoPeriodo(request);
  }
}
