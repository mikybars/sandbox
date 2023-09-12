package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoAmbitoOrigen;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TrabajoAmbitoOrigenRepository extends BaseRepository<TrabajoAmbitoOrigen, Long> {

  List<TrabajoAmbitoOrigen> findByTrabajoId(Long trabajoId);

}
