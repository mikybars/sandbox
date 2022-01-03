package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TareaAgrupacionCadena;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

import javax.validation.constraints.NotNull;

public interface TareaAgrupacionCadenaRepository extends BaseRepository<TareaAgrupacionCadena, Long> {

  List<TareaAgrupacionCadena> findByTareaId(@NotNull final Long id);

}
