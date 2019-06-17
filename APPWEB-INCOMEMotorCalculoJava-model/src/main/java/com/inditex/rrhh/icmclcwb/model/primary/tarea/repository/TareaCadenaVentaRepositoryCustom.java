package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCadenaVenta;

import java.util.List;

public interface TareaCadenaVentaRepositoryCustom {

    void save(List<TareaCadenaVenta> src);

    void updateActivoVentaOnlineEntregaDomicilio(TareaDto tarea);
}
