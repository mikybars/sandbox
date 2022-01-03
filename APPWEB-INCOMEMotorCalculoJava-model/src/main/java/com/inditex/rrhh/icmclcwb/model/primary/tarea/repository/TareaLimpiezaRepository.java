package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLimpieza;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

import javax.validation.constraints.NotNull;

public interface TareaLimpiezaRepository extends BaseRepository<TareaLimpieza, Long> {

  TareaLimpieza findByTareaId(@NotNull final Long id);

}
