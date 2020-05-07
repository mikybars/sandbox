package com.inditex.rrhh.icmclcwb.api.app.calcular.service;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;

import java.util.List;

public interface TipoDatoService {

    List<IdTipoDatoDto> findTipoDatoByTipoGrupoDato(Integer id);

}
