package com.inditex.rrhh.icmclcwb.api.app.calcular.service;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoVentaConceptoDto;

public interface TipoVentaConceptoService {

  TipoVentaConceptoDto findByIdMeta4(String idMeta4);

  TipoVentaConceptoDto findById(Long id);

}
