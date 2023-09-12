package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoAmbitoLocalizacion;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TrabajoAmbitoLocalizacionRepository extends BaseRepository<TrabajoAmbitoLocalizacion, Long> {

  List<TrabajoAmbitoLocalizacion> findByTrabajoId(Long trabajoId);

}
