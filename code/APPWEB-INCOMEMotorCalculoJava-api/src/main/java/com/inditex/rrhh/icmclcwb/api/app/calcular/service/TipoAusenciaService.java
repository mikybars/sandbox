package com.inditex.rrhh.icmclcwb.api.app.calcular.service;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoAusenciaDto;

public interface TipoAusenciaService {

  TipoAusenciaDto findByIcmTpAbsence(String icmTpAbsence);

  TipoAusenciaDto findById(Integer id);

}
