package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracion;

public interface TareaConfiguracionRepositoryCustom {

  List<TareaConfiguracion> save(final List<TareaConfiguracion> src);

}
