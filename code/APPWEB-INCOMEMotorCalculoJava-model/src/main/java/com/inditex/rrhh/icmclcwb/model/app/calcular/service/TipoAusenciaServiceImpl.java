package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoAusenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoAusenciaService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TipoAusenciaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.TipoAusenciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TipoAusenciaServiceImpl implements TipoAusenciaService {

  @Autowired
  private TipoAusenciaMapper tipoAusenciaMapper;

  @Autowired
  private TipoAusenciaRepository tipoAusenciaRepository;

  @Override
  @Cacheable(value = "itx.icmlcwb.tipo_ausencia_by_icm_tp_absence", key = "#icmTpAbsence")
  public TipoAusenciaDto findByIcmTpAbsence(String icmTpAbsence) {
    return tipoAusenciaMapper.tipoAusenciaToTipoAusenciaDto(
        tipoAusenciaRepository.findByIcmTpAbsence(icmTpAbsence));
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.tipo_ausencia_by_id", key = "#id")
  public TipoAusenciaDto findById(Integer id) {
    return tipoAusenciaMapper.tipoAusenciaToTipoAusenciaDto(
        tipoAusenciaRepository.findById(id).get());
  }

}
