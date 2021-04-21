package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLimpieza;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TareaLimpiezaRepository extends BaseRepository<TareaLimpieza, Long> {

    TareaLimpieza findByTareaId(@NotNull final Long id);

}
