package com.inditex.rrhh.icmclcwb.model.primary.proceso.repository;

import java.util.Set;

import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.Algoritmo;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface AlgoritmoRepository extends BaseRepository<Algoritmo, Long> {

    Algoritmo findByTipoCalculoId(Long id);
    
    Algoritmo findByTipoCalculoIdAndTipoComisionId(Long idTipoCalculo, Long idTipoComision);

    Set<Algoritmo> findByActivo(Boolean isActivo);
}
