package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Collection;
import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.Tarea;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

import javax.validation.constraints.NotNull;

public interface TareaRepository extends BaseRepository<Tarea, Long> {

  List<Tarea> findByTrabajoId(@NotNull final Long id);

  Tarea findByIdAndEstadoIdIn(@NotNull final Long id, final Collection<Integer> estados);

}
