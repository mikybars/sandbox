package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbito;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TareaAmbitoRepository extends BaseRepository<TareaAmbito, Long> {

  List<TareaAmbito> findByTareaId(Long tareaId);

}
