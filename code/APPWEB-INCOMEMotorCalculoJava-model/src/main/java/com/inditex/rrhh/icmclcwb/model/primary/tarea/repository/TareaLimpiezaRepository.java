package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLimpieza;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

import org.jspecify.annotations.NonNull;

public interface TareaLimpiezaRepository extends BaseRepository<TareaLimpieza, Long> {

  TareaLimpieza findByTareaId(@NonNull final Long id);

}
