package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.TIPO_VENTA_CONCEPTO_CHALLENGE_BY_ICM_ID_CONCEPTO_VENTA;
import static com.inditex.rrhh.icmclcwb.model.app.util.CacheNamesUtils.TIPO_VENTA_CONCEPTO_CHALLENGE_BY_ID;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoVentaConceptoChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoVentaConceptoChallengeService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TipoVentaConceptoChallengeMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.TipoVentaConceptoChallengeRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TipoVentoConceptoChallengeServiceImpl implements TipoVentaConceptoChallengeService {

  @Autowired
  private TipoVentaConceptoChallengeRespository tipoVentaConceptoChallengeRespository;

  @Autowired
  private TipoVentaConceptoChallengeMapper tipoVentaConceptoChallengeMapper;

  @Override
  @Cacheable(value = TIPO_VENTA_CONCEPTO_CHALLENGE_BY_ICM_ID_CONCEPTO_VENTA,
      key = "#icmIdConceptoVenta")
  public TipoVentaConceptoChallengeDto findByIcmIdConceptoVenta(String icmIdConceptoVenta) {
    return this.tipoVentaConceptoChallengeMapper.tipoVentaConceptoChallengeToTipoVentaConceptoChallengeDto(
        this.tipoVentaConceptoChallengeRespository.findByIcmIdConceptoVenta(icmIdConceptoVenta));
  }

  @Override
  @Cacheable(value = TIPO_VENTA_CONCEPTO_CHALLENGE_BY_ID, key = "#id")
  public TipoVentaConceptoChallengeDto findById(Long id) {
    return this.tipoVentaConceptoChallengeMapper.tipoVentaConceptoChallengeToTipoVentaConceptoChallengeDto(
        this.tipoVentaConceptoChallengeRespository.findById(id).get());
  }

}
