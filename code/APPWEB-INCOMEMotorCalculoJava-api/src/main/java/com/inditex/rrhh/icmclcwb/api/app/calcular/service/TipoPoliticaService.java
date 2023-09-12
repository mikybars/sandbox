package com.inditex.rrhh.icmclcwb.api.app.calcular.service;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoPoliticaDto;

public interface TipoPoliticaService {

  TipoPoliticaDto findByIdMeta4(String idMeta4);

  TipoPoliticaDto findById(Integer id);

}
