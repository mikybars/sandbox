package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.ReglaValidacionExcedidoDto;

public interface ReglaValidacionExcedidoService {

  /**
   * Find rules by cclIdOrigen and stdIdLegEnt.
   *
   * @param cclIdOrigen cclIdOrigen
   * @param stdIdLegEnt stdIdLegEnt
   * @return the list of rules
   */
  List<ReglaValidacionExcedidoDto> findByCclIdOrigenAndStdIdLegEnt(String cclIdOrigen, String stdIdLegEnt);

}
