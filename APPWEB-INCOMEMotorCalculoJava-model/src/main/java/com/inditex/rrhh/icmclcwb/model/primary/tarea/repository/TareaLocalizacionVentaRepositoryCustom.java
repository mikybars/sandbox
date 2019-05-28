package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;

public interface TareaLocalizacionVentaRepositoryCustom {

    List<TareaLocalizacionVenta> save(List<TareaLocalizacionVenta> src);
    
}
