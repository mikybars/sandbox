package com.inditex.rrhh.icmclcwb.api.app.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.ReglaValidacionExcedidoDto;

public interface ReglaValidacionExcedidoService {

  /**
   * Find rules by cclIdOrigen and stdIdLegEnt.
   *
   * @param cclIdOrigen the CCL ID origen
   * @param stdIdLegEnt the STD ID leg ent
   * @return the list of rules
   */
  List<ReglaValidacionExcedidoDto> findByCclIdOrigenAndStdIdLegEnt(String cclIdOrigen, String stdIdLegEnt);

}
