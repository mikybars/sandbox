package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoPersona;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TareaAmbitoPersonaRepository extends BaseRepository<TareaAmbitoPersona, Long> {

  List<TareaAmbitoPersona> findByTareaId(Long tareaId);

}
