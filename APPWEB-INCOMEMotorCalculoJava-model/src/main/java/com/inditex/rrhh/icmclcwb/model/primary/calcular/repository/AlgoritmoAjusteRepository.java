package com.inditex.rrhh.icmclcwb.model.primary.calcular.repository;

import java.util.List;
import java.util.Optional;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.AlgoritmoAjuste;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface AlgoritmoAjusteRepository extends BaseRepository<AlgoritmoAjuste, Integer> {

  public Optional<List<AlgoritmoAjuste>> findByPeso(Long id);

}
