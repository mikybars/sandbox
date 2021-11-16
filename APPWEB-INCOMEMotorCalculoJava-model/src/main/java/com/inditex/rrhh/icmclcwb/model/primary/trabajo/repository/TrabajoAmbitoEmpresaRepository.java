package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoAmbitoEmpresa;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TrabajoAmbitoEmpresaRepository extends BaseRepository<TrabajoAmbitoEmpresa, Long> {

  List<TrabajoAmbitoEmpresa> findByTrabajoId(Long trabajoId);

}
