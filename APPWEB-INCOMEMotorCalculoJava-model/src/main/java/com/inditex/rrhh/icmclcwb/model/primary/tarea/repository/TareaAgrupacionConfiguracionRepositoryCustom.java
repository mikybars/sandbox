package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionConfiguracion;

public interface TareaAgrupacionConfiguracionRepositoryCustom {

  List<TareaAgrupacionConfiguracion> save(final List<TareaAgrupacionConfiguracion> src);

}
