package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TareaAgrupacionCadena;

import org.jspecify.annotations.NonNull;

public interface TareaAgrupacionCadenaRepositoryCustom {

  List<TareaAgrupacionCadena> save(@NonNull final List<TareaAgrupacionCadena> agrupaciones);

}
