package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCalculoPersona;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TareaCalculoPersonaRepository extends BaseRepository<TareaCalculoPersona, Long> {

  List<TareaCalculoPersona> findByTareaId(Long tareaId);

}
