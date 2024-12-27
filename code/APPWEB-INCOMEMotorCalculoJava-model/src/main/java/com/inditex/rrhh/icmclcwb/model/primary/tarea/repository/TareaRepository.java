package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Collection;
import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

import org.jspecify.annotations.NonNull;

public interface TareaRepository extends BaseRepository<Tarea, Long> {

  List<Tarea> findByTrabajoId(@NonNull final Long id);

  Tarea findByIdAndEstadoIdIn(@NonNull final Long id, final Collection<Integer> estados);

}
