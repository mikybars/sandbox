package com.inditex.rrhh.icmclcwb.api.app.calcular.service;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoUnidadTiempoDto;

public interface TipoUnidadTiempoService {

  TipoUnidadTiempoDto findByIcmIdUnidadTiempo(String icmIdUnidadTiempo);

  TipoUnidadTiempoDto findById(Integer id);

}
