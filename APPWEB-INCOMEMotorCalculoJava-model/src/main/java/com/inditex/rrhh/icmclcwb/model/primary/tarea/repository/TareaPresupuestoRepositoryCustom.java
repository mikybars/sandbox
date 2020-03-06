package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPresupuesto;

import java.util.List;

public interface TareaPresupuestoRepositoryCustom {

    List<TareaPresupuesto> save(final List<TareaPresupuesto> src);

}
