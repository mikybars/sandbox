package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.ReglaValidacionExcedidoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.ReglaValidacionExcedidoService;
import com.inditex.rrhh.icmclcwb.model.app.mapper.ReglaValidacionExcedidoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.ReglaValidacionExcedido;
import com.inditex.rrhh.icmclcwb.model.primary.repository.ReglaValidacionExcedidoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class ReglaValidacionExcedidoServiceImpl implements ReglaValidacionExcedidoService {

  private final ReglaValidacionExcedidoRepository reglaValidacionExcedidoRepository;

  private final ReglaValidacionExcedidoMapper reglaValidacionExcedidoMapper;

  @Override
  public List<ReglaValidacionExcedidoDto> findByCclIdOrigenAndStdIdLegEnt(final String cclIdOrigen, final String stdIdLegEnt) {
    final List<ReglaValidacionExcedido> reglas = this.reglaValidacionExcedidoRepository
        .findByCclIdOrigenAndStdIdLegEnt(cclIdOrigen, stdIdLegEnt);
    return this.reglaValidacionExcedidoMapper.toDto(reglas);
  }

}
