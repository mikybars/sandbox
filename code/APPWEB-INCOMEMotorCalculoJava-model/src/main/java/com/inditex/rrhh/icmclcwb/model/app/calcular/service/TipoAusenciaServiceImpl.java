package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.TIPO_AUSENCIA_BY_ICM_TP_ABSENCE;
import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.TIPO_AUSENCIA_BY_ID;

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
  @Cacheable(value = TIPO_AUSENCIA_BY_ICM_TP_ABSENCE, key = "#icmTpAbsence")
  public TipoAusenciaDto findByIcmTpAbsence(String icmTpAbsence) {
    return this.tipoAusenciaMapper.tipoAusenciaToTipoAusenciaDto(
        this.tipoAusenciaRepository.findByIcmTpAbsence(icmTpAbsence));
  }

  @Override
  @Cacheable(value = TIPO_AUSENCIA_BY_ID, key = "#id")
  public TipoAusenciaDto findById(Integer id) {
    return this.tipoAusenciaMapper.tipoAusenciaToTipoAusenciaDto(
        this.tipoAusenciaRepository.findById(id).get());
  }

}
