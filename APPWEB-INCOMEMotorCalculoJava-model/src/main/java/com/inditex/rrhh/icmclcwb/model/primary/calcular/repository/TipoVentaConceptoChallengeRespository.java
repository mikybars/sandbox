package com.inditex.rrhh.icmclcwb.model.primary.calcular.repository;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoVentaConceptoChallenge;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TipoVentaConceptoChallengeRespository extends BaseRepository<TipoVentaConceptoChallenge, Long> {

  TipoVentaConceptoChallenge findByIcmIdConceptoVenta(String icmIdConceptoVenta);

}
