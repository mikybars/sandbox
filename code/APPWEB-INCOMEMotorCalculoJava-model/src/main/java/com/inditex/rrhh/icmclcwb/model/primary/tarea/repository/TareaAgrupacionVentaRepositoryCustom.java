package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionVenta;

public interface TareaAgrupacionVentaRepositoryCustom {

  List<TareaAgrupacionVenta> save(List<TareaAgrupacionVenta> src);

  void updateActivo(TareaDto tarea);

}
