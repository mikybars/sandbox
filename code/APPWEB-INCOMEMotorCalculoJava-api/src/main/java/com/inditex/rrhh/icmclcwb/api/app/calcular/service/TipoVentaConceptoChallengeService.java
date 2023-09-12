package com.inditex.rrhh.icmclcwb.api.app.calcular.service;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoVentaConceptoChallengeDto;

public interface TipoVentaConceptoChallengeService {

  TipoVentaConceptoChallengeDto findByIcmIdConceptoVenta(String icmIdConceptoVenta);

  TipoVentaConceptoChallengeDto findById(Long id);

}
