package com.inditex.rrhh.icmclcwb.model.primary.calcular.repository;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TipoPolitica;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TipoPoliticaRepository extends BaseRepository<TipoPolitica, Integer> {

  TipoPolitica findByIcmIdTpPolitica(String icmIdTpPolitica);

}
