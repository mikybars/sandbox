package com.inditex.rrhh.icmclcwb.model.primary.calcular.repository;

import java.util.Set;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.Algoritmo;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface AlgoritmoRepository extends BaseRepository<Algoritmo, Integer> {

  Algoritmo findByTipoCalculoId(Long id);

  Algoritmo findByTipoCalculoIdAndTipoComisionId(Long idTipoCalculo, Long idTipoComision);

  Set<Algoritmo> findByActivo(Boolean isActivo);

}
