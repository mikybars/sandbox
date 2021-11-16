package com.inditex.rrhh.icmclcwb.model.primary.calcular.repository;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoAusencia;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TipoAusenciaRepository extends BaseRepository<TipoAusencia, Integer> {

  TipoAusencia findByIcmTpAbsence(String icmTpAbsence);

}
