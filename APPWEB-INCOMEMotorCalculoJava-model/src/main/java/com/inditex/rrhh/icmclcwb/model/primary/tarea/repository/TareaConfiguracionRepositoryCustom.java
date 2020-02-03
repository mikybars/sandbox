package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracion;

import java.util.List;

public interface TareaConfiguracionRepositoryCustom {

    List<TareaConfiguracion> save(final List<TareaConfiguracion> src);
}
