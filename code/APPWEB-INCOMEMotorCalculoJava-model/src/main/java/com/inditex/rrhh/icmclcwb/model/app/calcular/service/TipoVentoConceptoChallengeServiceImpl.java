package com.inditex.rrhh.icmclcwb.model.app.calcular.service;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.TipoVentaConceptoChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoVentaConceptoChallengeService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.mapper.TipoVentaConceptoChallengeMapper;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.repository.TipoVentaConceptoChallengeRespository;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class TipoVentoConceptoChallengeServiceImpl implements TipoVentaConceptoChallengeService {

  private final TipoVentaConceptoChallengeRespository tipoVentaConceptoChallengeRespository;

  private final TipoVentaConceptoChallengeMapper tipoVentaConceptoChallengeMapper;

  @Override
  @Cacheable(value = "itx.icmlcwb.tipo_venta_concepto_challenge_by_icm_id_concepto_venta",
      key = "#icmIdConceptoVenta")
  public TipoVentaConceptoChallengeDto findByIcmIdConceptoVenta(String icmIdConceptoVenta) {
    return tipoVentaConceptoChallengeMapper.tipoVentaConceptoChallengeToTipoVentaConceptoChallengeDto(
        tipoVentaConceptoChallengeRespository.findByIcmIdConceptoVenta(icmIdConceptoVenta));
  }

  @Override
  @Cacheable(value = "itx.icmlcwb.tipo_venta_concepto_challenge_by_id", key = "#id")
  public TipoVentaConceptoChallengeDto findById(Long id) {
    return tipoVentaConceptoChallengeMapper.tipoVentaConceptoChallengeToTipoVentaConceptoChallengeDto(
        tipoVentaConceptoChallengeRespository.findById(id).get());
  }

}
