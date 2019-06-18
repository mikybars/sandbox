package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionVenta;

import java.util.List;

public interface TareaAgrupacionVentaRepositoryCustom {

    List<TareaAgrupacionVenta> save(List<TareaAgrupacionVenta> src);

    void updateActivo(TareaDto tarea);
}
