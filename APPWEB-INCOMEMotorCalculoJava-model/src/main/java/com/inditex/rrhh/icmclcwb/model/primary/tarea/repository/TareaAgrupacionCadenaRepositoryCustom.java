package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TareaAgrupacionCadena;

import javax.validation.constraints.NotNull;

public interface TareaAgrupacionCadenaRepositoryCustom {

  List<TareaAgrupacionCadena> save(@NotNull final List<TareaAgrupacionCadena> agrupaciones);

}
