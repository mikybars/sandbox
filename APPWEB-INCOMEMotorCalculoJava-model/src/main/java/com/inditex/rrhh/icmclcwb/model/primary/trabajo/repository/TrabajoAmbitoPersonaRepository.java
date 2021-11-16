package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoAmbitoPersona;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TrabajoAmbitoPersonaRepository extends BaseRepository<TrabajoAmbitoPersona, Long> {

  List<TrabajoAmbitoPersona> findByTrabajoId(Long trabajoId);

}
