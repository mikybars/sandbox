package com.inditex.rrhh.icmclcwb.api.app.calcular.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;

public interface TipoDatoService {

  List<IdTipoDatoDto> findTipoDatoByTipoGrupoDato(Integer id);

}
