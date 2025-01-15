package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TareaAgrupacionCadena;

public interface TareaAgrupacionCadenaRepositoryCustom {

  List<TareaAgrupacionCadena> save(@NotNull final List<TareaAgrupacionCadena> agrupaciones);

}
