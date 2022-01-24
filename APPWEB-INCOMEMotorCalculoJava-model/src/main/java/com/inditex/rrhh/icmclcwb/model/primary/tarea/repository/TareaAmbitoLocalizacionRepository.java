package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoLocalizacion;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TareaAmbitoLocalizacionRepository extends BaseRepository<TareaAmbitoLocalizacion, Long> {

  List<TareaAmbitoLocalizacion> findByTareaId(Long tareaId);

}
